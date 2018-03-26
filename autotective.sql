USE autotective ;
set foreign_key_checks=0;

drop table if exists setting;
drop table if exists tester;
drop table if exists sessions;
drop table if exists car;
drop table if exists log;
drop table if exists steering;
drop table if exists sensor;

create table setting (
	settingID int NOT NULL,
	gearNumber int NOT NULL,
	speedLimit int NOT NULL,
	testerID int NOT NULL,
	PRIMARY KEY(settingID).
	FOREIGN KEY(testerID) REFERENCES tester(testerID)
		ON DELETE CASCADE
		ON UPDATE CASCADE
	);

create table sensor (
	senstypeOf VARCHAR(11) NOT NULL,
	status CHAR(5) NOT NULL,
	carID int NOT NULL,
	PRIMARY KEY (SenstypeOf, CarID),
	FOREIGN KEY (CarID) REFERENCES Car (CarID)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);


create table log (
	logID int PRIMARY KEY,
	comment TEXT,
	latitude DECIMAL(8,7) NOT NULL,
	longitude DECIMAL(8,7) NOT NULL,
	speed int NOT NULL,
	brake int NOT NULL,
	typeOf VARCHAR(7) NOT NULL,
	seshID int NOT NULL;
	FOREIGN KEY (SeshID) REFERENCES Session(SeshID)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);


create table tester (
	testerID int PRIMARY KEY,
	fullName VARCHAR(50)
);

create table sessions (
	seshID int PRIMARY KEY,
	startTime TIME NOT NULL,
	endTime TIME,
	testerID int NOT NULL,
	carID int NOT NULL,
	settingID int NOT NULL,
	FOREIGN KEY (TesterID) REFERENCES Tester (testerID)
		ON DELETE CASCADE
		ON UPDATE CASCADE
	FOREIGN KEY (SettingID) REFERENCES Setting (SettingID)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
	FOREIGN KEY (CarID) REFERENCES Car (CarID)
		ON DELETE NO ACTION
		ON UPDATE CASCADE
);


create table car (
	carID int PRIMARY KEY,
	tested CHAR(5) NOT NULL
);

insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, true);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, false);
insert into car (carID, tested) values (NULL, false);

insert into tester (testerID, fullName) values (NULL, 'Davey Ullett');
insert into tester (testerID, fullName) values (NULL, 'Karina Matthiesen');
insert into tester (testerID, fullName) values (NULL, 'Birgit Krelle');
insert into tester (testerID, fullName) values (NULL, 'Melli Schuster');
insert into tester (testerID, fullName) values (NULL, 'Gino Clemitt');
insert into tester (testerID, fullName) values (NULL, 'Hendrick Quinell');
insert into tester (testerID, fullName) values (NULL, 'Janina Loan');
insert into tester (testerID, fullName) values (NULL, 'Mike Ygo');
insert into tester (testerID, fullName) values (NULL, 'Zed Greenly');
insert into tester (testerID, fullName) values (NULL, 'Gus Beddall');
insert into tester (testerID, fullName) values (NULL, 'Brewster Sloy');
insert into tester (testerID, fullName) values (NULL, 'Minta Henmarsh');
insert into tester (testerID, fullName) values (NULL, 'Milena Derrell');
insert into tester (testerID, fullName) values (NULL, 'Marice Armsby');
insert into tester (testerID, fullName) values (NULL, 'Felic Donovin');
insert into tester (testerID, fullName) values (NULL, 'Kerstin Jacques');
insert into tester (testerID, fullName) values (NULL, 'Norris Bus');
insert into tester (testerID, fullName) values (NULL, 'Oralie Langabeer');
insert into tester (testerID, fullName) values (NULL, 'Corrie Wolverson');
insert into tester (testerID, fullName) values (NULL, 'Josie Varey');

insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 04:17:00, 01:57:00, 8, 6, 1);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 12:52:00, 02:09:00, 5, 6, 2);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 02:51:00, 09:57:00, 4, 10, 2);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 01:08:00, 12:53:00, 4, 17, 3);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 05:55:00, 09:16:00, 3, 12, 5);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 05:37:00, 08:19:00, 5, 14, 3);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 12:53:00, 04:50:00, 8, 11, 5);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 05:09:00, 08:26:00, 5, 18, 7);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 04:31:00, 12:20:00, 8, 10, 10);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 09:48:00, 09:57:00, 1, 19, 11);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 05:28:00, 03:56:00, 1, 19, 17);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 05:47:00, 05:54:00, 5, 11, 11);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 11:04:00, 03:32:00, 9, 13, 12);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 12:38:00, 06:20:00, 1, 17, 11);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 12:55:00, 06:06:00, 10, 14, 17);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 03:56:00, 11:42:00, 14, 16, 13);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 10:59:00, 05:44:00, 10, 2, 16);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 11:01:00, 04:53:00, 13, 6, 16);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 05:33:00, 12:23:00, 14, 3, 19);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 09:17:00, 06:01:00, 11, 2, 16);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 09:39:00, 02:52:00, 16, 1, 13);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 02:02:00, 04:33:00, 14, 5, 10);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 11:53:00, 10:34:00, 14, 8, 3);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 09:10:00, 07:33:00, 2, 4, 3);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 06:05:00, 01:27:00, 4, 8, 8);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 04:31:00, 11:55:00, 6, 2, 2);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 06:34:00, 09:54:00, 4, 8, 7);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 12:14:00, 11:18:00, 5, 3, 10);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 01:35:00, 03:01:00, 2, 4, 3);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 08:43:00, 07:15:00, 5, 10, 5);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 01:25:00, 02:05:00, 1, 1, 2);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 10:11:00, 08:07:00, 1, 8, 4);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 12:02:00, 11:27:00, 5, 8, 6);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 11:23:00, 11:36:00, 8, 3, 5);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 05:46:00, 02:46:00, 1, 3, 3);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 10:20:00, 09:00:00, 10, 1, 7);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 11:40:00, 10:20:00, 19, 4, 1);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 02:04:00, 01:18:00, 16, 6, 4);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 03:25:00, 10:09:00, 19, 1, 4);
insert into sessions (seshID, startTime, endTime, testerID, carID, settingID) values (NULL, 09:40:00, 05:01:00, 15, 7, 4);

insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Morbi vel lectus in quam fringilla rhoncus.', 43.4945737, 5.8978018, 4, 5, 'tires', 4);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Proin interdum mauris non ligula pellentesque ultrices.', 37.2980237, 127.6371628, 2, 7, 'lights', 3);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Aliquam erat volutpat.', 50.2620534, 22.4210807, 5, 2, 'windows', 2);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Proin risus.', 6.085685, 8.3280086, 4, 6, 'camera', 1);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Aenean auctor gravida sem.', -7.0416627, 110.3998007, 0, 7, 'brake', 10);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 52.9434371, 20.5544716, 0, 9, 'camera', 9);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', 46.8282022, 28.589271, 3, 8, 'camera', 8);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Duis aliquam convallis nunc.', 51.249084, 21.0819865, 2, 9, 'tires', 7);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Quisque id justo sit:00et sapien dignissim vestibulum.', 39.728885, 116.341609, 2, 6, 'tires', 6);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 40.1694467, -8.4784931, 5, 3, 'brake', 5);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Morbi ut odio.', 51.4790619, 11.9027428, 0, 1, 'brake', 4);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Duis at velit eu est congue elementum.', 29.306756, 120.07514, 8, 2, 'brake', 3);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Nam dui.', 41.3435561, -8.3773116, 6, 4, 'camera', 2);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit:00et eleifend pede libero quis orci.', 46.801046, 98.0983756, 1, 3, 'windows', 3);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Vivamus vel nulla eget eros elementum pellentesque.', 28.7401, 118.793215, 7, 0, 'brake', 8);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Vestibulum rutrum rutrum neque.', 13.8198099, 100.5633655, 6, 6, 'tires', 9);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'In hac habitasse platea dictumst.', 38.7285284, -9.4069248, 0, 1, 'windows', 14);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Donec posuere metus vitae ipsum.', '36.61667', '37.45', 5, 7, 'tires', 19);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Aenean sitet justo.', 44.1509604, 15.5846313, 2, 2, 'brake', 12);
insert into log (logID, comment, latitude, longitude, speed, brake, typeOf, seshID) values (NULL, 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', 31.7579946, 25.0792189, 4, 2, 'lights', 11);

insert into sensor (senstypeOf, status, carID) values ('vision', false, 6);
insert into sensor (senstypeOf, status, carID) values ('temperature', true, 10);
insert into sensor (senstypeOf, status, carID) values ('radar', false, 5);
insert into sensor (senstypeOf, status, carID) values ('speed', true, 9);
insert into sensor (senstypeOf, status, carID) values ('temperature', false, 7);
insert into sensor (senstypeOf, status, carID) values ('gps', false, 17);
insert into sensor (senstypeOf, status, carID) values ('temperature', true, 14);
insert into sensor (senstypeOf, status, carID) values ('radar', false, 13);
insert into sensor (senstypeOf, status, carID) values ('radar', true, 2);
insert into sensor (senstypeOf, status, carID) values ('gps', false, 8);
insert into sensor (senstypeOf, status, carID) values ('speed', false, 1);
insert into sensor (senstypeOf, status, carID) values ('temperature', false, 6);
insert into sensor (senstypeOf, status, carID) values ('gps', false, 8);
insert into sensor (senstypeOf, status, carID) values ('gps', false, 7);
insert into sensor (senstypeOf, status, carID) values ('speed', true, 4);
insert into sensor (senstypeOf, status, carID) values ('vision', true, 3);
insert into sensor (senstypeOf, status, carID) values ('gps', true, 10);
insert into sensor (senstypeOf, status, carID) values ('vision', false, 10);
insert into sensor (senstypeOf, status, carID) values ('temperature', false, 1);
insert into sensor (senstypeOf, status, carID) values ('gps', false, 4);

insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 4, 2, 7);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 0, 4, 6);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 5, 1, 1);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 3, 5, 5);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 6, 6, 10);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 0, 9, 4);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 5, 5, 4);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 0, 6, 1);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 9, 5, 10);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 3, 6, 9);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 8, 6, 9);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 6, 1, 5);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 7, 6, 4);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 9, 5, 1);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 1, 1, 3);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 5, 8, 5);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 0, 5, 10);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 8, 6, 1);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 5, 8, 6);
insert into setting (settingID, gearNumber, speedLimit, testerID) values (NULL, 5, 9, 2);
