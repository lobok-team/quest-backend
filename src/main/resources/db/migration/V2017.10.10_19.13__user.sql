CREATE TABLE public.user_
(
  id            BIGSERIAL PRIMARY KEY,
  login         VARCHAR(255) NOT NULL,
  email         VARCHAR(255) NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  user_role     VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX user__login_uindex
  ON public.user_ (login);
CREATE UNIQUE INDEX user__email_uindex
  ON public.user_ (email);

INSERT INTO public.user_ (id, login, email, password_hash, user_role)
VALUES (1, 'test', 'test@test.ru', '$2a$10$hkRjlBol3ClFMsl9t9Telu6KK52Fn6.Zs7e0wL4cylP9QOauFVks.', 'ADMIN');
