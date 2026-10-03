# Hibernate E-Commerce Application

A Maven-based Java Application that implements E-commerce data model developed using Hibernate ORM and MySQL.

## Technologies

- Java 17
- Hibernate ORM
- Maven
- MySQL 8.0
- Jakarta Persistence (JPA)

## Entities

- Category
- Product
- Users
- Orders
- OrderDetails

## Relationships

- Category → Product: One-to-Many
- Product → Category: Many-to-One
- Users → Orders: One-to-Many
- Orders → Users: Many-to-One
- Orders → OrderDetails: One-to-Many
- OrderDetails → Product: Many-to-One

## Database Setup

Create the database:

```sql
CREATE DATABASE ecommerce;
