

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

INSERT INTO `memo` (`id`, `sender`, `receiver`, `description`, `posted_date`, `dead_line`, `private_memo`, `memo_is_do`) VALUES ('1', 'krack', 'loulou', 'Description of memo', '123456', '123456789', '1', '1')