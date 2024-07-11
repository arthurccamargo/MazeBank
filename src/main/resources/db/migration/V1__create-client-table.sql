CREATE TABLE client
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    cpf      VARCHAR(11)  NOT NULL,
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone    VARCHAR(11)  NOT NULL
);