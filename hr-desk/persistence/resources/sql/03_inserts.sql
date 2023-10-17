
insert into roles(id, label, description, level) VALUES (1, 'software administrator', 'software administrator', 0);
insert into roles(id, label, description, level) VALUES (2, 'developer', 'developer', 10);
insert into roles(id, label, description, level) VALUES (3, 'permanent, external consultant', 'dipendente, attualmente impiegato in attività di consulenza esterna', 80);
insert into roles(id, label, description, level) VALUES (4, 'course candidate', 'candidato a partecipare a corso', 90);
insert into roles(id, label, description, level) VALUES (5, 'guest', 'guest', 100);
insert into roles(id, label, description, level) VALUES (6, 'hr', 'human resources collegue', 50);
insert into roles(id, label, description, level) VALUES (7, 'commercial account', 'commercial account resources collegue', 7);
insert into roles(id, label, description, level) VALUES (8, 'company administrator', 'company administrator', 3);


insert into users (id, email,firstname,lastname, password, regdate, role, enabled) VALUES 
(1,'admin@hr.desk','Marco','Rossi', '$2a$10$uYjO1vB8zora1rvqBD00c.vg4Gz6fTqPftlP9JtObq0oTt1QecRpG', '2022-12-31', 0, true),
(2,'hr@hr.desk','Serena','Verdi', '$2a$10$uYjO1vB8zora1rvqBD00c.vg4Gz6fTqPftlP9JtObq0oTt1QecRpG', '2022-12-31', 50, true),
(3,'account@hr.desk','Michela','Bianchi', '$2a$10$uYjO1vB8zora1rvqBD00c.vg4Gz6fTqPftlP9JtObq0oTt1QecRpG', '2022-12-31', 7, true),
(4,'hr2@hr.desk','Giovanna','Bluetti', '$2a$10$uYjO1vB8zora1rvqBD00c.vg4Gz6fTqPftlP9JtObq0oTt1QecRpG', '2022-12-31', 50, true);


INSERT INTO `candidate_states` VALUES 
(1,4,1,'DA VALUTARE','entry appena effettuata. Stato: DA VALUTARE - DEFAULT','#f60000'),
(2,4,2,'ha rinunciato','Ha rinunciato a proseguire iter di selezione','#f98742'),
(3,4,3,'inadeguato standing/comportamentale','Scartato per inadeguatezza in termini di standing o criticità comportamentali','#f9c842'),
(4,4,4,'inadeguato background','Scartato per inadeguatezza background','#f9ec14'),
(5,4,5,'da tenere in considerazione a chiusura iter','inadeguat ma da tenere in considerazione a chiusura iter','#0e81ec'),
(6,4,6,'background solo parzialmente adeguato, NON LAUREATO/NON LAUREANDO','background parzialmente adeguato. NON LAUREATO/NON LAUREANDO','#2585de'),
(7,4,7,'background solo parzialmente adeguato, LAUREATO/LAUREANDO in materie inerenti la posizione','background parzialmente adeguato, LAUREATO/LAUREANDO in materie idonee la posizione','#25ded3'),
(8,4,8,'OK. Background di prima scelta. NON LAUREATO/NON LAUREANDO. Buona motivazione e background','NO LAUREATO/NO LAUREANDO. Buona motivazione e background. OK già da subito.','#7af914'),
(9,4,9,'OK. Background di prima scelta. LAUREATO/LAUREANDO. Buona motivazione e background','LAUREATO/LAUREANDO. Buona motivazione e background. OK già da subito.','#63b81e');

INSERT INTO `coursepage` (id, title, code, body_text, file_name, opened_by) VALUES 
(1,'Candidatura generica Milano','MILAN01','Candidatura spontanea su sede di Milano',NULL, 1),
(2,'Candidatura generica Roma','ROMA01','Candidatura spontanea su sede di Roma',NULL, 2);
--,(2,'Candidatura corso FullStackWeb+Java 01 Milano','MICEACFS01','Candidatura partecipazione a I Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Gen18-Mar18',NULL),
--(3,'Candidatura corso FullStackWeb+Java 02 Milano','MICEACFS02','Candidatura partecipazione a II Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Apr18-Giu18',NULL),
--(4,'Candidatura corso FullStackWeb+Java 03 Milano','MICEACFS03','Candidatura partecipazione a III Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Nov18-Gen19',NULL),
--(5,'Candidatura corso FullStackWeb+Java 04 Milano','MICEACFS04','Candidatura partecipazione a IV Centauri Academy sede di Milano, corso Full Stack Web Development Java+Frontend, Periodo Mar19-Mag19',NULL),
--(6,'Candidatura corso FullStackWeb+Java 05 Milano','MICEACFS05','Corso FullStack Java 05 - Milano',NULL),
--(9,'Corso Fullstack java developer Roma-Milano 01','FSRMMI01','https://proximainformatica.com/',NULL);

insert into POSITIONUSEROWNER (id, course_page_id, user_id) VALUES 
(1, 1, 2),
(2, 2, 2);