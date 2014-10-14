-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 09, 2014 at 12:02 AM
-- Server version: 5.5.38-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `ipro307`
--

-- --------------------------------------------------------

--
-- Table structure for table `intersection_coord`
--

CREATE TABLE IF NOT EXISTS `intersection_coord` (
  `intersection_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET latin1 NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  PRIMARY KEY (`intersection_id`),
  UNIQUE KEY `coord` (`latitude`,`longitude`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `weather_cache`
--

CREATE TABLE IF NOT EXISTS `weather_cache` (
  `weather_cache_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `coord_id` bigint(20) NOT NULL,
  PRIMARY KEY (`weather_cache_id`),
  UNIQUE KEY `coord_id` (`coord_id`),
  KEY `date_updated` (`date_updated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `weather_cache`
--
ALTER TABLE `weather_cache`
  ADD CONSTRAINT `weather_cache_ibfk_1` FOREIGN KEY (`coord_id`) REFERENCES `intersection_coord` (`intersection_id`) ON DELETE CASCADE ON UPDATE CASCADE;

