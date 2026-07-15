# 🛒 E-Commerce Product Catalog

A simple **E-Commerce Product Catalog** application built using **Spring Boot**, **Spring Data JPA**, **MySQL**, and **Thymeleaf**. The application allows users to browse products, view product details, search by category, and find products by their ID through a responsive web interface.

---

## 📌 Features

* Display all available products
* View detailed information for a selected product
* Search products by category
* Find a product by its ID
* Responsive UI using Thymeleaf templates
* MySQL database integration
* Layered architecture (Controller, Service, Repository)

---

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap

### Database

* MySQL

### Build Tool

* Maven

### IDE

* IntelliJ IDEA / Eclipse

---

## 📂 Project Structure

```text
ecommerce-product-catalog/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/ecommerce/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── EcommerceApplication.java
│   │   │
│   │   ├── resources/
│   │   │   ├── templates/
│   │   │   │   ├── index.html
│   │   │   │   ├── product-details.html
│   │   │   │   └── category-products.html
│   │   │   ├── static/
│   │   │   │   ├── css/
│   │   │   │   └── images/
│   │   │   └── application.properties
│
├── pom.xml
└── README.md
```

---

## 📊 Database

The application uses **MySQL** to store product information.

### Product Table

| Column      | Type    |
| ----------- | ------- |
| id          | INT     |
| name        | VARCHAR |
| description | TEXT    |
| price       | DECIMAL |
| category    | VARCHAR |
| image_url   | VARCHAR |

---

## 🚀 API / Routes

| Method | URL                    | Description                  |
| ------ | ---------------------- | ---------------------------- |
| GET    | `/`                    | Display all products         |
| GET    | `/products/{id}`       | View product details by ID   |
| GET    | `/category/{category}` | Display products by category |

---

## 🖥️ Application Screens

* Home Page

  * Displays all products in a grid layout.
  * Each product includes image, name, price, and category.

* Product Details Page

  * Product image
  * Product name
  * Description
  * Price
  * Category

* Category Page

  * Displays products filtered by the selected category.

---

## ⚙️ Configuration

Update the database configuration in **application.properties**.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false
```

---

## ▶️ Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/ecommerce-product-catalog.git
```

### 2. Navigate to the Project

```bash
cd ecommerce-product-catalog
```

### 3. Create MySQL Database

```sql
CREATE DATABASE ecommerce_db;
```

### 4. Update Database Credentials

Modify the `application.properties` file with your MySQL username and password.

### 5. Run the Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the `EcommerceApplication.java` class from your IDE.

---

## 💡 Future Enhancements

* User Authentication and Authorization
* Shopping Cart
* Wishlist
* Product Search by Name
* Product Pagination
* Admin Dashboard
* Order Management
* Payment Gateway Integration
* Product Reviews and Ratings
* Image Upload Support

---

## 📸 Screenshots



## 🎯 Learning Outcomes

This project helped in understanding:

* Spring Boot MVC Architecture
* Spring Data JPA and Hibernate
* MySQL Database Integration
* Thymeleaf Template Engine
* MVC Design Pattern
* CRUD Data Retrieval
* Dependency Injection
* Repository Pattern
* Dynamic HTML Rendering with Thymeleaf

---

## 👩‍💻 Author

**Durgadevi Vadakalur Krishnan**

Java Full Stack Developer

### Skills

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate
* MySQL
* Thymeleaf
* HTML
* CSS
* Bootstrap
* Git & GitHub

---

## ⭐ Support

If you found this project helpful, consider giving it a **⭐ Star** on GitHub.
