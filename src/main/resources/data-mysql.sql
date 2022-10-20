CREATE DATABASE IF NOT EXISTS flightradar404;
USE flightradar404;

DROP TABLE IF EXISTS flight;
DROP TABLE IF EXISTS terminal;
DROP TABLE IF EXISTS airport;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS pilot;
DROP TABLE IF EXISTS plane;
DROP TABLE IF EXISTS model;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS country;

CREATE TABLE country (name VARCHAR(45) NOT NULL PRIMARY KEY) ENGINE=InnoDB;

CREATE TABLE pilot (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 name VARCHAR(45) NOT NULL,
 surname VARCHAR(45) NOT NULL,
 age INT NOT NULL,
 flight_experience INT NOT NULL) ENGINE=InnoDB;

CREATE TABLE model (name VARCHAR(45) NOT NULL PRIMARY KEY,
 length FLOAT NOT NULL,
 wingspan FLOAT NOT NULL,
 count_of_seats INT NOT NULL) ENGINE=InnoDB;
 
CREATE TABLE city (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 name VARCHAR(45) NOT NULL,
 country_name VARCHAR(45) NOT NULL,
 CONSTRAINT fk_country_name1 FOREIGN KEY(country_name) REFERENCES country(name)) ENGINE=InnoDB;
 
CREATE TABLE airport (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 name VARCHAR(45) NOT NULL,
 city_id INT NOT NULL,
 CONSTRAINT fk_city_id FOREIGN KEY(city_id) REFERENCES city(id)) ENGINE=InnoDB;

CREATE TABLE terminal (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 number INT NOT NULL,
 airport_id INT NOT NULL,
 CONSTRAINT fk_airport_id FOREIGN KEY(airport_id) REFERENCES airport(id)) ENGINE=InnoDB;

CREATE TABLE company (name VARCHAR(45) NOT NULL PRIMARY KEY,
 country_name VARCHAR(45) NOT NULL,
 count_of_plane INT NOT NULL,
 CONSTRAINT fk_country_name2 FOREIGN KEY(country_name) REFERENCES country(name)) ENGINE=InnoDB;

CREATE TABLE plane (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 model_name VARCHAR(45) NOT NULL,
 company_name VARCHAR(45) NOT NULL,
 speed FLOAT NOT NUll,
 flight_time FLOAT NOT NULL,
 CONSTRAINT fk_model_name FOREIGN KEY(model_name) REFERENCES model(name)) ENGINE=InnoDB;
 
CREATE TABLE flight (id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
 pilot_id INT NOT NULL,
 plane_id INT NOT NULL,
 start_terminal INT NOT NULL,
 end_terminal INT NOT NULL,
 data DATE NOT NULL,
 time TIME NOT NULL,
 price FLOAT NOT NULL,
 CONSTRAINT fk_pilot_id FOREIGN KEY(pilot_id) REFERENCES pilot(id),
 CONSTRAINT fk_plane_id FOREIGN KEY(plane_id) REFERENCES plane(id),
 CONSTRAINT fk_flight_terminal1 FOREIGN KEY(start_terminal) REFERENCES terminal(id),
 CONSTRAINT fk_flight_terminal2 FOREIGN KEY(end_terminal) REFERENCES terminal(id)) ENGINE=InnoDB;
 
INSERT INTO country VALUES ('Belgium'),('Canada'),('England'),('France'),('Germany'),('Italy'),('Poland'),('Spain'),('Ukraine'),('USA');
INSERT INTO city VALUES (1,'Brugge','Belgium'),(2,'London','England'),(3,'Paris','France'),(4,'Keln','Germany'),(5,'Milan','Italy'),(6,'Krakiv','Poland'),(7,'Barcelona','Spain'),(8,'Lviv','Ukraine');
INSERT INTO airport VALUES (9,'Josep Tarradellas Barcelona-El Prat',7),(10,'Oostende-Brugge',1),(11,'Cologne Bonn',4),(12,'Kraków',6),(13,'London International',2),(14,'Danylo Halytskiy',8),(15,'Malpensa',5),(16,'Paris Charles de Gaulle',3);
INSERT INTO terminal VALUES (17,3,9),(18,8,12),(19,4,15),(20,2,10),(21,2,16),(22,1,11),(23,10,14),(24,4,9),(25,2,15),(26,7,16);
INSERT INTO pilot VALUES (37,'Stepan','Borshch',44,15879),(38,'Alex','Koval',37,9767),(39,'Bogdan','Varenyk',29,1679),(40,'Marko','Kich',31,2666),(41,'Yuriy','Hek',56,34128),(42,'Taras','Kos',33,3107),(43,'Valeriy','Plushch',59,39891),(44,'Oleg','Puhach',38,10611),(45,'Semen','Kos',26,1501),(46,'Maksum','Vovk',47,19510),(47,'Vasyl','Stus',33,13467);
INSERT INTO model VALUES ('Airbus A320',38.9,34.2,180),('Airbus A350',66,64.6,450),('Airbus A380',73.1,80.9,853),('Boeing 737',40,34.7,189),('Boeing 747',71.5,64,366),('Boeing 777',63,64.8,388),('Boeing 787',57.3,60.7,248),('Cessna 525C',16,14.3,9);
INSERT INTO company VALUES ('Air France','France',346),('Emirates','Belgium',142),('Eva Air','Italy',234),('Hainan','Spain',99),('MAU','Ukraine',455),('Qatar','USA',347);
INSERT INTO plane VALUES (27,'Boeing 737','MAU',777,8),(28,'Airbus A380','MAU',434,3),(29,'Boeing 737','Eva Air',879,12),(30,'Cessna 525C','Hainan',342,7),(31,'Boeing 777','Air France',111,1),(32,'Airbus A320','Emirates',455,7),(33,'Airbus A320','MAU',397,4),(34,'Boeing 787','Air France',667,9),(35,'Boeing 787','Eva Air',99,1),(36,'Airbus A380','Emirates',544,6);
INSERT INTO flight VALUES (46,41,31,22,19,'2022-09-10','16:00:00',69),(47,37,35,17,26,'2022-08-25','01:30:00',189),(48,42,28,24,25,'2022-09-25','21:15:00',42),(49,44,30,26,20,'2022-10-01','09:45:00',99),(50,45,29,18,25,'2022-10-05','06:10:00',25),(51,42,36,19,23,'2022-11-18','17:30:00',169);

CREATE INDEX pilot_idx ON pilot(flight_experience);
CREATE INDEX company_idx ON company(count_of_plane);
CREATE INDEX plane_idx ON plane(speed, flight_time);
CREATE INDEX flight_idx ON flight(data, time, price);

SHOW INDEX FROM pilot;
SHOW INDEX FROM company;
SHOW INDEX FROM plane;
SHOW INDEX FROM flight;