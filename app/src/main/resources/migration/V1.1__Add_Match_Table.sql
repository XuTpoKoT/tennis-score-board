CREATE TABLE IF NOT EXISTS public.Match (
    id         serial PRIMARY KEY
    , player_1 text NULL REFERENCES public.Player(name) ON DELETE CASCADE
    , player_2 text NULL REFERENCES public.Player(name) ON DELETE CASCADE
    , winner   text NULL REFERENCES public.Player(name) ON DELETE CASCADE
);