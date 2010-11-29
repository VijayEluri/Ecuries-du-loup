
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

ALTER TABLE `user` ADD `birth_date` BIGINT NOT NULL ;
ALTER TABLE `user` ADD `last_access_date_notifier` BIGINT NOT NULL ;

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
-- Contenu de la table `forum_categorie`
--
INSERT INTO `forum_categorie` (`id`, `titre`, `description`) VALUES
(1, 'titre de la categorie', 'description de la categorie');

--
-- Contenu de la table `forum_droit`
--


--
-- Contenu de la table `forum_message`
--
INSERT INTO `forum_message` (`id`, `topic`, `auteur`, `message`, `date_postage`, `date_modification`) VALUES
(1, 1, 'krack', 'contenu ajouter', 123456789, 0);

--
-- Contenu de la table `forum_topic`
--
INSERT INTO `forum_topic` (`id` ,`titre` ,`ouvert` ,`categorie` ,`createur`)
VALUES ('1', 'titre topic', '1', '1', 'krack');


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

