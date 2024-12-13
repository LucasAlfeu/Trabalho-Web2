CREATE DATABASE IF NOT EXISTS sistema_de_matricula;

USE sistema_de_matricula;

CREATE TABLE IF NOT EXISTS Docente (
ID_Docente INT PRIMARY KEY AUTO_INCREMENT,
usuario VARCHAR(255),
senha VARCHAR(255),
nome VARCHAR(255),
identificacao VARCHAR(20),
eh_coordenador BOOLEAN,
eh_chefe_de_departamento BOOLEAN
);
CREATE TABLE IF NOT EXISTS Disciplina (
ID_Disciplina INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
maxAlunos INT,
numDiscMatriculados INT,
periodo VARCHAR(255),
cargaHoraria INT,
ID_Docente_ID_Docente INT,
FOREIGN KEY (ID_Docente_ID_Docente) REFERENCES Docente(ID_Docente)
);
CREATE TABLE IF NOT EXISTS Discente (
ID_Discente INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(255),
usuario VARCHAR(255),
senha VARCHAR(255),
matricula VARCHAR(255),
email VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Resultado (
ID_Resultado INT PRIMARY KEY AUTO_INCREMENT,
nota FLOAT,
aprovado VARCHAR(14),
ID_Disciplina_ID_Disciplina INT,
ID_Discente_ID_Discente INT,
FOREIGN KEY (ID_Disciplina_ID_Disciplina) REFERENCES Disciplina(ID_Disciplina),
FOREIGN KEY (ID_Discente_ID_Discente) REFERENCES Discente(ID_Discente)
);