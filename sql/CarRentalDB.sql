-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.15-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных car_rental
CREATE DATABASE IF NOT EXISTS `car_rental` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `car_rental`;

-- Дамп структуры для таблица car_rental.cars
CREATE TABLE IF NOT EXISTS `cars` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  `passengers` int(10) unsigned DEFAULT NULL,
  `fuel` varchar(255) DEFAULT NULL,
  `is_air_condition` tinyint(3) unsigned DEFAULT NULL,
  `price_per_day` int(10) unsigned DEFAULT NULL,
  `is_available` tinyint(4) unsigned DEFAULT '1',
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.cars: ~15 rows (приблизительно)
DELETE FROM `cars`;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`id`, `brand_name`, `model`, `type`, `transmission`, `passengers`, `fuel`, `is_air_condition`, `price_per_day`, `is_available`, `image`) VALUES
	(1, 'SMART', 'FORTWO', 'Mini', 'Manual', 2, 'Petrol', 1, 27, 1, 'https://image.ibb.co/cCOfVd/33540_GWY_R.png'),
	(2, 'AUDI', 'A8', 'Sedan', 'Automatic', 4, 'Diesel', 1, 142, 1, 'https://image.ibb.co/kncM3y/31780_GWY_R.png'),
	(25, 'AUDI', 'TT', 'Coupe', 'Manual', 2, 'Petrol', 1, 221, 1, 'https://image.ibb.co/eWsZso/audiTT.png'),
	(26, 'MERCEDES-BENZ', 'A-180', 'Compact', 'Automatic', 2, 'Petrol', 1, 85, 1, 'https://image.ibb.co/kq2658/MersA.png'),
	(27, 'BMW', 'X4', 'SUV', 'Automatic', 4, 'Diesel', 1, 198, 1, 'https://image.ibb.co/kaNTJT/BMWX4png.png'),
	(28, 'MERCEDES-BENZ', 'CLA 200', 'Sedan', 'Automatic', 5, 'Petrol', 1, 136, 1, 'https://image.ibb.co/epvR58/Mers_CLA200.png'),
	(29, 'MERCEDES-BENZ', 'VITO', 'Van', 'Automatic', 9, 'Petrol', 1, 320, 1, 'https://image.ibb.co/cYO2dT/MersVito.png'),
	(30, 'OPEL', 'INSIGNIA', 'Sedan', 'Manual', 5, 'Diesel', 0, 117, 1, 'https://image.ibb.co/niXHCo/OpelIns.png'),
	(31, 'SEAT', 'LEON', 'Compact', 'Manual', 5, 'Petrol', 1, 76, 1, 'https://image.ibb.co/czRzQ8/SEATLEON.png'),
	(32, 'SKODA', 'SUPERB', 'Sedan', 'Automatic', 5, 'Petrol', 1, 193, 0, 'https://image.ibb.co/k5rzQ8/SKODAsuperb.png'),
	(33, 'VW', 'GOLF 7', 'Compact', 'Manual', 5, 'Petrol', 0, 84, 1, 'https://image.ibb.co/jNi2dT/VWGolf7.png'),
	(34, 'VW', 'PASSAT', 'Sedan', 'Automatic', 5, 'Diesel', 1, 132, 1, 'https://image.ibb.co/eNL4so/VWpassat.png'),
	(35, 'VW', 'POLO', 'Compact', 'Manual', 5, 'Petrol', 0, 82, 1, 'https://image.ibb.co/fYKKQ8/VWPolo.png'),
	(36, 'VW', 'TIGUAN', 'SUV', 'Automatic', 5, 'Petrol', 1, 167, 1, 'https://image.ibb.co/kg0R58/VWTiguan.png'),
	(37, 'AUDI', 'A1', 'Compact', 'Manual', 4, 'Petrol', 1, 83, 0, 'https://image.ibb.co/jf32dT/AUDIA1.png');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.customer_personal_data
CREATE TABLE IF NOT EXISTS `customer_personal_data` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `passport_numb` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `driving_exp` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.customer_personal_data: ~7 rows (приблизительно)
DELETE FROM `customer_personal_data`;
/*!40000 ALTER TABLE `customer_personal_data` DISABLE KEYS */;
INSERT INTO `customer_personal_data` (`id`, `name`, `surname`, `passport_numb`, `date_of_birth`, `driving_exp`) VALUES
	(51, 'Viktor', 'Stulov', 'MP2321123471', '1969-06-19', 25),
	(52, 'Алексей', 'Фронтов', 'MP1236551243', '1978-06-21', 10),
	(53, 'Sergej', 'Novov', 'MS89238HJ', '1989-10-24', 5),
	(54, 'John', 'Williams', 'REW5243T', '1981-10-23', 15),
	(55, 'Goga', 'Jankins', 'MS356453', '1987-03-04', 3),
	(56, 'Ekaterina', 'Frolova', 'VSw7341', '1987-09-11', 3),
	(57, 'Ekaterina', 'Frolova', 'LK65213', '1985-06-11', 2);
