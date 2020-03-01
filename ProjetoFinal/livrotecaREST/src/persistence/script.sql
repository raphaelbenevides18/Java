create database bdLivrotecaREST;

use bdLivrotecaREST;

create table livros (
idLivro int primary key auto_increment,
titulo varchar (70) not null unique,
autor varchar(70) not null,
categoria varchar(70),
descricao varchar(250),
numPaginas int,
imagem varchar (250)
);

create table usuarios(idUsuario int primary key auto_increment, 
nome varchar(50),
email varchar(50) unique,
senha varchar (250),
foto varchar (250)
);

insert into livros values(null,'harry potter e a pedra filisofal',
'J.K Rowling','Fantasia', 'garoto bruxo que só faz merda...',304, 'foto.jpg');

insert into usuarios values(null, 'alex', 'alexboladao@gmail.com', '123456', 'foto.jpg');