CREATE TABLE books
(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    author  varchar(20)  NOT NULL,
    publication_year  int NOT NULL,
    PRIMARY KEY (id)
);
