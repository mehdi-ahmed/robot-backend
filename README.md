
**Description**

   * This a Java Spring boot Backend project that manages a RobotPart Inventory.
   
   *Technologies Used :* 
   - Spring boot *2.0.3*    
   - H2 embedded in-memory database.    
   - Swagger UI for a documenting the REST API.
   - Spring 5.x / Java 8 / Maven 3.x
   
**- How to run the application**

        - Command line : ./mvnw clean install -U and then mvn spring-boot:run
         OR : 
        
        - Import to IDE and run the Main class RobotChallengeApplication.java  
   
   
   Remark : Default port used is 8081    
   -  In case there is a problem with the current port being used, please change the port in the resources/application.properties
   and also in the test/resources/test.properties that is used in the Integration Tests.
              
**- Swagger Ui**
     
     http://localhost:8081/swagger-ui.html#/robot45part45controller
   
**- H2 DB Console**  
    
     http://localhost:8081/h2-console/
   
        - JDBC URL : jdbc:h2:mem:bootapp;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
        - User Name : sa
        - Password : 
   

