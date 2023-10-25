## Local Setup

To run this application locally, you'll need to configure the database connection in the `application.yml` file. 
Here are the steps:

1. Clone the repository to your local machine:
   ```bash
   git clone git@github.com:saurabhmaslekar1/sentryc-ttpl.git
   ```

   Navigate to the project directory:

   ```
   cd sentryc-graphql-test
   ```

2. Open the src/main/resources/application.yml file and configure the database settings. You may need to set the URL, username, and password for your database.

   ```
    spring.datasource.url=jdbc:postgresql://localhost:5435/your_db_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
   ```

3. Save the changes.


4. Build and run the application:

   ``` bash
   ./mvnw spring-boot:run
   ```

5. Your Spring Boot application should now be running locally. Access it in your web browser at http://localhost:8080.