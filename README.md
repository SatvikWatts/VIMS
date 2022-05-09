# VIMS

Requirements: Netbeans(IDE) , Database(Mysql)

Schema:
 Name : vims
 
 Tables :
 
 1]
    CREATE TABLE `stay` (
  `visitor_id` int NOT NULL,
  `building` varchar(20) DEFAULT NULL,
  `days` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`visitor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

2]
  CREATE TABLE `vihost` (
  `visitor_id` int DEFAULT NULL,
  `host_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

3]
    CREATE TABLE `visitor` (
  `visitor_id` int NOT NULL AUTO_INCREMENT,
  `vname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `pass` varchar(100) DEFAULT NULL,
  `id_type` varchar(20) DEFAULT NULL,
  `id` varchar(100) DEFAULT NULL,
  `cnumber` varchar(100) DEFAULT NULL,
  `is_admin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`visitor_id`),
  UNIQUE KEY `email` (`email`,`cnumber`,`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
