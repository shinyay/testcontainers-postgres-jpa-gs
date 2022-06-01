CREATE TABLE books
(
    id SERIAL NOT NULL,
    title varchar(255) NOT NULL,
    author  varchar(20)  NOT NULL,
    publication_year integer NOT NULL,
    PRIMARY KEY (id)
);
