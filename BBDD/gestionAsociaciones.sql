-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 02-06-2017 a las 10:00:17
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionAsociaciones`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad`
--

CREATE TABLE `actividad` (
  `id_actividad` int(11) NOT NULL,
  `nombre` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `n_destinatarios` int(11) NOT NULL,
  `lugar` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(280) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `actividad`
--

INSERT INTO `actividad` (`id_actividad`, `nombre`, `n_destinatarios`, `lugar`, `descripcion`) VALUES
(1, 'Baloncesto', 50, 'Madrid', NULL),
(2, 'Obra Teatro', 12, 'Madrid', NULL),
(3, 'BaloncestoB', 50, 'Casteldefels', NULL),
(4, 'Artes marciales', 35, 'Ayora', NULL),
(5, 'Boxeo', 60, 'Lugo', NULL),
(6, 'Musica', 5, 'Las Palmas', NULL),
(7, 'Enseñanza', 20, 'Alava', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividad_tipo`
--

CREATE TABLE `actividad_tipo` (
  `actividad` int(11) NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `actividad_tipo`
--

INSERT INTO `actividad_tipo` (`actividad`, `tipo`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 6),
(5, 1),
(6, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asociacion`
--

CREATE TABLE `asociacion` (
  `CIF` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(129) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `municipio` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `cod_postal` int(11) NOT NULL,
  `e_mail` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tlf_fijo` int(11) NOT NULL,
  `tlf_movil` int(11) DEFAULT NULL,
  `fax` int(11) DEFAULT NULL,
  `id_documentacion` int(11) NOT NULL,
  `estatuto_asoc` tinyint(1) DEFAULT NULL,
  `certif_dom_social` tinyint(1) DEFAULT NULL,
  `numero_asociacionRDP` tinyint(1) DEFAULT NULL,
  `acta_junta_directiva` tinyint(1) DEFAULT NULL,
  `fecha_solicitud` date DEFAULT NULL,
  `representante` varchar(11) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `asociacion`
--

INSERT INTO `asociacion` (`CIF`, `nombre`, `direccion`, `municipio`, `cod_postal`, `e_mail`, `tlf_fijo`, `tlf_movil`, `fax`, `id_documentacion`, `estatuto_asoc`, `certif_dom_social`, `numero_asociacionRDP`, `acta_junta_directiva`, `fecha_solicitud`, `representante`) VALUES
('092829N', 'NBA', 'C/Iverson', 'Madrid', 3242, 'CJ@g.com', 93443345, NULL, NULL, 2, 1, 0, 0, 1, '2017-03-08', '2323243F'),
('123f', 'iiiiii', 'iiiiiii', 'iiiiii', 2323, 'iiiiiii', 131331, 131313, 13131313, 30, NULL, NULL, NULL, NULL, NULL, NULL),
('232323d', 'wdwdwd', 'dwdwdwd', 'wdwdwd', 23323, 'dwdwdwd', 232323, 232323, 23232323, 27, NULL, NULL, NULL, NULL, NULL, NULL),
('232323V', 'prueba', 'prueba', 'prueba', 28021, 'prueba', 29292, 232323, 23233, 12, NULL, NULL, NULL, NULL, NULL, '3535355D'),
('243435C', 'UFC', 'C/Silva', 'Ayora', 23233, 'BL@g.com', 9876362, NULL, NULL, 4, 1, 0, 1, 1, '2017-03-27', '3343455D'),
('244353J', 'U-tad', 'C/Newell', 'Alava', 2345, 'GN@g.com', 9023445, NULL, NULL, 7, 1, 1, 1, 1, '2017-03-01', '243232424F'),
('297287V', 'HBO Boxing', 'C/Ali', 'Lugo', 2435, 'CL@g.com', 9545667, NULL, NULL, 5, 1, 1, 1, 1, '2017-03-20', '3535355D'),
('33672676G', 'ACB', 'C/Gasol', 'Casteldefels', 2324, 'JS@g.com', 92373636, NULL, NULL, 3, 1, 0, 0, 1, '2017-03-14', '2423434F'),
('343535D', 'N.W.A', 'C/eazy E', 'Las Palmas', 2435, 'IC@g.com', 9234567, NULL, NULL, 6, 0, 0, 0, 1, '2017-03-30', '6565757S'),
('44F', 'prueba', 'madrid', 'madrid', 28021, 'prueba', 231313, 131313, 131313, 28, NULL, NULL, NULL, NULL, NULL, NULL),
('eeeee2', 'sasas', 'dqqdqd', 'asas', 11, 'axwxwq', 2222, 211, 2222, 31, NULL, NULL, NULL, NULL, NULL, NULL),
('ff2', 'prueba', 'prueba', 'prueba', 2902, 'prueba', 12313, 131313, 13133, 29, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asociacion_tipo`
--

CREATE TABLE `asociacion_tipo` (
  `CIF` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `asociacion_tipo`
--

INSERT INTO `asociacion_tipo` (`CIF`, `tipo`) VALUES
('092829N', 1),
('232323V', 3),
('243435C', 1),
('244353J', 4),
('297287V', 5),
('33672676G', 7),
('ff2', 2),
('ff2', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organiza_participa`
--

CREATE TABLE `organiza_participa` (
  `asociacion` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `actividad` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `organiza_participa`
--

INSERT INTO `organiza_participa` (`asociacion`, `actividad`, `fecha`) VALUES
('092829N', 1, '2017-03-02'),
('243435C', 3, '2017-03-08'),
('244353J', 6, '2017-03-08'),
('297287V', 4, '2017-03-07'),
('33672676G', 7, '2017-03-07'),
('343535D', 5, '2017-03-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representante`
--

CREATE TABLE `representante` (
  `NIF_NIE` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellido1` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellido2` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `municipio` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `cod_postal` int(11) NOT NULL,
  `e_mail` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `tlf_fijo` int(11) DEFAULT NULL,
  `tlf_movil` int(11) NOT NULL,
  `fax` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `representante`
--

INSERT INTO `representante` (`NIF_NIE`, `nombre`, `apellido1`, `apellido2`, `direccion`, `municipio`, `cod_postal`, `e_mail`, `tlf_fijo`, `tlf_movil`, `fax`) VALUES
('2323243F', 'Bruce ', 'Lee ', '', 'C/Silva', 'Ayora', 232324, 'BL@g.com', NULL, 64535344, NULL),
('2423434F', 'Ice ', 'Cube', '', 'C/eazy E', 'Las Palmas', 2434335, '', NULL, 6748383, NULL),
('243232424F', ' Chrysoprasis ', 'ibaca ', '', 'C/Gasol', 'Casteldefels', 23242, 'JS@g.com', NULL, 6445454, NULL),
('3343455D', 'Cassius ', 'Clay', '', 'C/Ali', 'Lugo', 24243, 'CL@g.com', NULL, 65242728, NULL),
('3535355D', 'Michael ', 'Jordan', '', 'C/Iverson', 'Madrid', 2323, 'CJ@g.com', NULL, 62353267, NULL),
('6565757S', 'Gabe ', 'Newell', '', 'C/Newell', 'Alava', 343545, '', NULL, 68786545, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede_localmunicipal`
--

CREATE TABLE `sede_localmunicipal` (
  `id_sede` int(11) NOT NULL,
  `asociacion` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `caracteristicas` varchar(280) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_solicitud` date NOT NULL,
  `fecha_concesion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sede_localmunicipal`
--

INSERT INTO `sede_localmunicipal` (`id_sede`, `asociacion`, `direccion`, `caracteristicas`, `fecha_solicitud`, `fecha_concesion`) VALUES
(1, '092829N', 'C/Iverson', NULL, '2017-03-01', '2017-03-08'),
(2, '243435C', 'C/Gasol', NULL, '2017-03-07', NULL),
(3, '244353J', 'C/Silva', NULL, '2017-03-06', '2017-03-13'),
(5, '297287V', 'C/Ali', NULL, '2017-03-08', '2017-03-24'),
(6, '343535D', 'C/eazy E', NULL, '2017-03-01', NULL),
(8, '33672676G', 'C/cube', NULL, '2017-03-07', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subvencion`
--

CREATE TABLE `subvencion` (
  `id_subvencion` int(11) NOT NULL,
  `asociacion` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `importe_solicitado` int(11) NOT NULL,
  `fecha_solicitud` date NOT NULL,
  `actividad_prev` int(11) NOT NULL,
  `estado` enum('concedida','pendiente','rechazada','finalizada') COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `subvencion`
--

INSERT INTO `subvencion` (`id_subvencion`, `asociacion`, `importe_solicitado`, `fecha_solicitud`, `actividad_prev`, `estado`) VALUES
(1, '092829N', 2345, '2017-03-07', 1, 'pendiente'),
(2, '243435C', 1213, '2017-03-02', 3, 'concedida'),
(3, '244353J', 4324, '2017-03-03', 3, 'rechazada'),
(4, '297287V', 3234, '2017-03-13', 4, 'concedida'),
(5, '343535D', 4534, '2017-03-15', 5, 'finalizada'),
(7, '33672676G', 1213, '2017-03-21', 7, 'concedida');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `id_tipo` int(11) NOT NULL,
  `categoria` varchar(120) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`id_tipo`, `categoria`) VALUES
(1, 'Deporte'),
(2, 'Cine'),
(3, 'Teatro'),
(4, 'Cultural'),
(5, 'Joven/Ocio'),
(6, 'Artes Marciales'),
(7, 'Musica');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividad`
--
ALTER TABLE `actividad`
  ADD PRIMARY KEY (`id_actividad`);

--
-- Indices de la tabla `actividad_tipo`
--
ALTER TABLE `actividad_tipo`
  ADD PRIMARY KEY (`actividad`,`tipo`),
  ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `asociacion`
--
ALTER TABLE `asociacion`
  ADD PRIMARY KEY (`CIF`),
  ADD UNIQUE KEY `id_documentacion` (`id_documentacion`),
  ADD KEY `representante` (`representante`);

--
-- Indices de la tabla `asociacion_tipo`
--
ALTER TABLE `asociacion_tipo`
  ADD PRIMARY KEY (`CIF`,`tipo`),
  ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `organiza_participa`
--
ALTER TABLE `organiza_participa`
  ADD PRIMARY KEY (`asociacion`,`actividad`),
  ADD KEY `acti` (`actividad`);

--
-- Indices de la tabla `representante`
--
ALTER TABLE `representante`
  ADD PRIMARY KEY (`NIF_NIE`);

--
-- Indices de la tabla `sede_localmunicipal`
--
ALTER TABLE `sede_localmunicipal`
  ADD PRIMARY KEY (`id_sede`),
  ADD UNIQUE KEY `direccion` (`direccion`),
  ADD UNIQUE KEY `direccion_2` (`direccion`),
  ADD UNIQUE KEY `direccion_3` (`direccion`),
  ADD KEY `asociacion` (`asociacion`);

--
-- Indices de la tabla `subvencion`
--
ALTER TABLE `subvencion`
  ADD PRIMARY KEY (`id_subvencion`),
  ADD KEY `asociacion` (`asociacion`),
  ADD KEY `actividad_prev` (`actividad_prev`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividad`
--
ALTER TABLE `actividad`
  MODIFY `id_actividad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `asociacion`
--
ALTER TABLE `asociacion`
  MODIFY `id_documentacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT de la tabla `sede_localmunicipal`
--
ALTER TABLE `sede_localmunicipal`
  MODIFY `id_sede` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `subvencion`
--
ALTER TABLE `subvencion`
  MODIFY `id_subvencion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `tipo`
--
ALTER TABLE `tipo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividad_tipo`
--
ALTER TABLE `actividad_tipo`
  ADD CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`actividad`) REFERENCES `actividad` (`id_actividad`),
  ADD CONSTRAINT `tipo_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`id_tipo`);

--
-- Filtros para la tabla `asociacion`
--
ALTER TABLE `asociacion`
  ADD CONSTRAINT `representante_ibfk_1` FOREIGN KEY (`representante`) REFERENCES `representante` (`NIF_NIE`);

--
-- Filtros para la tabla `asociacion_tipo`
--
ALTER TABLE `asociacion_tipo`
  ADD CONSTRAINT `asociacion_ibfk_1` FOREIGN KEY (`CIF`) REFERENCES `asociacion` (`CIF`),
  ADD CONSTRAINT `tipo_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`id_tipo`);

--
-- Filtros para la tabla `organiza_participa`
--
ALTER TABLE `organiza_participa`
  ADD CONSTRAINT `actividad_ibfk_2` FOREIGN KEY (`actividad`) REFERENCES `actividad` (`id_actividad`),
  ADD CONSTRAINT `asociacion_ibfk_2` FOREIGN KEY (`asociacion`) REFERENCES `asociacion` (`CIF`);

--
-- Filtros para la tabla `sede_localmunicipal`
--
ALTER TABLE `sede_localmunicipal`
  ADD CONSTRAINT `asociacion_ibfk_3` FOREIGN KEY (`asociacion`) REFERENCES `asociacion` (`CIF`);

--
-- Filtros para la tabla `subvencion`
--
ALTER TABLE `subvencion`
  ADD CONSTRAINT `actividad_ibfk_3` FOREIGN KEY (`actividad_prev`) REFERENCES `actividad` (`id_actividad`),
  ADD CONSTRAINT `asociacion_ibfk_4` FOREIGN KEY (`asociacion`) REFERENCES `asociacion` (`CIF`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
