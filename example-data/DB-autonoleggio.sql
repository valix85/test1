-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              5.7.18 - MySQL Community Server (GPL)
-- S.O. server:                  Linux
-- HeidiSQL Versione:            9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database db_auto_noleggio
CREATE DATABASE IF NOT EXISTS `db_auto_noleggio` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_auto_noleggio`;

-- Dump della struttura di tabella db_auto_noleggio.auto
CREATE TABLE IF NOT EXISTS `auto` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `numeroTelaio` varchar(255) NOT NULL,
  `targa` varchar(30) NOT NULL,
  `kilometri` int(10) NOT NULL,
  `noleggiata` tinyint(1) NOT NULL,
  `data_scadenza_assicurazione` date NOT NULL,
  `prezzoGiornaliero` int(3) NOT NULL,
  `n_Porte` int(1) NOT NULL,
  `fk_rel_marca_categoria` int(3) NOT NULL,
  `fk_colore` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rel_marca_categoria` (`fk_rel_marca_categoria`),
  KEY `fk_colore` (`fk_colore`),
  CONSTRAINT `auto_ibfk_1` FOREIGN KEY (`fk_rel_marca_categoria`) REFERENCES `rel_marca_categoria` (`id_relazione`),
  CONSTRAINT `auto_ibfk_2` FOREIGN KEY (`fk_colore`) REFERENCES `colore` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella db_auto_noleggio.auto: ~15 rows (circa)
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` (`id`, `numeroTelaio`, `targa`, `kilometri`, `noleggiata`, `data_scadenza_assicurazione`, `prezzoGiornaliero`, `n_Porte`, `fk_rel_marca_categoria`, `fk_colore`) VALUES
	(1, '55154-5440', 'cd5aab', 72625, 0, '2017-11-25', 41, 3, 3, 1),
	(2, '21695-357', '220ac8', 62585, 0, '2017-12-07', 97, 5, 10, 1),
	(3, '49349-207', '44934a', 74524, 0, '2017-11-30', 50, 4, 5, 1),
	(4, '0268-1198', '67c2f6', 60925, 0, '2017-11-30', 98, 4, 8, 10),
	(5, '49546-106', '89d049', 74048, 0, '2017-12-14', 65, 3, 14, 1),
	(6, '36800-211', '5a0a69', 23460, 0, '2017-12-06', 86, 4, 3, 10),
	(7, '37012-296', '02bffd', 81149, 0, '2017-12-07', 89, 5, 14, 4),
	(8, '0363-0823', 'd6b8cc', 22771, 0, '2017-11-25', 59, 4, 13, 4),
	(9, '43063-457', '8a6f2c', 79308, 0, '2017-12-11', 66, 2, 8, 10),
	(10, '41595-7009', '6f2a7f', 86628, 1, '2017-12-01', 63, 2, 6, 4),
	(11, '43269-795', '45414e', 83093, 1, '2017-12-07', 94, 3, 14, 2),
	(12, '54868-6189', '16c4af', 19494, 1, '2017-12-14', 59, 4, 8, 10),
	(13, '11523-7291', '954f4b', 28071, 1, '2017-12-09', 41, 2, 10, 3),
	(14, '65162-711', '1c0c89', 94437, 0, '2017-12-08', 81, 2, 10, 3),
	(15, '65044-0825', '55a14f', 69392, 1, '2017-12-03', 70, 2, 4, 2);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;

-- Dump della struttura di tabella db_auto_noleggio.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella db_auto_noleggio.categoria: ~6 rows (circa)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `categoria`) VALUES
	(1, 'Berlina'),
	(2, 'Cabriolet'),
	(3, 'Coupè'),
	(4, 'Suv'),
	(5, 'Fuoristrada'),
	(6, 'Utilitaria');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Dump della struttura di tabella db_auto_noleggio.colore
CREATE TABLE IF NOT EXISTS `colore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella db_auto_noleggio.colore: ~10 rows (circa)
/*!40000 ALTER TABLE `colore` DISABLE KEYS */;
INSERT INTO `colore` (`id`, `nome`) VALUES
	(1, 'bianco'),
	(2, 'nero'),
	(3, 'arancione'),
	(4, 'rosso'),
	(5, 'giallo'),
	(6, 'blu'),
	(7, 'azzurro'),
	(8, 'verde'),
	(9, 'grigio'),
	(10, 'viola');
/*!40000 ALTER TABLE `colore` ENABLE KEYS */;

