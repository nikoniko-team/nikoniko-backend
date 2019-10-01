SET client_encoding = 'UTF8';
SET TIME ZONE 'America/Sao_Paulo';

-- INSERT INTO public."user"(
--     id, name, email, password, role)
-- VALUES (?, ?, ?, ?, ?);

-- UPDATE public."user"
-- SET id=?, name=?, email=?, password=?, role=?
-- WHERE <condition>;

-- DELETE FROM public."user"
-- WHERE <condition>;

INSERT INTO public."user"(id, name, email, password, role)
VALUES (nextval('public.user_seq'),
        'admin',
        'admin@nikoniko.com.br',
        '$2a$06$xIvBeNRfS65L1N17I7JzgefzxEuLAL0Xk0wFAgIkoNqu9WD6rmp4m',
        'ROLE_ADMIN');


-- INSERT INTO public.mood(id, name, url)
-- VALUES (?, ?, ?);

-- UPDATE public.mood
-- SET id=?,
--     name=?,
--     url=?
-- WHERE <condition>;

-- DELETE
-- FROM public.mood
-- WHERE <condition>;

--Atualizar currentValue das Sequences.
--mood=12
--SELECT setval('mood_seq', 12);
