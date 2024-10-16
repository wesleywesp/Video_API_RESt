create table videos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    descricao varchar(500) not null,
    url varchar(768) not null unique,
    ativo tinyint not null,

    primary key(id)

) charset=utf8mb4;