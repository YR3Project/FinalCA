-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2017 at 05:46 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testdb`
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
  `DateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`ArticleID`, `AuthorID`, `Title`, `ArticleText`, `Game`, `DateAdded`) VALUES
(1, 1, 'Riots new Release', 'test', 'wow', '2017-02-06'),
(2, 3, 'New Article', 'word word word word word word word word word word word word word word word word word word word word word word word word', 'def', '2017-02-07'),
(3, 29, 'Bens Test', 'dsadsadasd', 'lol', '2008-03-17');

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
(19, 1, 29, 'wewew', '2017-03-15'),
(20, 2, 29, 'wewew', '2017-03-15'),
(21, 2, 29, 'wewew', '2017-03-15'),
(22, 2, 29, 'Test1', '2017-03-15'),
(23, 1, 46, 'TestComment', '2017-05-02'),
(46, 3, 46, 'Test123', '2017-05-03');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(128) NOT NULL,
  `country` varchar(200) DEFAULT 'No Country',
  `admin` smallint(1) NOT NULL,
  `salt` varchar(128) NOT NULL,
  `Created` varchar(20) NOT NULL,
  `Due` varchar(20) NOT NULL,
  `photo` varchar(200) DEFAULT 'Images/Profiles/Default.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `email`, `password`, `country`, `admin`, `salt`, `Created`, `Due`, `photo`) VALUES
(1, 'Aleks', 'Aleks@Aleks.com', 'Password1', 'Ireland', 1, '', '07/01/17', '25/12/17', NULL),
(2, 'Chris', 'Chris@Chris.com', 'Password1', 'Ireland', 1, '', '07/01/17', '25/12/17', NULL),
(3, 'Ben', 'Ben@Ben.com', 'Placeholder', 'Ireland', 1, '', '07/01/17', '25/12/17', NULL),
(8, 'Christest', 'Chris@gmail.com', 'faf2a3be4db969c413da9ddc4a34930cb01948dae2240c98e1890f1cb911fc0094e7d032093e8b8415bfd7df4328a47837c2cf1422b0fc1973744a1fd81051cd', 'Ireland', 0, 'îÛ€dsD9E,SÆ5vø', '16/02/17', '26/02/17', 'ÿØÿà\0JFIF\0\0\0\0\0\0ÿÛ\0„\0	( \Z%!1!%)+...383-7(-.+\n\n\n\r\Z-%----0.----------------------7--------+----------+-ÿÀ\0\0·"\0ÿÄ\0\0\0\0\0\0\0\0\0\0\0\0\0\0'),
(9, 'AleksMtr', 'aleksmtr@yahoo.com', '6e33a5b75b599ebee8bc594d7b5120f63b9cbae93569a0ab598eb7b68a16e151dc28591a3011579a51acdb7dd7a5b35fe0441b3aef10f95a4d4a23f0756ee963', 'Ireland', 1, 'sŒu£>	ÁõìœúJWœÐ', '03/03/17', '13/03/17', NULL),
(29, 'BenRose', 'ben.rose76@gmail.com', 'ce0a57b223e57d295fc0dcd5db69b4f526d07966c1c5b837b65412acf06f9ae6d546ab6a3fbec11bcacf850d82d430d7b8aaa254e559d4be6c852394c2845a04', 'Ireland', 1, 'Õªõ,ç—Yj¡†‰cÏÅ', '08/03/17', '18/03/17', NULL),
(30, 'ChrisJunit2', 'junit@gmail.com', 'a8da501d8a98fe40afd6ff8049c0ce5846e3740c568f85333d6af8da80d586a127854e256ed6eac74dec48bccceb4ede8bfc99e740020b56167e3c4bc68bec90', 'Ireland', 0, 'j6š3qvª£8á†O¨~¤', '02/05/17', '12/05/17', 'Images/Profiles/Default.jpg'),
(46, 'ChrisJunit23', 'junitTest@gmaill.com', '0da6c2881ab6ac06723e8ca9770226c89d44af182e81e799d03fc2aef21fdc4d6c86a27072e5fa2cc913c3dd09f6fe10cffdf9f947d4e182c0c831c06fe45dd0', 'Ireland', 0, 'TT´fP‰<~ ëÎ ó‰á', '02/05/17', '12/05/17', 'Images/Profiles/Default.jpg');

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
  MODIFY `ArticleID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `battle`
--
ALTER TABLE `battle`
  MODIFY `ChampID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `CommentID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`AuthorID`) REFERENCES `users` (`userID`);

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`ArticleID`) REFERENCES `article` (`ArticleID`),
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`CAuthor`) REFERENCES `users` (`userID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
