CREATE TABLE transaction
(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    sender INTEGER NOT NULL,
    receiver INTEGER NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    date TIMESTAMP NOT NULL,
    CONSTRAINT fk_sender_id FOREIGN KEY (sender) REFERENCES client(id),
    CONSTRAINT fk_receiver_id FOREIGN KEY (receiver) REFERENCES client(id)
);