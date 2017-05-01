-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2017 at 08:27 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tubes_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `ddr`
--

CREATE TABLE IF NOT EXISTS `ddr` (
  `IDPeriksa` varchar(10) NOT NULL,
  `Nomor Ruangan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE IF NOT EXISTS `dokter` (
  `NamaD` varchar(25) NOT NULL,
  `Kesanggupan` int(2) NOT NULL DEFAULT '25'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE IF NOT EXISTS `pasien` (
  `IDPasien` varchar(10) NOT NULL,
  `NamaP` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `periksa`
--

CREATE TABLE IF NOT EXISTS `periksa` (
  `IDPeriksa` varchar(10) NOT NULL,
  `Dokter` varchar(25) NOT NULL,
  `IDPasien` varchar(10) NOT NULL,
  `Tanggal Periksa` date NOT NULL,
  `Indikasi` varchar(255) NOT NULL,
  `Rekomendasi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE IF NOT EXISTS `ruangan` (
  `Nomor` varchar(10) NOT NULL,
  `Kapasitas` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ddr`
--
ALTER TABLE `ddr`
 ADD KEY `IDPeriksa` (`IDPeriksa`,`Nomor Ruangan`), ADD KEY `Nomor Ruangan` (`Nomor Ruangan`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
 ADD PRIMARY KEY (`NamaD`), ADD KEY `Nama` (`NamaD`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
 ADD PRIMARY KEY (`IDPasien`);

--
-- Indexes for table `periksa`
--
ALTER TABLE `periksa`
 ADD PRIMARY KEY (`IDPeriksa`), ADD KEY `Dokter` (`Dokter`), ADD KEY `IDPasien` (`IDPasien`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
 ADD PRIMARY KEY (`Nomor`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ddr`
--
ALTER TABLE `ddr`
ADD CONSTRAINT `ddrPeriksa` FOREIGN KEY (`IDPeriksa`) REFERENCES `periksa` (`IDPeriksa`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `ddrRuang` FOREIGN KEY (`Nomor Ruangan`) REFERENCES `ruangan` (`Nomor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `periksa`
--
ALTER TABLE `periksa`
ADD CONSTRAINT `DokterPeriksa` FOREIGN KEY (`Dokter`) REFERENCES `dokter` (`NamaD`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `PasienPeriksa` FOREIGN KEY (`IDPasien`) REFERENCES `pasien` (`IDPasien`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;