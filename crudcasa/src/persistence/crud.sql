create database crud;
use crud;

create table cliente(
id int primary key auto_increment not null,
nome varchar(50),
cpf varchar(15) not null unique
);

insert into cliente values(null,'Roberto','152.754.574-75');
insert into cliente values(null,'raphael','145.752.527-15');
insert into cliente values(null,'lu','347.002.156-03');
insert into cliente values(null,'belem','123.321.654-00');