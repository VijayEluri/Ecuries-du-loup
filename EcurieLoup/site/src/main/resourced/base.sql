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

--
-- Table structure for table `EnregistrementTraceRequete`
--

DROP TABLE IF EXISTS `EnregistrementTraceRequete`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `EnregistrementTraceRequete` (
  `id` bigint(20) NOT NULL,
  `date` bigint(20) NOT NULL,
  `userAgent` varchar(255) NOT NULL,
  `referer` varchar(255) NOT NULL,
  `uri` varchar(255) NOT NULL,
  `remoteAdress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ParametreEnregistrementTraceRequete`
--

DROP TABLE IF EXISTS `ParametreEnregistrementTraceRequete`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `ParametreEnregistrementTraceRequete` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `value` varchar(50) NOT NULL,
  `requete` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `calendrier_evenement`
--

DROP TABLE IF EXISTS `calendrier_evenement`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `calendrier_evenement` (
  `id` bigint(20) NOT NULL,
  `date` bigint(20) NOT NULL,
  `description` text NOT NULL,
  `type_evenement` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `calendrier_type_evenement`
--

DROP TABLE IF EXISTS `calendrier_type_evenement`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `calendrier_type_evenement` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `couleur` varchar(7) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

 ALTER TABLE `calendrier_type_evenement` ADD `urlJspView` VARCHAR( 255 ) NOT NULL DEFAULT '' ;
ALTER TABLE `calendrier_type_evenement` ADD `permanent` BOOL NOT NULL ;
 
 --
-- Table structure for table `forum_categorie`
--

DROP TABLE IF EXISTS `forum_categorie`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `forum_categorie` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `forum_droit`
--

DROP TABLE IF EXISTS `forum_droit`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `forum_droit` (
  `categorie` int(11) NOT NULL,
  `role` varchar(50) NOT NULL,
  PRIMARY KEY  (`categorie`,`role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `forum_message`
--

DROP TABLE IF EXISTS `forum_message`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `forum_message` (
  `id` bigint(20) NOT NULL,
  `topic` bigint(20) NOT NULL,
  `auteur` varchar(50) NOT NULL,
  `message` text NOT NULL,
  `date_postage` bigint(20) NOT NULL,
  `date_modification` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `forum_topic`
--

DROP TABLE IF EXISTS `forum_topic`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `forum_topic` (
  `id` bigint(20) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `ouvert` tinyint(1) NOT NULL,
  `categorie` int(11) NOT NULL,
  `createur` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;


DROP TABLE IF EXISTS `forum_lecture`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `forum_lecture` (
	`id` BIGINT NOT NULL ,
	`topic_lu` BIGINT NOT NULL ,
	`utilisateur` VARCHAR( 50 ) NOT NULL ,
	`heure_lecture` BIGINT NOT NULL ,
	PRIMARY KEY ( `id` )
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT ;
SET character_set_client = @saved_cs_client;
--
-- Table structure for table `nouvelle`
--

DROP TABLE IF EXISTS `nouvelle`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `nouvelle` (
  `id` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `contenu` text NOT NULL,
  `auteur` varchar(50) NOT NULL,
  `date_creation` bigint(20) NOT NULL,
  `date_derniere_modification` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `page`
--

DROP TABLE IF EXISTS `page`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `page` (
  `id` int(11) NOT NULL,
  `contenu` text NOT NULL,
  `lien` varchar(100) NOT NULL,
  `ordre` int(11) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `photo_album`
--

DROP TABLE IF EXISTS `photo_album`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `photo_album` (
  `id` bigint(20) NOT NULL,
  `titre` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;



--
-- Structure de la table `photo_lecture`
--

CREATE TABLE IF NOT EXISTS `photo_lecture` (
  `id` bigint(20) NOT NULL,
  `album_vu` bigint(20) NOT NULL,
  `utilisateur` varchar(50) NOT NULL,
  `heure_lecture` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Table structure for table `photo_commentaire`
--

DROP TABLE IF EXISTS `photo_commentaire`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `photo_commentaire` (
  `id` bigint(20) NOT NULL,
  `photo` bigint(20) NOT NULL,
  `posteur` varchar(50) NOT NULL,
  `date` bigint(20) NOT NULL,
  `contenu` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `photo_photo`
--

DROP TABLE IF EXISTS `photo_photo`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `photo_photo` (
  `id` bigint(20) NOT NULL,
  `description` text NOT NULL,
  `posteur` varchar(50) NOT NULL,
  `album` bigint(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

 ALTER TABLE `photo_photo` ADD `date_postage` BIGINT NOT NULL AFTER `posteur`;


--
-- Table structure for table `photo_tag`
--

DROP TABLE IF EXISTS `photo_tag`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `photo_tag` (
  `id` bigint(20) NOT NULL,
  `photo` bigint(20) NOT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `role`
--

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
-- Table structure for table `sauvegarde_photo`
--

DROP TABLE IF EXISTS `sauvegarde_photo`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sauvegarde_photo` (
  `identifiant` int(11) NOT NULL,
  `fichier` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sauvegarde_smiley`
--

DROP TABLE IF EXISTS `sauvegarde_smiley`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sauvegarde_smiley` (
  `identifiant` int(11) NOT NULL,
  `fichier` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `smiley_categorie`
--

DROP TABLE IF EXISTS `smiley_categorie`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `smiley_categorie` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `ordre` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `smiley_smiley`
--

DROP TABLE IF EXISTS `smiley_smiley`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `smiley_smiley` (
  `id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL,
  `image` varchar(255) NOT NULL,
  `categorieSmiley` int(11) NOT NULL,
  `ordre` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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

ALTER TABLE `user` ADD `last_access_date_notifier` BIGINT NOT NULL;

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

--
-- Table structure for table `vrac`
--

DROP TABLE IF EXISTS `vrac`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `vrac` (
  `id` varchar(50) NOT NULL,
  `contenu` text NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
SET character_set_client = @saved_cs_client;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- Dump completed on 2009-11-27 19:43:21
CREATE TABLE `memo` (
`id` BIGINT NOT NULL ,
`sender` VARCHAR( 50 ) NOT NULL ,
`receiver` VARCHAR( 50 ) NOT NULL ,
`description` TEXT NOT NULL ,
`posted_date` BIGINT NOT NULL ,
`dead_line` BIGINT NOT NULL ,
`private_memo` BOOL NOT NULL ,
`memo_is_do` BOOL NOT NULL ,
PRIMARY KEY ( `id` )
) ENGINE = InnoDB ;


CREATE TABLE `memo_reading` (
`user` VARCHAR( 50 ) NOT NULL ,
`date_of_see` BIGINT NOT NULL ,
PRIMARY KEY ( `user` )
) ENGINE = InnoDB ;


CREATE TABLE `ficheChevaux_owner` (
`id` BIGINT NOT NULL ,
`name` VARCHAR( 50 ) NOT NULL ,
`user` VARCHAR( 50 ) NULL ,
PRIMARY KEY ( `id` )
) ENGINE = InnoDB ;

INSERT INTO `vrac` (`id`, `contenu`) VALUES
('edito', '[gras]edito super genial[/gras]\n\nviva moi[:p]');



INSERT INTO `role` (`role`, `image`, `description`) VALUES
('ROLE_ADMINISTRATEUR_ADMIN', 'images/admin.png', 'Rôle permettant la modification des pages de présentation ainsi que la gestion des utilistateurs et de leurs droits'),
('ROLE_ADMINISTRATEUR_CALENDRIER', 'images/calendrier.png', 'Rôle permettant les gestions du calendrier.'),
('ROLE_ADMINISTRATEUR_FORUM', 'images/forum.jpg', 'Rôle permettant la gestion du forum (modération, fermeture de topics ...)'),
('ROLE_ADMINISTRATEUR_NEWS', 'images/news.png', 'Rôle permettant la rédaction de news.'),
('ROLE_ADMINISTRATEUR_PHOTO', 'images/photo.jpg', 'Rôle permettant la gestion des photos et albums photo ainsi que la modération des commentaire sur les photos.'),
('ROLE_AUTHENTIFIER', 'images/authentifier.png', 'Rôle permettant l''identification sur le site. Sans ce rôle, l''utilisateur ne pourra plus se connecter. '),
('ROLE_ADMINISTRATEUR_FICHECHEVAUX', 'images/fiche.png', 'Permet la création, modification, suppression des fiches chevaux');


ALTER TABLE `photo_photo` ADD `typeAdding` VARCHAR( 50 ) NOT NULL;
ALTER TABLE `photo_photo` ADD `shotDate` DATETIME NULL ;

ALTER TABLE `page` ADD `description` TEXT NULL ;