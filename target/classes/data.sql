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
    nom_parent            varchar(50),
    prenom_parent            varchar(50)
);

/*==============================================================*/
/* Table : typeAnimal                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS typeanimal
(
    type_animal_id         int not null AUTO_INCREMENT primary key,
    lib_type_animal        varchar(100)
);

/*==============================================================*/
/* Table : animal                                          */
/*==============================================================*/

CREATE TABLE IF NOT EXISTS animal
(
   animal_id            int not null AUTO_INCREMENT primary key,
   nom_animal            varchar(50),
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
   nom_medecin           varchar(50),
   prenom_medecin        varchar(50),
   contact              varchar(50)
);

/*==============================================================*/
/* Table : rendezVous                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS rendezvous
(
   rdv_id                int not null AUTO_INCREMENT primary key,
   data_rdv              datetime unique,
   heure_debut_rdv        datetime unique,
   heure_fin_rdv          datetime unique,
   medecin_id              int NOT NULL REFERENCES medecin (medecin_id),
   animal_id               int NOT NULL REFERENCES animal (animal_id)
);

/*==============================================================*/
/* Table : medicament                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS medicament
(
   medicament_id         int not null AUTO_INCREMENT primary key,
   name        varchar(100),
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

INSERT INTO typeanimal (type_animal_id,lib_type_animal) VALUES (1,'dqsdfqsd qsdfqs');
INSERT INTO parent  VALUES (1,'Daniel', 'jordan');
INSERT INTO animal  VALUES (1,'chien','male', 1, 1);

INSERT INTO medecin  VALUES (1,'Nzali','Herman','752058425');

INSERT INTO rendezvous  VALUES (1,'2020-08-17 12:32','2020-08-17 12:32','2020-08-17 12:32',1,1);
INSERT INTO rendezvous  VALUES (2,'2020-09-16 09:30','2020-09-16 09:30','2020-09-16 10:00',1,1);
INSERT INTO rendezvous  VALUES (3,'2020-11-29 14:00','2020-11-29 14:00','2020-11-29 14:30',1,1);

INSERT INTO ordonnance  VALUES (1,1);
INSERT INTO ordonnance  VALUES (2,1);
INSERT INTO ordonnance  VALUES (3,1);
INSERT INTO ordonnance  VALUES (4,1);

INSERT INTO medicament  VALUES (1,'qdf','qsdff');

INSERT INTO prescription  VALUES (1,'qsdfssssddsdsdds','qdf qsdfsdf',7,1,1);

INSERT INTO prescription  VALUES (1,'12-01-16 12:32','qdf qsdfsdf',7,1,1);
