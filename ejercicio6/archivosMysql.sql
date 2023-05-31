CREATE SCHEMA `obcurso` ;

CREATE TABLE `obcurso`.`laptop` (
  `idlaptop` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NOT NULL,
  `modelo` VARCHAR(255) NOT NULL,
  `mem_Disco` INT NOT NULL,
  `mem_Ram` INT NOT NULL,
  `microprocesador` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idlaptop`));

INSERT INTO `obcurso`.`laptop` (`marca`, `modelo`, `mem_Disco`, `mem_Ram`, `microprocesador`)
						VALUES ('Lenovo', 'Ideapad', '1000', '4', 'Intel i3'),
							   ('Acer', 'Aspire e575', '500', '8', 'Intel i5'),
                               ('Exo', 'Smart', '500', '4', 'Intel N4020'),
                               ('Dell', 'Inspiron', '1000', '12', 'AMD Ryzen 5');