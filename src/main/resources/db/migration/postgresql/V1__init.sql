SET client_encoding = 'UTF8';
SET TIME ZONE 'America/Sao_Paulo';

-- Cria usuario de banco niko_db_user.
-- CREATE ROLE niko_db_user WITH
--     LOGIN
--     SUPERUSER
--     CREATEDB
--     CREATEROLE
--     INHERIT
--     NOREPLICATION
--     CONNECTION LIMIT -1
--     PASSWORD 'niko12345';

-- Cria DataBase nikoniko.
-- CREATE DATABASE nikoniko
--     WITH
--     OWNER = niko_db_user
--     TEMPLATE = template0
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'en_US.UTF-8'
--     LC_CTYPE = 'en_US.UTF-8'
--     CONNECTION LIMIT = -1;


--Cria e ativa extensao para remover acentos.
CREATE EXTENSION IF NOT EXISTS unaccent;
