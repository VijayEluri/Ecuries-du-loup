

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

ALTER TABLE `photo_photo` ADD `typeAdding` VARCHAR( 50 ) NOT NULL;

INSERT INTO `photo_album` (`id`, `titre`) VALUES (1, 'titre album');
INSERT INTO `photo_commentaire` (`id`, `photo`, `posteur`, `date`, `contenu`) VALUES (1, '1', 'krack', '123456789', 'Commentaire test');
INSERT INTO `photo_photo` (`id`, `description`, `posteur`, `date_postage`, `album`, `typeAdding`) VALUES (1, 'Description de la photo de test', 'krack', '123456789', '1', 'notifier');
INSERT INTO `photo_tag` (`id`, `photo`, `x`, `y`, `nom`) VALUES (1, '1', '152', '154', 'Agathe');

ALTER TABLE `photo_photo` ADD `type` INT NOT NULL DEFAULT '0';

ALTER TABLE `photo_lecture` CHANGE `album_vu` `media_vu` BIGINT( 20 ) NOT NULL;

ALTER TABLE `photo_lecture` ADD INDEX ( `media_vu` , `utilisateur` ) ;
ALTER TABLE `photo_lecture`  DROP `heure_lecture`;