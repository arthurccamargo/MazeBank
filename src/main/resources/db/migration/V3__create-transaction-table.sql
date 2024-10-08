CREATE TABLE transaction
(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    sender_id INTEGER NOT NULL,
    receiver_id INTEGER NOT NULL,
    sender_account_id INTEGER NOT NULL,
    receiver_account_id INTEGER NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    date TIMESTAMP NOT NULL,
    CONSTRAINT fk_sender_id FOREIGN KEY (sender_id) REFERENCES client(id),
    CONSTRAINT fk_receiver_id FOREIGN KEY (receiver_id) REFERENCES client(id),
    CONSTRAINT fk_sender_account_id FOREIGN KEY (sender_account_id) REFERENCES checkingAccount(id),
    CONSTRAINT fk_receiver_account_id FOREIGN KEY (receiver_account_id) REFERENCES checkingAccount(id)
);