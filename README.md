###Tech Stack
1. Java JDK `1.8`
2. Spring Boot `2.2.6.RELEASE`

###Assumptions
1. Income and Salary are double primitive type
2. All Incomes are rounded off to the nearest whole number, by leveraging the Math.Round() method.

###To Run
1. If running from IDE, provide Program Arguments (`"Mary Song" 60000`), and then proceed to run the application
2. If running from cmd/bash ->

    a. `mvn package`
    
    b. `java -jar target/employee-income-0.0.1-SNAPSHOT.jar "Mary Song" 60000`