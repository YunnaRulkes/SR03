INSERT INTO UTILISATEURs(login, motDePasse, nom, prenom, email, statusAdmin) VALUES ('admin', '1234', 'Admin', 'Master', 'admin@admin.fr', true);
INSERT INTO UTILISATEURs(login, motDePasse, nom, prenom, email, statusAdmin) VALUES ('tmarinho', 'TMARINHO', 'Marinho', 'Thais', 'thais.marinho@etu.utc.fr', false);
INSERT INTO UTILISATEURs(login, motDePasse, nom, prenom, email, statusAdmin) VALUES ('fotsoloi', 'FOTSOLOI', 'Fotso', 'Loic', 'loic.fotso@etu.utc.fr', false);

INSERT INTO `QUESTION` (`libelle`) VALUES
('Dans quelle ville s''est tenue les derniers jeux olympiques ?'),
('Quelle est la capitale du Bingladesh ?'),
('Quel est le nom du 50e président des Etats Unis ?'),
('Où s''est déroulée la COP21 en 2016 ?');

INSERT INTO `QUESTIONNAIRE` (`nom`) VALUES ('Actualité');
