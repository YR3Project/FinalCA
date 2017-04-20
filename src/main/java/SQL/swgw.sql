-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2017 at 03:46 PM
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
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `ArticleID` int(4) NOT NULL,
  `AuthorID` int(4) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `ArticleText` varchar(2000) NOT NULL,
  `Game` varchar(3) NOT NULL,
  `DateAdded` date NOT NULL,
  `photo` varchar(200) NOT NULL DEFAULT 'Images/Articles/Default.jpg	'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`ArticleID`, `AuthorID`, `Title`, `ArticleText`, `Game`, `DateAdded`, `photo`) VALUES
(5, 46, 'Riots Latest Release', 'Riot has revealed their newest champion rework today: Galio, The Colossus Sample Line:  "I only wake up when it''s time to squash something. And I''m awake right now."\r\n', 'lol', '2017-04-08', 'Images/Articles/Default.jpg	'),
(6, 47, 'Return to the Broken Shore', 'Players return to the Broken Shore in Patch 7.2 with a vengeance, fighting the Legion with the help of the Armies of Legionfall. Blizzard explains all the different types of content coming in Patch 7.2 in their official preview.\r\n', 'wow', '2017-04-08', 'Images/Articles/Default.jpg	'),
(9, 48, 'Welcome to StatWiseGameWise', 'Welcome to StatWiseGameWise', 'def', '2017-04-16', 'Images/Articles/35.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `battle`
--

CREATE TABLE `battle` (
  `ChampID` int(3) NOT NULL,
  `ChampName` varchar(20) DEFAULT NULL,
  `ChampValue` int(3) DEFAULT NULL,
  `Position` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `battle`
--

INSERT INTO `battle` (`ChampID`, `ChampName`, `ChampValue`, `Position`) VALUES
(1, 'Vi', 52, 'Jung'),
(2, 'Jayce', 54, 'Top'),
(3, 'Urgot', 42, 'ADC'),
(4, 'Janna', 50, 'Support'),
(5, 'Viktor', 51, 'Mid'),
(6, 'Malphite', 48, 'Top'),
(7, 'Shaco', 53, 'Jung'),
(8, 'Gangplank', 47, 'Top'),
(9, 'Lucian', 52, 'ADC'),
(10, 'Lulu', 55, 'Support'),
(11, 'Lissandra', 50, 'Mid'),
(12, 'Fiora', 49, 'Top'),
(13, 'Graves', 50, 'Jung'),
(14, 'Galio', 50, 'Top'),
(15, 'Varus', 52, 'ADC'),
(16, 'Thresh', 46, 'Support'),
(17, 'Leblanc', 51, 'Mid'),
(18, 'KhaZix', 51, 'Jung'),
(19, 'Maokai', 52, 'Top'),
(20, 'Caitlyn', 52, 'ADC'),
(21, 'Braum', 48, 'Support'),
(22, 'Ziggs', 48, 'Mid'),
(23, 'Warwick', 54, 'Jung'),
(24, 'Jinx', 47, 'ADC'),
(25, 'Karma', 52, 'Support'),
(26, 'Karma', 50, 'Mid'),
(27, 'Zac', 52, 'Jung'),
(28, 'KogMaw', 49, 'ADC'),
(29, 'Lulu', 51, 'Mid'),
(30, 'Nami', 47, 'Support'),
(31, 'Nautilus', 49, 'Top'),
(32, 'XinZhoa', 46, 'Jung'),
(33, 'Darius', 50, 'Top'),
(34, 'Ashe', 52, 'ADC'),
(35, 'Zyra', 51, 'Support'),
(36, 'Ahri', 51, 'Mid'),
(37, 'Ivern', 49, 'Jung'),
(38, 'Jhin', 51, 'ADC'),
(39, 'Bard', 49, 'Support'),
(40, 'Zed', 47, 'Mid'),
(41, 'Camille', 49, 'Top'),
(42, 'Rengar', 48, 'Jung'),
(43, 'Ezreal', 50, 'ADC'),
(44, 'Morgana', 52, 'Support'),
(45, 'Katarina', 51, 'Mid');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `CommentID` int(6) NOT NULL,
  `ArticleID` int(4) NOT NULL,
  `CAuthor` int(4) NOT NULL,
  `CommentText` varchar(2000) NOT NULL,
  `DateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`CommentID`, `ArticleID`, `CAuthor`, `CommentText`, `DateAdded`) VALUES
(11, 1, 44, 'Fascinating', '2017-03-15'),
(12, 1, 35, 'Nice to hear @AleksMtr', '2017-03-15'),
(14, 2, 35, 'Interesting', '2017-03-15'),
(15, 6, 52, 'My first comment', '2017-04-17'),
(16, 9, 52, 'Test comment', '2017-04-19');

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
(51, 'JohnWick67', 'ben.rose76@gmail.com', '0068212c622b9b18c9bb4f95fce9312a438ab5ba0438154e4210bc3ef7da9c891145cd841757f1965e92f2334ae35e6b795f3895389de9d201cb16d0c2ee20ae', 0, 'Ñù€}4‡ÖÀQ í ·GAï', '17/04/17', '18/04/17', 'Images/Profiles/Default.jpg'),
(52, 'chips97', 'beartrap15@gmail.com', '622b9a6afcdd1e480b42986763b19e4235a284111a26fa32efb956a72a316c6d53dfcbe66afabfc20a79f35f15afaec7f1e7fc88e973508eabbde12f7a894b65', 0, 'ÕÖ„àD òÛ*&6¥ÇŒ', '17/04/17', '27/04/17', 'Images/Profiles/Default.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`ArticleID`),
  ADD KEY `AuthorID` (`AuthorID`);

--
-- Indexes for table `battle`
--
ALTER TABLE `battle`
  ADD PRIMARY KEY (`ChampID`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`CommentID`),
  ADD KEY `ArticleID` (`ArticleID`),
  ADD KEY `CAuthor` (`CAuthor`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `ArticleID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `battle`
--
ALTER TABLE `battle`
  MODIFY `ChampID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `CommentID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
