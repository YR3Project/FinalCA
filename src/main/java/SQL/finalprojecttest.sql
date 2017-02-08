-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2017 at 08:09 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `finalprojecttest`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `ArticleID` int(4) NOT NULL,
  `AuthorID` int(6) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `ArticleText` varchar(2000) NOT NULL,
  `DateAdded` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`ArticleID`, `AuthorID`, `Title`, `ArticleText`, `DateAdded`) VALUES
(1, 1, 'StatWiseGameWise is born!', 'Yes Indeed! The website is finally born! You all better enjoy your time here', '2017-02-06'),
(2, 3, 'New Article', 'word word word word word word word word word word word word word word word word word word word word word word word word', '2017-02-07');

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
  `Due` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `email`, `password`, `admin`, `salt`, `Created`, `Due`) VALUES
(1, 'Aleks', 'Aleks@Aleks.com', 'Password1', 1, '', '07/01/17', '25/12/17'),
(2, 'Chris', 'Chris@Chris.com', 'Password1', 1, '', '07/01/17', '25/12/17'),
(3, 'Ben', 'Ben@Ben.com', 'Placeholder', 1, '', '07/01/17', '25/12/17'),
(4, 'BenTest', 'ben.rose76@gmail.com', 'aeb7b825425e386fb803e7c1d8eaef15117cba76d5a28c5ff75976f38d366fd3baf0118ff7768667316147c0ac67acc643dd2e07bf5fb0710a477e11286889db', 0, '<’üOåÚÓ‚|ýÂ\Zr>', '08/02/17', '10/02/17');

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
  MODIFY `userID` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`AuthorID`) REFERENCES `users` (`userID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
