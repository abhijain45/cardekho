#!/bin/bash

# Improved database connectivity test script

echo "=== Database Connectivity Test ==="

# Check if services are running
check_service() {
    if systemctl is-active --quiet $1; then
        echo "[✓] $1 service is running"
        return 0
    else
        echo "[✗] $1 service is NOT running"
        return 1
    fi
}

# PostgreSQL tests using peer authentication
check_service postgresql && {
    echo "\nTesting PostgreSQL connections:"
    
    # Try peer authentication via sudo
    echo "- Trying catalog database (peer auth)"
    sudo -u postgres psql -d cardekho_catalog -c "SELECT 1" 2>/dev/null && {
        echo "  [✓] Success with peer authentication"
    } || echo "  [✗] Failed with peer authentication"
}

# MongoDB tests
check_service mongod && {
    echo "\nTesting MongoDB connections:"
    
    # Try both mongo and mongosh clients
    for client in mongosh mongo; do
        if command -v $client >/dev/null; then
            echo "- Using $client client"
            $client --eval "db.runCommand({ ping: 1 }).ok" \
                mongodb://root:example@localhost:27017/cardekho_users?authSource=admin \
                2>/dev/null && echo "  [✓] Connection successful" || echo "  [✗] Connection failed"
            break
        fi
    done
}

echo "\n=== Troubleshooting Tips ==="
echo "For PostgreSQL:"
echo "1. Check password in /etc/postgresql/*/main/pg_hba.conf"
echo "2. Try: sudo -u postgres psql -c \"ALTER USER postgres WITH PASSWORD 'newpassword';\""
echo "\nFor MongoDB:"
echo "1. Verify service is running: sudo systemctl status mongod"
echo "2. Check credentials in MongoDB configuration"

exit 0
