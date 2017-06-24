DROP TABLE IF EXISTS x_fellow;
CREATE TABLE x_fellow (
	id INTEGER NOT NULL,
	name VARCHAR(128) NULL COLLATE NOCASE,
	password VARCHAR(128) NULL,
	email VARCHAR(128) NULL COLLATE NOCASE,
	rtime DATETIME NULL,
	status VARCHAR(255) NULL,
	memo VARCHAR(255) NULL,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS x_comment;
CREATE TABLE x_comment (
	id INTEGER NOT NULL,
	title VARCHAR(128) NULL,
	author VARCHAR(128) NULL,
	content TEXT NOT NULL,
	ctime DATETIME NULL,
	memo VARCHAR(255) NULL,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS x_article;
CREATE TABLE x_article (
	id INTEGER NOT NULL,
	title VARCHAR(128) NULL,
	author VARCHAR(128) NULL,
	content TEXT NOT NULL,
	ctime DATETIME NULL,
	parent_id INTEGER NOT NULL DEFAULT 0,
	memo VARCHAR(255) NULL,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS au_role;
CREATE TABLE au_role (
	id INTEGER NOT NULL,
	name VARCHAR(128) NULL,
	description TEXT NULL,
	create_time DATETIME NULL,
	parent_id INTEGER NOT NULL DEFAULT 0,
	memo VARCHAR(255) NULL,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS res_menu;
CREATE TABLE res_menu (
	id INTEGER NOT NULL,
	name VARCHAR(128) NULL,
	path VARCHAR(128) NULL,
	description TEXT NULL,
	create_time DATETIME NULL,
	parent_id INTEGER NOT NULL DEFAULT 0,
	memo VARCHAR(255) NULL,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS rel_user_role;
CREATE TABLE rel_user_role (
	id INTEGER NOT NULL,
	user_id INTEGER NULL,
	role_id INTEGER NULL,
	create_time DATETIME NULL,
	parent_id INTEGER NOT NULL DEFAULT 0,
	memo VARCHAR(255) NULL,
	PRIMARY KEY (id)
);

DROP VIEW IF EXISTS v_user;
CREATE VIEW v_user AS
    SELECT f.name AS username,
        password,
        1 AS enable,
        r.name AS role
    FROM x_fellow f,
        rel_user_role rel,
        au_role r
    WHERE f.id = rel.user_id
        AND r.id = rel.role_id;

INSERT INTO x_fellow(id, name) VALUES(1, 'leo'), (2, 'yui');
INSERT INTO au_role(id, name, create_time) VALUES (1, 'ROLE_USER', datetime('now', 'localtime'));