CREATE TABLE users(


  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)

  ENGINE = InnoDB;




CREATE TABLE roles(


  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL

)

  ENGINE = InnoDB;


CREATE TABLE user_roles(

  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY (role_id) REFERENCES roles(id),


  UNIQUE(user_id, role_id)
)

  ENGINE = InnoDB;


INSERT INTO roles VALUES(1, 'ROLE_USER');
INSERT into roles VALUES(2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES(1,2);