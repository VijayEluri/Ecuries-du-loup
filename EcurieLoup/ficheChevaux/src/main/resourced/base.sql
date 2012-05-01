-- MySQL dump 10.11
--
-- Host: localhost    Database: ecurieduloup
-- ------------------------------------------------------
-- Server version	5.0.51a-3ubuntu5.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `role`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `role` (
  `role` varchar(50) NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` text NOT NULL,
  UNIQUE KEY `role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user` (
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `creation_date` date NOT NULL,
  `last_access_date` date NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `site` varchar(255) NOT NULL,
  PRIMARY KEY  (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;


ALTER TABLE `user` ADD `identifiant_facebook` VARCHAR( 50 ) NULL,
ADD UNIQUE (
`identifiant_facebook`
);
--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user_role` (
  `login` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY  (`login`,`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;



INSERT INTO `role` (`role`, `image`, `description`) VALUES
('ROLE_ADMINISTRATEUR_ADMIN', 'images/admin.png', 'Rôle permettant la modification des pages de présentation ainsi que la gestion des utilistateurs et de leurs droits'),
('ROLE_ADMINISTRATEUR_CALENDRIER', 'images/calendrier.png', 'Rôle permettant les gestions du calendrier.'),
('ROLE_ADMINISTRATEUR_FORUM', 'images/forum.jpg', 'Rôle permettant la gestion du forum (modération, fermeture de topics ...)'),
('ROLE_ADMINISTRATEUR_NEWS', 'images/news.png', 'Rôle permettant la rédaction de news.'),
('ROLE_ADMINISTRATEUR_PHOTO', 'images/photo.jpg', 'Rôle permettant la gestion des photos et albums photo ainsi que la modération des commentaire sur les photos.'),
('ROLE_AUTHENTIFIER', 'images/authentifier.png', 'Rôle permettant l''identification sur le site. Sans ce rôle, l''utilisateur ne pourra plus se connecter. '),
('ROLE_ADMINISTRATEUR_FICHECHEVAUX', 'images/fiche.png', 'Permet la création, modification, suppression des fiches chevaux');


--
-- Contenu de la table `user`
--

INSERT INTO `user` (`login`, `password`, `nom`, `prenom`, `email`, `creation_date`, `last_access_date`, `enabled`, `site`) VALUES
('a 1ieruser', 'pass', 'nom', 'prenom', 'email', '2009-09-23', '2009-09-23', 1, ''),
('krack', 'pass', 'Gandon', 'Sylvain', 'krack_6@hotmail.com', '2009-03-03', '2009-09-17', 1, ''),
('loulou', 'loulou445', 'Bourny', 'Louise', 'trucmuse@truc.fr', '2009-03-03', '2009-07-13', 1, 'http://www.facebook.com');

--
-- Contenu de la table `user_role`
--

INSERT INTO `user_role` (`login`, `role`) VALUES
('a 1ieruser', 'ROLE_AUTHENTIFIER'),
('krack', 'ROLE_ADMINISTRATEUR_ADMIN'),
('krack', 'ROLE_ADMINISTRATEUR_CALENDRIER'),
('krack', 'ROLE_ADMINISTRATEUR_FORUM'),
('krack', 'ROLE_ADMINISTRATEUR_NEWS'),
('krack', 'ROLE_ADMINISTRATEUR_PHOTO'),
('krack', 'ROLE_AUTHENTIFIER'),
('loulou', 'ROLE_AUTHENTIFIER');




--
-- Table structure for table `ficheChevaux_fiche`
--

DROP TABLE IF EXISTS `ficheChevaux_fiche`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ficheChevaux_fiche` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `robe` int(11) NOT NULL,
  `race` int(11) NOT NULL,
  `date_naissance` bigint(20) NOT NULL,
  `sexe` int(11) NOT NULL,
  `photo_corps` bigint(20) default NULL,
  `photo_tete` bigint(20) default NULL,
  `description` text NOT NULL,
  `annee_naissance` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;
ALTER TABLE `ficheChevaux_fiche` ADD `owner` BIGINT NULL ;
--
-- Table structure for table `ficheChevaux_race`
--

DROP TABLE IF EXISTS `ficheChevaux_race`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ficheChevaux_race` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ficheChevaux_robe`
--

DROP TABLE IF EXISTS `ficheChevaux_robe`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ficheChevaux_robe` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ficheChevaux_sexe`
--

DROP TABLE IF EXISTS `ficheChevaux_sexe`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ficheChevaux_sexe` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `nom` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ficheChevaux_surnom`
--

DROP TABLE IF EXISTS `ficheChevaux_surnom`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ficheChevaux_surnom` (
  `id` int(11) NOT NULL,
  `surnom` varchar(255) NOT NULL,
  `ficheCheval` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

CREATE TABLE `ficheChevaux_owner` (
`id` BIGINT NOT NULL ,
`name` VARCHAR( 50 ) NOT NULL ,
`user` VARCHAR( 50 ) NULL ,
PRIMARY KEY ( `id` )
) ENGINE = InnoDB ;

INSERT INTO `ficheChevaux_race` (`id`, `nom`) VALUES ('1', 'nom Race');
INSERT INTO `ficheChevaux_robe` (`id`, `nom`) VALUES ('1', 'nom Robe');
INSERT INTO `ficheChevaux_sexe` (`id`, `nom`) VALUES ('1', 'nom Sexe');

INSERT INTO `ficheChevaux_fiche` (`id`, `nom`, `robe`, `race`, `date_naissance`, `sexe`, `photo_corps`, `photo_tete`, `description`, `annee_naissance`, `owner`) VALUES ('1', 'nom dada', '1', '1', '', '1', NULL, NULL, 'description du dada', '2005', 1);
INSERT INTO `ficheChevaux_fiche` (`id`, `nom`, `robe`, `race`, `date_naissance`, `sexe`, `photo_corps`, `photo_tete`, `description`, `annee_naissance`, `owner`) VALUES ('2', 'nom dada', '1', '1', '', '1', NULL, NULL, 'description du dada', '2005', 1);

INSERT INTO `fichechevauxtest`.`ficheChevaux_surnom` (`id`, `surnom`, `ficheCheval`) VALUES ('1', 'nom Surnom', '1');

INSERT INTO `ficheChevaux_owner` (`id`, `name`, `user`) VALUES ('1', 'krack', 'krack');

ALTER TABLE `user` ADD `birth_date` BIGINT NOT NULL ;
ALTER TABLE `user` ADD `last_access_date_notifier` BIGINT NOT NULL ;

CREATE TABLE ficheChevaux_category(
	`id` int(11) NOT NULL,
	`name` varchar(255) NOT NULL,
  	PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `ficheChevaux_fiche` ADD `category` int(11) NULL ;
