-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2022 at 04:19 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `examv2`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` varchar(63) DEFAULT NULL,
  `summary` varchar(127) DEFAULT NULL,
  `isbn` varchar(63) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `category` varchar(127) DEFAULT NULL,
  `reservation` int(11) DEFAULT NULL,
  `image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `summary`, `isbn`, `pages`, `category`, `reservation`, `image`) VALUES
(1, 'Haris Poteris ir Išminties akmuo', 'Haris Poteris - vienuolikmetis našlaitis su akinukais, vargstantis klaikioje dėdės ir tetos Durslių šeimynėlėje.', '12-3456-789-1', 248, 'Poezija, esė', 1, 'file:/C:/Users/acer/Pictures/testams/3.PNG'),
(3, 'Haris Poteris ir paslapčių kambarys', 'Hariui atostogos pas nedorėlius Durslius buvo liūdnos, užtat Hogvartse laukia nauji pavojai ir naujos mįslės. ', '12-3456-789-2', 272, 'Fantastika', 2, 'file:/C:/Users/acer/Pictures/testams/1.png'),
(17, 'Intuicija', 'Jaunas niujorkietis Timotis Fišeris yra vidutinio pasisekimo sulaukiančių detektyvų rašytojas...', '12-3456-789-3', 382, 'Drama', NULL, 'file:/C:/Users/acer/Pictures/testams/3.PNG'),
(18, 'Valdovės gambitas', 'Automobilio avarijoje žuvus motinai, vos aštuonerių sulaukusi Betė Harmon išsiunčiama į našlaičių globos namus...', '12-3456-789-4', 384, 'Klasika', NULL, 'file:/C:/Users/acer/Pictures/testams/4.PNG'),
(19, 'Švelnumas pragare', 'Vytautas Pliura (1951-2011) - poetas, dramaturgas, anglų kalba kūręs lietuvių išeivio', '12-3456-789-5', 184, 'Poezija, esė', NULL, 'file:/C:/Users/acer/Pictures/testams/Null.png');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `categoryTitle` varchar(127) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `categoryTitle`) VALUES
(3, 'Fantastika'),
(9, 'Drama'),
(10, 'Tikros istorijos'),
(13, 'Klasika'),
(14, 'Poezija, esė');

-- --------------------------------------------------------

--
-- Table structure for table `favorite`
--

CREATE TABLE `favorite` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(63) DEFAULT NULL,
  `summary` varchar(127) DEFAULT NULL,
  `isbn` varchar(63) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `category` varchar(63) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `favorite`
--

INSERT INTO `favorite` (`id`, `user_id`, `title`, `summary`, `isbn`, `pages`, `category`) VALUES
(11, 2, 'Haris Poteris', 'Raganos raganiai...', '12-3456-789-1', 1318, 'Romantinis'),
(24, 2, 'Haris Poteris 2', 'Raganos raganiai... ', '12-3456-789-3', 1450, 'Fantastiniai'),
(25, 2, 'Haris Poteris3', 'Raganos raganiai...', '12-3456-789-3', 1488, 'Fantastinis'),
(26, 2, 'Haris Poteris3', 'Raganos raganiai...', '12-3456-789-3', 1488, 'Fantastinis'),
(33, 1, 'Haris Poteris ir Išminties akmuo', 'Haris Poteris - vienuolikmetis našlaitis su akinukais, vargstantis klaikioje dėdės ir tetos Durslių šeimynėlėje.', '12-3456-789-1', 248, 'Poezija, esė'),
(35, 1, 'Intuicija', 'Jaunas niujorkietis Timotis Fišeris yra vidutinio pasisekimo sulaukiančių detektyvų rašytojas...', '12-3456-789-3', 382, 'Drama'),
(37, 1, 'Švelnumas pragare', 'Vytautas Pliura (1951-2011) - poetas, dramaturgas, anglų kalba kūręs lietuvių išeivio', '12-3456-789-5', 184, 'Poezija, esė');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(63) DEFAULT NULL,
  `password` varchar(127) DEFAULT NULL,
  `email` varchar(63) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `admin`) VALUES
(1, 'admin', '$2a$12$OdvVI9dpBfEAUWHuHXCISeKasEb2uMjzwae7YxwBLnqfUPNPLqBKO', 'admin@gmail.com', 1),
(2, 'useris', '$2a$12$767AyOr5ebFvnMwhvBgas.PMKs1BiNgW0ZhqzTkyqupDxR1gV0CoK', 'useris@useris.com', 0),
(3, 'vipas', '$2a$12$R8V2ravDCQ1nqo0dxHAHDOWRkfbMC49zhOPjh77MuWW9mV8yEG6AS', 'vipas@vipas.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `favorite`
--
ALTER TABLE `favorite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
