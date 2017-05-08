-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2017 at 01:00 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE IF NOT EXISTS `dokter` (
  `NamaD` varchar(25) NOT NULL,
  `Kesanggupan` int(2) NOT NULL DEFAULT '25'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`NamaD`, `Kesanggupan`) VALUES
('diah', 25),
('victor', 25);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE IF NOT EXISTS `pasien` (
  `IDPasien` varchar(10) NOT NULL,
  `NamaP` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`IDPasien`, `NamaP`) VALUES
('11', 'kamal'),
('12', 'vini');

-- --------------------------------------------------------

--
-- Table structure for table `periksa`
--

CREATE TABLE IF NOT EXISTS `periksa` (
  `IDPeriksa` varchar(10) NOT NULL,
  `Dokter` varchar(25) NOT NULL,
  `IDPasien` varchar(10) NOT NULL,
  `NomorRuang` varchar(10) DEFAULT NULL,
  `TanggalPeriksa` varchar(10) NOT NULL,
  `Indikasi` varchar(255) NOT NULL,
  `Rekomendasi` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `periksa`
--

INSERT INTO `periksa` (`IDPeriksa`, `Dokter`, `IDPasien`, `NomorRuang`, `TanggalPeriksa`, `Indikasi`, `Rekomendasi`) VALUES
('9998', 'diah', '11', 'a1', '4454', '666', '767766'),
('periksa1', 'victor', '11', 'a1', '05-05-2017', 'sehat', 'jaga kesehatan'),
('periksa2', 'victor', '12', 'a2', '29-02-2017', 'sakit berat', 'kurangi makan'),
('periksa3', 'diah', '11', 'a2', '28-12-1998', 'sakit sehat', 'sehat ehat');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE IF NOT EXISTS `ruangan` (
  `Nomor` varchar(10) NOT NULL,
  `Kapasitas` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`Nomor`, `Kapasitas`) VALUES
('a1', 10),
('a2', 12);

--
-- Indexes for dumped tables
--

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
 ADD PRIMARY KEY (`IDPeriksa`), ADD KEY `Dokter` (`Dokter`), ADD KEY `IDPasien` (`IDPasien`), ADD KEY `NomorRuang` (`NomorRuang`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
 ADD PRIMARY KEY (`Nomor`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `periksa`
--
ALTER TABLE `periksa`
ADD CONSTRAINT `DokterPeriksa` FOREIGN KEY (`Dokter`) REFERENCES `dokter` (`NamaD`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `PasienPeriksa` FOREIGN KEY (`IDPasien`) REFERENCES `pasien` (`IDPasien`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `PeriksaRuang` FOREIGN KEY (`NomorRuang`) REFERENCES `ruangan` (`Nomor`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
