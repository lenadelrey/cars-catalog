create table users
(
    id       bigserial    not null
        constraint users_pkey
            primary key,
    name     varchar(200) not null,
    email    varchar(254) not null,
    password varchar(300) not null
);