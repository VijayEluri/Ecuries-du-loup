CREATE TABLE `generiqueutiltest`.`object_test` (
`id` BIGINT NOT NULL ,
`string1` VARCHAR( 255 ) NOT NULL ,
`string2` VARCHAR( 255 ) NOT NULL ,
`date1` TIMESTAMP NOT NULL 
) ENGINE = MYISAM ;


CREATE TABLE `generiqueutiltest`.`object_test2` (
`id` BIGINT NOT NULL ,
`objectTest` BIGINT NOT NULL
) ENGINE = MYISAM ;

INSERT INTO `generiqueutiltest`.`object_test` (
`id` ,
`string1` ,
`string2` ,
`date1` 
)
VALUES ('1', 'string11', 'string12', '2010-01-27');
