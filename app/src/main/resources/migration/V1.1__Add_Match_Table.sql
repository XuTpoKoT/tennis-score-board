CREATE TABLE IF NOT EXISTS public.Match (
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid()
    , player_1 integer NOT NULL REFERENCES public.Player(id) ON DELETE CASCADE
    , player_2 integer NOT NULL REFERENCES public.Player(id) ON DELETE CASCADE
    , winner   integer NOT NULL REFERENCES public.Player(id) ON DELETE CASCADE
);