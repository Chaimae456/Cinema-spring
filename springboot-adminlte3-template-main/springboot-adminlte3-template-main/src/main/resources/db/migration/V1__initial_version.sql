-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 25 oct. 2022 à 18:57
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cinema`
--

-- --------------------------------------------------------

--
-- Structure de la table `customers`
--

CREATE TABLE `customers` (
  `id` bigint(20) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `email` varchar(255) NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `id` bigint(20) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `annee` int(11) NOT NULL,
  `duree` time NOT NULL,
  `titre` varchar(50) NOT NULL,
  `genre_id` bigint(20) DEFAULT NULL,
  `nationalite_id` bigint(20) DEFAULT NULL,
  `director_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`id`, `added_date`, `annee`, `duree`, `titre`, `genre_id`, `nationalite_id`, `director_id`) VALUES
(1, '2022-10-25 12:12:02', 1994, '01:30:00', 'Les Évadés', 4, 3, 2),
(2, '2022-10-25 12:12:55', 1972, '03:00:00', ' Le Parrain', 3, 5, 2),
(3, '2022-10-25 12:13:40', 2008, '02:30:00', ' The Dark Knight : Le Chevalier noir', 5, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `film_acteur`
--

CREATE TABLE `film_acteur` (
  `actor_id` bigint(20) NOT NULL,
  `film_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `film_acteur`
--

INSERT INTO `film_acteur` (`actor_id`, `film_id`) VALUES
(1, 3),
(1, 4),
(1, 5),
(2, 3),
(2, 5),
(3, 1),
(3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1', 'init', 'SQL', 'V1__init.sql', 0, 'root', '2022-10-25 16:44:14', 17, 1);

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `genre`
--

INSERT INTO `genre` (`id`, `libelle`) VALUES
(1, 'Action'),
(2, 'Adventure '),
(3, 'Comedy '),
(4, 'Musical'),
(5, 'Science Fiction'),
(6, 'Fiction');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `nationalite`
--

CREATE TABLE `nationalite` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `nationalite`
--

INSERT INTO `nationalite` (`id`, `libelle`) VALUES
(1, 'Moroccan'),
(2, 'English'),
(3, 'Spanish'),
(4, 'Algerian'),
(5, 'Egyptian');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` bigint(20) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `date_naissance` datetime(6) DEFAULT NULL,
  `nom` varchar(50) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `prenom` varchar(50) NOT NULL,
  `type_personne` varchar(50) NOT NULL,
  `nationalite_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `added_date`, `date_naissance`, `nom`, `photo`, `prenom`, `type_personne`, `nationalite_id`) VALUES
(1, '2022-10-25 12:01:41', '1981-06-13 07:00:00.000000', 'CHRIS ', '/photos/personnes/6484bb22-84c6-46ee-93ec-c4980a8bd338ChrisEvans-2019_r.jpg', 'EVANS', 'ACTEUR', 2),
(2, '2022-10-25 12:07:40', '1965-04-04 07:00:00.000000', 'ROBERT ', '/photos/personnes/66c8f3b7-c6cd-4244-a438-775ddc2f0318robert162574544.jpg', 'DOWNEY, JR.', 'REALISATEUR', 2),
(3, '2022-10-25 12:08:20', '1990-09-15 07:00:00.000000', 'JENNIFER ', '/photos/personnes/c1542444-2163-4937-948f-be682ae3487bJenniferLawrence-2019.jpg', 'LAWRENCE', 'ACTEUR', 2),
(4, '2022-10-25 12:09:00', '1980-04-26 07:00:00.000000', 'CHANNING ', '/photos/personnes/fc9c7456-8cd0-4ade-96ff-9bf04c7ba89fChanningTatum-2020_r.jpg', 'TATUM', 'ACTEUR', 3),
(5, '2022-10-25 12:09:43', '1963-06-09 07:30:00.000000', 'JOHNNY ', '/photos/personnes/2f45bb17-5c6a-4ab8-90f5-708405ba210dJohnnyDepp-2017.jpg', 'DEPP', 'ACTEUR', 2);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `id` bigint(20) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `capacite` int(11) NOT NULL,
  `numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `added_date`, `capacite`, `numero`) VALUES
(1, '2022-10-25 11:59:01', 30, 1),
(2, '2022-10-25 11:59:19', 45, 2),
(3, '2022-10-25 11:59:29', 25, 3),
(4, '2022-10-25 11:59:41', 30, 6);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

CREATE TABLE `seance` (
  `id` bigint(20) NOT NULL,
  `date_projection` date DEFAULT NULL,
  `heure_debut` time DEFAULT NULL,
  `heure_fin` time DEFAULT NULL,
  `film_id` bigint(20) DEFAULT NULL,
  `salle_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`id`, `date_projection`, `heure_debut`, `heure_fin`, `film_id`, `salle_id`) VALUES
(1, '2022-10-27', '09:00:00', '13:00:00', 3, 3),
(2, '2022-10-28', '09:00:00', '11:10:00', 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `t_user`
--

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_rfbvkrffamfql7cjmen8v976v` (`email`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK72h8eraicy2k4cn11ibevrg7m` (`genre_id`),
  ADD KEY `FKg9fhcn138vw45qkc7ligu3u8u` (`nationalite_id`),
  ADD KEY `FKcldyhuux59siv1auyk9erp8s0` (`director_id`);

--
-- Index pour la table `film_acteur`
--
ALTER TABLE `film_acteur`
  ADD KEY `FKk64q02b3b08hdovqbtp0do6fs` (`film_id`),
  ADD KEY `FKqn8rmou6bowxrsrkvdda9h5ho` (`actor_id`);

--
-- Index pour la table `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Index pour la table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `nationalite`
--
ALTER TABLE `nationalite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkenihid5kc1hh7v33oab2u74f` (`nationalite_id`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKchlcmip8ejlfuo4c990k5ry8y` (`film_id`),
  ADD KEY `FKhupu0bkkkinurpu14xeyjcuep` (`salle_id`);

--
-- Index pour la table `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_i6qjjoe560mee5ajdg7v1o6mi` (`email`),
  ADD UNIQUE KEY `UK_jhib4legehrm4yscx9t3lirqi` (`username`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `nationalite`
--
ALTER TABLE `nationalite`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `seance`
--
ALTER TABLE `seance`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FK72h8eraicy2k4cn11ibevrg7m` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `FKcldyhuux59siv1auyk9erp8s0` FOREIGN KEY (`director_id`) REFERENCES `personne` (`id`),
  ADD CONSTRAINT `FKg9fhcn138vw45qkc7ligu3u8u` FOREIGN KEY (`nationalite_id`) REFERENCES `nationalite` (`id`);

--
-- Contraintes pour la table `film_acteur`
--
ALTER TABLE `film_acteur`
  ADD CONSTRAINT `FKk64q02b3b08hdovqbtp0do6fs` FOREIGN KEY (`film_id`) REFERENCES `personne` (`id`),
  ADD CONSTRAINT `FKqn8rmou6bowxrsrkvdda9h5ho` FOREIGN KEY (`actor_id`) REFERENCES `film` (`id`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `FKkenihid5kc1hh7v33oab2u74f` FOREIGN KEY (`nationalite_id`) REFERENCES `nationalite` (`id`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `FKchlcmip8ejlfuo4c990k5ry8y` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  ADD CONSTRAINT `FKhupu0bkkkinurpu14xeyjcuep` FOREIGN KEY (`salle_id`) REFERENCES `salle` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
