# Order Processing System

A simple Spring Boot REST API for managing customer orders.

## Features
- Create an order with multiple products
- Get order details by ID
- List all orders (with optional status filter)
- Update order status (`PENDING`, `PROCESSING`, `SHIPPED`, `DELIVERED`)
- Cancel an order if status is `PENDING`
- Auto-update `PENDING` orders to `PROCESSING` every 5 mins

## Tech Stack
- Java 24
- Spring Boot 3.5.0
- Gradle
- Validation
- In-memory storage (List)
