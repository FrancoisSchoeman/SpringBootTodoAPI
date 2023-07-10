CREATE TABLE IF NOT EXISTS Todo(
    id INTEGER AUTO_INCREMENT,
    task TEXT NOT NULL,
    is_complete BOOLEAN DEFAULT 0,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    PRIMARY KEY (id)
);