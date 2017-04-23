-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2017 at 02:05 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `swgw`
--

-- --------------------------------------------------------

--
-- Table structure for table `battle`
--

CREATE TABLE `battle` (
  `ChampID` int(3) NOT NULL,
  `ChampName` varchar(20) DEFAULT NULL,
  `ChampValue` double(3,1) DEFAULT NULL,
  `Position` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `battle`
--

INSERT INTO `battle` (`ChampID`, `ChampName`, `ChampValue`, `Position`) VALUES
(1, 'Vi', 52.1, 'Jung'),
(2, 'Jayce', 50.4, 'Top'),
(3, 'Urgot', 42.2, 'ADC'),
(4, 'Janna', 50.2, 'Support'),
(5, 'Viktor', 51.2, 'Mid'),
(6, 'Malphite', 47.5, 'Top'),
(7, 'Shaco', 52.1, 'Jung'),
(8, 'Gangplank', 49.8, 'Top'),
(9, 'Lucian', 53.2, 'ADC'),
(10, 'Lulu', 51.2, 'Support'),
(11, 'Lissandra', 51.0, 'Mid'),
(12, 'Fiora', 49.7, 'Top'),
(13, 'Graves', 50.1, 'Jung'),
(14, 'Galio', 52.2, 'Top'),
(15, 'Varus', 52.3, 'ADC'),
(16, 'Thresh', 48.8, 'Support'),
(17, 'Leblanc', 50.1, 'Mid'),
(18, 'KhaZix', 50.8, 'Jung'),
(19, 'Maokai', 48.2, 'Top'),
(20, 'Caitlyn', 52.4, 'ADC'),
(21, 'Braum', 52.4, 'Support'),
(22, 'Ziggs', 48.9, 'Mid'),
(23, 'Warwick', 50.2, 'Jung'),
(24, 'Jinx', 48.7, 'ADC'),
(25, 'Karma', 52.0, 'Support'),
(26, 'Karma', 52.5, 'Mid'),
(27, 'Zac', 52.3, 'Jung'),
(28, 'KogMaw', 53.5, 'ADC'),
(29, 'Lulu', 52.1, 'Mid'),
(30, 'Nami', 47.8, 'Support'),
(31, 'Nautilus', 50.2, 'Top'),
(32, 'XinZhoa', 48.9, 'Jung'),
(33, 'Darius', 50.1, 'Top'),
(34, 'Ashe', 50.4, 'ADC'),
(35, 'Zyra', 53.2, 'Support'),
(36, 'Ahri', 52.5, 'Mid'),
(37, 'Ivern', 49.1, 'Jung'),
(38, 'Jhin', 48.8, 'ADC'),
(39, 'Bard', 49.0, 'Support'),
(40, 'Zed', 48.9, 'Mid'),
(41, 'Camille', 49.7, 'Top'),
(42, 'Rengar', 49.2, 'Jung'),
(43, 'Ezreal', 51.4, 'ADC'),
(44, 'Morgana', 49.5, 'Support'),
(45, 'Katarina', 51.7, 'Mid');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `battle`
--
ALTER TABLE `battle`
  ADD PRIMARY KEY (`ChampID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `battle`
--
ALTER TABLE `battle`
  MODIFY `ChampID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
