 Spring Boot Testing

A dedicated Spring Boot project for learning and implementing **Unit Testing and Integration Testing** using JUnit, Mockito, MockMvc, Spring Boot Test, Spring Data JPA, Hibernate, and MySQL.

## 📌 Project Overview

This project was created to understand how testing works in a real Spring Boot backend application.

The project uses an `Order` domain and follows the standard Spring Boot architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Hibernate / JPA
    ↓
MySQL

The tests verify individual components as well as the integration between multiple layers.

🧪 Testing Covered

Unit Testing
JUnit
Mockito
Mocking dependencies
Service layer testing
Controller layer testing
Integration Testing
@SpringBootTest
MockMvc
Controller → Service → Repository integration
Real MySQL database integration
JSON response validation
HTTP status validation
Test data setup
Transactions and rollback
Test isolation
@DataJpaTest
Repository integration testing

🏗️ Project Structure

src
├── main
│   └── java
│       └── com.example.test
│           ├── Controller
│           │   └── OrderController.java
│           │
│           ├── Service
│           │   └── OrderService.java
│           │
│           ├── Repository
│           │   └── OrderRepository.java
│           │
│           └── Entity
│               └── Order.java
│
└── test
    └── java
        └── com.example.test
            ├── Unit Tests
            └── Integration Tests

🔗 Integration Test Flow

The integration test verifies the complete request flow:

MockMvc
   ↓
HTTP Request
   ↓
OrderController
   ↓
OrderService
   ↓
OrderRepository
   ↓
Hibernate / JPA
   ↓
MySQL
   ↓
Response

For example:

GET /orders/id/{id}

The test verifies that the request reaches the controller, retrieves the order through the service and repository layers, and returns the expected HTTP response.

🗄️ Database

The integration tests use a separate MySQL database:

TestingDb

This keeps testing data separate from the application's main database.

The tests use real:

MySQL
Hibernate
JPA
Spring Data JPA

🔄 Test Isolation

Test data can be created during an integration test:

Order order = new Order();

order.setProductName("Laptop");
order.setAmount(50000);

Order savedOrder = orderRepository.save(order);

The test can then use the generated ID:

savedOrder.getId()

and verify the API response.

Transactions and rollback can be used to prevent test data from permanently remaining in the test database.

✅ Example Integration Test
@SpringBootTest
@AutoConfigureMockMvc
class OrderIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void shouldReturnOrderById() throws Exception {

        // Arrange
        Order order = new Order();
        order.setProductName("Laptop");
        order.setAmount(50000);

        Order savedOrder = orderRepository.save(order);

        // Act + Assert
        mockMvc.perform(get("/orders/id/" + savedOrder.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(savedOrder.getId()))
                .andExpect(jsonPath("$.productName").value(order.getProductName()))
                .andExpect(jsonPath("$.amount").value(order.getAmount()));
    }
}

🎯 What I Learned

Through this project, I learned how to:

Write unit tests with JUnit
Mock dependencies using Mockito
Test Spring services independently
Test controllers
Load the Spring application context using @SpringBootTest
Simulate HTTP requests using MockMvc
Test real database integration
Work with MySQL in integration tests
Validate HTTP status codes
Validate JSON response data
Understand Arrange → Act → Assert
Understand test transactions
Use rollback for test isolation
Understand the purpose of @DataJpaTest
Understand the difference between unit and integration testing

🛠️ Technologies Used
Java
Spring Boot
Spring MVC
Spring Data JPA
Hibernate
JUnit
Mockito
MockMvc
MySQL
Maven

📚 Learning Objective

The main objective of this project is to understand how testing works in a real Spring Boot backend, rather than simply writing tests that pass.

The focus is on understanding:

What am I testing?
        ↓
Why am I testing it?
        ↓
Which layer am I testing?
        ↓
What dependencies should be real?
        ↓
What dependencies should be mocked?
        ↓
How do I verify the result?

👨‍💻 Author

Asim Khot

Learning Java Backend Development with Spring Boot.


### Suggested repository name

```text
spring-boot-testing
