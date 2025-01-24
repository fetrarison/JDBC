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
