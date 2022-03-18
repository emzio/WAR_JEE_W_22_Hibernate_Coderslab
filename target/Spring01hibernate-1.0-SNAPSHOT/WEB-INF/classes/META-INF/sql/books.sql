use bookstore;

INSERT INTO bookstore.publishers (name) VALUES ('Wydawca');
INSERT INTO bookstore.publishers (name) VALUES ('PWN');
INSERT INTO bookstore.publishers (name) VALUES ('ZYSKiSka');

INSERT INTO bookstore.books (description, rating, title, publisher_id) VALUES ('desc1', 6, 'title1', 2);
INSERT INTO bookstore.books (description, rating, title, publisher_id) VALUES ('desc2', 5, 'title2', 1);
INSERT INTO bookstore.books (description, rating, title, publisher_id) VALUES ('desc3', 3, 'title3', 3);
INSERT INTO bookstore.books (description, rating, title, publisher_id) VALUES ('desc4', 4, 'title4', 3);
INSERT INTO bookstore.books (description, rating, title, publisher_id) VALUES ('desc5', 2, 'title5', 1);
INSERT INTO bookstore.books (description, rating, title, publisher_id) VALUES ('desc6', 6, 'title6', 2);
INSERT INTO bookstore.books (description, rating, title, publisher_id) VALUES ('desc7', 1, 'title7', 1);

INSERT INTO bookstore.authors (firstName, lastName) VALUES ('first author', 'first');
INSERT INTO bookstore.authors (firstName, lastName) VALUES ('drugi', 'second');
INSERT INTO bookstore.authors (firstName, lastName) VALUES ('Karol ', 'May');
INSERT INTO bookstore.authors (firstName, lastName) VALUES ('Anne ', 'Proloux');

INSERT INTO bookstore.books_authors (Book_id, authors_id) VALUES (1, 2);
INSERT INTO bookstore.books_authors (Book_id, authors_id) VALUES (1, 1);
INSERT INTO bookstore.books_authors (Book_id, authors_id) VALUES (2, 2);
INSERT INTO bookstore.books_authors (Book_id, authors_id) VALUES (4, 4);
INSERT INTO bookstore.books_authors (Book_id, authors_id) VALUES (3, 3);
INSERT INTO bookstore.books_authors (Book_id, authors_id) VALUES (5, 4);