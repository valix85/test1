CREATE DATABASE IF NOT EXISTS `db_auto_noleggio` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_auto_noleggio`;

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `colore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `marca` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `marca` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `modello` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `modello` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

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



CREATE TABLE `view_catalogo_auto` (
	`id` INT(3) NOT NULL,
	`marca` VARCHAR(30) NOT NULL COLLATE 'latin1_swedish_ci',
	`modello` VARCHAR(30) NOT NULL COLLATE 'latin1_swedish_ci',
	`categoria` VARCHAR(64) NOT NULL COLLATE 'latin1_swedish_ci'
) ENGINE=InnoDB;
DROP TABLE IF EXISTS `view_catalogo_auto`;
CREATE VIEW `view_catalogo_auto` AS select `rmc`.`id_relazione` AS `id`,`m`.`marca` AS `marca`,`mo`.`modello` AS `modello`,`c`.`categoria` AS `categoria` from (((`rel_marca_categoria` `rmc` join `marca` `m` on((`rmc`.`fk_marca` = `m`.`id`))) join `modello` `mo` on((`rmc`.`fk_modello` = `mo`.`id`))) join `categoria` `c` on((`rmc`.`fk_categoria` = `c`.`id`)));
