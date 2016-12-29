# RESTful-Inventory-Service
##REST API for managing inventory; using Java and Jersey

This a simple service for managing product inventory. 
User can get and update inventory counts for specific products at specific stores/locations.

Products are identified by a unique SKU (ID), and contain counts of that product at different stores.
Each store will be uniquely identified by a store number. For example, here is a sample table defining product inventory information:

| SKU | Name          | Store | Count |
|-----|---------------|-------|-------|
| 123 | iPhone 7 64GB | 900   | 12    |
| 234 | iPhone 6 16GB | 900   | 9     |
| 345 | iPhone 5 32GB | 900   | 4     |
 
##Functional Requirements:
The following features/methods have been implemented:
- Register/define a new product with a SKU and product name
- Get the inventory count for a product at a particular store (for instance, get number of iPhones at store number 900)
- Update the inventory count for a product as a particular store (for instance, update number of iPhones at store number 900 to 20)


##Technology
- Application Server: GlassFish
- Jersey framework
- IDE: Eclipse IDE for Java EE Developers - Neon
- Java EE
- Database: MySQL
- Build tool: Maven


##References
* http://java.boot.by/scbcd5-guide/ch08s05.html
* https://examples.javacodegeeks.com/enterprise-java/rest/jersey/jax-rs-queryparam-example/
* http://www.java2s.com/Code/Java/JPA/NamedQueryWithTwoParameters.htm
* https://www.tutorialspoint.com/restful/restful_first_application.htm
* http://zangolie.com/building-a-restful-web-service-in-java/
* http://www.mkyong.com/tutorials/jax-rs-tutorials/
* http://www.codemiles.com/jpa/more-than-one-parameter-with-name-query-t6188.html
* http://www.codingpedia.org/ama/resources-on-how-to-design-error-handling-in-a-rest-api
* http://www.codingpedia.org/ama/error-handling-in-rest-api-with-jersey/#61_Source_Code
* http://stackoverflow.com/
* http://howtodoinjava.com/jersey/jax-rs-jersey-custom-exceptions-handling-with-exceptionmapper/
