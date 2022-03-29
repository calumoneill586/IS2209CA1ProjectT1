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