/*!40000 ALTER TABLE `customer_personal_data` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.damages
CREATE TABLE IF NOT EXISTS `damages` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned DEFAULT NULL,
  `car_id` int(10) unsigned DEFAULT NULL,
  `damage_name` varchar(255) DEFAULT NULL,
  `damage_cost` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_damages_cars` (`car_id`),
  KEY `FK_damages_orders` (`order_id`),
  CONSTRAINT `FK_damages__cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_damages__orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.damages: ~3 rows (приблизительно)
DELETE FROM `damages`;
/*!40000 ALTER TABLE `damages` DISABLE KEYS */;
INSERT INTO `damages` (`id`, `order_id`, `car_id`, `damage_name`, `damage_cost`) VALUES
	(27, 107, 1, 'broken wheel', 50),
	(28, 107, 1, 'engine damage', 420),
	(29, 109, 1, 'Broken door', 55);
/*!40000 ALTER TABLE `damages` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` varchar(255) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `user_id` int(11) unsigned DEFAULT NULL,
  `car_id` int(11) unsigned DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `customer_id` int(10) unsigned DEFAULT NULL,
  `total_price` int(10) unsigned DEFAULT NULL,
  `insurance` tinyint(3) unsigned DEFAULT NULL,
  `is_damaged` tinyint(3) unsigned DEFAULT NULL,
  `damage_amount` int(10) unsigned DEFAULT NULL,
  `rejection_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_order_customer` (`customer_id`),
  KEY `FK_orders_cars` (`car_id`),
  KEY `FK_orders_users` (`user_id`),
  CONSTRAINT `FK_orders__cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_orders__customer` FOREIGN KEY (`customer_id`) REFERENCES `customer_personal_data` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_orders__users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.orders: ~7 rows (приблизительно)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `status`, `order_date`, `user_id`, `car_id`, `start_date`, `end_date`, `customer_id`, `total_price`, `insurance`, `is_damaged`, `damage_amount`, `rejection_reason`) VALUES
	(103, 'FINISHED', '2018-06-08', 2, 1, '2018-06-18', '2018-06-20', 51, 56, 1, 0, 0, NULL),
	(104, 'WAITING_FOR_APPROVE', '2018-06-08', 2, 1, '2018-06-19', '2018-06-21', 52, 56, 1, NULL, NULL, NULL),
	(105, 'REJECTED', '2018-06-08', 2, 25, '2018-06-11', '2018-06-13', 53, 442, 0, 0, 0, 'Sorry, You have bad order history!'),
	(106, 'PAID', '2018-06-08', 2, 2, '2018-06-11', '2018-06-13', 54, 286, 1, 0, 0, NULL),
	(107, 'WAITING_FOR_DAMAGE_PAYMENT', '2018-06-08', 2, 1, '2018-06-26', '2018-06-27', 55, 28, 1, 1, 470, NULL),
	(108, 'CANCELLED', '2018-06-08', 3, 1, '2018-06-27', '2018-06-28', 56, 28, 1, 0, 0, NULL),
	(109, 'WAITING_FOR_DAMAGE_PAYMENT', '2018-06-08', 3, 1, '2018-06-27', '2018-06-28', 57, 27, 0, 1, 55, NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `balance` int(10) unsigned NOT NULL DEFAULT '0',
  `is_admin` tinyint(4) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.users: ~4 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `password`, `name`, `surname`, `email`, `balance`, `is_admin`) VALUES
	(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Aleksey', 'Sprynchan', 'a.spirt@gmail.com', 0, 1),
	(2, 'user1', 'a722c63db8ec8625af6cf71cb8c2d939', 'Ivan', 'Ivanov', 'ivan@gmail.com', 433, 0),
	(3, 'user2', 'c1572d05424d0ecb2a65ec6a82aeacbf', 'Petr', 'Petrov', 'petr@gmail.com', 799, 0),
	(4, 'user3', '3afc79b597f88a72528e864cf81856d2', 'Sidor', 'Sidorov', 'sidor@gmail.com', 10, 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
