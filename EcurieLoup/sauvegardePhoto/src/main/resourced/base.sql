
DROP TABLE IF EXISTS `sauvegarde_photo`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `sauvegarde_photo` (
  `identifiant` BIGINT NOT NULL,
  `fichier` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;