create table users_roles
(
    user_id bigserial NOT NULL,
    role_id bigserial NOT NULL,
    constraint fk_user_id foreign key (user_id) references users (user_id),
    constraint fk_role_id foreign key (role_id) references roles (role_id)
);