/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  admin
 * Created: 29 Mar 2022
 */
--Create Pizza Table with autoid, name, and price
CREATE TABLE PIZZA (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, "NAME" VARCHAR(100), PRICE DECIMAL(8, 2), PRIMARY KEY (ID));

--Insert five rows of data into the pizza table
insert into pizza (name, price) values('Pepperoni', 10.99);
insert into pizza (name, price) values('Hawaiian', 11.99);
insert into pizza (name, price) values('Margherita', 9.99);
insert into pizza (name, price) values('Vegetarian', 11.99);
insert into pizza (name, price) values('Seafood', 12.99);

--Create Ingredient Table with autoid, name, calories, allergens
CREATE TABLE INGREDIENT (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, "NAME" VARCHAR(100), "CALORIES" INT, "ALLERGENS" VARCHAR(100), PRIMARY KEY (ID));

--Insert ten rows of data into ingredient table
insert into ingredient (name, calories, allergens) values('Cheese', 90, 'Dairy');
insert into ingredient (name, calories, allergens) values('Tomato Sauce', 30, '');
insert into ingredient (name, calories, allergens) values('Pepperoni', 100, 'Dairy');
insert into ingredient (name, calories, allergens) values('Ham', 90, '');
insert into ingredient (name, calories, allergens) values('Pineapple', 50, '');
insert into ingredient (name, calories, allergens) values('Shrimp', 80, 'Shellfish');
insert into ingredient (name, calories, allergens) values('Crab Meat', 90, 'Shellfish');
insert into ingredient (name, calories, allergens) values('Peppers', 40, '');
insert into ingredient (name, calories, allergens) values('Sweetcorn', 40, '');
insert into ingredient (name, calories, allergens) values('Olives', 30, '');

--Create PIZZAINGREDIENTLOOKUP with autoid, foreign keys pizzaid and ingredientid
CREATE TABLE PIZZAINGREDIENTLOOKUP (
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
"PIZZAID" INT,
    FOREIGN KEY ("PIZZAID") REFERENCES PIZZA (ID),
"INGREDIENTID" INT,
    FOREIGN KEY ("INGREDIENTID") REFERENCES INGREDIENT (ID),
PRIMARY KEY (ID)
);

--Insert 19 rows of data into PIZZAINGREDIENTLOOKUP, relating pizzas to the ingredients they have
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(1, 1);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(1, 2);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(1, 3);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(2, 1);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(2, 2);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(2, 4);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(2, 5);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(3, 1);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(3, 2);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(4, 1);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(4, 2);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(4, 8);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(4, 9);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(4, 10);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(4, 1);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(5, 1);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(5, 2);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(5, 6);
insert into pizzaingredientlookup (PIZZAID, INGREDIENTID) values(5, 7);

--Insert 9 rows into CUSTOMER table
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Marco Dalla', '1 Main Street', 'Douglas', '2628 7972 8917 7493', '086 098 7654', 'Dairy', 'username', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('George Dunphy', '2 Main Street', 'Douglas', '2379 2898 2084 5793', '086 334 4455', 'Dairy', 'dunphy1', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Barry McCarthy', '3 Main Street', 'Carrigaline', '6987 8398 3984 3874', '086 111 9786', '', 'barmanbarry', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Isabelle McDonald', '8 Water Down Street', 'Ballincollig', '2379 1234 6347 9874', '086 667 2333', 'Shellfish', 'mcdonald21', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Michael Souft', '96 Grange Street', 'Douglas', '2379 1217 9548 8594', '086 556 9234', 'Dairy', 'michaelsouft', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Robert Cove-Williams-Wizard', '34 Magic Road', 'Mallow', '2346 2387 6509 2958', '089 123 4567', 'Shellfish', 'wizard99', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Joe Chickenball', '41 Nevergreen Terrace', 'Douglas', '2009 5482 5802 8435', '089 345 9823', '', 'chickenballjoe', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Rupert Beasley', '42 Nevergreen Terrace', 'Douglas', '2828 1485 4243 8993', '089 983 5124', 'Dairy', 'beasleystreet', 'password');
insert into CUSTOMER (NAME, ADDRESSLINE1, ADDRESSLINE2, CREDITCARDNO, PHONENO, ALLERGIES, USERNAME, PASSWORD) values('Evan Healy', '26 Weston Park', 'Mallow', '2023 5132 9850 5243', '086 196 8842', 'Shellfish', 'handsomehealy', 'password');

--Create Orders
CREATE TABLE ORDERS (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
"CUSTOMERID" INT,
    FOREIGN KEY ("CUSTOMERID") REFERENCES CUSTOMER (ID),
"PAYMETHOD" VARCHAR(100),
"GETMETHOD" VARCHAR(100),
"REQUEST" VARCHAR(100),
PRIMARY KEY (ID)); 

--OrderItem
CREATE TABLE ORDERITEM (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
"ORDERID" INT,
    FOREIGN KEY ("ORDERID") REFERENCES ORDERS (ID),
"PIZZAID" INT,
    FOREIGN KEY ("PIZZAID") REFERENCES PIZZA (ID),
"QUANTITY" DOUBLE,
PRIMARY KEY (ID));

--Create custompizza
CREATE TABLE CUSTOMPIZZA (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
"ORDERITEMID" INT,
    FOREIGN KEY ("ORDERITEMID") REFERENCES ORDERITEM (ID),
"INGREDIENTID" INT,
    FOREIGN KEY ("INGREDIENTID") REFERENCES INGREDIENT (ID),
PRIMARY KEY (ID));

-- Create Shop Table
CREATE TABLE SHOP (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, "LOCATION" VARCHAR(100), PRIMARY KEY (ID)); 

--Populating Shop 
insert into shop (location) values('Ballincollig'); 
insert into shop (location) values('Mallow');
insert into shop (location) values('Carrigaline'); 
insert into shop (location) values('Douglas');


-- Create Staff Table
CREATE TABLE STAFF (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
"SHOPID" INT,
    FOREIGN KEY ("SHOPID") REFERENCES SHOP (ID),
"STAFFROLE" VARCHAR(100),
PRIMARY KEY (ID)); 


--Populating Staff 
insert into staff (shopid, STAFFROLE) values(1, 'Manager');
insert into staff (shopid, STAFFROLE) values(2, 'Manager');
insert into staff (shopid, STAFFROLE) values(3, 'Manager');
insert into staff (shopid, STAFFROLE) values(1, 'Delivery Driver');
insert into staff (shopid, STAFFROLE) values(2, 'Delivery Driver');
insert into staff (shopid, STAFFROLE) values(3, 'Delivery Driver');
insert into staff (shopid, STAFFROLE) values(1, 'Floor Staff');
insert into staff (shopid, STAFFROLE) values(2, 'Floor Staff');
insert into staff (shopid, STAFFROLE) values(3, 'Floor Staff');
insert into staff (shopid, STAFFROLE) values(4, 'Manager');
insert into staff (shopid, STAFFROLE) values(4, 'Delivery Driver');
insert into staff (shopid, STAFFROLE) values(4, 'Floor Staff');