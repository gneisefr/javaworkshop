--DROP TABLE IF EXISTS myschema.Person;
--DROP TABLE IF EXISTS myschema.User;
--CREATE TABLE myschema.Person (
--        id BIGINT NOT NULL AUTO_INCREMENT,
--        firstname VARCHAR(255) NOT NULL DEFAULT '',
--        name VARCHAR(255) NOT NULL DEFAULT '',
--        system VARCHAR(255) DEFAULT '',
--        discriminator VARCHAR(20) NOT NULL,
--        PRIMARY KEY (id))
--        ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

TRUNCATE TABLE myschema.User;

