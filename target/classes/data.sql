/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  27/11/2020 15:11:24                      */
/*==============================================================*/

/*==============================================================*/
/* Table : animal                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS parent
(
    idParent            int not null AUTO_INCREMENT primary key,
    nomParent            varchar(50),
    prenomParent            varchar(50)
);

/*==============================================================*/
/* Table : typeAnimal                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS typeAnimal
(
    idTypeAnimal         int not null AUTO_INCREMENT primary key,
    libTypeAnimal        varchar(100)
);

CREATE TABLE IF NOT EXISTS animal
(
   idAnimal            int not null AUTO_INCREMENT primary key,
   nomAnimal            varchar(50),
   sexAnimal            varchar(50),
   typeAnimal           varchar(50),
   parent int NOT NULL REFERENCES parent(idParent),
   typeAnimal int NOT NULL REFERENCES typeAnimal(idTypeAnimal)
);

/*==============================================================*/
/* Table : medecin                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS medecin
(
   idMedecin            int not null AUTO_INCREMENT primary key,
   nomMedecin           varchar(50),
   prenomMedecin        varchar(50),
   contact              varchar(50)
);

/*==============================================================*/
/* Table : rendezVous                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS rendezvous
(
   idRdv                int not null AUTO_INCREMENT primary key,
   dateRdv              datetime,
   heureRdv             datetime,
   medecin              int NOT NULL REFERENCES medecin (idMedecin),
   animal               int NOT NULL REFERENCES animal (idAnimal)
);

/*==============================================================*/
/* Table : medicament                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS medicament
(
   idMedicament         int not null AUTO_INCREMENT primary key,
   nomMedicament        varchar(100)
);

/*==============================================================*/
/* Table : ordonnance                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS ordonnance
(
   idOrdonnance         int not null AUTO_INCREMENT primary key,
   rdv                  int NOT NULL REFERENCES rendezVous (idRdv)
);


/*==============================================================*/
/* Table : prescription                                         */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS prescription
(
   idPrescription       int not null AUTO_INCREMENT primary key,
   datePrescription     datetime,
   quantite             int,
   frequenceDePrise     varchar(200),
   medicament           int NOT NULL REFERENCES medicament (idMedicament),
   ordonnance           int NOT NULL REFERENCES ordonnance (idOrdonnance)
);










