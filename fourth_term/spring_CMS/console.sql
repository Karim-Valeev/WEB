create table "user" (
    id serial primary key,
    login varchar unique not null ,
    email varchar  unique not null ,
    password varchar unique not null
);

create table website (
    id serial primary key,
    title varchar not null,
    html_file_src varchar not null,
    url varchar unique not null,
    creator int references "user"(id),
    parent_site varchar references website(url)
);

alter  table  website add column body varchar;

insert into "user"(login, email, password)
values
       ('admin',
        'admin@admins.com',
        '43dc6cec56fb974e5535b14198088a2de22e8e3933f4dd0c390651c033a55283');

