CREATE DATABASE IF NOT EXISTS gamer_demo;
USE gamer_demo;

DROP TABLE IF EXISTS gamer;
CREATE Table gamer(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32) UNIQUE KEY NOT NULL,
    geography VARCHAR(64) DEFAULT 'unknown',
    INDEX (geography)
);

DROP TABLE IF EXISTS game;
CREATE Table game(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(64) UNIQUE NOT NULL
);

DROP TABLE IF EXISTS gg_link;
CREATE Table gg_link(
    userID BIGINT NOT NULL,
    gameID BIGINT NOT NULL,
    level VARCHAR(32) DEFAULT 'N00B',
    PRIMARY KEY (userID, gameID),
    FOREIGN KEY (userID) REFERENCES gamer(id),
    FOREIGN KEY (gameID) REFERENCES game(id)
);

INSERT INTO gamer VALUES (1, 'Alice', 'Beijing');
INSERT INTO game VALUES(1, 'gta5');
INSERT INTO gg_link VALUES(1, 1, 'PRO');