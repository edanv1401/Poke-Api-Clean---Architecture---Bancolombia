CREATE SCHEMA IF NOT EXISTS PokeApi;

CREATE
    TABLE pokemons
(
    id   INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url  VARCHAR(255) NOT NULL
);

INSERT INTO pokemons (id, name, url)
VALUES (1, 'bulbasaur', 'https://pokeapi.co/api/v2/pokemon/1/'),
       (2, 'ivysaur', 'https://pokeapi.co/api/v2/pokemon/2');
