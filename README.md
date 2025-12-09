# Credit Application Service

This is a microservice that handles the credit application process for affiliates in a system. It allows creating and updating affiliate records, creating credit applications, and evaluating the risk level of credit applications.

## Features

- **Register new affiliate**: Allows creating a new affiliate record in the system.
- **Update affiliate information**: Allows updating an existing affiliate's details.
- **Create credit application**: Allows affiliates to submit a credit application.
- **Evaluate credit application**: Evaluates the risk of a credit application.

## Use Cases

The application supports the following use cases:

1. **RegisterAffiliateUseCase**: Handles the registration of a new affiliate.
2. **CreateCreditApplicationUseCase**: Handles the creation of a new credit application for an affiliate.
3. **EvaluateCreditApplicationUseCase**: Evaluates the risk of a credit application.
4. **UpdateAffiliateUseCase**: Updates the information of an existing affiliate.
5. **GetAffiliateUseCase**: Retrieves an affiliate by their ID.

## Requirements

- Java 17 or later
- Spring Boot 2.5.x or later
- Maven or Gradle for dependency management
- Git for version control

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Sam-Rodriguez-jpg/Module6_Assessment.git
   ```

2. **Navigate to the project folder:**
```
cd Module6_Assessment/credit-application-service
```

3. **Build the project:**

If you are using Maven:
```
mvn clean install
```

If you are using Gradle:
```
gradle build
```

4. **Run the application:**

Using Maven:
```
mvn spring-boot:run
```

Using Gradle:
```
gradle bootRun
```

---

## Endpoints

The following REST endpoints are available:

- `POST /api/affiliates`: Registers a new affiliate.
- `PUT /api/affiliates/{affiliateId}`: Updates an existing affiliate.
- `GET /api/affiliates/{affiliateId}`: Retrieves an affiliate's information.

## Authentication

GitHub requires authentication via a **Personal Access Token (PAT)**. This means password authentication is no longer supported for Git operations.

### Steps to create and use a Personal Access Token (PAT):

1. Go to [GitHub Token Settings](https://github.com/settings/tokens).
2. Click on **Generate new token**.
3. Select the appropriate permissions (e.g., `repo` for repository access).
4. Copy the **generated token**.

**When pushing to the repository**, use the following authentication:

- **Username**: Your GitHub username.
- **Password**: The **Personal Access Token (PAT)** you generated.

For example:

```bash
git push -u origin main
Username for 'https://github.com': your-username
Password for 'https://your-username@github.com': your-personal-access-token
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
