DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ROLES;
DROP TABLE IF EXISTS USER_ROLE;

CREATE TABLE USERS (
  id INTEGER PRIMARY KEY NOT NULL,
  username varchar(50) NOT NULL,
  isActive boolean default 1
);

CREATE TABLE ROLES (
  id INTEGER PRIMARY KEY NOT NULL,
  name varchar(50) NOT NULL,
  isActive boolean default 1
);

CREATE TABLE USER_ROLE (
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  PRIMARY KEY (user_id, role_id), 
    FOREIGN KEY (user_id) REFERENCES USERS(id), 
    FOREIGN KEY (role_id) REFERENCES ROLES(id)
);