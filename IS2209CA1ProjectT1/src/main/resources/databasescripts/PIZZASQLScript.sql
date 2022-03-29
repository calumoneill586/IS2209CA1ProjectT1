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