-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 01, 2022 at 10:05 PM
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
(10, 'Tikros istorijos'),
(26, 'Fantastika'),
(28, 'Poezija, esė'),
(29, 'Romantika'),
(34, 'Komedija'),
(35, 'Animaciniai'),
(36, 'Dramos'),
(38, 'Serialas');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_username` varchar(63) NOT NULL,
  `film_id` int(11) NOT NULL,
  `comment` varchar(512) NOT NULL,
  `data` text NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `user_username`, `film_id`, `comment`, `data`) VALUES
(53, 'admin', 1, 'Man patiko', '2022-07-28 22:10:34'),
(54, 'admin', 3, 'Prastai', '2022-07-28 22:10:43'),
(55, 'petras', 1, 'Filmas labai labai labai geras', '2022-07-28 22:14:00'),
(56, 'zygis', 1, 'Patiko šis filmas. Geresnis lyginant už visas praeitas serijas', '2022-07-28 22:14:46');

-- --------------------------------------------------------

--
-- Table structure for table `favorite`
--

CREATE TABLE `favorite` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(63) DEFAULT NULL,
  `summary` varchar(127) DEFAULT NULL,
  `imdb` varchar(63) DEFAULT NULL,
  `category` varchar(63) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `favorite`
--

INSERT INTO `favorite` (`id`, `user_id`, `title`, `summary`, `imdb`, `category`) VALUES
(110, 1, 'Parazitas', 'Bedarbis Kitaekas suklastoja dokumentus ir tamp....', '8.5', 'Tikros istorijos');

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `id` int(11) NOT NULL,
  `title` varchar(63) DEFAULT NULL,
  `summary` varchar(512) DEFAULT NULL,
  `imdb` varchar(63) DEFAULT NULL,
  `category` varchar(127) DEFAULT NULL,
  `reservation` int(11) DEFAULT NULL,
  `image` text DEFAULT NULL,
  `comments` varchar(127) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`id`, `title`, `summary`, `imdb`, `category`, `reservation`, `image`, `comments`) VALUES
(1, 'Haris Poteris ir Išminties akmuo', 'Tai istorija apie berniuką Harį Poterį, kuris 10 metų pragyveno po laiptais ir tikėjo apgaulingais dėdės ir tetos pasakojimais, kad jo tėvai žuvo autoavarijoje, nors iš tikrųjų jie buvo nužudyti per Helovyno šventę.', '7.6', 'Fantastika', 1, 'file:./src/main/resources/images/3.PNG', NULL),
(3, 'Haris Poteris ir paslapčių kambarys', 'Hariui atostogos pas nedorėlius Durslius buvo liūdnos, užtat Hogvartse laukia nauji pavojai ir naujos mįslės. ', '7.7', 'Fantastika', 2, 'file:./src/main/resources/images/1.PNG', NULL),
(41, 'Parazitas', 'Bedarbis Kitaekas suklastoja dokumentus ir tamp....', '8.5', 'Tikros istorijos', NULL, 'file:./src/main/resources/images/Null.PNG', NULL),
(80, 'Šviesmetis', 'Vieno mylimiausių Žaislų istorijos filmų personažo laukia netikėtos pažintys, smagi muzika ir, žinoma, pavojingi, bet linksmi nuotykiai.', '5.8', 'Animaciniai', 1, 'file:./src/main/resources/images/Null.PNG', NULL),
(82, 'Baigiamieji egzaminai', 'Romeo - vidutinio amžiaus gydytojas, gyvenantis kompromisų kupiną, bet ganėtinai patogų gyvenimą mažame Transilvanijos miestelyje. ', '7.3', 'Dramos', 36, 'file:./src/main/resources/images/Null.PNG', NULL),
(86, 'Samarietis', 'Jaunas berniukas sužino, kad superherojus, kuris, kaip manoma, dingo po epiškos kovos prieš dvidešimt metų, galbūt vis dar gyvas.', '5.9', 'Fantastika', NULL, 'file:./src/main/resources/images/Null.PNG', NULL),
(87, 'Didesnis', 'Įkvepianti istorija apie kultūrizmo pionierius Džo ir Beną Weiderius. Nepaisydami didžiulio skurdo ir tvyrojuso antisemitizmo, broliai įveikė visas kliūtis, kad sukurtų imperiją ir įkvėptų ateities kartas.', '6.3', 'Tikros istorijos', NULL, 'file:./src/main/resources/images/Null.PNG', NULL),
(88, 'Virtuvės istorijos', 'Įspūdingai sėkmingai maisto tinklaraštininkei Kacey pasiūloma galimybė parašyti savo kulinarijos knygą. Vienintelė problema ta, kad ji nėra labai gera virėja. Tačiau su šefo Gavino pagalba jai gali pasisekti.', '5.1', 'Romantika', 35, 'file:./src/main/resources/images/Null.PNG', NULL),
(89, 'Spąstai', 'Filmas pasakoja istoriją apie praeito amžiaus 6-ojo dešimtmečio politinių kalinių bejėgiškumą ir brutalumą, naudojamą, siekiant priversti duoti melagingus parodymus. ', '5.8', 'Tikros istorijos', NULL, 'file:./src/main/resources/images/Null.PNG', NULL),
(91, 'Valdovės gambitas', '8-metė našlaitė, Betė Harmon yra tyli, užsidariusi ir sunkiai pastebima. Kol nesužaidžia pirmosios šachmatų partijos. Jos pojūčiai ir mąstymas ima aštrėti ir pirmą kartą gyvenime, ji ima jausti kontrolę. Būdama 16-os, ji dalyvavo JAV čempionate. Betei perėjus į profesionalų lygą, jos atsiskyrimas vis labiau gąsdina ir ji ima svarstyti apie pabėgimą. Paremta Volterio Tiuviso (Walter Tevis) knyga.', '8.6', 'Serialas', NULL, 'file:./src/main/resources/images/4.PNG', NULL);

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
(3, 'vipas', '$2a$12$R8V2ravDCQ1nqo0dxHAHDOWRkfbMC49zhOPjh77MuWW9mV8yEG6AS', 'vipas@vipas.com', 1),
(10, 'zygis', '$2a$12$ytiFsNOrB0ye0s4faAuaveGJZhIpwxDiTVtt28gF6vMW3XhRKIXWK', 'zygis@gmail.com', 0),
(26, 'petras', '$2a$12$J7ZZdah0UsdQFUWwnrufS.jUoR2oy2zc5chJ6jeOT/KTicivfZyRC', 'admin@gmail.com', 0),
(35, 'jonas123', '$2a$12$QvKqVfLh39rifJQsYXaRuOWcsJXN3svcyQ5hH3lMnRMd62J3RJp9O', 'jonas123@gmail.com', 0),
(36, 'petras123', '$2a$12$7runTEg.j0CPDIomldR4K.RlIq7jPz3abnAC6aW/FDAwlesongvhC', 'petras123@gmail.com', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `films`
--
ALTER TABLE `films`
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
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT for table `favorite`
--
ALTER TABLE `favorite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
