// Initialize MongoDB with sample data

// Clear existing collections
db = db.getSiblingDB('cardekho_users');
db.users.drop();
db = db.getSiblingDB('cardekho_reviews');
db.reviews.drop();

// Insert sample users
db = db.getSiblingDB('cardekho_users');
db.users.insertMany([
  {
    _id: 1,
    username: 'john_doe',
    email: 'john@example.com',
    password: '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mqrq19m4L.9Dl7F3WX5QIM2wJ7iQyGy', // password123
    roles: ['USER']
  },
  {
    _id: 2,
    username: 'jane_smith',
    email: 'jane@example.com',
    password: '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mqrq19m4L.9Dl7F3WX5QIM2wJ7iQyGy', // password123
    roles: ['USER']
  }
]);

// Insert sample reviews
db = db.getSiblingDB('cardekho_reviews');
db.reviews.insertMany([
  {
    userId: 1,
    carId: 1,
    rating: 4,
    comment: 'Great car, very reliable',
    createdAt: new Date()
  },
  {
    userId: 2,
    carId: 3,
    rating: 5,
    comment: 'Excellent performance and comfort',
    createdAt: new Date()
  }
]);

print('Sample data initialized successfully');
