CREATE TABLE IF NOT EXISTS Todo(
    id INTEGER AUTO_INCREMENT,
    task TEXT NOT NULL,
    is_complete BOOLEAN DEFAULT 0,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Comment(
    id INTEGER AUTO_INCREMENT,
    todo_id INTEGER NOT NULL,
    comment TEXT NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (todo_id) REFERENCES Todo(id)
);