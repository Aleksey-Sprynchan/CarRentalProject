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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.cars: ~11 rows (приблизительно)
DELETE FROM `cars`;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`id`, `brand_name`, `model`, `type`, `transmission`, `passengers`, `fuel`, `is_air_condition`, `price_per_day`, `is_available`, `image`) VALUES
	(1, 'SMART', 'FORTWO', 'Mini', 'Manual', 2, 'Gas', 1, 27, 1, 'https://image.ibb.co/cCOfVd/33540_GWY_R.png'),
	(2, 'AUDI', 'A8', 'Sedan', 'Automatic', 4, 'Gas', 1, 142, 1, 'https://image.ibb.co/kncM3y/31780_GWY_R.png'),
	(3, 'Kia', 'Rio', 'Mini', 'Manual', 5, 'Gas', 1, 30, 1, 'https://thumb.ibb.co/fhXM0d/KiaRio.jpg'),
	(4, 'Renault', 'Logan', 'Sedan', 'Manual', 4, 'Gas', 0, 40, 1, 'https://thumb.ibb.co/m2V26J/Renault_Logan.png'),
	(6, 'Volvo', 'XC90', 'SUV', 'Automatic', 5, 'Gas', 1, 55, 0, 'https://thumb.ibb.co/f1YYDy/Volvo_XC90.jpg'),
	(7, 'Mazda', 'model 6', 'Sedan', 'Automatic', 5, 'Gas', 1, 35, 1, 'https://thumb.ibb.co/e9Qr0d/Mazda6.jpg'),
	(10, 'Mazda', 'model 3', 'Sedan', 'Automatic', 4, 'Gas', 1, 24, 1, 'https://thumb.ibb.co/dz7FRJ/Mazda3.jpg'),
	(12, 'Mercedes-Benz', 'C230', 'Sedan', 'Manual', 4, 'Diesel', 1, 28, 1, 'https://thumb.ibb.co/kMsM0d/C200.jpg'),
	(20, 'Honda', 'Accord', 'Sedan', 'Automatic', 4, 'Gas', 1, 19, 0, 'https://thumb.ibb.co/bDMyyy/Honda_Accord.png'),
	(21, 'BMW', 'X5', 'SUV', 'Automatic', 5, 'Diesel', 1, 20, 1, 'https://thumb.ibb.co/kOcPmJ/bmwX5.jpg'),
	(23, 'Mercedes-Benz', 'S500', 'Sedan', 'Automatic', 5, 'Diesel', 1, 95, 1, 'https://thumb.ibb.co/ijGQRJ/Mercedes_Benz_S500.jpg');
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.customer_personal_data: ~16 rows (приблизительно)
DELETE FROM `customer_personal_data`;
/*!40000 ALTER TABLE `customer_personal_data` DISABLE KEYS */;
INSERT INTO `customer_personal_data` (`id`, `name`, `surname`, `passport_numb`, `date_of_birth`, `driving_exp`) VALUES
	(32, 'Aleksey321', 'Sprynchan', 'MP88888888', '1990-12-04', 15),
	(33, 'uidyfsh', 'adsgf', 'jjsgdf', '2018-05-15', 20),
	(34, 'dhgfgh', 'cnedgwg', 'gssefs', '2018-05-17', 34),
	(37, 'fdcfca', 'asdasda', 'asdaczc', '2018-05-02', 2),
	(38, 'asdzxc', 'zxczxc', 'ascd', '2018-05-16', 45),
	(39, 'sdfsfs', 'dfsvx', 'cvxcv', '2018-05-14', 23),
	(40, 'swrefsdvf', 'svxcvxc', 'vsdsw', '2018-05-09', 3),
	(41, 'kjahdfkjh', 'kjdzhfkjahf', 'jdfzfj', '2018-05-09', 4),
	(42, 'pppppppppppp', 'ppppppppppppp', 'ppppppppppppppp', '2018-05-08', 6),
	(43, 'zxvxzfqefa', 'qsdcxzcqsa', 'caszcsqacz', '2018-05-02', 4),
	(44, 'Сергей', 'Cельский', 'MP1312312', '1953-06-17', 3),
	(45, 'Aleksey', 'Cельский', 'zxczxc', '2018-06-16', 10),
	(46, 'Виктор', 'Cельский', 'qweqwe', '2018-06-20', 123),
	(47, 'KJdajkdhkh', 'Skajhsdkj', 'kajsdhkjhasd', '2018-06-07', 2),
	(48, 'Wdsfsdf', 'Wckfjslfd', 'sdfkjshdf4', '2018-06-14', 44),
	(50, 'Qsadaq', 'SDSsdfsdf', 'qwe123', '2018-06-13', 6);
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.damages: ~17 rows (приблизительно)
DELETE FROM `damages`;
/*!40000 ALTER TABLE `damages` DISABLE KEYS */;
INSERT INTO `damages` (`id`, `order_id`, `car_id`, `damage_name`, `damage_cost`) VALUES
	(10, 86, 23, 'broken wheel', 120),
	(11, 86, 23, 'small dent', 50),
	(12, 86, 23, 'engine damage', 565),
	(13, 91, 21, 'dam1', 10),
	(14, 91, 21, 'dam2', 20),
	(15, 91, 21, 'dam3', 30),
	(16, 92, 23, 'dam1', 111),
	(17, 92, 23, 'dam2', 111),
	(18, 92, 23, 'dam3', 111),
	(19, 92, 23, 'dam4', 111),
	(20, 96, 1, '123', 123),
	(21, 96, 1, '@#!#', 123),
	(22, 96, 1, 'qweqwe', 222),
	(23, 96, 1, 'asasd', 333),
	(24, 102, 4, '21323414', 8),
	(25, 102, 4, '@#@', 123),
	(26, 102, 4, '#@!', 123);
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
  CONSTRAINT `FK_orders__customer` FOREIGN KEY (`customer_id`) REFERENCES `customer_personal_data` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_orders__users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.orders: ~16 rows (приблизительно)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `status`, `order_date`, `user_id`, `car_id`, `start_date`, `end_date`, `customer_id`, `total_price`, `insurance`, `is_damaged`, `damage_amount`, `rejection_reason`) VALUES
	(80, 'CANCELLED', '2018-05-05', 2, 23, '2018-05-09', '2018-05-11', 32, 192, 1, 0, 0, NULL),
	(85, 'FINISHED', '2018-05-06', 2, 23, '2018-05-15', '2018-05-18', 33, 288, 1, 0, 0, NULL),
	(86, 'FINISHED', '2018-05-06', 2, 23, '2018-05-28', '2018-05-30', 34, 190, 0, 1, 735, NULL),
	(89, 'REJECTED', '2018-05-07', 2, 21, '2018-05-22', '2018-05-25', 37, 63, 1, 0, 0, 'qweaxczxc'),
	(90, 'REJECTED', '2018-05-08', 2, 23, '2018-05-23', '2018-05-25', 38, 192, 1, 0, 0, 'sdg'),
	(91, 'FINISHED', '2018-05-09', 2, 21, '2018-05-22', '2018-05-25', 39, 63, 1, 1, 60, NULL),
	(92, 'WAITING_FOR_DAMAGE_PAYMENT', '2018-05-10', 2, 23, '2018-05-30', '2018-05-31', 40, 95, 0, 1, 444, NULL),
	(93, 'WAITING_FOR_PAYMENT', '2018-05-13', 2, 23, '2018-05-22', '2018-05-30', 41, 768, 1, 0, 0, NULL),
	(94, 'CANCELLED', '2018-05-14', 2, 23, '2018-05-16', '2018-05-17', 42, 95, 0, 0, 0, NULL),
	(95, 'CANCELLED', '2018-05-14', 2, 2, '2018-05-17', '2018-05-30', 43, 1859, 1, 0, 0, NULL),
	(96, 'RETURNED', '2018-06-01', 2, 1, '2018-06-20', '2018-06-21', 44, 28, 1, 1, 801, NULL),
	(97, 'FINISHED', '2018-06-01', 2, 1, '2018-06-05', '2018-06-07', 45, 54, 0, 0, 0, NULL),
	(98, 'REJECTED', '2018-06-01', 3, 4, '2018-06-12', '2018-06-13', 46, 41, 1, 0, 0, 'sdkjhvxcuqhf kjzdhf z jhakfha xc zhaj kfkzjh uq'),
	(99, 'REJECTED', '2018-06-06', 2, 3, '2018-06-20', '2018-06-29', 47, 279, 1, 0, 0, 'sfkjghvgjqgfjkcbzxkjchasjk'),
	(100, 'WAITING_FOR_PAYMENT', '2018-06-06', 2, 7, '2018-06-27', '2018-06-28', 48, 36, 1, 0, 0, NULL),
	(102, 'WAITING_FOR_DAMAGE_PAYMENT', '2018-06-06', 2, 4, '2018-06-22', '2018-06-25', 50, 120, 0, 1, 254, NULL);
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
	(2, 'user1', 'a722c63db8ec8625af6cf71cb8c2d939', 'Ivan', 'Ivanov', 'ivan@gmail.com', 203, 0),
	(3, 'user2', 'c1572d05424d0ecb2a65ec6a82aeacbf', 'Petr', 'Petrov', 'petr@gmail.com', 826, 0),
	(4, 'user3', '3afc79b597f88a72528e864cf81856d2', 'Sidor', 'Sidorov', 'sidor@gmail.com', 10, 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
