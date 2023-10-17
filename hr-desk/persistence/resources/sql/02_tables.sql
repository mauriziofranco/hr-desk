
drop table if exists positionuserowner;
drop table if exists interviewreplies;
drop table if exists surveyinterviews;
drop table if exists interviews; 
drop table if exists surveyquestions; --fabio
drop table if exists surveyreplies; --marcof
drop table if exists candidatesurveytokens ;
drop table if exists surveys;
drop table if exists questions;
drop table if exists candidates;
drop table if exists candidate_states;
drop table if exists coursepage;
drop table if exists users; 
drop table if exists roles; 

create table roles (
	id bigint NOT NULL AUTO_INCREMENT, 
	label VARCHAR(50),
	description VARCHAR(2000),
	level int,
	primary key(id),
	CONSTRAINT level UNIQUE (level)
);

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `regdate` datetime NOT NULL,
  `role` int(11) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqueEmail` (`email`),
  --KEY `role` (`role`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role`) REFERENCES `roles` (`level`)
);

CREATE TABLE `coursepage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000) NOT NULL,
  `code` varchar(100) NOT NULL,
  `body_text` mediumtext NOT NULL,
  `file_name` varchar(300) DEFAULT NULL,
  opened_by bigint(20),
  created_datetime datetime DEFAULT CURRENT_TIMESTAMP,
  status_open BOOLEAN NOT NULL default true,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  CONSTRAINT `openedBy_ibfk_1` FOREIGN KEY (`opened_by`) REFERENCES `users` (`id`)
);

CREATE TABLE `candidate_states` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `status_code` int(11) NOT NULL,
  `status_label` varchar(300) DEFAULT NULL,
  `status_description` varchar(1000) DEFAULT NULL,
  `status_color` varchar(7) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `status_code` (`status_code`),
  --KEY `role_id` (`role_id`),
  CONSTRAINT `candidate_states_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);

CREATE TABLE `candidates` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `domicile_city` varchar(100) DEFAULT NULL,
  `study_qualification` varchar(300) DEFAULT NULL,
  `graduate` tinyint(1) DEFAULT NULL,
  `high_graduate` tinyint(1) DEFAULT NULL,
  `still_high_study` tinyint(1) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `cv_external_path` varchar(1000) DEFAULT NULL,
  `course_code` varchar(100) NOT NULL,
  `candidacy_date_time` datetime NOT NULL,
  `label` varchar(200) DEFAULT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dateofbirth` date DEFAULT NULL,
  `regdate` datetime NOT NULL,
  `technical_note` varchar(2000) DEFAULT NULL,
  `hr_note` varchar(2000) DEFAULT NULL,
  `inserted_by` bigint(20) NOT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `candidate_state_code` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  --KEY `course_code` (`course_code`),
  --KEY `inserted_by` (`inserted_by`),
  --KEY `candidate_state_code` (`candidate_state_code`),
  CONSTRAINT `candidates_ibfk_2` FOREIGN KEY (`course_code`) REFERENCES `coursepage` (`code`),
  CONSTRAINT `candidates_ibfk_4` FOREIGN KEY (`inserted_by`) REFERENCES `users` (`id`),
  CONSTRAINT `candidates_ibfk_5` FOREIGN KEY (`candidate_state_code`) REFERENCES `candidate_states` (`status_code`)
);

create table questions (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    label varchar(500) not null,
    description varchar(3000),
    ansa VARCHAR(255),
	ansb VARCHAR(255),
	ansc VARCHAR(255),
	ansd VARCHAR(255),
	anse VARCHAR(255),
	ansf VARCHAR(255),
	ansg VARCHAR(255),
	ansh VARCHAR(255),
	cansa BIT,
	cansb BIT,
	cansc BIT,
	cansd BIT,
	canse BIT,
	cansf BIT,
	cansg BIT,
	cansh BIT,
	full_answer VARCHAR(3000)
);

create table surveys(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	label VARCHAR(50) NOT NULL,
	time bigint,
	description VARCHAR(2000)
);

create table surveyquestions (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    survey_id bigint not null,
    question_id bigint not null,
    position int,
    foreign key (survey_id) references surveys(id),
    foreign key (question_id) references questions(id),
    CONSTRAINT UC_SurveyQuestion UNIQUE (survey_id,question_id)
    
);

create table surveyreplies(
	id bigint(20) NOT NULL AUTO_INCREMENT,
	survey_id bigint not null,
	starttime datetime,
	endtime datetime,
	answers varchar(5000),
	pdffilename varchar(100),
	points varchar(50),
	candidate_id bigint(20) NOT NULL,
	generated_token varchar(50),
	foreign key(survey_id) references surveys(id),
	foreign key(candidate_id) references candidates(id)
);

create table candidatesurveytokens (
	id bigint(20) NOT NULL AUTO_INCREMENT, 
	candidate_id bigint not null,
	survey_id bigint not null,
	generated_token VARCHAR(50),
	expiration_date_time datetime,
	expired boolean DEFAULT false,
	primary key(id),
	CONSTRAINT uniqueToken UNIQUE (generated_token),
	foreign key (candidate_id) references candidates(id),
	foreign key (survey_id) references surveys(id)
);

create table positionuserowner (
    id bigint primary key auto_increment,
    course_page_id bigint not null,
    user_id bigint not null,    
    foreign key (course_page_id) references coursepage(id),
    foreign key (user_id) references users(id)    
);