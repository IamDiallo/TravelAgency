-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 13, 2021 at 03:42 AM
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
  `country_id` int(11) NOT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `cityImg` varchar(50) DEFAULT NULL,
  `esti_price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cities`
--

INSERT INTO `cities` (`id`, `name`, `country_id`, `longitude`, `latitude`, `cityImg`, `esti_price`) VALUES
(1, 'Paris', 1, 2.3522, 48.8566, 'img/paris.png', 1050),
(2, 'Lyon', 1, 4.8357, 45.764, 'img/lyon.png', 800),
(3, 'Marseille', 1, 5.3698, 43.2965, 'img/marseille.png', 750),
(4, 'Venice', 2, 12.3155, 45.4408, 'img/venice.jpeg', 600),
(5, 'Roma', 2, 12.4964, 41.9028, 'img/roma.png', 750),
(6, 'Milan', 2, 9.19, 45.4642, 'img/milan.png', 850),
(7, 'Lisbon', 3, 9.1393, 38.7223, 'img/lisbon.jpeg', 305),
(8, 'Tavira', 3, 7.643, 37.1336, 'img/tavira.jpeg', 200),
(9, 'Evora', 3, 7.9135, 38.5714, 'img/evora.jpeg', 400),
(10, 'Berlin', 4, 13.405, 52.52, 'img/berlin.jpeg', 1070),
(11, 'Munich', 4, 11.582, 48.1351, 'img/munich.jpeg', 800),
(12, 'Hamburg', 4, 9.9937, 53.5511, 'img/hamburg.jpeg', 650),
(13, 'Barcelona', 5, 2.1734, 41.3851, 'img/barcelona.jpeg', 870),
(14, 'Madrid', 5, 3.7038, 40.4168, 'img/madrid.jpeg', 840),
(15, 'Seville', 5, 5.9845, 37.3891, 'img/seville.jpeg', 760),
(16, 'Bruges', 6, 3.2247, 51.2093, 'img/bruges.jpeg', 304),
(17, 'brussels', 6, 4.3517, 50.8503, 'img/brussels.jpeg', 890),
(18, 'Ghent', 6, 3.7174, 51.0543, 'img/ghent.jpeg', 380),
(19, 'London', 7, -0.118092, 51.5099, 'img/london.jpeg', 1500),
(20, 'Manchester', 7, 2.2426, 53.4808, 'img/manchester.jpeg', 940),
(21, 'Liverpool', 7, 2.9916, 53.4084, 'img/liverpool.jpeg', 790);

-- --------------------------------------------------------

--
-- Table structure for table `countries`
--

