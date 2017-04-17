-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 17, 2017 at 04:50 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

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
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(128) NOT NULL,
  `admin` smallint(1) NOT NULL,
  `salt` varchar(128) NOT NULL,
  `Created` varchar(20) NOT NULL,
  `Due` varchar(20) NOT NULL,
  `photo` varchar(200) DEFAULT 'Images/Profiles/Default.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `email`, `password`, `admin`, `salt`, `Created`, `Due`, `photo`) VALUES
(46, 'Chris', 'chris.mck@gmail.com', 'c1cdb3ada9de6cfe84c3a7cfe192bcbda2331130c8db4d5026a1ae250be4af60974fcddf1903afcb03f97c9976e0e6e0aa8d991d44d6a43fe3a6af92399a0806', 1, '„›ærº\n²…Bü=˜Q', '08/04/17', '18/04/17', 'Images/Profiles/46.jpg'),
(47, 'AleksMtr', 'aleks56@gmail.com', 'bb6ca5a73b4b82ad50789d156a770cf8ed3279df13caceb9ea465b94152c165361c32460790b944b2bd6f8ca5404fda9dc821d9044cc9bc203f8c1e63f717a73', 1, 'ìÄNÐôG–uÛ5)ê', '08/04/17', '18/04/17', 'Images/Profiles/47.jpg'),
(48, 'BenRose', 'ben.rose@gmail.com', 'b025b32a87802b94541d75aca4e27248de2cf1ec5c6cd5cf05fabfab13b7cc48a002edf4a4363ab15dccd38b72853fcefdc74c932c4d2e3054665af0466de5fc', 1, 'Lð[\ZÜX¿ˆb¨ˆ‰…', '16/04/17', '05/12/17', 'Images/Profiles/35.jpg'),
(51, 'JohnWick67', 'ben.rose76@gmail.com', '0068212c622b9b18c9bb4f95fce9312a438ab5ba0438154e4210bc3ef7da9c891145cd841757f1965e92f2334ae35e6b795f3895389de9d201cb16d0c2ee20ae', 0, 'Ñù€}4‡ÖÀQ í ·GAï', '17/04/17', '18/04/17', 'Images/Profiles/Default.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
