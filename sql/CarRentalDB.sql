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
  `doors` int(10) unsigned DEFAULT NULL,
  `passengers` int(10) unsigned DEFAULT NULL,
  `fuel` varchar(255) DEFAULT NULL,
  `isAirCondition` tinyint(3) unsigned DEFAULT NULL,
  `price_per_day` int(10) unsigned DEFAULT NULL,
  `isAvailable` tinyint(4) unsigned DEFAULT '1',
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.cars: ~9 rows (приблизительно)
DELETE FROM `cars`;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`id`, `brand_name`, `model`, `type`, `transmission`, `doors`, `passengers`, `fuel`, `isAirCondition`, `price_per_day`, `isAvailable`, `image`) VALUES
	(1, 'Mercedes-Benz', 'S500', 'Sedan', 'Automatic', 5, 5, 'Diesel', 1, 95, 1, NULL),
	(2, 'BMW', 'X5', 'SUV', 'Automatic', 5, 5, 'Diesel', 1, 20, 1, NULL),
	(3, 'Kia', 'Rio', 'Mini', 'Manual', 5, 5, 'Gas', 1, 30, 1, NULL),
	(4, 'Renault', 'Logan', 'Sedan', 'Manual', 5, 4, 'Gas', 0, 40, 1, NULL),
	(6, 'Volvo', 'XC90', 'SUV', 'Automatic', 5, 5, 'Gas', 1, 55, 1, NULL),
	(7, 'Mazda', 'model 6', 'Sedan', 'Automatic', 5, 5, 'Gas', 1, 35, 1, NULL),
	(10, 'Mazda', 'model 3', 'Sedan', 'Automatic', 5, 4, 'Gas', 1, 24, 1, NULL),
	(12, 'Mercedes-Benz', 'C230', 'Sedan', 'Manual', 5, 4, 'Diesel', 1, 28, 1, NULL),
	(20, 'Honda', 'Accord', 'Sedan', 'Automatic', 5, 4, 'Gas', 1, 19, 1, NULL);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.cars_damage_cost
