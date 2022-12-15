BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, property, property_users, maintenance CASCADE;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE property (
	property_id SERIAL,
	address varchar(100) NOT NULL,
	price numeric(12, 2) NOT NULL,
	--change numeric to money and update on the backend
	bedrooms int NOT NULL,
	bathrooms numeric (2, 1) NOT NULL,
	pic_url varchar(250),
	sq_footage int NOT NULL,
	description varchar(1000),
	landlord_id int NOT NULL,
	is_rented boolean NOT NULL DEFAULT false,
	rent_status varchar(20) NOT NULL DEFAULT 'DUE',
	due_day int NOT NULL DEFAULT 5,
	CONSTRAINT CK_rent_status CHECK (rent_status IN ('PAID', 'DUE', 'OVERDUE')), 
	CONSTRAINT PK_property PRIMARY KEY (property_id),
	CONSTRAINT FK_landlord_id_to_user_id FOREIGN KEY (landlord_id) REFERENCES users (user_id),
	CONSTRAINT CK_price CHECK (price > 0),
	CONSTRAINT CK_bedrooms CHECK (bedrooms > 0),
	CONSTRAINT CK_bathrooms CHECK (bathrooms > 0),
	CONSTRAINT CK_sq_footage CHECK (sq_footage > 0)
);

CREATE TABLE property_users (
	property_id int,
	renter_id int,
	CONSTRAINT FK_property_id_to_property_id FOREIGN KEY (property_id) REFERENCES property (property_id),
	CONSTRAINT FK_renter_id_to_user_id FOREIGN KEY (renter_id) REFERENCES users (user_id)	
);

CREATE TABLE maintenance (
title varchar (100) NOT NULL,
request_id SERIAL,
worker_id int DEFAULT NULL,
request_date timestamp NOT NULL DEFAULT Now(),
property_id int,
maintenance_status varchar(15) DEFAULT 'RECEIVED',
description varchar(1000) NOT NULL,
CONSTRAINT PK_maintenance PRIMARY KEY (request_id),
CONSTRAINT FK_maintenance_worker FOREIGN KEY (worker_id) REFERENCES users (user_id),
CONSTRAINT FK_maintenance_property FOREIGN KEY (property_id) REFERENCES property (property_id),
CONSTRAINT CK_maintenance_status CHECK (maintenance_status IN ('RECEIVED', 'IN PROGRESS', 'COMPLETE'))

);


COMMIT TRANSACTION;
