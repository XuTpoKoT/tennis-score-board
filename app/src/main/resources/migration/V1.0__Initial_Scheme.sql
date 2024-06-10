CREATE TABLE public.Player (
    id     serial PRIMARY KEY
    , name text   UNIQUE NOT NULL
);