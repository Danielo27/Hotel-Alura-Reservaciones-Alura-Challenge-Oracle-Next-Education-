create database hotel_Alura;
use hotel_Alura;

create table Reservas(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    fechaEntrada VARCHAR (50) NOT NULL,
    fechaSalida VARCHAR (50) NOT NULL,
    valor BIGINT NOT NULL,
    formaDePago VARCHAR(25) NOT NULL
)ENGINE=INNODB;

create table Huspedes(
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nombre VARCHAR (255) NOT NULL,
  apellido VARCHAR (255) NOT NULL,
  fechaDeNacimiento VARCHAR(50) NOT NULL,
  nacionalidad VARCHAR (255) NOT NULL,
  telefono VARCHAR(10) NOT NULL,
  idReserva INT NOT NULL UNIQUE,
  CONSTRAINT fk_reserva FOREIGN KEY (idReserva) REFERENCES Reservas(id)
)ENGINE=INNODB;


create table Login(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (255) NOT NULL,
  password VARCHAR (255) NOT NULL
)ENGINE=INNODB;

INSERT INTO login(name,password) VALUES ("admin","admin");

DELIMITER //
CREATE PROCEDURE borrarHusResID(IN idRequest INT)
BEGIN
	DELETE FROM Huspedes WHERE idReserva = idRequest;
    DELETE FROM Reservas WHERE id = idRequest;
END//






