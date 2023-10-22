CREATE TABLE `Defencivo` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `preco`  number (255) DEFAULT NULL,
  `quantidade` number (255) DEFAULT NULL,
  FOREIGN KEY (`id`) REFERENCES `Safra` (`id`));
