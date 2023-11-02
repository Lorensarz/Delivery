CREATE DATABASE delivery;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

create type order_status as enum ('new', 'processing', 'shipped', 'delivered', 'cancelled');


CREATE TABLE delivery(
 delivery_uuid uuid  DEFAULT gen_random_uuid() PRIMARY KEY,
 order_uuid uuid,
 order_date TIMESTAMP ,
 delivery_date TIMESTAMP ,
 orderState order_status ,
 curier uuid ,
 adress VARCHAR  ,
 cost numeric
);

