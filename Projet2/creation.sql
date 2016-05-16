DROP TABLE IF EXISTS UTILISATEUR CASCADE; 

CREATE TABLE UTILISATEUR (
	ID VARCHAR(10) AUTO_INCREMENT PRIMARY KEY,
	login VARCHAR(20) NOT NULL,
	motDePasse VARCHAR(20) NOT NULL,
	nom VARCHAR(30) NOT NULL,
	prenom VARCHAR(30) NOT NULL,
	societe VARCHAR(30),
	telephone VARCHAR(30),
	email VARCHAR(150) NOT NULL,
	dateDeCreation TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
	statusActif BOOLEAN DEFAULT TRUE,
	statusAdmin BOOLEAN DEFAULT FALSE,
        constraint pk_UTILISATEUR primary key (id),
	CHECK (email NOT REGEXP '^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9][a-zA-Z0-9._-]*\\.[a-zA-Z]{2,4}$')
);


INSERT INTO UTILISATEUR(login, motDePasse, nom, prenom, email, statusAdmin) VALUES ('admin', '1234', 'Admin', 'Master', 'admin@admin.fr', true);
INSERT INTO UTILISATEUR(login, motDePasse, nom, prenom, email, statusAdmin) VALUES ('tmarinho', 'TMARINHO', 'Marinho', 'Thais', 'thais.marinho@etu.utc.fr', false);
INSERT INTO UTILISATEUR(login, motDePasse, nom, prenom, email, statusAdmin) VALUES ('fotsoloi', 'FOTSOLOI', 'Fotso', 'Loic', 'loic.fotso@etu.utc.fr', false);



