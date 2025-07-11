# Order Processing System

Managing customer orders.

## Features
- Create an order with multiple products
- Get order details by ID
- List all orders (with optional status filter)
- Update order status (`PENDING`, `PROCESSING`, `SHIPPED`, `DELIVERED`)
- Cancel an order if status is `PENDING`
- Auto-update `PENDING` orders to `PROCESSING` every 5 mins
- Payment Service

## Tech Stack
- Java 24
- Spring Boot 3.5.0
- Gradle
- Validation
- In-memory storage (List)
