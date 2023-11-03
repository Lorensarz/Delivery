CREATE DATABASE delivery;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE delivery(
 delivery_uuid uuid  DEFAULT gen_random_uuid() PRIMARY KEY,
 order_uuid uuid,
 order_date TIMESTAMP ,
 delivery_date TIMESTAMP ,
 orderState varchar ,
 curier uuid ,
 adress VARCHAR  ,
 cost numeric
);

