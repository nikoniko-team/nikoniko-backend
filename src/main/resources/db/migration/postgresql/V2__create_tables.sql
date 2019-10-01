SET client_encoding = 'UTF8';
SET TIME ZONE 'America/Sao_Paulo';

-- user
-- Cria sequence mood_seq
CREATE SEQUENCE public.user_seq;
ALTER SEQUENCE public.user_seq
    OWNER to niko_db_user;

-- Cria tabela user
CREATE TABLE public."user"
(
    id       bigint                 NOT NULL,
    name     character varying(255) NOT NULL,
    email    character varying(255),
    password character varying(255),
    role     character varying(255),
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

ALTER TABLE public."user"
    OWNER to niko_db_user;


-- mood
-- Cria sequence mood_seq
CREATE SEQUENCE public.mood_seq;
ALTER SEQUENCE public.mood_seq
    OWNER to niko_db_user;

-- Cria tabela mood
CREATE TABLE public.mood
(
    id   bigint                 NOT NULL,
    name character varying(255) NOT NULL,
    url  character varying(255),
    CONSTRAINT mood_pkey PRIMARY KEY (id)
);

ALTER TABLE public.mood
    OWNER to niko_db_user;


