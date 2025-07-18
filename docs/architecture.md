┌─────────────────────────────────────────────────────────────────────────────────┐
│                                                                                 │
│   ┌─────────────┐    ┌─────────────┐    ┌─────────────┐    ┌─────────────┐     │
│   │    Web      │    │   Mobile    │    │   Admin     │    │   Dealer    │     │
│   │  Frontend   │    │   App       │    │  Dashboard  │    │  Portal     │     │
│   └──────┬──────┘    └──────┬──────┘    └──────┬──────┘    └──────┬──────┘     │
│          │                  │                  │                  │             │
│          └──────────────────┼──────────────────┼──────────────────┘             │
│                             │                  │                                │
│                             ▼                  ▼                                │
│   ┌─────────────────────────────────────────────────────────────────────┐       │
│   │                          API Gateway                                │       │
│   │ (Authentication, Rate Limiting, Request Routing, Load Balancing)   │       │
│   └──────┬──────┬──────┬───────┬───────┬───────┬───────┬───────┬───────┘       │
│          │      │      │       │       │       │       │       │                │
│          ▼      ▼      ▼       ▼       ▼       ▼       ▼       ▼                │
│   ┌─────────────┐┌─────────────┐┌─────────────┐┌─────────────┐┌─────────────┐  │
│   │  Car Catalog││  Car Search ││   User      ││  Booking    ││  Review     │  │
│   │  Service    ││  Service    ││   Service   ││  Service    ││  Service    │  │
│   │ (Write)     ││ (Read)      ││             ││             ││             │  │
│   └──────┬──────┘└─────────────┘└──────┬──────┘└──────┬──────┘└──────┬──────┘  │
│          │                              │              │              │         │
│          ▼                              ▼              ▼              ▼         │
│   ┌───────────────────────┐    ┌──────────────┐┌──────────────┐┌─────────────┐ │
│   │        Kafka          │    │  PostgreSQL  ││  Elastic     ││  MongoDB    │ │
│   │  (Event Bus)          │    │  (Car Write) ││  Search      ││  (Users)    │ │
│   └───────┬───────┬───────┘    └──────────────┘└──────────────┘└─────────────┘ │
│           │       │                                                             │
│           ▼       ▼                                                             │
│   ┌─────────────┐┌─────────────┐                                               │
│   │  Redis      ││  S3/Blob    │                                               │
│   │  (Cache)    ││  Storage    │                                               │
│   └─────────────┘└─────────────┘                                               │
│                                                                                 │
└─────────────────────────────────────────────────────────────────────────────────┘