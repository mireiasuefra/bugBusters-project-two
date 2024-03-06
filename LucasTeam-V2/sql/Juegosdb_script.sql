create database sql11688610;
use sql11688610;
DROP TABLE `juegos`;

CREATE TABLE `juegos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
   `nombre` varchar(150) NOT NULL,
  `plataforma` varchar(45) NOT NULL,
  `fecha_publicacion` int(11) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `editor` varchar(45) NOT NULL,
  `ventas` float(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;