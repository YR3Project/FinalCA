

CREATE TABLE article (
  ArticleID int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  AuthorID int(4) NOT NULL,
  Title varchar(50) NOT NULL,
  ArticleText varchar(2000) NOT NULL,
  DateAdded date NOT NULL
  FOREIGN KEY (`AuthorID`) REFERENCES `users` (`userID`); 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `article` (`ArticleID`, `AuthorID`, `Title`, `ArticleText`, `DateAdded`) VALUES
(1, 1, 'StatWiseGameWise is born!', 'Yes Indeed! The website is finally born! You all better enjoy your time here', '2017-02-06'),
(2, 3, 'New Article', 'word word word word word word word word word word word word word word word word word word word word word word word word', '2017-02-07');


CREATE TABLE users (
  userID int(4) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  email varchar(30) NOT NULL,
  password varchar(128) NOT NULL,
  admin smallint(1) NOT NULL,
  salt varchar(128) NOT NULL,
  Created varchar(20) NOT NULL,
  Due varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users` (`userID`, `username`, `email`, `password`, `admin`, `salt`, `Created`, `Due`) VALUES
(1, 'Aleks', 'Aleks@Aleks.com', 'Password1', 1, '', '07/01/17', '25/12/17'),
(2, 'Chris', 'Chris@Chris.com', 'Password1', 1, '', '07/01/17', '25/12/17'),
(3, 'Ben', 'Ben@Ben.com', 'Placeholder', 1, '', '07/01/17', '25/12/17'),
(4, 'BenTest', 'ben.rose76@gmail.com', 'aeb7b825425e386fb803e7c1d8eaef15117cba76d5a28c5ff75976f38d366fd3baf0118ff7768667316147c0ac67acc643dd2e07bf5fb0710a477e11286889db', 0, '<’üOåÚÓ‚|ýÂ\Zr>', '08/02/17', '10/02/17');

ALTER TABLE `article`
  ADD KEY `AuthorID` (`AuthorID`);


ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`AuthorID`) REFERENCES `users` (`userID`);

CREATE TABLE comments (
CommentID int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT,
ArticleID int(4) NOT NULL,
CAuthor int(4) NOT NULL,
CommentText varchar(2000) NOT NULL,
DateAdded date NOT NULL,
FOREIGN KEY (ArticleID) REFERENCES article(ArticleID),
FOREIGN KEY (CAuthor) REFERENCES users(userID)
);

CREATE TABLE report (
ReportID int(6) NOT NULL PRIMARY KEY AUTO_INCREMENT,
CommentID int(6) NOT NULL,
UserID int(4) NOT NULL,
Reason VARCHAR(2000) NOT NULL,
FOREIGN KEY (CommentID) REFERENCES comments(CommentID),
FOREIGN KEY (UserID) REFERENCES users(userID)
);
