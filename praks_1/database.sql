DROP TABLE IF EXISTS Programmeerimiskeel;
CREATE TABLE IF NOT EXISTS Programmeerimiskeel (
  id            SERIAL       NOT NULL,
  nimi          VARCHAR(200) NOT NULL,
  loomise_aasta NUMERIC      NOT NULL,
  disainer      VARCHAR(200) NOT NULL,
  CONSTRAINT PK_programmeerimiskeel_id PRIMARY KEY (id)
);

INSERT INTO Programmeerimiskeel (nimi, loomise_aasta, disainer) VALUES ('Fortran', 1957, 'John Backus');
INSERT INTO Programmeerimiskeel (nimi, loomise_aasta, disainer) VALUES ('C', 1972, 'Dennis Ritchie');
INSERT INTO Programmeerimiskeel (nimi, loomise_aasta, disainer) VALUES ('Python', 1991, 'Guido Van Rossum');
INSERT INTO Programmeerimiskeel (nimi, loomise_aasta, disainer) VALUES ('Java', 1995, '	James Gosling');
INSERT INTO Programmeerimiskeel (nimi, loomise_aasta, disainer) VALUES ('PHP', 1995, 'Rasmus Lerdorf');
INSERT INTO Programmeerimiskeel (nimi, loomise_aasta, disainer)
VALUES ('F Sharp', 2005, 'Don Syme, Microsoft Research');