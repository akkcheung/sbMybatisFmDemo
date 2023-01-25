DROP TABLE IF EXISTS TEACHERS;
DROP TABLE IF EXISTS PUPILS;

CREATE TABLE TEACHERS (
  id    INTEGER PRIMARY KEY NOT NULL,
  name varchar(255) not null
);

CREATE TABLE PUPILS (
  id    INTEGER PRIMARY KEY NOT NULL,
  name varchar(255) not null,
  teacher_id INTEGER NOT NULL,
  FOREIGN KEY (teacher_id) 
  	references TEACHERS(id)
);