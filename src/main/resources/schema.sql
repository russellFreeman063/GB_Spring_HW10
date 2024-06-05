create table books (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    publication_year INT,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);