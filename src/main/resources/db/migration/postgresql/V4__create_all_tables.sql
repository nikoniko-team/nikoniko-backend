SET client_encoding = 'UTF8';
SET TIME ZONE 'America/Sao_Paulo';

-- user
-- Cria sequence team_seq
CREATE SEQUENCE public.team_seq;
--ALTER SEQUENCE public.team_seq
--    OWNER to niko_db_user;

-- Cria tabela team
CREATE TABLE public."team"
(
    id       bigint                 NOT NULL,
    name     character varying(255) NOT NULL,
    CONSTRAINT team_pkey PRIMARY KEY (id)
);

-- user
-- Cria sequence team_user_seq
CREATE SEQUENCE public.team_user_seq;
--ALTER SEQUENCE public.team_user_seq
--    OWNER to niko_db_user;

-- Cria tabela team_user
CREATE TABLE public."team_user"
(
    id       bigint                 NOT NULL,
    user_id  bigint NOT NULL references public."user" (id),
    team_id  bigint NOT NULL references team (id),
    role     character varying(255) NOT NULL,
    CONSTRAINT team_user_pkey PRIMARY KEY (id)
);

-- user
-- Cria sequence record_seq
CREATE SEQUENCE public.record_seq;
--ALTER SEQUENCE public.record_seq
--    OWNER to niko_db_user;

-- Cria tabela record
CREATE TABLE public."record"
(
    id       bigint                 NOT NULL,
    team_user_id  bigint NOT NULL references team_user (id),
    mood_id  bigint NOT NULL references mood (id),
    date     TIMESTAMPTZ NOT NULL,
    CONSTRAINT record_pkey PRIMARY KEY (id)
);

-- user
-- Cria sequence tag_seq
CREATE SEQUENCE public.tag_seq;
--ALTER SEQUENCE public.tag_seq
--    OWNER to niko_db_user;

-- Cria tabela tag
CREATE TABLE public."tag"
(
    id       bigint                 NOT NULL,
    name     character varying(255) NOT NULL,
    CONSTRAINT tag_pkey PRIMARY KEY (id)
);

-- user
-- Cria sequence record_tag_seq
CREATE SEQUENCE public.record_tag_seq;
--ALTER SEQUENCE public.record_tag_seq
--    OWNER to niko_db_user;

-- Cria tabela record_tag
CREATE TABLE public."record_tag"
(
    id       bigint                 NOT NULL,
    record_id  bigint NOT NULL references record (id),
    tag_id  bigint NOT NULL references tag (id),
    comment text,
    CONSTRAINT record_tag_pkey PRIMARY KEY (id)
);

