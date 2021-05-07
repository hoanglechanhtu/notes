CREATE SCHEMA notes;


-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE `note` (
  `id` int(11) AUTO_INCREMENT NOT NULL,
  `uuid` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `context` TEXT DEFAULT NULL,
  `status` tinyint DEFAULT 0,
  `author_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `created_date` timestamp null,
  `last_modified_date` timestamp null,
  PRIMARY KEY (`id`),
  FOREIGN KEY (author_id) references author(id),
  FOREIGN KEY (category_id) references category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) AUTO_INCREMENT NOT NULL,
  `uuid` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` timestamp null,
  `last_modified_date` timestamp null ,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) AUTO_INCREMENT NOT NULL ,
  `uuid` varchar(36) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_date` timestamp null,
  `last_modified_date` timestamp null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;






-- --------------------------------------------------------

--
-- Dummy data
--
insert into category (uuid, name, created_date, last_modified_date) values ("3b94b31c-b756-4eb0-95a5-3dd02754fc2e", "Work", now(), now());

insert into author (uuid, name, created_date, last_modified_date) values ("3b94b31c-b756-4eb0-95a5-3dd02754fc1e", "Tu", now(), now());

insert into note (uuid, name, context, status, author_id, category_id, created_date, last_modified_date)
values ("3b94b31c-b756-4eb0-95a5-3dd02754fc1e", "Note1", "Hello everyone",0,  1, 1, now(), now()),
("3b94b31c-b756-4eb0-95a5-3dd02754fc1a", "Note2", "Hello everyone 2",0, 1, 1, now(), now()),
("3b94b31c-b756-4eb0-95a5-3dd02754fc1d", "Note3", "Hello everyone 3",0, 1, 1, now(), now());