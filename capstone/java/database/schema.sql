BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, property CASCADE;


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
	bedrooms int NOT NULL,
	bathrooms numeric (2, 1) NOT NULL,
	pic_url varchar(250),
	sq_footage int NOT NULL,
	description varchar(1000),
	landlord_id int NOT NULL,
	CONSTRAINT PK_property PRIMARY KEY (property_id),
	CONSTRAINT FK_landlord_id_to_user_id FOREIGN KEY (landlord_id) REFERENCES users (user_id),
	CONSTRAINT CK_price CHECK (price > 0),
	CONSTRAINT CK_bedrooms CHECK (bedrooms > 0),
	CONSTRAINT CK_bathrooms CHECK (bathrooms > 0),
	CONSTRAINT CK_sq_footage CHECK (sq_footage > 0)
	
);

COMMIT;
