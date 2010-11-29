-- phpMyAdmin SQL Dump
-- version 3.2.2.1deb1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Lun 30 Novembre 2009 à 13:26
-- Version du serveur: 5.1.37
-- Version de PHP: 5.2.10-2ubuntu6.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Base de données: `ecurieduloupTest`
--

--
-- Contenu de la table `calendrier_evenement`
--

INSERT INTO `calendrier_evenement` (`id`, `date`, `description`, `type_evenement`) VALUES
(1, 1254158848362, 'evenement de test', 1);

--
-- Contenu de la table `calendrier_type_evenement`
--

INSERT INTO `calendrier_type_evenement` (`id`, `nom`, `description`, `couleur`) VALUES
(1, 'type Evenement Test', 'Ba voila la superbe description', '#123123');

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
INSERT INTO `ecuriedulouptest`.`forum_topic` (
`id` ,
`titre` ,
`ouvert` ,
`categorie` ,
`createur`
)
VALUES (
'1', 'titre topic', '1', '1', 'krack');

--
-- Contenu de la table `nouvelle`
--

INSERT INTO `nouvelle` (`id`, `titre`, `contenu`, `auteur`, `date_creation`, `date_derniere_modification`) VALUES
(1, 'titre nouvelle', 'contenu de la nouvelle trop génial', 'krack', 1254257154162, 0);

--
-- Contenu de la table `page`
--

INSERT INTO `page` (`id`, `contenu`, `lien`, `ordre`, `visible`) VALUES
(1, 'contenu de test', 'lien de test', 1, 1);



--
-- Contenu de la table `smiley_categorie`
--

INSERT INTO `smiley_categorie` (`id`, `nom`, `ordre`) VALUES
(1, 'nom de la categorie de test', 1);

--
-- Contenu de la table `smiley_smiley`
--

INSERT INTO `smiley_smiley` (`id`, `code`, `image`, `categorieSmiley`, `ordre`) VALUES
(1, 'code pour ', 'image du smiley/trop cool', 1, 1);

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
-- Contenu de la table `vrac`
--
