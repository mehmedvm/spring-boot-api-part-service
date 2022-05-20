CREATE DATABASE  IF NOT EXISTS `parts_registry`;
USE `parts_registry`;
--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `parts`;
CREATE TABLE `parts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(45) DEFAULT NULL, 
  `part_origin` varchar(45) DEFAULT NULL,
  `part_qty` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `parts` VALUES 
(1,'screwdriver', 'USA', 10)