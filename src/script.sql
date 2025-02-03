-- Création de la table 'author'
CREATE TABLE author (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(100) UNIQUE
);

-- Création de la table 'book'
CREATE TABLE book (
                      id SERIAL PRIMARY KEY,          -- Identifiant unique pour chaque livre
                      title VARCHAR(150) NOT NULL,    -- Titre du livre
                      published_date DATE,            -- Date de publication
                      author_id INT,                  -- Identifiant de l'auteur
                      FOREIGN KEY (author_id) REFERENCES author(id) -- Clé étrangère reliant à 'author'
);
-- Insérer les auteurs
INSERT INTO author (name, email) VALUES
                                     ('J.K. Rowling', 'jk.rowling@example.com'),
                                     ('George R.R. Martin', 'grrm@example.com'),
                                     ('J.R.R. Tolkien', 'jrr.tolkien@example.com'),
                                     ('Agatha Christie', 'agatha.christie@example.com'),
                                     ('Stephen King', 'stephen.king@example.com');

-- Insérer les livres en récupérant les bons IDs
INSERT INTO book (title, published_date, author_id) VALUES
                                                        ('Harry Potter and the Sorcerer''s Stone', '1997-06-26', (SELECT id FROM author WHERE name = 'J.K. Rowling')),
                                                        ('A Game of Thrones', '1996-08-06', (SELECT id FROM author WHERE name = 'George R.R. Martin')),
                                                        ('The Hobbit', '1937-09-21', (SELECT id FROM author WHERE name = 'J.R.R. Tolkien')),
                                                        ('Murder on the Orient Express', '1934-01-01', (SELECT id FROM author WHERE name = 'Agatha Christie')),
                                                        ('The Shining', '1977-01-28', (SELECT id FROM author WHERE name = 'Stephen King')),
                                                        ('Harry Potter and the Chamber of Secrets', '1998-07-02', (SELECT id FROM author WHERE name = 'J.K. Rowling')),
                                                        ('A Clash of Kings', '1998-11-16', (SELECT id FROM author WHERE name = 'George R.R. Martin')),
                                                        ('The Lord of the Rings', '1954-07-29', (SELECT id FROM author WHERE name = 'J.R.R. Tolkien')),
                                                        ('And Then There Were None', '1939-11-06', (SELECT id FROM author WHERE name = 'Agatha Christie')),
                                                        ('It', '1986-09-15', (SELECT id FROM author WHERE name = 'Stephen King'));