CREATE TABLE `countries` (
  `id_country` int(11) NOT NULL,
  `countryName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `countries`
--

INSERT INTO `countries` (`id_country`, `countryName`) VALUES
(1, 'Fance'),
(2, 'Italie'),
(3, 'Portugal'),
(4, 'Germany'),
(5, 'Spain'),
(6, 'Belgium'),
(7, 'England');

-- --------------------------------------------------------

--
-- Table structure for table `destinations`
--

CREATE TABLE `destinations` (
  `destination_id` int(11) NOT NULL,
  `nameDest` varchar(30) NOT NULL,
  `typeDest` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `img` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `destinations`
--

INSERT INTO `destinations` (`destination_id`, `nameDest`, `typeDest`, `city_id`, `img`) VALUES
(1, 'Eiffel Tower', 1, 1, 'img/destination/EiffelTower.jpg'),
(2, 'Arc de Triomphe', 1, 1, 'img/destination/ArcdeTriomphe.jpg'),
(3, 'Cathedrale Notre-Dame ', 1, 1, 'img/destination/CathedraleNotreDame.jpg'),
(4, 'Basilique de Fourviere', 1, 2, 'img/destination/BasiliquedeFourviere.jpg'),
(5, 'Cathedrale Saint-Jean', 1, 2, 'img/destination/CathedraleSaintJean.jpg'),
(6, 'Chateau de la Tourette', 1, 2, 'img/destination/ChateaudelaTourette.jpg'),
(7, 'Parc Martin Luther King', 2, 1, 'img/destination/ParcMartinLutherKing.jpg'),
(8, 'Jardin des Tuileries', 2, 1, 'img/destination/JardindesTuileries.jpg'),
(9, 'Jardin du Luxembourg', 2, 1, 'img/destination/JardinduLuxembourg.jpg'),
(10, 'Parc de la Tete dor', 2, 2, 'img/destination/ParcdelaTetedor.jpg'),
(11, 'Parc des berges du Rhône', 2, 2, 'img/destination/ParcdesbergesduRhone.jpg'),
(12, 'le massif de la Sainte-Baume', 3, 3, 'img/destination/lemassifdelaSainteBaume.jpg'),
(13, 'la montagne Sainte-Victoire', 3, 3, 'img/destination/lamontagneSainteVictoire.jpg'),
(14, 'le mont Olympe', 3, 3, 'img/destination/lemontOlympe.jpg'),
(15, 'la Brevenne', 3, 2, 'img/destination/laBrevenne.jpg'),
(16, 'le Garon', 3, 2, 'img/destination/leGaron.jpg'),
(17, 'la Coise', 3, 2, 'img/destination/laCoise.jpg'),
(18, 'Abbaye Saint-Victor', 1, 3, 'img/destination/AbbayeSaintVictor.jpg'),
(19, 'Chateau dIf', 1, 3, 'img/destination/ChateaudIf.jpg'),
(20, 'Chateau de la Buzine.', 1, 3, 'img/destination/ChateaudelaBuzine.jpg'),
(21, 'St. Marks Basilica', 1, 4, 'img/destination/StMarksBasilica.jpg'),
(22, 'Piazza San Marco', 1, 4, 'img/destination/PiazzaSanMarco.jpg'),
(23, 'Santa Maria Gloriosa', 1, 4, 'img/destination/SantaMariaGloriosa.jpg'),
(24, 'Lido', 4, 4, 'img/destination/Lido.jpg'),
(25, 'The Colosseum', 1, 5, 'img/destination/TheColosseum.jpg'),
(26, 'Vatican City', 1, 5, 'img/destination/VaticanCity.jpg'),
(27, 'The Pantheon', 1, 5, 'img/destination/ThePantheon.jpg'),
(28, 'Santa Marinella', 4, 5, 'img/destination/SantaMarinella.jpg'),
(29, 'Anzio', 4, 5, 'img/destination/Anzio.jpg'),
(30, 'Duomo', 1, 6, 'img/destination/Duomo.jpg'),
(32, 'Aquaneva', 2, 6, 'img/destination/Aquaneva.jpg'),
(33, 'Parc Aventura', 2, 6, 'img/destination/ParcAventura.jpg'),
(34, 'Pizzo della Croce', 3, 6, 'img/destination/PizzodellaCroce.jpg'),
(35, 'Rifugio Murelli', 3, 6, 'img/destination/RifugioMurelli.jpg'),
(36, 'Algar do Carvao', 6, 7, 'img/destination/AlgardoCarvao.jpg'),
(37, 'Parque Eduardo VII', 2, 7, 'img/destination/ParqueEduardoVII.jpg'),
(38, 'Lisbon Zoo', 2, 7, 'img/destination/LisbonZoo.jpg'),
(39, 'The Tower of Belem ', 1, 7, 'img/destination/TheTowerofBelem.jpg'),
(40, 'Monsanto Forest', 7, 7, 'img/destination/MonsantoForest.jpg'),
(41, 'Cave Rock Bar', 6, 7, 'img/destination/CaveRockBar.jpg'),
(42, 'Camera Obscura Tavira', 6, 8, 'img/destination/CameraObscuraTavira.jpg'),
(43, 'Praia da Ilha de Tavira', 4, 8, 'img/destination/PraiadaIlhadeTavira.jpg'),
(44, 'Prudencio Navarro Zoo', 5, 8, 'img/destination/PrudencioNavarroZoo.jpg'),
(45, 'tavira national park', 2, 8, 'img/destination/taviranationalpark.jpg'),
(46, 'Cap Saint-Vincent', 3, 8, 'img/destination/CapSaintVincent.jpg'),
(47, 'Beliche Portugal ', 3, 8, 'img/destination/BelichePortugal.jpg'),
(48, 'Templo Romano Evora', 1, 9, 'img/destination/TemploRomanoEvora.jpg'),
(49, 'Paris Zoological', 5, 9, 'img/destination/ParisZoological.jpg'),
(50, 'Thoiry ZooSafari', 5, 9, 'img/destination/ThoiryZooSafari.jpg'),
(51, 'Praia dos Pescadores', 4, 9, 'img/destination/PraiadosPescadores.jpg'),
(52, 'Praia do Peneco', 4, 9, 'img/destination/PraiadoPeneco.jpg'),
(53, 'Ruinas Fingidas', 6, 9, 'img/destination/RuinasFingidas.jpg'),
(54, 'Brandenburg Gate', 1, 10, 'img/destination/BrandenburgGate.jpg'),
(55, 'Spandauer Forst', 7, 10, 'img/destination/SpandauerForst.jpg'),
(56, 'Rixdorfer hohe', 3, 10, 'img/destination/Rixdorferhohe.jpg'),
(57, 'Les Caves Weine', 6, 10, 'img/destination/LesCavesWeine.jpg'),
(58, 'Strandbad Grunau', 4, 10, 'img/destination/StrandbadGrunau.jpg'),
(59, 'Victory Column', 1, 10, 'img/destination/VictoryColumn.jpg'),
(60, 'Mariensaule', 1, 11, 'img/destination/Mariensaule.jpg'),
(61, 'English Garden', 2, 11, 'img/destination/EnglishGarden.jpg'),
(62, 'Bat Cave', 6, 11, 'img/destination/BatCave.jpg'),
(63, 'Hellabrunn Zoo', 5, 11, 'img/destination/HellabrunnZoo.jpg'),
(64, 'Perlacher Muggl', 7, 11, 'img/destination/PerlacherMuggl.jpg'),
(65, 'Aubinger Lohe', 7, 11, 'img/destination/AubingerLohe.jpg'),
(66, 'Planten un Blomen', 2, 12, 'img/destination/PlantenunBlomen.jpg'),
(67, 'Park Fiction', 2, 12, 'img/destination/ParkFiction.jpg'),
(68, 'Meiendorfer-Forest', 7, 12, 'img/destination/MeiendorferForest.jpg'),
(69, 'Wilder Wald Wilhelmsburg', 7, 12, 'img/destination/WilderWaldWilhelmsburg.jpg'),
(70, 'Tierpark Hagenbeck', 5, 12, 'img/destination/TierparkHagenbeck.jpg'),
(71, 'Tropen-Aquarium Hagenbeck', 5, 12, 'img/destination/TropenAquariumHagenbeck.jpg'),
(72, 'Mountain Barcelona', 3, 13, 'img/destination/MountainBarcelona.jpg'),
(73, 'Tibidabo', 3, 13, 'img/destination/Tibidabo.jpg'),
(74, 'Barceloneta Beach', 4, 13, 'img/destination/BarcelonetaBeach.jpg'),
(75, 'Platja del Forum', 4, 13, 'img/destination/PlatjadelForum.jpg'),
(76, 'Coves del Salnitre', 6, 13, 'img/destination/CovesdelSalnitre.jpg'),
(77, 'Cave of Saint Ignatius', 6, 13, 'img/destination/CaveofSaintIgnatius.jpg'),
(78, 'Penalara', 3, 14, 'img/destination/Penalara.jpg'),
(79, 'Mount Abantos', 3, 14, 'img/destination/MountAbantos.jpg'),
(80, 'La Maliciosa', 4, 14, 'img/destination/LaMaliciosa.jpg'),
(81, 'Madrid Forest', 2, 14, 'img/destination/MadridForest.jpg'),
(82, 'Urban Beach Madrid', 4, 14, 'img/destination/UrbanBeachMadrid.jpg'),
(83, 'Sauna Beach', 4, 14, 'img/destination/SaunaBeach.jpg'),
(84, 'Torre del Oro', 1, 15, 'img/destination/TorredelOro.jpg'),
(86, 'Monumento a Juan', 1, 15, 'img/destination/MonumentoaJuan.jpg'),
(87, 'Alamillo Park', 2, 15, 'img/destination/AlamilloPark.jpg'),
(88, 'Parque de Maria Luisa', 2, 15, 'img/destination/ParquedeMariaLuisa.jpg'),
(89, 'Principes Park', 2, 15, 'img/destination/PrincipesPark.jpg'),
(90, 'Minnewaterpark', 2, 16, 'img/destination/Minnewaterpark.jpg'),
(91, 'Boudewijn Seapark', 2, 16, 'img/destination/BoudewijnSeapark.jpg'),
(92, 'Jeff de Bruges', 3, 16, 'img/destination/JeffdeBruges.jpg'),
(93, 'Lace Jewel', 3, 16, 'img/destination/LaceJewel.jpg'),
(95, 'Serpentarium', 5, 16, 'img/destination/Serpentarium.jpg'),
(96, 'Residence Palace', 1, 17, 'img/destination/ResidencePalace.jpg'),
(97, 'Infantry Memorial', 1, 17, 'img/destination/InfantryMemorial.jpg'),
(98, 'Brussels Park', 2, 17, 'img/destination/BrusselsPark.jpg'),
(100, 'Bois de la Cambre', 5, 17, 'img/destination/BoisdelaCambre.jpg'),
(101, 'Brussels Zoo', 5, 17, 'img/destination/BrusselsZoo.jpg'),
(102, 'Design Museum Gent', 1, 18, 'img/destination/DesignMuseumGent.jpg'),
(104, 'Pen-y-ghent', 3, 18, 'img/destination/Penyghent.jpg'),
(105, 'Dulle Griet', 1, 18, 'img/destination/DulleGriet.jpg'),
(106, 'Parc Muink', 2, 18, 'img/destination/ParcMuink.jpg'),
(109, 'London Tower Bridge', 1, 19, 'img/destination/LondonTowerBridge.jpg'),
(110, 'St James\'s Park', 2, 19, 'img/destination/StJamessPark.jpg'),
(111, 'Monster Mountains', 3, 19, 'img/destination/MonsterMountains.jpg'),
(112, 'Betsom\'s Hill', 3, 19, 'img/destination/BetsomsHill.jpg'),
(113, 'Hyde Park', 2, 19, 'img/destination/HydePark.jpg'),
(114, 'Queen Victoria\'s Statue', 1, 20, 'img/destination/QueenVictoriasStatue.jpeg'),
(115, 'Albert Memorial', 1, 20, 'img/destination/AlbertMemorial.jpg'),
(116, 'Ainsdale Beach', 4, 20, 'img/destination/AinsdaleBeach.jpg'),
(117, 'Platt Fields Park', 2, 20, 'img/destination/PlattFieldsPark.jpg'),
(119, 'Clayton Vale', 3, 20, 'img/destination/ClaytonVale.jpg'),
(121, 'Memoriale del Trasporto', 1, 21, 'img/destination/MemorialedelTrasporto.jpg'),
(122, 'Crosby Beach', 4, 21, 'img/destination/CrosbyBeach.jpg'),
(123, 'Wallasey Beach', 4, 21, 'img/destination/WallaseyBeach.jpg'),
(124, 'Knowsley Safari', 5, 21, 'img/destination/KnowsleySafari.jpg'),
(125, 'Croxteth Petting Farm', 5, 21, 'img/destination/CroxtethPettingFarm.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `dest_type`
--

CREATE TABLE `dest_type` (
  `id` int(11) NOT NULL,
  `destType` varchar(30) NOT NULL,
  `img_link` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dest_type`
--

INSERT INTO `dest_type` (`id`, `destType`, `img_link`) VALUES
(1, 'Monuments', 'img/monument/monument.jpeg'),
(2, 'Parc', 'img/parc/parc.jpeg'),
(3, 'Montagne', 'img/montagne/montagne.png'),
(4, 'Beach', 'img/beach/beach.jpeg'),
(5, 'Zoo', 'img/zoo/zoo.jpeg'),
(6, 'Cave', 'img/cave/cave.jpg'),
(7, 'Forest', 'img/forest/forest.jpg');

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
  ADD PRIMARY KEY (`id_country`);

--
-- Indexes for table `destinations`
--
ALTER TABLE `destinations`
  ADD PRIMARY KEY (`destination_id`),
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `countries`
--
ALTER TABLE `countries`
  MODIFY `id_country` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `destinations`
--
ALTER TABLE `destinations`
  MODIFY `destination_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT for table `dest_type`
--
ALTER TABLE `dest_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cities`
--
ALTER TABLE `cities`
  ADD CONSTRAINT `FK_Country` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id_country`);

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
