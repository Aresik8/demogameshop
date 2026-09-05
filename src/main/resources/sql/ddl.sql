CREATE TABLE IF NOT EXISTS genres
(
    id   INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL UNIQUE CHECK (name <> '')
);

CREATE TABLE IF NOT EXISTS users
(
    id       INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username TEXT NOT NULL UNIQUE CHECK (username <> ''),
    email    TEXT NOT NULL UNIQUE CHECK (email ~ '^[^@]+@[^@]+\.[^@]+$'),
    password TEXT NOT NULL CHECK (password <> '')
);

CREATE TABLE IF NOT EXISTS game
(
    id                  INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name                TEXT NOT NULL UNIQUE CHECK (name <> ''),
    price               FLOAT CHECK (price >= 0),
    developer           TEXT NOT NULL,
    release_date        DATE NOT NULL DEFAULT CURRENT_DATE,
    player_quantity     TEXT,
    description         TEXT,
    system_requirements TEXT
);

CREATE TABLE IF NOT EXISTS review
(
    id          INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    game_id     INT  NOT NULL REFERENCES game (id),
    user_id     INT  NOT NULL REFERENCES users (id),
    is_positive BOOL NOT NULL DEFAULT TRUE,
    created_at  DATE NOT NULL DEFAULT CURRENT_DATE,
    comment     TEXT,
    UNIQUE (user_id, game_id)
);

CREATE TABLE IF NOT EXISTS game_genre
(
    game_id  INT NOT NULL REFERENCES game (id),
    genre_id INT NOT NULL REFERENCES genres (id),
    UNIQUE (game_id, genre_id)
);