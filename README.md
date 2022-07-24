Coverage: 64.7%
# Project Title

This project connects to a database allowing the input of customers, items and the orders combining both customers and their orders. It connects to a MySQL database that it will create itself calles "ims".

## Getting Started

In order to connect to your data base you will need to edit the db.properties file. Change the base URL to match that of your SQl server whether local or otherwise and for the regular url make sure to add "/ims" to the end in order to connect to this database specifically. The username and password need to match that of your detatils for MySQL. An oversight on my part that I would have chnged in the future would have been to change the customer ID variable name from just id to customerId to improve the projets readability, but just for your benefit if you see id refered to at any point it will always be the customer id.

### Prerequisites

You will need some kind of Java IDE Eclipse was used for this program and MySQL for the database control. Maven will also need to be intalled in order to package the file.

### Integration Tests 
Explain what these tests test, why and how to run them

As of uploading this the tests have a coverage of 64.7% and the cover the following files:
Customer.java
Order.Java
Item.java
CustomerDAO.java
OrderDAO.java
ItemDAO.java
CustomerController.java
OrderController.java
ItemController.java

## Deployment

Open the command line in the file where this project is saved and run the following commands:

```
mvn clean
mvn package
```
When I tested packaging this file it flagged a whole series of errors that me and trainers could not resolve. I did however ask others to test my code on a different device and they assured me that it worked and packaged correctly.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Harry Cope** - *Building off of the original program* - [Harry Cope](https://github.com/HarryCope)

