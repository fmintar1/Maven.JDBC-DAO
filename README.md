# JDBC - CRUD - daos.DAO Lab

Requirements

* JDK 1.8
* SQL database


## Part 1 Create Data Model

1. Create a sql database using a RDBMS (MySql)
2. Create a table to represent some object data
    * The table should have 5-7 fields that represent the object
3. Populate the database with at least 5 records

__example__

a _car_ table may have the fields for:

* id
* make
* model
* year
* color
* vin

## Part 2 Configure Java Application to use the JDBC API

Use Maven.com to get the sql-connector-java dependency. Add this to your pom.xml


## Create daos.DAO

Create a Java app that uses the daos.DAO pattern to perform CRUD operations on you sql database 
[daos.DAO Pattern](https://dzone.com/articles/building-simple-data-access-layer-using-jdbc)

These classes should include:

1. A daos.DAO abstract class or interface for the following methods
    * public T findById(int id);
    * public List<T> findAll();
    * public T update(T dto);
    * public T create(T dto);
    * public  void delete(int id);
2. A daos.DAO concrete class that implements all the methods of the abstract or interface from the previous step
3. A models.DTO interface with the following method stub
    * int getId();
4. A concrete models.DTO class that implements the interface.

## Run the App
Create an App runner class to run each CRUD operation against your daos.DAO

* findById()
* findAll()
* update()
* create()
* delete()




