# Link Shortener

The project is a Spring Boot application that provides a Link Shortener service. It allows users to generate short URLs for long URLs, making it easier to share and manage links. The application handles the generation of unique short URLs, checks for duplicate URLs, and includes a time-based expiration feature to ensure the short URLs are valid for a limited time. The project utilizes Spring Boot's MVC architecture, JPA for data persistence, and RESTful API endpoints to interact with the frontend. It provides a user-friendly interface to enter URLs and obtain their shortened versions. The application is scalable, modular, and easily extendable, making it suitable for various use cases.


## Prerequisites

- Java Development Kit (JDK8 and above) 
- Maven 3 or above
- Your preferred IDE (IntelliJ IDEA, Eclipse, etc.)
- Database H2

## Installation

1. Clone the repository:
	- git clone https://github.com/PrasannaKumarReddyBoreddy/link-shortener-full-stack.git
   
2. Change to the project directory:
	- cd link-shortener-spring-boot
	
3. Import the project into your preferred IDE as a Maven project

4. Build and run the application using your IDE or the following command:
	- mvn spring-boot:run