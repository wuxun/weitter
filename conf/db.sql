CREATE TABLE user (
       id BIGINT(64) NOT NULL AUTO_INCREMENT,
       name VARCHAR(255) NOT NULL,
       password VARCHAR(64) NOT NULL,
       PRIMARY KEY (id)
       );

CREATE TABLE followers (
       id BIGINT(64) NOT NULL AUTO_INCREMENT,
       user_id BIGINT(64) NOT NULL,
       followers_id BIGINT(64),
       PRIMARY KEY (id)
       );

CREATE TABLE following (
       id BIGINT(64) NOT NULL AUTO_INCREMENT,
       user_id BIGINT(64) NOT NULL,
       follow_id BIGINT(64),
       PRIMARY KEY (id)
       );

CREATE TABLE message (
       id BIGINT(64) NOT NULL AUTO_INCREMENT,
       user_id BIGINT(64) NOT NULL,
       timestamp timestamp NOT NULL,
       content varchar(255) NOT NULL,
       ref_msg_id BIGINT(64),
       image varchar(255),
       video varchar(255),
       PRIMARY KEY (id)
       );

CREATE TABLE activity (
       id BIGINT(64) NOT NULL AUTO_INCREMENT,
       user_id BIGINT(64),
       activity_type TINYINT,
       timestamp INT,
       PRIMARY KEY (id)
       );
