/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  27/11/2020 15:11:24                      */
/*==============================================================*/

/*==============================================================*/
/* Table : parent                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS parent
(
    parent_id            int not null AUTO_INCREMENT primary key,
    nomparent            varchar(50),
    prenom_parent            varchar(50)
);

/*==============================================================*/
/* Table : typeAnimal                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS typeanimal
(
    type_animal_id         int not null AUTO_INCREMENT primary key,
    libtypeanimal        varchar(100)
);

/*==============================================================*/
/* Table : animal                                          */
/*==============================================================*/

CREATE TABLE IF NOT EXISTS animal
(
    animal_id            int not null AUTO_INCREMENT primary key,
    nomanimal            varchar(50),
    sex_animal            varchar(50),
    parent_id int NOT NULL REFERENCES parent(parent_id),
    type_animal_id int NOT NULL REFERENCES typeanimal(type_animal_id)
);

/*==============================================================*/
/* Table : medecin                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS medecin
(
    medecin_id            int not null AUTO_INCREMENT primary key,
    nommedecin           varchar(50),
    prenom_medecin        varchar(50),
    contact              varchar(50)
);

/*==============================================================*/
/* Table : rendezVous                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS rendezvous
(
    rdv_id                int not null AUTO_INCREMENT primary key,
    datardv              datetime NOT NULL UNIQUE,
    heuredebutrdv        datetime NOT NULL UNIQUE,
    heurefinrdv          datetime NOT NULL UNIQUE,
    medecin_id              int NOT NULL REFERENCES medecin (medecin_id),
    animal_id               int NOT NULL REFERENCES animal (animal_id)
);

/*==============================================================*/
/* Table : medicament                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS medicament
(
    medicament_id         int not null AUTO_INCREMENT primary key,
    nommedicament        varchar(100),
    description          varchar(250)
);

/*==============================================================*/
/* Table : ordonnance                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS ordonnance
(
    ordonnance_id         int not null AUTO_INCREMENT primary key,
    rdv_id                  int NOT NULL REFERENCES rendezVous (rdv_id)
);


/*==============================================================*/
/* Table : prescription                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS prescription
(
    prescription_id       int not null AUTO_INCREMENT primary key,
    date_prescription     datetime,
    frequence_de_prise     varchar(200),
    quantite             int,
    ordonnance_id           int NOT NULL REFERENCES ordonnance (ordonnance_id),
    medicament_id           int NOT NULL REFERENCES medicament (medicament_id)
);



INSERT INTO typeanimal (type_animal_id,libtypeanimal)
VALUES
(1,'chien'),
(2,'Lapin'),
(3,'cheval'),
(4,'veau'),
(5,'chat');

INSERT INTO parent (parent_id,nomparent,prenom_parent)
VALUES
(1,'Popo', 'Marx'),
(2,'Doudou', 'Scooby'),
(3,'Case', 'Doo'),
(4,'Momo', 'Tom'),
(5,'Bobo', 'Joe');

INSERT INTO animal
VALUES
(1,'Lalou','female', 1, 5),
(2,'Lili','female', 3, 2),
(3,'Lolo','male', 5, 1),
(4,'Toto','female', 4, 3),
(5,'Tati','male', 2, 4);

INSERT INTO medecin (medecin_id,nommedecin,prenom_medecin,contact)
VALUES
(1,'Kossi','Etiam','0601548976'),
(2,'Nibaruta','Khelia','0669854126'),
(3,'Sipe','Daniel','0632106987'),
(4,'DAlmeida','Denis','0621598742'),
(5,'Keza','Assia','0623598741');

INSERT INTO rendezvous
VALUES
(1,'12-01-21 12:32','12-01-21 08:30','12-01-21 09:30',1,4),
(2,'18-01-21 12:32','18-01-21 10:00','18-01-21 11:00',5,3),
(3,'20-01-21 12:32','20-01-21 11:00','20-01-21 12:00',3,1),
(4,'25-01-21 12:32','25-01-21 14:00','25-01-21 15:00',4,2),
(5,'20-01-21 12:32','20-01-21 16:00','20-01-21 17:00',2,5);
INSERT INTO ordonnance
VALUES
(1,4),
(2,2),
(3,5),
(4,3),
(5,1);

INSERT INTO medicament
VALUES
(1,'ACTI-TETRA B','Poudre pour solution buvable'),
(2,'ACTI-TETRA I','Solution injectable'),
(3,'IMALGENE 1000','Solution injectable'),
(4,'CALCIVITOL','Solution injectable'),
(5,'CALCITAT FORT','Solution injectable');

INSERT INTO prescription
VALUES
(1,'25-01-21 15:00','une fois par jour',1,1,1),
(2,'18-01-21 11:00','une fois par jour',1,2,2),
(3,'20-01-21 17:00','trois fois par jour',3,3,3),
(4,'20-01-21 12:00','deux fois par jour',2,4,4),
(5,'12-01-21 09:30','deux fois par jour',2,5,5);



