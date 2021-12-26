create table cars
(
    car_id      bigserial    not null
        constraint cars_pkey
            primary key,
    user_id     bigserial,
    model       varchar(50)  not null,
    description varchar(300) not null,
    price       float        not null,
    year        int,
    constraint fk_user foreign key (user_id) references users (user_id)
);