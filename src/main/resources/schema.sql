CREATE TABLE book (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(200) NULL,
  `link` VARCHAR(1000) NULL,
  `img` VARCHAR(2000) NULL,
  `description` VARCHAR(2000) NULL,
  `tag` VARCHAR(200) NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_info (
  `user_id` INT NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authorities (
  `user_id` INT NOT NULL,
  `authority` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`user_id`, `authority`),
  CONSTRAINT `fk_authorities_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user_info` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
