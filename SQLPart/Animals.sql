/*
В подключенном MySQL репозитории создать базу данных “Друзья
человека”
*/
CREATE DATABASE Human_friends;
/*
Создать таблицы с иерархией из диаграммы в БД
*/
USE Human_friends;
CREATE TABLE animal_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
	Class_name VARCHAR(20)
);
INSERT INTO animal_classes (Class_name)
VALUES ('pack'),
('home');

CREATE TABLE packed_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO packed_animals (Genus_name, Class_id)
VALUES ('Horses', 1),
('Camels', 1),
('Donkeys', 1);

CREATE TABLE home_animals
(
	  Id INT AUTO_INCREMENT PRIMARY KEY,
    Genus_name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animal_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO home_animals (Genus_name, Class_id)
VALUES ('Cats', 3),
('Dogs', 3),
('Humsters', 3);

/*
Заполнить низкоуровневые таблицы именами(животных),
командами которые они выполняют и датами рождения
*/

CREATE TABLE cats
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO cats (Name, Birthday, Commands, Genus_id)
VALUES ('Sasha', '2013-04-04', "kitty-kitty", 1),
('Masha', '2022-06-06', "kis-kis-kis", 1),
('Jora', '2022-08-08', "kitty-kitty", 1);

CREATE TABLE dogs
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO dogs (Name, Birthday, Commands, Genus_id)
VALUES ('Belka', '2020-05-05', "paw, bark, sit, place, bark", 2),
('Strelka', '2021-07-07', "bark, place, sit, drop it", 2),
('Grisha', '2018-09-09', "sit, stop, wait, bark", 2);

CREATE TABLE hamsters
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO hamsters (Name, Birthday, Commands, Genus_id)
VALUES ('Ninja', '2021-01-01', "Kill", 3),
('Brilliant', '2021-03-03', "Fly", 3),
('Galaxy Destroyer', '2023-01-01', "Destroy Galaxy", 3);


CREATE TABLE horses
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO horses (Name, Birthday, Commands, Genus_id)
VALUES ('Chicha', '2021-01-01', "gait, walk, trot, gallop", 1),
('Rome', '2018-03-03', "gait, walk, trot, gallop", 1),
('Fire', '2013-05-05', "gait, walk, trot, gallop", 1);

CREATE TABLE camels
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO camels (Name, Birthday, Commands, Genus_id)
VALUES ('Tiki', '2021-02-02', "stay, run, jump", 3),
('Lacky', '2022-03-03', "stay, run, jump", 3),
('Dormambu', '2019-04-04', "stay, run, jump", 3);

CREATE TABLE donkeys
(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Birthday DATE,
    Commands VARCHAR(50),
    Genus_id int,
    Foreign KEY (Genus_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO donkeys (Name, Birthday, Commands, Genus_id)
VALUES ('Gray', '2020-01-01', "go, stay", 2),
('White', '2019-03-03', "go, stay", 2),
('Black', '2018-01-03', "go, stay", 2);

/*
Удалить из таблицы верблюдов,
т.к. верблюдов решили перевезти в другой питомник на зимовку.
*/

SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

/*
Объединить таблицы лошади, и ослы в одну таблицу.
*/

SELECT Name, Birthday, Commands FROM horses
UNION SELECT  Name, Birthday, Commands FROM donkeys;

/*
Создать новую таблицу “молодые животные”
в которую попадут все животные старше 1 года,
но младше 3 лет и в отдельном столбце
с точностью до месяца
подсчитать возраст животных в новой таблице
*/

CREATE TEMPORARY TABLE animals AS
SELECT *, 'Horses' as genus FROM horses
UNION SELECT *, 'Donkeys' AS genus FROM donkeys
UNION SELECT *, 'Dogs' AS genus FROM dogs
UNION SELECT *, 'Cats' AS genus FROM cats
UNION SELECT *, 'Humsters' AS genus FROM hamsters;

CREATE TABLE yang_animal AS
SELECT Name, Birthday, Commands, genus, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_in_month
FROM animals WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

SELECT * FROM yang_animal;

/*
Объединить все таблицы в одну, при этом сохраняя поля,
указывающие на прошлую принадлежность к старым таблицам.
*/

SELECT h.Name, h.Birthday, h.Commands, pa.Genus_name, ya.Age_in_month
FROM horses h
LEFT JOIN yang_animal ya ON ya.Name = h.Name
LEFT JOIN packed_animals pa ON pa.Id = h.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, pa.Genus_name, ya.Age_in_month
FROM donkeys d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN packed_animals pa ON pa.Id = d.Genus_id
UNION
SELECT c.Name, c.Birthday, c.Commands, ha.Genus_name, ya.Age_in_month
FROM cats c
LEFT JOIN yang_animal ya ON ya.Name = c.Name
LEFT JOIN home_animals ha ON ha.Id = c.Genus_id
UNION
SELECT d.Name, d.Birthday, d.Commands, ha.Genus_name, ya.Age_in_month
FROM dogs d
LEFT JOIN yang_animal ya ON ya.Name = d.Name
LEFT JOIN home_animals ha ON ha.Id = d.Genus_id
UNION
SELECT hm.Name, hm.Birthday, hm.Commands, ha.Genus_name, ya.Age_in_month
FROM hamsters hm
LEFT JOIN yang_animal ya ON ya.Name = hm.Name
LEFT JOIN home_animals ha ON ha.Id = hm.Genus_id;

