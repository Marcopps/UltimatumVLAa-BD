-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2026 a las 22:26:07
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ultimatum_vla`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `puntuacion` int(11) DEFAULT 0,
  `vidas` int(11) DEFAULT 3,
  `aciertos` int(11) DEFAULT 0,
  `errores` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id`, `nombre`, `puntuacion`, `vidas`, `aciertos`, `errores`) VALUES
(1, 'Markops', 0, 3, 0, 0),
(2, 'mrkop', 0, 3, 0, 0),
(3, 'lao', 0, 3, 0, 0),
(4, 'Marco', 20, 0, 2, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidas`
--

CREATE TABLE `partidas` (
  `id` int(11) NOT NULL,
  `jugador_id` int(11) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp(),
  `puntuacion_final` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas`
--

CREATE TABLE `preguntas` (
  `id` int(11) NOT NULL,
  `pregunta` varchar(255) DEFAULT NULL,
  `opcion1` varchar(255) DEFAULT NULL,
  `opcion2` varchar(255) DEFAULT NULL,
  `opcion3` varchar(255) DEFAULT NULL,
  `opcion4` varchar(255) DEFAULT NULL,
  `respuesta_correcta` varchar(255) DEFAULT NULL,
  `dificultad` varchar(20) DEFAULT NULL,
  `creada_por` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `preguntas`
--

INSERT INTO `preguntas` (`id`, `pregunta`, `opcion1`, `opcion2`, `opcion3`, `opcion4`, `respuesta_correcta`, `dificultad`, `creada_por`) VALUES
(1, 'Capital de México', NULL, NULL, NULL, NULL, 'CDMX', 'FACIL', NULL),
(2, 'Capital de Francia', NULL, NULL, NULL, NULL, 'Paris', 'FACIL', NULL),
(3, 'Color del cielo en un día despejado', NULL, NULL, NULL, NULL, 'Azul', 'FACIL', NULL),
(4, 'Cuánto es 5 + 5', NULL, NULL, NULL, NULL, '10', 'FACIL', NULL),
(5, 'Animal que dice miau', NULL, NULL, NULL, NULL, 'Gato', 'FACIL', NULL),
(6, 'Planeta donde vivimos', NULL, NULL, NULL, NULL, 'Tierra', 'FACIL', NULL),
(7, 'Mes con Navidad', NULL, NULL, NULL, NULL, 'Diciembre', 'FACIL', NULL),
(8, 'Cuántos días tiene una semana', NULL, NULL, NULL, NULL, '7', 'FACIL', NULL),
(9, 'Instrumento para cortar papel', NULL, NULL, NULL, NULL, 'Tijeras', 'FACIL', NULL),
(10, 'Rey de la selva', NULL, NULL, NULL, NULL, 'Leon', 'FACIL', NULL),
(11, 'Autor de Don Quijote', NULL, NULL, NULL, NULL, 'Cervantes', 'MEDIA', NULL),
(12, 'Derivada de x²', NULL, NULL, NULL, NULL, '2x', 'MEDIA', NULL),
(13, 'País con más población', NULL, NULL, NULL, NULL, 'India', 'MEDIA', NULL),
(14, 'Año de independencia de México', NULL, NULL, NULL, NULL, '1810', 'MEDIA', NULL),
(15, 'Quién pintó la Mona Lisa', NULL, NULL, NULL, NULL, 'Da Vinci', 'MEDIA', NULL),
(16, 'Raíz cuadrada de 144', NULL, NULL, NULL, NULL, '12', 'MEDIA', NULL),
(17, 'Qué planeta es conocido como planeta rojo', NULL, NULL, NULL, NULL, 'Marte', 'MEDIA', NULL),
(18, 'Creador de Facebook', NULL, NULL, NULL, NULL, 'Mark Zuckerberg', 'MEDIA', NULL),
(19, 'Lenguaje usado para páginas web', NULL, NULL, NULL, NULL, 'HTML', 'MEDIA', NULL),
(20, 'Capital de Canadá', NULL, NULL, NULL, NULL, 'Ottawa', 'MEDIA', NULL),
(21, 'Cuál es la velocidad de la luz aproximada', NULL, NULL, NULL, NULL, '300000 km/s', 'DIFICIL', NULL),
(22, 'Quién desarrolló Tesla', NULL, NULL, NULL, NULL, 'Elon Musk', 'DIFICIL', NULL),
(23, 'Qué lenguaje usa Android nativamente', NULL, NULL, NULL, NULL, 'Kotlin', 'DIFICIL', NULL),
(24, 'Derivada de sen(x)', NULL, NULL, NULL, NULL, 'cos(x)', 'DIFICIL', NULL),
(25, 'Año de caída del muro de Berlín', NULL, NULL, NULL, NULL, '1989', 'DIFICIL', NULL),
(26, 'Qué país tiene más husos horarios', NULL, NULL, NULL, NULL, 'Francia', 'DIFICIL', NULL),
(27, 'Cuál es el metal más conductor', NULL, NULL, NULL, NULL, 'Plata', 'DIFICIL', NULL),
(28, 'Nombre de la galaxia donde vivimos', NULL, NULL, NULL, NULL, 'Via Lactea', 'DIFICIL', NULL),
(29, 'Cuánto es 25²', NULL, NULL, NULL, NULL, '625', 'DIFICIL', NULL),
(30, 'Quién escribió La Iliada', NULL, NULL, NULL, NULL, 'Homero', 'DIFICIL', NULL),
(31, 'Capital de México', NULL, NULL, NULL, NULL, 'CDMX', 'FACIL', NULL),
(32, 'Capital de Francia', NULL, NULL, NULL, NULL, 'Paris', 'FACIL', NULL),
(33, 'Color del cielo en un día despejado', NULL, NULL, NULL, NULL, 'Azul', 'FACIL', NULL),
(34, 'Cuánto es 5 + 5', NULL, NULL, NULL, NULL, '10', 'FACIL', NULL),
(35, 'Animal que dice miau', NULL, NULL, NULL, NULL, 'Gato', 'FACIL', NULL),
(36, 'Planeta donde vivimos', NULL, NULL, NULL, NULL, 'Tierra', 'FACIL', NULL),
(37, 'Mes con Navidad', NULL, NULL, NULL, NULL, 'Diciembre', 'FACIL', NULL),
(38, 'Cuántos días tiene una semana', NULL, NULL, NULL, NULL, '7', 'FACIL', NULL),
(39, 'Instrumento para cortar papel', NULL, NULL, NULL, NULL, 'Tijeras', 'FACIL', NULL),
(40, 'Rey de la selva', NULL, NULL, NULL, NULL, 'Leon', 'FACIL', NULL),
(41, 'Cuál es el océano más grande', NULL, NULL, NULL, NULL, 'Pacifico', 'FACIL', NULL),
(42, 'Cuánto es 9 x 9', NULL, NULL, NULL, NULL, '81', 'FACIL', NULL),
(43, 'Primera letra del abecedario', NULL, NULL, NULL, NULL, 'A', 'FACIL', NULL),
(44, 'País famoso por tacos', NULL, NULL, NULL, NULL, 'Mexico', 'FACIL', NULL),
(45, 'Animal más grande del mundo', NULL, NULL, NULL, NULL, 'Ballena azul', 'FACIL', NULL),
(46, 'Qué estación sigue después de primavera', NULL, NULL, NULL, NULL, 'Verano', 'FACIL', NULL),
(47, 'Color de una esmeralda', NULL, NULL, NULL, NULL, 'Verde', 'FACIL', NULL),
(48, 'Cuánto es 100 dividido entre 10', NULL, NULL, NULL, NULL, '10', 'FACIL', NULL),
(49, 'Metal precioso amarillo', NULL, NULL, NULL, NULL, 'Oro', 'FACIL', NULL),
(50, 'Continente donde está Japón', NULL, NULL, NULL, NULL, 'Asia', 'FACIL', NULL),
(51, 'Capital de Italia', NULL, NULL, NULL, NULL, 'Roma', 'FACIL', NULL),
(52, 'Cuántos meses tiene un año', NULL, NULL, NULL, NULL, '12', 'FACIL', NULL),
(53, 'Animal que ladra', NULL, NULL, NULL, NULL, 'Perro', 'FACIL', NULL),
(54, 'Qué bebida sale de las vacas', NULL, NULL, NULL, NULL, 'Leche', 'FACIL', NULL),
(55, 'Capital de España', NULL, NULL, NULL, NULL, 'Madrid', 'FACIL', NULL),
(56, 'Color de un plátano maduro', NULL, NULL, NULL, NULL, 'Amarillo', 'FACIL', NULL),
(57, 'Cuánto es 3 x 4', NULL, NULL, NULL, NULL, '12', 'FACIL', NULL),
(58, 'Qué planeta está más cerca del Sol', NULL, NULL, NULL, NULL, 'Mercurio', 'FACIL', NULL),
(59, 'Cuántas horas tiene un día', NULL, NULL, NULL, NULL, '24', 'FACIL', NULL),
(60, 'País famoso por samba', NULL, NULL, NULL, NULL, 'Brasil', 'FACIL', NULL),
(61, 'Autor de Don Quijote', NULL, NULL, NULL, NULL, 'Cervantes', 'MEDIA', NULL),
(62, 'Derivada de x²', NULL, NULL, NULL, NULL, '2x', 'MEDIA', NULL),
(63, 'País con más población', NULL, NULL, NULL, NULL, 'India', 'MEDIA', NULL),
(64, 'Año de independencia de México', NULL, NULL, NULL, NULL, '1810', 'MEDIA', NULL),
(65, 'Quién pintó la Mona Lisa', NULL, NULL, NULL, NULL, 'Da Vinci', 'MEDIA', NULL),
(66, 'Raíz cuadrada de 144', NULL, NULL, NULL, NULL, '12', 'MEDIA', NULL),
(67, 'Qué planeta es conocido como planeta rojo', NULL, NULL, NULL, NULL, 'Marte', 'MEDIA', NULL),
(68, 'Creador de Facebook', NULL, NULL, NULL, NULL, 'Mark Zuckerberg', 'MEDIA', NULL),
(69, 'Lenguaje usado para páginas web', NULL, NULL, NULL, NULL, 'HTML', 'MEDIA', NULL),
(70, 'Capital de Canadá', NULL, NULL, NULL, NULL, 'Ottawa', 'MEDIA', NULL),
(71, 'Qué gas respiramos principalmente', NULL, NULL, NULL, NULL, 'Oxigeno', 'MEDIA', NULL),
(72, 'Cuánto es 15 x 8', NULL, NULL, NULL, NULL, '120', 'MEDIA', NULL),
(73, 'Autor de Harry Potter', NULL, NULL, NULL, NULL, 'J K Rowling', 'MEDIA', NULL),
(74, 'Primer presidente de México', NULL, NULL, NULL, NULL, 'Guadalupe Victoria', 'MEDIA', NULL),
(75, 'Cuántos continentes existen', NULL, NULL, NULL, NULL, '6', 'MEDIA', NULL),
(76, 'Cuál es el río más largo del mundo', NULL, NULL, NULL, NULL, 'Nilo', 'MEDIA', NULL),
(77, 'Quién descubrió América', NULL, NULL, NULL, NULL, 'Cristobal Colon', 'MEDIA', NULL),
(78, 'Idioma oficial de Brasil', NULL, NULL, NULL, NULL, 'Portugues', 'MEDIA', NULL),
(79, 'Cuánto vale pi aproximado', NULL, NULL, NULL, NULL, '3.14', 'MEDIA', NULL),
(80, 'Qué país ganó el mundial 2022', NULL, NULL, NULL, NULL, 'Argentina', 'MEDIA', NULL),
(81, 'Qué significa CPU', NULL, NULL, NULL, NULL, 'Unidad Central de Procesamiento', 'MEDIA', NULL),
(82, 'Quién formuló la teoría de la relatividad', NULL, NULL, NULL, NULL, 'Einstein', 'MEDIA', NULL),
(83, 'Elemento químico H', NULL, NULL, NULL, NULL, 'Hidrogeno', 'MEDIA', NULL),
(84, 'Animal símbolo de Australia', NULL, NULL, NULL, NULL, 'Canguro', 'MEDIA', NULL),
(85, 'Cuál es el hueso más largo del cuerpo', NULL, NULL, NULL, NULL, 'Femur', 'MEDIA', NULL),
(86, 'País conocido por las pirámides', NULL, NULL, NULL, NULL, 'Egipto', 'MEDIA', NULL),
(87, 'Cuál es el resultado de 2³', NULL, NULL, NULL, NULL, '8', 'MEDIA', NULL),
(88, 'Capital de Argentina', NULL, NULL, NULL, NULL, 'Buenos Aires', 'MEDIA', NULL),
(89, 'Autor de Romeo y Julieta', NULL, NULL, NULL, NULL, 'Shakespeare', 'MEDIA', NULL),
(90, 'Qué instrumento mide temperatura', NULL, NULL, NULL, NULL, 'Termometro', 'MEDIA', NULL),
(91, 'Capital de Chile', NULL, NULL, NULL, NULL, 'Santiago', 'MEDIA', NULL),
(92, 'Capital de Perú', NULL, NULL, NULL, NULL, 'Lima', 'MEDIA', NULL),
(93, 'Qué significa USB', NULL, NULL, NULL, NULL, 'Universal Serial Bus', 'MEDIA', NULL),
(94, 'Cuál es el animal más rápido terrestre', NULL, NULL, NULL, NULL, 'Guepardo', 'MEDIA', NULL),
(95, 'Quién escribió La Odisea', NULL, NULL, NULL, NULL, 'Homero', 'MEDIA', NULL),
(96, 'Cuánto es 50 + 70', NULL, NULL, NULL, NULL, '120', 'MEDIA', NULL),
(97, 'Qué país tiene forma de bota', NULL, NULL, NULL, NULL, 'Italia', 'MEDIA', NULL),
(98, 'Cuál es el satélite natural de la Tierra', NULL, NULL, NULL, NULL, 'Luna', 'MEDIA', NULL),
(99, 'Qué lenguaje usa Java', NULL, NULL, NULL, NULL, 'POO', 'MEDIA', NULL),
(100, 'Capital de Alemania', NULL, NULL, NULL, NULL, 'Berlin', 'MEDIA', NULL),
(101, 'Cuál es la velocidad de la luz aproximada', NULL, NULL, NULL, NULL, '300000 km/s', 'DIFICIL', NULL),
(102, 'Quién desarrolló Tesla', NULL, NULL, NULL, NULL, 'Elon Musk', 'DIFICIL', NULL),
(103, 'Qué lenguaje usa Android nativamente', NULL, NULL, NULL, NULL, 'Kotlin', 'DIFICIL', NULL),
(104, 'Derivada de sen(x)', NULL, NULL, NULL, NULL, 'cos(x)', 'DIFICIL', NULL),
(105, 'Año de caída del muro de Berlín', NULL, NULL, NULL, NULL, '1989', 'DIFICIL', NULL),
(106, 'Qué país tiene más husos horarios', NULL, NULL, NULL, NULL, 'Francia', 'DIFICIL', NULL),
(107, 'Cuál es el metal más conductor', NULL, NULL, NULL, NULL, 'Plata', 'DIFICIL', NULL),
(108, 'Nombre de la galaxia donde vivimos', NULL, NULL, NULL, NULL, 'Via Lactea', 'DIFICIL', NULL),
(109, 'Cuánto es 25²', NULL, NULL, NULL, NULL, '625', 'DIFICIL', NULL),
(110, 'Quién escribió La Iliada', NULL, NULL, NULL, NULL, 'Homero', 'DIFICIL', NULL),
(111, 'Capital de Nueva Zelanda', NULL, NULL, NULL, NULL, 'Wellington', 'DIFICIL', NULL),
(112, 'Qué significa RAM', NULL, NULL, NULL, NULL, 'Memoria de Acceso Aleatorio', 'DIFICIL', NULL),
(113, 'Cuánto vale e aproximado', NULL, NULL, NULL, NULL, '2.71', 'DIFICIL', NULL),
(114, 'Quién inventó el teléfono', NULL, NULL, NULL, NULL, 'Alexander Graham Bell', 'DIFICIL', NULL),
(115, 'País más grande del mundo', NULL, NULL, NULL, NULL, 'Rusia', 'DIFICIL', NULL),
(116, 'Cuál es el símbolo químico del oro', NULL, NULL, NULL, NULL, 'Au', 'DIFICIL', NULL),
(117, 'Quién pintó La noche estrellada', NULL, NULL, NULL, NULL, 'Van Gogh', 'DIFICIL', NULL),
(118, 'Qué científico propuso las leyes del movimiento', NULL, NULL, NULL, NULL, 'Newton', 'DIFICIL', NULL),
(119, 'Cuántos elementos tiene la tabla periódica', NULL, NULL, NULL, NULL, '118', 'DIFICIL', NULL),
(120, 'Capital de Turquía', NULL, NULL, NULL, NULL, 'Ankara', 'DIFICIL', NULL),
(121, 'Qué significa URL', NULL, NULL, NULL, NULL, 'Uniform Resource Locator', 'DIFICIL', NULL),
(122, 'Cuánto es 17 x 17', NULL, NULL, NULL, NULL, '289', 'DIFICIL', NULL),
(123, 'Cuál es el monte más alto del mundo', NULL, NULL, NULL, NULL, 'Everest', 'DIFICIL', NULL),
(124, 'Quién escribió Cien años de soledad', NULL, NULL, NULL, NULL, 'Gabriel Garcia Marquez', 'DIFICIL', NULL),
(125, 'Qué país inventó el sushi', NULL, NULL, NULL, NULL, 'Japon', 'DIFICIL', NULL),
(126, 'Cuál es el órgano más grande del cuerpo', NULL, NULL, NULL, NULL, 'Piel', 'DIFICIL', NULL),
(127, 'Qué lenguaje usa iOS', NULL, NULL, NULL, NULL, 'Swift', 'DIFICIL', NULL),
(128, 'Cuánto es la raíz cuadrada de 225', NULL, NULL, NULL, NULL, '15', 'DIFICIL', NULL),
(129, 'Quién creó Microsoft', NULL, NULL, NULL, NULL, 'Bill Gates', 'DIFICIL', NULL),
(130, 'Qué planeta tiene más lunas', NULL, NULL, NULL, NULL, 'Saturno', 'DIFICIL', NULL),
(131, 'Año de inicio de la Segunda Guerra Mundial', NULL, NULL, NULL, NULL, '1939', 'DIFICIL', NULL),
(132, 'Qué significa SQL', NULL, NULL, NULL, NULL, 'Structured Query Language', 'DIFICIL', NULL),
(133, 'Cuál es el país más pequeño del mundo', NULL, NULL, NULL, NULL, 'Vaticano', 'DIFICIL', NULL),
(134, 'Qué hormona regula el azúcar', NULL, NULL, NULL, NULL, 'Insulina', 'DIFICIL', NULL),
(135, 'Cuál es el desierto más grande del mundo', NULL, NULL, NULL, NULL, 'Antartida', 'DIFICIL', NULL),
(136, 'Quién formuló las leyes de la herencia', NULL, NULL, NULL, NULL, 'Mendel', 'DIFICIL', NULL),
(137, 'Cuánto es 50 por 12', NULL, NULL, NULL, NULL, '600', 'DIFICIL', NULL),
(138, 'Capital de Corea del Sur', NULL, NULL, NULL, NULL, 'Seul', 'DIFICIL', NULL),
(139, 'Qué significa GPU', NULL, NULL, NULL, NULL, 'Unidad de Procesamiento Grafico', 'DIFICIL', NULL),
(140, 'Cuál es el idioma más hablado del mundo', NULL, NULL, NULL, NULL, 'Mandarin', 'DIFICIL', NULL),
(141, 'Quién descubrió la gravedad', NULL, NULL, NULL, NULL, 'Newton', 'DIFICIL', NULL),
(142, 'Capital de Islandia', NULL, NULL, NULL, NULL, 'Reikiavik', 'DIFICIL', NULL),
(143, 'Qué red social compró Elon Musk', NULL, NULL, NULL, NULL, 'Twitter', 'DIFICIL', NULL),
(144, 'Cuál es el resultado de 11²', NULL, NULL, NULL, NULL, '121', 'DIFICIL', NULL),
(145, 'Quién escribió El Principito', NULL, NULL, NULL, NULL, 'Antoine de Saint Exupery', 'DIFICIL', NULL),
(146, 'Capital de Suiza', NULL, NULL, NULL, NULL, 'Berna', 'DIFICIL', NULL),
(147, 'Qué significa HTTP', NULL, NULL, NULL, NULL, 'HyperText Transfer Protocol', 'DIFICIL', NULL),
(148, 'Cuál es el elemento químico del agua', NULL, NULL, NULL, NULL, 'H2O', 'DIFICIL', NULL),
(149, 'Quién creó Linux', NULL, NULL, NULL, NULL, 'Linus Torvalds', 'DIFICIL', NULL),
(150, 'Cuánto es 144 dividido entre 12', NULL, NULL, NULL, NULL, '12', 'DIFICIL', NULL),
(151, 'Cuál es el idioma oficial de China', NULL, NULL, NULL, NULL, 'Mandarin', 'DIFICIL', NULL),
(152, 'Qué empresa creó Java', NULL, NULL, NULL, NULL, 'Sun Microsystems', 'DIFICIL', NULL),
(153, 'Cuál es el número romano de 50', NULL, NULL, NULL, NULL, 'L', 'DIFICIL', NULL),
(154, 'Qué científico descubrió la penicilina', NULL, NULL, NULL, NULL, 'Alexander Fleming', 'DIFICIL', NULL),
(155, 'Capital de Noruega', NULL, NULL, NULL, NULL, 'Oslo', 'DIFICIL', NULL),
(156, 'Qué científico propuso el heliocentrismo', NULL, NULL, NULL, NULL, 'Copernico', 'DIFICIL', NULL),
(157, 'Qué significa DNS', NULL, NULL, NULL, NULL, 'Domain Name System', 'DIFICIL', NULL),
(158, 'Cuál es la capital de Finlandia', NULL, NULL, NULL, NULL, 'Helsinki', 'DIFICIL', NULL),
(159, 'Qué científico desarrolló la electricidad moderna', NULL, NULL, NULL, NULL, 'Tesla', 'DIFICIL', NULL),
(160, 'Cuál es el océano más profundo', NULL, NULL, NULL, NULL, 'Pacifico', 'DIFICIL', NULL),
(161, 'Cuánto es 19 x 19', NULL, NULL, NULL, NULL, '361', 'DIFICIL', NULL),
(162, 'Qué significa BIOS', NULL, NULL, NULL, NULL, 'Basic Input Output System', 'DIFICIL', NULL),
(163, 'Capital de Dinamarca', NULL, NULL, NULL, NULL, 'Copenhague', 'DIFICIL', NULL),
(164, 'Qué significa LAN', NULL, NULL, NULL, NULL, 'Local Area Network', 'DIFICIL', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rondas`
--

CREATE TABLE `rondas` (
  `id` int(11) NOT NULL,
  `partida_id` int(11) DEFAULT NULL,
  `pregunta_id` int(11) DEFAULT NULL,
  `respuesta_usuario` varchar(255) DEFAULT NULL,
  `correcta` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `jugador_id` (`jugador_id`);

--
-- Indices de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `rondas`
--
ALTER TABLE `rondas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `partida_id` (`partida_id`),
  ADD KEY `pregunta_id` (`pregunta_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `partidas`
--
ALTER TABLE `partidas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `preguntas`
--
ALTER TABLE `preguntas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=165;

--
-- AUTO_INCREMENT de la tabla `rondas`
--
ALTER TABLE `rondas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `partidas`
--
ALTER TABLE `partidas`
  ADD CONSTRAINT `partidas_ibfk_1` FOREIGN KEY (`jugador_id`) REFERENCES `jugadores` (`id`);

--
-- Filtros para la tabla `rondas`
--
ALTER TABLE `rondas`
  ADD CONSTRAINT `rondas_ibfk_1` FOREIGN KEY (`partida_id`) REFERENCES `partidas` (`id`),
  ADD CONSTRAINT `rondas_ibfk_2` FOREIGN KEY (`pregunta_id`) REFERENCES `preguntas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
