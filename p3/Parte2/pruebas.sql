\CONNECT Schema2DB2

SELECT * FROM Soldado;

SELECT * FROM Grupo;

SELECT * FROM Vehiculo;

\connect Ranger

UPDATE Peloton SET Clase='Fusileros' WHERE identificador='1004';

UPDATE Ranger SET rango='cabo' WHERE identificador='7956';

UPDATE Vehiculo SET armamento='NO' WHERE Matricula='1345';

\CONNECT Marina

UPDATE Escuadra SET Nombre='Oso 3' WHERE id='1';

UPDATE Marine SET Nombre='Juan Jose' WHERE id='05910689';

UPDATE Vehiculo SET armas='NO' WHERE id='14057';

\CONNECT Schema2DB2

SELECT * FROM Soldado;

SELECT * FROM Grupo;

SELECT * FROM Vehiculo;
