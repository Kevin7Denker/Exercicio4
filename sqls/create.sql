CREATE TABLE IF NOT EXISTS `carros` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `ano_fabricacao` INT NOT NULL,
  `ano_modelo` INT NOT NULL,
  `peso` DOUBLE NOT NULL,
  `kilometragem_atual` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC) VISIBLE);