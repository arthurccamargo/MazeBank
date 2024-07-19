CREATE TABLE checkingAccount (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    account_number VARCHAR(11) NOT NULL,
    balance DOUBLE,
    transaction_limit INTEGER,
    client_id INTEGER NOT NULL ,
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES client(id)
);