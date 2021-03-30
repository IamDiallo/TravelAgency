-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 30, 2021 at 02:06 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel`
--

-- --------------------------------------------------------

--
-- Table structure for table `cities`
--

CREATE TABLE `cities` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `country_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cities`
--

INSERT INTO `cities` (`id`, `name`, `country_id`) VALUES
(1, 'Paris', 1),
(2, 'Lyon', 1),
(3, 'Marseille', 1);

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--

CREATE TABLE `countries` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `continent` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `countries`
--

INSERT INTO `countries` (`id`, `name`, `continent`) VALUES
(1, 'Fance', 'Europe'),
(2, 'Italie', 'Europe');

-- --------------------------------------------------------

--
-- Table structure for table `destinations`
--

CREATE TABLE `destinations` (
  `id` int(11) NOT NULL,
  `nameDest` varchar(30) NOT NULL,
  `typeDest` int(11) NOT NULL,
  `city_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destinations`
--

INSERT INTO `destinations` (`id`, `nameDest`, `typeDest`, `city_id`) VALUES
(1, 'Eiffel Tower', 1, 1),
(2, 'Arc de Triomphe', 1, 1),
(3, 'Cathédrale Notre-Dame ', 1, 1),
(4, 'Basilique de Fourvière', 1, 2),
(5, 'Cathédrale Saint-Jean', 1, 2),
(6, 'Château de la Tourette', 1, 2),
(7, 'Parc Martin Luther King', 2, 1),
(8, 'Jardin des Tuileries', 2, 1),
(9, 'Jardin du Luxembourg', 2, 1),
(10, 'Parc de la Tête d\'or', 2, 2),
(11, 'Parc des berges du Rhône', 2, 2),
(12, 'le massif de la Sainte-Baume', 3, 3),
(13, 'la montagne Sainte-Victoire', 3, 3),
(14, 'le mont Olympe', 3, 3),
(15, 'la Brévenne', 3, 2),
(16, 'le Garon', 3, 2),
(17, 'la Coise', 3, 2),
(18, 'Abbaye Saint-Victor', 1, 3),
(19, 'Château d’If', 1, 3),
(20, 'Château de la Buzine.', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `dest_type`
--

CREATE TABLE `dest_type` (
  `id` int(11) NOT NULL,
  `destType` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dest_type`
--

INSERT INTO `dest_type` (`id`, `destType`) VALUES
(1, 'Monuments'),
(2, 'Parc'),
(3, 'Montagne');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cities`
--
ALTER TABLE `cities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Country` (`country_id`);

--
-- Indexes for table `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `destinations`
--
ALTER TABLE `destinations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_destinations` (`typeDest`),
  ADD KEY `fk_cities` (`city_id`);

--
-- Indexes for table `dest_type`
--
ALTER TABLE `dest_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cities`
--
ALTER TABLE `cities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `countries`
--
ALTER TABLE `countries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `destinations`
--
ALTER TABLE `destinations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `dest_type`
--
ALTER TABLE `dest_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cities`
--
ALTER TABLE `cities`
  ADD CONSTRAINT `FK_Country` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

--
-- Constraints for table `destinations`
--
ALTER TABLE `destinations`
  ADD CONSTRAINT `fk_cities` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`),
  ADD CONSTRAINT `fk_destinations` FOREIGN KEY (`typeDest`) REFERENCES `dest_type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
