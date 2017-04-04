-- 
--
-- Host: localhost    Database: university_db
-- ------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT 'UNKNOWN',
  `gender` varchar(255) DEFAULT 'UNKNOWN',
  `type` varchar(255) DEFAULT 'UNKNOWN',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);

INSERT INTO `clients` VALUES ('10','Romina Repole','FEMININE','ANONYMOUS'),('12','new client','FEMININE','ANONYMOUS'),('13','Lucas','MASCULINE','MEMBER'),('14','new client','FEMININE','ANONYMOUS'),('15','new client','FEMININE','ANONYMOUS'),('17','Ramiro','MASCULINE','MEMBER'),('18','Jorgito','MASCULINE','MEMBER'),('19','putJorge','MASCULINE','MEMBER'),('20','Lucas','MASCULINE','MEMBER'),('21','Lucasasgakjsghkajsghk','MASCULINE','MEMBER'),('3','DBTest1','MASCULINE','MEMBER'),('4','DBTest1','MASCULINE','MEMBER'),('6','Jorgito','MASCULINE','MEMBER'),('7','Jorgelin','FEMININE','ANONYMOUS'),('9','new client','FEMININE','ANONYMOUS'),('9be92185-634f-444e-b997-d27161330a99','new client jorge','FEMININE','ANONYMOUS'),('a98a25a2-9a72-4217-a023-ef0b306d36bd','new client jorge','FEMININE','ANONYMOUS'),('d87ff889-ff47-4179-91b1-e00a14b22dd9','new client jorge','FEMININE','ANONYMOUS'),('e75204a5-bf4e-4af9-9271-3d3071cb42c6','new client mighuel','FEMININE','ANONYMOUS'),('ff8081814c51e092014c51e0a0130000','new client jorge','FEMININE','ANONYMOUS'),('ff8081814c51f434014c51f4367a0000','new client jorge','FEMININE','ANONYMOUS'),('ff8081814c51f497014c51f499ac0000','new client jorge','FEMININE','ANONYMOUS'),('ff8081814c51f56b014c51f56d4d0000','new client jorge','FEMININE','ANONYMOUS'),('ff8081814c51f7d1014c51fae0c30000','ChosenOme','MASCULINE','ANONYMOUS'),('ff8081814c51f7d1014c51fba2c30001','ChosenOme','MASCULINE','ANONYMOUS'),('ff8081814c51f7d1014c51fe44190002','aslkgjaslgkjasglkajsglaksjglaskjg','MASCULINE','ANONYMOUS'),('ff8081814c52122c014c52122e410000','new client mighuel','FEMININE','ANONYMOUS'),('ff8081814c522857014c52285a3d0000','new client mighuel','FEMININE','ANONYMOUS'),('ff8081814c523346014c52335d9e0000','New Person','MASCULINE','ANONYMOUS'),('ff8081814c760ddd014c760e6fdc0000','roberto','MASCULINE','MEMBER'),('ff8081814c76805d014c768072330000','roberto','MASCULINE','MEMBER'),('ff8081814c76ef98014c76f058a20000','robertoaksjkasgkajsgkasgkj','MASCULINE','MEMBER'),('ff8081814c76fa19014c76fa827c0000','robertoaksjkasgkajsgkasgkj','MASCULINE','MEMBER'),('ff8081814c76fa19014c76fafd140001','robertoaksjkasgkajsgkasgkj','MASCULINE','MEMBER'),('ff8081814cdd424f014cdd430dab0000','roberto','MASCULINE','MEMBER'),('ff8081814cdd729c014cdd7620af0000','roberto','MASCULINE','MEMBER'),('ff8081814ce2b391014ce2b4c4d10000','roberto','MASCULINE','MEMBER'),('ff8081814ce2b624014ce2b6c41b0000','ricardo','MASCULINE','MEMBER');
