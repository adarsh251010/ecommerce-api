# 🛒 E-Commerce API

A **Spring Boot REST API** for managing products in an e-commerce system.  
Built with **Spring Boot (Java 17)**, **H2 Database**, and **Spring Data JPA**.  
Includes **RESTful endpoints**, **Swagger UI** for API documentation, and a layered architecture (Controller → Service → Repository).

---

## ✨ Features
- Product CRUD operations (Create, Read, Update, Delete)
- Search by **name, SKU, or description**
- Pagination and sorting support
- RESTful API design with Spring Boot
- Input validation using Jakarta Validation
- In-memory **H2 database** for quick setup
- Swagger UI for interactive API docs
- Clean architecture: Controller → Service → Repository
- Ready to extend with JWT security & MySQL/Postgres for production

---

## 🛠️ Tech Stack
- **Backend:** Spring Boot 3 (Java 17)
- **Database:** H2 (in-memory, dev/testing)
- **Build Tool:** Maven
- **API Docs:** Springdoc OpenAPI (Swagger UI)
- **Testing:** JUnit + Mockito (extendable)

---

## 📂 Project Structure
ecommerce-api/
├─ src/main/java/com/adarsh/shop/
│ ├─ ShopApplication.java # Main entry point
│ ├─ config/OpenApiConfig.java # Swagger / OpenAPI configuration
│ └─ product/
│ ├─ Product.java # Entity
│ ├─ ProductRepository.java # Repository
│ ├─ ProductService.java # Service interface
│ ├─ ProductServiceImpl.java # Service implementation
│ └─ ProductController.java # REST Controller
├─ src/main/resources/
│ ├─ application.properties # App config
│ └─ data.sql # Sample seed data
├─ pom.xml # Maven dependencies
└─ README.md # Project documentation


---

API Endpoints

| Method | Endpoint             | Description                              |
| ------ | -------------------- | ---------------------------------------- |
| GET    | `/api/products`      | List products (with pagination & search) |
| GET    | `/api/products/{id}` | Get product by ID                        |
| POST   | `/api/products`      | Create new product                       |
| PUT    | `/api/products/{id}` | Update product                           |
| DELETE | `/api/products/{id}` | Delete product                           |

 Access the API

Swagger UI: 👉 http://localhost:8081/swagger-ui/index.html

H2 Console: 👉 http://localhost:8081/h2-console

JDBC URL: jdbc:h2:mem:shopdb

User: sa, Password: (empty)
