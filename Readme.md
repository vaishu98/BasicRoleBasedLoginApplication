# Role-Based Login Application (Backend)

This is a simple Spring Boot application that provides role-based 
authentication using JWT (JSON Web Tokens). The application utilizes MySQL as the database
and offers two user roles: ROLE_ADMIN and ROLE_USER. The roles are stored in the roles 
table in the database, and the admin user and user-role mapping are stored in the users and 
user_roles tables, respectively.

## Prerequisites

Before running the application, ensure that you have the following:

- JDK (Java Development Kit) installed on your system.
- MySQL database server installed and running.
- Access credentials for the MySQL database.

## Installation

To set up and run the backend application, follow these steps:

- **Clone the repository:** git clone <repository-url>

- **Navigate to the project directory:** cd <project-directory>

- Open the src/main/resources/application.properties file and update the following properties with your MySQL database credentials:

  - spring.datasource.url: The URL for your MySQL database.
  - spring.datasource.username: The username for your MySQL database.
  - spring.datasource.password: The password for your MySQL database.

- Build the project: ./mvnw clean install
- Run the application: ./mvnw spring-boot:run

The application should now be up and running on http://localhost:8080.

## API Endpoints

The following API endpoints are available:

### User Registration
- **Endpoint:** POST /api/auth/register
- **Description:** Create a new user account with the ROLE_USER role.

### User Login
- **Endpoint:** POST /api/auth/login
- **Description:** Log in as a user or admin to obtain a JWT token.
  
### User-Restricted Endpoint
  
- Endpoint: GET /api/user
- Description: Accessible only to users with the ROLE_USER role.
- Authorization: Set the Authorization header with the value Bearer <jwt-token>.
  
### Admin-Restricted Endpoint
  
- Endpoint: GET /api/admin/**
- Description: Accessible only to users with the ROLE_ADMIN role.
- Authorization: Set the Authorization header with the value Bearer <jwt-token>.
  
## Frontend Implementation

The frontend implementation of this application can be found in the R
ole-Based-Login-Application-frontend-using-Angular repository at https://github.com/vaishu98/Role-Based-Login-Application-frontend-using-Angular.git

Please follow the instructions in the frontend repository's README file to set up and run the Angular frontend application.

## Contribution

Contributions are welcome! If you find any issues or would like to add new features, feel free to submit a pull request.

Please ensure that your code adheres to the coding standards and is well-documented.

## License

This project is licensed under the MIT License.