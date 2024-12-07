# Migration Instructions

## Prerequisites
- Ensure you have Docker installed and running on your machine.
- Ensure you have Gradle installed or use the provided Gradle wrapper.

## Steps to Execute the Migration

1. **Clone the Repository**
   ```sh
   git clone https://github.com/ezequiassam2/delogic-eval.git
   cd delogic-eval
   ```

2. **Export Environment Variables**
   - Rename file template.env to .env
   - Run the following command to export the environment variables:
     ```sh
     export $(cat .env | xargs)
     ```

3. **Start the MySQL Database**
   - Run the following command to start the MySQL container:
     ```sh
     docker-compose up -d db
     ```

4. **Build the Project**
   - If you have Gradle installed:
     ```sh
     gradle build
     ```
   - If you are using the Gradle wrapper:
     ```sh
     ./gradlew build
     ```

5. **Execute the Flyway Migrations**
   - If you have Gradle installed:
     ```sh
     gradle flywayMigrate
     ```
   - If you are using the Gradle wrapper:
     ```sh
     ./gradlew flywayMigrate
     ```

6. **Verify the Migration**
   - Connect to the MySQL database to verify that the tables have been created and data has been loaded:
     ```sh
     docker exec -it <container_id> mysql -u${MYSQL_ROOT_USER} -p${MYSQL_ROOT_PASSWORD}
     USE ${MYSQL_DATABASE};
     SHOW TABLES;
     ```

7. **Start the Application**
   - Run the following command to start the application container:
     ```sh
     docker-compose up -d app
     ```  

8. **Verify the Application**
 - Open your browser and navigate to http://localhost:8080 to verify that the application is running.
 - Please refer to the API \`DOCS_API.md\` to use the application.

## Notes
- This guide is for running the migration locally. Password configurations should be stored securely.