CREATE TABLE mytable(
   id          INTEGER  NOT NULL PRIMARY KEY 
  ,main        VARCHAR(5) NOT NULL
  ,description VARCHAR(9) NOT NULL
  ,icon        VARCHAR(3) NOT NULL
);
INSERT INTO mytable(id,main,description,icon) VALUES (800,'Clear','clear sky','01d');
