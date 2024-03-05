create database sql11688610;
use sql11688610;

CREATE TABLE `juegos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(45) NOT NULL,
  `plataforma` varchar(45) NOT NULL,
  `fechaPublicacion` int(11) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `editor` varchar(45) NOT NULL,
  `ventas` double(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1