CREATE TABLE IF NOT EXISTS `cars_damage_cost` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` int(10) unsigned DEFAULT NULL,
  `cracked_windshield_cost` int(10) unsigned DEFAULT NULL,
  `small_dent_cost` int(10) unsigned DEFAULT NULL,
  `broken_headlight_cost` int(10) unsigned DEFAULT NULL,
  `punctured_wheel_cost` int(10) unsigned DEFAULT NULL,
  `large_dent_cost` int(10) unsigned DEFAULT NULL,
  `engine_damage_cost` int(10) unsigned DEFAULT NULL,
  `huge_damage_cost` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_cars_damages_cost__cars` (`car_id`),
  CONSTRAINT `FK_cars_damages_cost__cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.cars_damage_cost: ~0 rows (приблизительно)
DELETE FROM `cars_damage_cost`;
/*!40000 ALTER TABLE `cars_damage_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `cars_damage_cost` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.customer_personal_data
CREATE TABLE IF NOT EXISTS `customer_personal_data` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `passport_numb` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `driving_exp` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.customer_personal_data: ~6 rows (приблизительно)
DELETE FROM `customer_personal_data`;
/*!40000 ALTER TABLE `customer_personal_data` DISABLE KEYS */;
INSERT INTO `customer_personal_data` (`id`, `name`, `surname`, `passport_numb`, `date_of_birth`, `driving_exp`) VALUES
	(32, 'Aleksey321', 'Sprynchan', 'MP88888888', '1990-12-04', 15),
	(33, 'uidyfsh', 'adsgf', 'jjsgdf', '2018-05-15', 20),
	(34, 'dhgfgh', 'cnedgwg', 'gssefs', '2018-05-17', 34),
	(37, 'fdcfca', 'asdasda', 'asdaczc', '2018-05-02', 2),
	(38, 'asdzxc', 'zxczxc', 'ascd', '2018-05-16', 45),
	(39, 'sdfsfs', 'dfsvx', 'cvxcv', '2018-05-14', 23);
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
  CONSTRAINT `FK_damages_cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_damages_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.damages: ~3 rows (приблизительно)
DELETE FROM `damages`;
/*!40000 ALTER TABLE `damages` DISABLE KEYS */;
INSERT INTO `damages` (`id`, `order_id`, `car_id`, `damage_name`, `damage_cost`) VALUES
	(10, 86, 1, 'broken wheel', 120),
	(11, 86, 1, 'small dent', 50),
	(12, 86, 1, 'engine damage', 565);
/*!40000 ALTER TABLE `damages` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.damage_history
CREATE TABLE IF NOT EXISTS `damage_history` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned DEFAULT NULL,
  `car_id` int(10) unsigned DEFAULT NULL,
  `cracked_windshield` tinyint(3) unsigned DEFAULT '0',
  `small_dent` tinyint(3) unsigned DEFAULT '0',
  `broken_headlight` tinyint(3) unsigned DEFAULT '0',
  `punctured_wheel` tinyint(3) unsigned DEFAULT '0',
  `large_dent` tinyint(3) unsigned DEFAULT '0',
  `engine_damage` tinyint(3) unsigned DEFAULT '0',
  `huge_damage` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK2_damage_history__orders` (`order_id`),
  KEY `FK1_damage_history__cars` (`car_id`),
  CONSTRAINT `FK_damage_history__cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_damage_history__orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.damage_history: ~0 rows (приблизительно)
DELETE FROM `damage_history`;
/*!40000 ALTER TABLE `damage_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `damage_history` ENABLE KEYS */;

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
  `isDamaged` tinyint(3) unsigned DEFAULT NULL,
  `damage_amount` int(10) unsigned DEFAULT NULL,
  `rejection_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FK_order_customer` (`customer_id`),
  KEY `FK_orders_cars` (`car_id`),
  KEY `FK_orders_users` (`user_id`),
  CONSTRAINT `FK_orders__cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_orders__customer` FOREIGN KEY (`customer_id`) REFERENCES `customer_personal_data` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_orders__users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.orders: ~6 rows (приблизительно)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `status`, `order_date`, `user_id`, `car_id`, `start_date`, `end_date`, `customer_id`, `total_price`, `insurance`, `isDamaged`, `damage_amount`, `rejection_reason`) VALUES
	(80, 'CANCELLED', '2018-05-05', 2, 1, '2018-05-09', '2018-05-11', 32, 192, 1, 0, 0, NULL),
	(85, 'FINISHED', '2018-05-06', 2, 1, '2018-05-15', '2018-05-18', 33, 288, 1, 0, 0, NULL),
	(86, 'FINISHED', '2018-05-06', 2, 1, '2018-05-28', '2018-05-30', 34, 190, 0, 1, 735, NULL),
	(89, 'REJECTED', '2018-05-07', 2, 2, '2018-05-22', '2018-05-25', 37, 63, 1, 0, 0, 'qweaxczxc'),
	(90, 'REJECTED', '2018-05-08', 2, 1, '2018-05-23', '2018-05-25', 38, 192, 1, 0, 0, 'sdg'),
	(91, 'WAITING_FOR_APPROVE', '2018-05-09', 2, 2, '2018-05-22', '2018-05-25', 39, 63, 1, NULL, NULL, NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `balance` int(10) unsigned NOT NULL DEFAULT '0',
  `isAdmin` tinyint(4) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.users: ~5 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `password`, `name`, `surname`, `email`, `balance`, `isAdmin`) VALUES
	(1, 'admin', 'admin', 'Aleksey', 'Sprynchan', 'a.spirt@gmail.com', 0, 1),
	(2, 'user1', 'pass1', 'Ivan', 'Ivanov', 'ivan@gmail.com', 400, 0),
	(3, 'user2', 'pass2', 'Petr', 'Petrov', 'petr@gmail.com', 867, 0),
	(4, 'user3', 'pass3', 'Sidor', 'Sidorov', 'sidor@gmail.com', 0, 0),
	(5, 'Ekaterina', '1604', 'Ekaterina', 'Sprynchan', 'kate@gmail.com', 150, 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
