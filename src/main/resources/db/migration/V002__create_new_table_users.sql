create table users
(
    user_id  bigserial    not null
        constraint users_pkey
            primary key,
    name     varchar(200) not null,
    email    varchar(254) not null UNIQUE,
    password varchar(300) not null,
    role_id  bigserial    not null,
    constraint fk_role_id foreign key (role_id) references roles (role_id)
);