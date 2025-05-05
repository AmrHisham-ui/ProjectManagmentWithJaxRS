# Product Management - JAX-RS Implementation

This is a simple RESTful Product Management API built using **JAX-RS (Jakarta RESTful Web Services)**.

## Features

- Create, read, update, and delete (CRUD) products.
- Uses in-memory `HashMap` for storing products.
- Simple endpoints to test using Postman.

## Technologies

- Java 17
- JAX-RS (Jakarta)
- In-memory storage

## Endpoints

- `GET api/products` – List all products
- `GET api/products/{id}` – Get product by ID
- `POST api/products` – Add a product
- `PUT api/products/{id}` – Update a product
- `DELETE api/products/{id}` – Delete a product

## Example JSON

```json
{
  "id": 1,
  "name": "Phone",
  "price": 899.99
}