-- Dump della struttura di tabella db_auto_noleggio.marca
CREATE TABLE IF NOT EXISTS `marca` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `marca` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella db_auto_noleggio.marca: ~5 rows (circa)
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` (`id`, `marca`) VALUES
	(1, 'Volkswagen'),
	(2, 'Ford'),
	(3, 'Renault'),
	(4, 'Opel'),
	(5, 'Fiat');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;

-- Dump della struttura di tabella db_auto_noleggio.modello
CREATE TABLE IF NOT EXISTS `modello` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `modello` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella db_auto_noleggio.modello: ~15 rows (circa)
/*!40000 ALTER TABLE `modello` DISABLE KEYS */;
INSERT INTO `modello` (`id`, `modello`) VALUES
	(1, 'Golf'),
	(2, 'Passat'),
	(3, 'Tuareg'),
	(4, 'Fiesta'),
	(5, 'Mondeo'),
	(6, 'Kuga'),
	(7, 'Clio'),
	(8, 'Megane'),
	(9, 'Kadjar'),
	(10, 'Adam'),
	(11, 'Astra'),
	(12, 'Crossland X'),
	(13, '500'),
	(14, '124 Spider'),
	(15, 'Fullback');
/*!40000 ALTER TABLE `modello` ENABLE KEYS */;

-- Dump della struttura di tabella db_auto_noleggio.noleggio
CREATE TABLE IF NOT EXISTS `noleggio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_auto` int(11) DEFAULT NULL,
  `prezzo` decimal(12,1) NOT NULL,
  `assicurazione_noleggio` varchar(11) NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
  `pagato` tinyint(1) NOT NULL,
  `utente` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auto` (`fk_auto`),
  CONSTRAINT `noleggio_ibfk_1` FOREIGN KEY (`fk_auto`) REFERENCES `auto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella db_auto_noleggio.noleggio: ~45 rows (circa)
/*!40000 ALTER TABLE `noleggio` DISABLE KEYS */;
INSERT INTO `noleggio` (`id`, `fk_auto`, `prezzo`, `assicurazione_noleggio`, `data_inizio`, `data_fine`, `pagato`, `utente`) VALUES
	(1, 1, 91.5, 'gold', '2017-05-22', '2017-06-27', 1, 'Norene'),
	(2, 2, 71.0, 'premium', '2017-05-12', '2017-05-22', 1, 'Vannie'),
	(3, 3, 84.9, 'premium', '2017-05-13', '2017-06-03', 0, 'Cori'),
	(4, 4, 48.9, 'premium', '2017-05-15', '2017-06-08', 1, 'Tamma'),
	(5, 5, 44.6, 'gold', '2017-05-05', '2017-06-12', 0, 'Kristo'),
	(6, 6, 62.5, 'basic', '2017-05-04', '2017-07-01', 1, 'Nanice'),
	(7, 7, 44.4, 'premium', '2017-05-18', '2017-06-29', 1, 'Vivian'),
	(8, 8, 83.5, 'basic', '2017-05-13', '2017-07-12', 1, 'Delano'),
	(9, 9, 61.4, 'premium', '2017-05-25', '2017-06-21', 0, 'Vivyanne'),
	(10, 10, 99.1, 'basic', '2017-05-17', '2017-06-20', 1, 'Callida'),
	(11, 11, 53.9, 'premium', '2017-05-17', '2017-07-06', 0, 'Ruperta'),
	(12, 12, 64.8, 'basic', '2017-05-14', '2017-07-08', 0, 'Christiana'),
	(13, 13, 64.5, 'gold', '2017-05-15', '2017-06-29', 0, 'Delcina'),
	(14, 14, 83.1, 'premium', '2017-05-07', '2017-06-01', 1, 'Martie'),
	(15, 15, 52.6, 'gold', '2017-05-20', '2017-06-20', 0, 'Laurianne'),
	(16, 1, 70.1, 'gold', '2017-06-29', '2017-07-10', 0, 'Kerry'),
	(17, 2, 93.1, 'gold', '2017-05-24', '2017-07-07', 1, 'Stephi'),
	(18, 3, 75.5, 'premium', '2017-06-05', '2017-07-07', 1, 'Marlie'),
	(19, 4, 65.6, 'premium', '2017-06-10', '2017-07-14', 0, 'Korie'),
	(20, 5, 70.7, 'gold', '2017-06-24', '2017-07-08', 0, 'Felix'),
	(21, 6, 51.0, 'premium', '2017-07-27', '2017-08-03', 1, 'Libbi'),
	(22, 7, 56.6, 'gold', '2017-06-30', '2017-07-02', 0, 'Carine'),
	(23, 8, 66.3, 'premium', '2017-07-14', '2017-07-21', 1, 'Ado'),
	(24, 9, 97.9, 'basic', '2017-06-24', '2017-06-30', 1, 'Ardys'),
	(25, 10, 49.7, 'gold', '2017-06-24', '2017-06-30', 1, 'Lola'),
	(26, 11, 70.5, 'premium', '2017-07-10', '2017-07-30', 0, 'Cari'),
	(27, 12, 75.9, 'basic', '2017-07-24', '2017-08-19', 1, 'Dion'),
	(28, 13, 49.9, 'basic', '2017-06-30', '2017-07-11', 1, 'Heida'),
	(29, 14, 67.7, 'basic', '2017-06-15', '2017-06-27', 0, 'Joellen'),
	(30, 15, 44.2, 'basic', '2017-07-01', '2017-07-10', 1, 'Arleen'),
	(31, 1, 51.0, 'premium', '2017-07-27', '2017-08-03', 1, 'Libbi'),
	(32, 2, 56.6, 'gold', '2017-07-09', '2017-07-29', 0, 'Carine'),
	(33, 3, 66.3, 'premium', '2017-07-14', '2017-07-21', 1, 'Ado'),
	(34, 4, 97.9, 'basic', '2017-07-24', '2017-08-30', 1, 'Ardys'),
	(35, 5, 49.7, 'gold', '2017-07-10', '2017-07-30', 1, 'Lola'),
	(36, 6, 70.5, 'premium', '2017-08-10', '2017-08-30', 0, 'Cari'),
	(37, 7, 75.9, 'basic', '2017-07-24', '2017-08-19', 1, 'Dion'),
	(38, 8, 49.9, 'basic', '2017-07-30', '2017-08-11', 1, 'Heida'),
	(39, 9, 67.7, 'basic', '2017-07-15', '2017-07-27', 0, 'Joellen'),
	(40, 10, 44.2, 'basic', '2017-07-01', '2017-07-10', 1, 'Arleen'),
	(41, 11, 70.5, 'premium', '2017-08-10', '2017-08-30', 0, 'Cari'),
	(42, 12, 75.9, 'basic', '2017-07-30', '2017-08-19', 1, 'Dion'),
	(43, 13, 49.9, 'basic', '2017-07-13', '2017-07-27', 1, 'Heida'),
	(44, 14, 67.7, 'basic', '2017-06-30', '2017-07-27', 0, 'Joellen'),
	(45, 15, 44.2, 'basic', '2017-07-11', '2017-08-10', 1, 'Arleen');
/*!40000 ALTER TABLE `noleggio` ENABLE KEYS */;

-- Dump della struttura di tabella db_auto_noleggio.rel_marca_categoria
CREATE TABLE IF NOT EXISTS `rel_marca_categoria` (
  `id_relazione` int(3) NOT NULL AUTO_INCREMENT,
  `fk_modello` int(3) NOT NULL,
  `fk_marca` int(2) NOT NULL,
  `fk_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_relazione`),
  KEY `fk_modello` (`fk_modello`),
  KEY `fk_marca` (`fk_marca`),
  KEY `fk_categoria` (`fk_categoria`),
  CONSTRAINT `rel_marca_categoria_ibfk_1` FOREIGN KEY (`fk_modello`) REFERENCES `modello` (`id`),
  CONSTRAINT `rel_marca_categoria_ibfk_2` FOREIGN KEY (`fk_marca`) REFERENCES `marca` (`id`),
  CONSTRAINT `rel_marca_categoria_ibfk_3` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella db_auto_noleggio.rel_marca_categoria: ~15 rows (circa)
/*!40000 ALTER TABLE `rel_marca_categoria` DISABLE KEYS */;
INSERT INTO `rel_marca_categoria` (`id_relazione`, `fk_modello`, `fk_marca`, `fk_categoria`) VALUES
	(1, 1, 1, 6),
	(2, 2, 1, 1),
	(3, 3, 1, 4),
	(4, 4, 2, 6),
	(5, 5, 2, 1),
	(6, 6, 2, 4),
	(7, 7, 3, 6),
	(8, 8, 3, 1),
	(9, 9, 3, 4),
	(10, 10, 4, 6),
	(11, 11, 4, 1),
	(12, 12, 4, 4),
	(13, 13, 5, 6),
	(14, 14, 5, 2),
	(15, 15, 5, 5);
/*!40000 ALTER TABLE `rel_marca_categoria` ENABLE KEYS */;

-- Dump della struttura di vista db_auto_noleggio.view_catalogo_auto
-- Creazione di una tabella temporanea per risolvere gli errori di dipendenza della vista
CREATE TABLE `view_catalogo_auto` (
	`id` INT(3) NOT NULL,
	`marca` VARCHAR(30) NOT NULL COLLATE 'latin1_swedish_ci',
	`modello` VARCHAR(30) NOT NULL COLLATE 'latin1_swedish_ci',
	`categoria` VARCHAR(64) NOT NULL COLLATE 'latin1_swedish_ci'
) ENGINE=MyISAM;

-- Dump della struttura di vista db_auto_noleggio.view_catalogo_auto
-- Rimozione temporanea di tabella e creazione della struttura finale della vista
DROP TABLE IF EXISTS `view_catalogo_auto`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `view_catalogo_auto` AS select `rmc`.`id_relazione` AS `id`,`m`.`marca` AS `marca`,`mo`.`modello` AS `modello`,`c`.`categoria` AS `categoria` from (((`rel_marca_categoria` `rmc` join `marca` `m` on((`rmc`.`fk_marca` = `m`.`id`))) join `modello` `mo` on((`rmc`.`fk_modello` = `mo`.`id`))) join `categoria` `c` on((`rmc`.`fk_categoria` = `c`.`id`)));

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
