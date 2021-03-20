-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-03-2021 a las 17:39:59
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `ID_EXPE` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `SEXO` varchar(1) NOT NULL,
  `NACIMIENTO` date NOT NULL,
  `GRUPO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`ID_EXPE`, `NOMBRE`, `SEXO`, `NACIMIENTO`, `GRUPO`) VALUES
(1, 'PEDRO ARIAS', 'M', '2021-03-01', 1),
(2, 'JULIA AVALOS', 'F', '2021-03-01', 1),
(3, 'HUGO APAZA', 'M', '2021-03-01', 2),
(4, 'OLGA PORTAL', 'F', '2021-03-01', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aula`
--

CREATE TABLE `aula` (
  `ID_AULA` varchar(10) NOT NULL,
  `ASIENTOS` int(11) NOT NULL,
  `PISO` int(11) NOT NULL,
  `ESCUELA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aula`
--

INSERT INTO `aula` (`ID_AULA`, `ASIENTOS`, `PISO`, `ESCUELA`) VALUES
('AU_1', 35, 1, 1),
('AU_2', 30, 1, 2),
('AU_3', 40, 2, 1),
('AU_4', 40, 2, 2),
('AU_5', 15, 4, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escuela`
--

CREATE TABLE `escuela` (
  `ID_ESCU` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `DIRECCION` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `escuela`
--

INSERT INTO `escuela` (`ID_ESCU`, `NOMBRE`, `DIRECCION`) VALUES
(1, 'HEROINAS LAS TOL.EDO', 'AV BUENOS AIRES 960'),
(2, 'DOS DE MAYO', 'AV CHIQUITO 640'),
(3, 'ANDE', 'RAY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `ID_GRUPO` int(11) NOT NULL,
  `GRADO` varchar(40) NOT NULL,
  `C_ALUMNOS` int(11) NOT NULL,
  `AULA` varchar(10) NOT NULL,
  `MAESTRO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grupo`
--

INSERT INTO `grupo` (`ID_GRUPO`, `GRADO`, `C_ALUMNOS`, `AULA`, `MAESTRO`) VALUES
(1, '1 PRIMARIA', 25, 'AU_1', 25805514),
(2, '2 PRIMARIA', 25, 'AU_3', 56859625),
(3, '4 SECUNDARIA', 15, 'AU_2', 63524578),
(4, '5 SECUNDARIA', 15, 'AU_4', 96587423);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestro`
--

CREATE TABLE `maestro` (
  `DNI` int(11) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `SEXO` varchar(1) NOT NULL,
  `GRADUACION` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `maestro`
--

INSERT INTO `maestro` (`DNI`, `NOMBRE`, `SEXO`, `GRADUACION`) VALUES
(25805514, 'JUAN PEREZ', 'M', 2005),
(56859625, 'CECILIA ARIAS', 'F', 2012),
(63524578, 'MARIA QUISPE', 'F', 2010),
(96587423, 'OSCAR CALZADA', 'M', 2008);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `clave` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `clave`) VALUES
(1, 'usuario', '$2a$10$AI7toHqx1dxDKXAUS70fzuFgt7.7MOX2Q5tOxmVajOWbARDBiMynW'),
(2, 'idat', '$2a$10$gspN9HBYJYuA9zr6CNZ0sed6IlaEUVigaXkSBe9no9/ezKqz7Z0Be');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`ID_EXPE`),
  ADD KEY `GRUPO` (`GRUPO`);

--
-- Indices de la tabla `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`ID_AULA`),
  ADD KEY `ESCUELA` (`ESCUELA`);

--
-- Indices de la tabla `escuela`
--
ALTER TABLE `escuela`
  ADD PRIMARY KEY (`ID_ESCU`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`ID_GRUPO`),
  ADD KEY `AULA` (`AULA`),
  ADD KEY `MAESTRO` (`MAESTRO`);

--
-- Indices de la tabla `maestro`
--
ALTER TABLE `maestro`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `ID_EXPE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `escuela`
--
ALTER TABLE `escuela`
  MODIFY `ID_ESCU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `grupo`
--
ALTER TABLE `grupo`
  MODIFY `ID_GRUPO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`GRUPO`) REFERENCES `grupo` (`ID_GRUPO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `aula`
--
ALTER TABLE `aula`
  ADD CONSTRAINT `FK74hwmebslhin2xg9ge9l2llt` FOREIGN KEY (`ESCUELA`) REFERENCES `escuela` (`ID_ESCU`),
  ADD CONSTRAINT `aula_ibfk_1` FOREIGN KEY (`ESCUELA`) REFERENCES `escuela` (`ID_ESCU`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD CONSTRAINT `grupo_ibfk_1` FOREIGN KEY (`AULA`) REFERENCES `aula` (`ID_AULA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `grupo_ibfk_2` FOREIGN KEY (`MAESTRO`) REFERENCES `maestro` (`DNI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
