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
  `isAvailable` tinyint(4) unsigned DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.cars: ~9 rows (приблизительно)
DELETE FROM `cars`;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`id`, `brand_name`, `model`, `type`, `transmission`, `doors`, `passengers`, `fuel`, `isAirCondition`, `isAvailable`) VALUES
	(1, 'Mercedes-Benz', 'S500', 'Sedan', 'Automatic', 5, 5, 'Diesel', 1, 0),
	(2, 'BMW', 'X5', 'SUV', 'Automatic', 5, 5, 'Diesel', 1, 1),
	(3, 'Kia', 'Rio', 'Mini', 'Manual', 5, 5, 'Gas', 1, 1),
	(4, 'Renault', 'Logan', 'Sedan', 'Manual', 5, 4, 'Gas', 0, 1),
	(6, 'Volvo', 'XC90', 'SUV', 'Automatic', 5, 5, 'Gas', 1, 1),
	(7, 'Mazda', 'model 6', 'Sedan', 'Automatic', 5, 5, 'Gas', 1, 1),
	(10, 'Mazda', 'model 3', 'Sedan', 'Automatic', 5, 4, 'Gas', 1, 1),
	(12, 'Mercedes-Benz', 'C230', 'Sedan', 'Manual', 5, 4, 'Diesel', 1, 1),
	(20, 'Honda', 'Accord', 'Sedan', 'Automatic', 5, 4, 'Gas', 0, 1);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.cars_images
CREATE TABLE IF NOT EXISTS `cars_images` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `car_id` int(11) unsigned DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `priority` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1_cars_images_cars` (`car_id`),
  CONSTRAINT `FK1_cars_images_cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.cars_images: ~2 rows (приблизительно)
DELETE FROM `cars_images`;
/*!40000 ALTER TABLE `cars_images` DISABLE KEYS */;
INSERT INTO `cars_images` (`id`, `car_id`, `img`, `priority`) VALUES
	(1, 1, 'images/qwe.jpeg', 1),
	(2, 2, 'dasdasdcz', 1);
/*!40000 ALTER TABLE `cars_images` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.customer_personal_data
CREATE TABLE IF NOT EXISTS `customer_personal_data` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `passport_numb` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `driving_exp` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.customer_personal_data: ~2 rows (приблизительно)
DELETE FROM `customer_personal_data`;
/*!40000 ALTER TABLE `customer_personal_data` DISABLE KEYS */;
INSERT INTO `customer_personal_data` (`id`, `name`, `surname`, `passport_numb`, `date_of_birth`, `driving_exp`) VALUES
	(7, 'vvvvvvvvvvv', 'vvvvvvvvv', 'vvvvvvvv', '2018-04-13', 4),
	(8, 'user2', 'user2', 'passport2', '2018-04-05', 2);
/*!40000 ALTER TABLE `customer_personal_data` ENABLE KEYS */;

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
  `isDamaged` tinyint(3) unsigned DEFAULT NULL,
  `damage_amount` int(10) unsigned DEFAULT NULL,
  `rejection_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_cars` (`car_id`),
  KEY `FK_orders_users` (`user_id`),
  KEY `FK_order_customer` (`customer_id`),
  CONSTRAINT `FK_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer_personal_data` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_orders_cars` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_orders_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.orders: ~2 rows (приблизительно)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `status`, `order_date`, `user_id`, `car_id`, `start_date`, `end_date`, `customer_id`, `total_price`, `isDamaged`, `damage_amount`, `rejection_reason`) VALUES
	(55, 'CANCELLED', '2018-04-19', 2, 10, '2018-04-06', '2018-04-21', 7, 0, 0, 0, 'qweqweqwe'),
	(56, 'WAITING_FOR_APPROVE', '2018-04-20', 3, 1, '2018-04-12', '2018-04-13', 8, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп структуры для таблица car_rental.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `isAdmin` tinyint(4) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_rental.users: ~4 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `password`, `name`, `surname`, `email`, `isAdmin`) VALUES
	(1, 'admin', 'admin', 'Aleksey', 'Sprynchan', 'a.spirt@gmail.com', 1),
	(2, 'user1', 'pass1', 'Ivan', 'Ivanov', 'ivan@gmail.com', 0),
	(3, 'user2', 'pass2', 'Petr', 'Petrov', 'petr@gmail.com', 0),
	(4, 'user3', 'pass3', 'Sidor', 'Sidorov', 'sidor@gmail.com', 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
