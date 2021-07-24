# Automating Amazon Web using Selenium WebDriver
## Overview
This project is to automate Amazon web application using Selenium WebDriver with Java. Developed as a requirement of phase 1 in the Automation Masters Program provided by Simplilearn on behalf of Saudi Digital Academy. 
## Problem Statement
The Amazon application has a huge database. The customers are taking more time to find a particular product. As a Test Engineer, I have to write an automation script to get the list of different products in a particular category. Based on the list, it will be easy for the customers to select the product.
## Goals
* Automating the Amazon web to get the list of types of a particular product.
* Manage Transactions using Selenium and JDBC.
* Writing automation scripts using page object design pattern.
## Specifications
- Project type: Maven. 
- Programming language: Java 1.8.
- Framework: Selenium standalone server 3.141.59
- Database: MySQL.
- Pattern: Page object design (POM).
- Editor: Eclipse.

## MySQL Setup 
### 1. Create the database:
``` sql
create database AmazonProducts;
```
### 2. Create products table:
``` sql
create table products(
category varchar(30),
product varchar(30));
```
### 3. Insert products:
You could pick any category from amazon and insert it along with the product name e.g.: category: Amazon Fashion, product: Sunglasses.  
``` sql
Insert into products(category, product)
Values ("Amazon Devices","Iphone 12");
```

### 4. JDBC Connection: 
You have to change database url, username and password under JDBCSetupForAmazonDB() method in AmazonHomePage.java class based on your mysql configuration:
``` java
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/AmazonProducts","root","root");
```
