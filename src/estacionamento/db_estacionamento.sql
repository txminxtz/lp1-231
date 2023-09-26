Create database if not exists db_estacionamento;
use db_estacionamento;

create table if not exists tbl_usuarios (
  cod int auto_increment,
  nome varchar(30) not null,
  cargo varchar(50) not null,
  email varchar(50) not null,
  telefone varchar(11) not null,
  senha varchar(10) not null,
  primary key (cod)
);

-- insert
insert into tbl_usuarios values (null, 'Joao', 'operador de entrada', 'joao@gmail.com', '11955563518', 'joao123');
insert into tbl_usuarios values (null, 'Pedro', 'operador de saida', 'pedror@gmail.com', '11998563292','1602');
insert into tbl_usuarios values (null, 'Maria', 'contador', 'mariaclara@gmail.com', '11924567426','mc2002');

select * from tbl_usuarios;

create table if not exists tbl_valores(
cod int auto_increment,
primeira double not null,
demais double not null,
diaria double not null,
mensalidade double,
primary key (cod)
);

insert into tbl_valores(cod, primeira, demais, diaria, mensalidade) values (null, '10.00', '5.00', '20.00', '100.00');

select * from tbl_valores;

create table if not exists tbl_veiculos(
placa varchar (7),
marca varchar (30),
modelo varchar (50),
cor varchar (10),
primary key (placa)
);

insert into tbl_veiculos(placa, marca, modelo, cor) values ('GBQ9512', 'honda', 'civic', 'branco');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('GIU9215', 'chevrolet', 'onix', 'preto');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('WRT6582', 'fiat', 'palio', 'vermelho');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('HYU5236', 'hyundai', 'creta', 'prata');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('BJU7289', 'fiat', 'mob', 'prata');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('AWD8742', 'honda', 'hrv', 'branco');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('HIN9802', 'bmw', 'i8', 'branco');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('HUB8793', 'honda', 'civic', 'prata');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('BJA7289', 'nissan', 'kicks', 'branco');
insert into tbl_veiculos(placa, marca, modelo, cor) values ('ATD8742', 'toyota', 'corolla', 'prata');

select * from tbl_veiculos;

create table if not exists tbl_registros(
cod int auto_increment,
data date,
usuario int not null,
placa varchar (7),
mensalista varchar (1),
entrada time,
saida time,
valor double,
primary key (cod),
foreign key (usuario) references tbl_usuarios (cod)
);

insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-10', 1, 'GBQ9512', 'N', '09:32:17', '11:30:27', '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-12', 1, 'GIU9215', 'N', '13:14:47', null, '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-12', 2, 'WRT6582', 'N', '07:27:48', null, '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-11', 3, 'HYU5236', 'N', '22:10:23', null, '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-11', 3, 'BJU7289', 'N', '21:02:57', '22:14:31', '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-09', 1, 'AWD8742', 'N', '08:56:48', '12:44:52', '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-12', 2, 'HIN9802', 'N', '10:56:21', null, '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-12', 3, 'HUB8793', 'N', '22:10:23', null, '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-11', 3, 'BJU7289', 'N', '21:02:57', '22:14:31', '0.0');
insert into tbl_registros(cod, data, usuario, placa, mensalista, entrada, saida, valor) values (null, '2023-09-09', 1, 'AWD8742', 'N', '08:56:48', '12:44:52', '0.0');

select * from tbl_registros;

create table if not exists tbl_proprietarios(
cod int auto_increment,
nome varchar(30) not null,
endereco varchar(50) not null,
email varchar(50) not null,
telefone varchar(11) not null,
primary key (cod)
);

insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'thiago', 'rua sao paulo ', 'thiago@gmail.com', '11980766543');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'marcelo', 'rua sao pedro ', 'marcelo@gmail.com', '11967578653');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'julia', 'rua sete de setembro ', 'julia@gmail.com', '11932469121');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'lais', 'rua amazonas ', 'lais@gmail.com', '11965740708');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'leonardo', 'rua parana ', 'leonardo@gmail.com', '11925986099');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'gabriel', 'rua bela vista ', 'gabriel@gmail.com', '11993406995');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'maria', 'rua castro alves ', 'maria@gmail.com', '11986574532');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'ana', 'rua duque de caxias ', 'ana@gmail.com', '11913549467');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'enzo', 'rua minas gerais ', 'enzo@gmail.com', '11909853193');
insert into tbl_proprietarios(cod, nome, endereco, email, telefone) values (null, 'benjamin', 'rua santos dumont ', 'benjamin@gmail.com', '11953678975');

select * from tbl_proprietarios;
