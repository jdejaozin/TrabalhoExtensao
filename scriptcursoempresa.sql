CREATE SCHEMA `cursosempresadb` ;

use cursosempresadb;

-- CRIAÇÃO DE TABELAS
-- TABELA DE EMPRESAS
CREATE TABLE `cursosempresadb`.`empresa` (
  `idempresa` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idempresa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- TABELA DE TURMA
CREATE TABLE `cursosempresadb`.`turma` (
  `idturma` INT NOT NULL AUTO_INCREMENT,
  `id_curso` INT NOT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`idturma`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- TABELA DE ALUNOS
CREATE TABLE `cursosempresadb`.`aluno` (
  `id_aluno` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `rg` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(150) NOT NULL,
  `data_nascimento` DATETIME NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `id_turma` INT NOT NULL,
  `cnpj_empresa` VARCHAR(45),
  PRIMARY KEY (`id_aluno`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- TABELA DE CURSOS
CREATE TABLE `cursosempresadb`.`curso` (
  `idcurso` INT NOT NULL,
  `nome` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`idcurso`));
  ALTER TABLE `cursosempresadb`.`curso` 
CHANGE COLUMN `idcurso` `idcurso` INT NOT NULL AUTO_INCREMENT;

-- TABELA DE ALUNOS

