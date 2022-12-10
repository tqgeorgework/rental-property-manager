BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, name) VALUES ('landlord','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_LANDLORD', 'jotaro');
INSERT INTO users (username,password_hash,role, name) VALUES ('landlord2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_LANDLORD', 'josephine');
INSERT INTO users (username,password_hash,role, name) VALUES ('landlord3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_LANDLORD', 'jolene');
INSERT INTO users (username,password_hash,role, name) VALUES ('landlord4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_LANDLORD', 'joanna');
INSERT INTO users (username,password_hash,role, name) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'jonny5');

INSERT INTO users (username,password_hash,role, name) VALUES ('maintenance1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MAINTENANCE', 'jo');
INSERT INTO users (username,password_hash,role, name) VALUES ('maintenance2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MAINTENANCE', 'joe');
INSERT INTO users (username,password_hash,role, name) VALUES ('maintenance3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MAINTENANCE', 'joseph');
INSERT INTO users (username,password_hash,role, name) VALUES ('maintenance4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MAINTENANCE', 'joey');
INSERT INTO users (username,password_hash,role, name) VALUES ('maintenance5','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MAINTENANCE', 'jojo');

INSERT INTO users (username,password_hash,role, name) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'josh');
INSERT INTO users (username,password_hash,role, name) VALUES ('user2','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'joshua');
INSERT INTO users (username,password_hash,role, name) VALUES ('user3','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'jodi');
INSERT INTO users (username,password_hash,role, name) VALUES ('user4','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'joel');
INSERT INTO users (username,password_hash,role, name) VALUES ('user5','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'jonathan');
INSERT INTO users (username,password_hash,role, name) VALUES ('user6','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'jose');


INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id) 
VALUES ('201 S Sunbury Rd, Westerville, OH 43081', 2200, 4, 2, 'https://photos.zillowstatic.com/fp/f4dd05266fac8d7cfcd44793142519b6-cc_ft_768.webp', 1727,
		'4 BR 2 full bath ranch home that overlooks Hoover Reservoir. Go over for a walk or to fish! The bike path that runs along Hoover is just across the street! Spacious living room with a picture window with a beautiful view. Formal dining room as well as an eat in kitchen with new stainless appliances. 4 large bedrooms and updated bathrooms with custom tile finishes. This charming home has a huge unfinished basement that has been waterproofed and is perfect for addional living space. Plenty of off street parking and a two car garage. This is a large lot for lots of privacy. Looking for an 18 month lease. Westerville schools. No pets or smoking and shed is not for tenant use. This property allows self guided viewing without an appointment. Contact for details.',
		1);
		
INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('1109 24th Ave, Columbus, OH 43211', 1300, 3, 1, 'https://photos.zillowstatic.com/fp/09f2fed9061026c30863b313e2da93d6-uncropped_scaled_within_1536_1152.webp', 1300, 
					 'Three bedroom HOUSE - Welcome to 1109 E. 24th St. located in North Columbus. This is a three bedroom, cape cod style home with the largest of the three bedrooms being upstairs. One bath and an eat in kitchen. Hardwood flooring, brand new kitchen and bathroom, Full basement with washer and dryer hookup. Garage in back yard accessible from the alleyway. Wateris an additional $100 monthly to be paid with rent 
Residents must supply their own appliances 
App fee is $35 per adult and non-refundable 
-3x rent in monthly gross income 
-No evictions in the past 5 years 
-No balances due to previous landlords 
-No felonies in the past 10 years 
-Pass full national credit & criminal background check at time of application', 1);

INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('5900 Sundrops Ave, Galloway, OH 43119', 1850, 3, 2, 'https://photos.zillowstatic.com/fp/225e39d319a84f6e74b75180b2f48c4c-cc_ft_768.webp', 
	   1800, 'description', 1);
	   
	   INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('3169 Longspur Dr, Columbus, OH 43228, OH 43119', 1995, 3, 2, 'https://maps.googleapis.com/maps/api/streetview?location=3169+Longspur+Dr%2C+Columbus%2C+OH+43228&size=768x576&key=AIzaSyARFMLB1na-BBWf7_R3-5YOQQaHqEJf6RQ&source=outdoor&&signature=Ioyo7sKQiK8otDOvP0DAQI9csqc=', 
	   1258, 'description', 1);
	   
	   INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('120 W Blake Ave, Columbus, OH 43202', 1575, 2, 1, 'https://photos.zillowstatic.com/fp/fedc08af2d57f776ac57b6f2c1ec9356-uncropped_scaled_within_1536_1152.webp', 
	   1375, 'description', 1);
	   
	   INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('2986 E Powell Rd, Columbus, OH 43240', 1950, 3, 2.5, 'https://photos.zillowstatic.com/fp/225e39d319a84f6e74b75180b2f48c4c-cc_ft_768.webp', 
	   1800, 'description', 1);
	   
	   INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('6000 Sundrops Ave, Galloway, OH 43119', 1800, 3, 2, 'https://photos.zillowstatic.com/fp/b8682f6904dda8fc30f192fbd6b7c734-cc_ft_768.webp', 
	   1404, 'description', 1);
	   
	   INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('6993 Richfield Dr, Reynoldsburg, OH 43068', 2085, 3, 2, 'https://photos.zillowstatic.com/fp/9be09309b3da361d2d9da5d07ecce3b3-cc_ft_768.webp', 
	   1296, 'description', 1);
	   
	   INSERT INTO property (address, price, bedrooms, bathrooms, pic_url, sq_footage, description, landlord_id)
VALUES ('4311 Sidway Ave, Columbus, OH 43227', 1495, 3, 2, 'https://photos.zillowstatic.com/fp/c641c08fcf0c0ae3d0c7ba69345971a9-cc_ft_768.webp', 
	   1218, 'description', 1);
	   
INSERT INTO property_users(property_id, renter_id)
VALUES (1, 11);
INSERT INTO property_users(property_id, renter_id)
VALUES (1, 12);
INSERT INTO property_users(property_id, renter_id)
VALUES (2, 13);
INSERT INTO property_users(property_id, renter_id)
VALUES (2, 14);
INSERT INTO property_users(property_id, renter_id)
VALUES (3, 15);
	   
	  


COMMIT TRANSACTION;
