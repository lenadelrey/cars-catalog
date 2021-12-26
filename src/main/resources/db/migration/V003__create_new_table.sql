create table users
(
    user_id  bigserial    not null
        constraint users_pkey
            primary key,
    name     varchar(200) not null,
    email    varchar(254) not null,
    password varchar(300) not null,
    role     varchar(100) not null
);