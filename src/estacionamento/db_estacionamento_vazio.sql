Create database if not exists db_estacionamento;
use db_estacionamento;

create table if not exists tbl_usuarios (
  login varchar(30),
  nome varchar(30) not null,
  cargo varchar(50) not null,
  email varchar(50) not null,
  telefone varchar(20) not null,
  senha varchar(10) not null,
  primary key (login)
);

select * from tbl_usuarios;

create table if not exists tbl_proprietarios(
cod int,
nome varchar(30) not null,
email varchar(50) not null,
telefone varchar(11) not null,
primary key (cod)
);

select * from tbl_proprietarios;

create table if not exists tbl_veiculos(
placa varchar (7),
marca varchar (30),
modelo varchar (50),
cor varchar (10),
proprietario int,
primary key (placa),
foreign key (proprietario) REFERENCES tbl_proprietarios(cod)
);

select * from tbl_veiculos;

create table if not exists tbl_tarifas(
cod int,
primeira double not null,
demais double not null,
diaria double not null,
mensalidade double,
primary key (cod)
);

select * from tbl_tarifas;

create table if not exists tbl_registros(
cod int,
placa varchar (7),
entrada datetime,
saida datetime,
tarifa int,
valor double,
usuario varchar(30),
primary key (cod),
foreign key (tarifa) REFERENCES tbl_tarifas(cod),
foreign key (usuario) REFERENCES tbl_usuarios(login)
);

select * from tbl_registros;


