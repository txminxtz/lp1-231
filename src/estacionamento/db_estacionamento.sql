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

insert into tbl_usuarios values ('joao.silva', 'Joao da Silva', 'operador de entrada', 'joao@gmail.com', '11955563518', 'joao123');
insert into tbl_usuarios values ('pedror', 'Pedro Ribeiro', 'operador de saida', 'pedror@gmail.com', '11998563292','1602');
insert into tbl_usuarios values ('mariaclara', 'Maria Clara', 'contador', 'mariaclara@gmail.com', '11924567426','mc2002');

select * from tbl_usuarios;

create table if not exists tbl_proprietarios(
cod int,
nome varchar(30) not null,
email varchar(50) not null,
telefone varchar(11) not null,
primary key (cod)
);

insert into tbl_proprietarios(cod, nome, email, telefone) values (1, 'thiago', 'thiago@gmail.com', '11980766543');
insert into tbl_proprietarios(cod, nome, email, telefone) values (2, 'marcelo', 'marcelo@gmail.com', '11967578653');
insert into tbl_proprietarios(cod, nome, email, telefone) values (3, 'julia',  'julia@gmail.com', '11932469121');
insert into tbl_proprietarios(cod, nome, email, telefone) values (4, 'lais',  'lais@gmail.com', '11965740708');
insert into tbl_proprietarios(cod, nome, email, telefone) values (5, 'gabriel', 'gabriel@gmail.com', '11993406995');
insert into tbl_proprietarios(cod, nome, email, telefone) values (6, 'ana',  'ana@gmail.com', '11913549467');
insert into tbl_proprietarios(cod, nome, email, telefone) values (7, 'enzo',  'enzo@gmail.com', '11909853193');
insert into tbl_proprietarios(cod, nome, email, telefone) values (8, 'benjamin',  'benjamin@gmail.com', '11953678975');

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

insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('GBQ9512', 'honda', 'civic', 'branco', 1);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('GIU9215', 'chevrolet', 'onix', 'preto', 2);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('WRT6582', 'fiat', 'palio', 'vermelho', 3);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('HYU5236', 'hyundai', 'creta', 'prata', 1);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('BJU7289', 'fiat', 'mob', 'prata', 3);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('AWD8742', 'honda', 'hrv', 'branco', 1);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('HIN9802', 'bmw', 'i8', 'branco', 2);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('HUB8793', 'honda', 'civic', 'prata', 2);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('BJA7289', 'nissan', 'kicks', 'branco', 1);
insert into tbl_veiculos(placa, marca, modelo, cor, proprietario) values ('ATD8742', 'toyota', 'corolla', 'prata', 3);

select * from tbl_veiculos;

create table if not exists tbl_tarifas(
cod int,
primeira double not null,
demais double not null,
diaria double not null,
mensalidade double,
primary key (cod)
);

insert into tbl_tarifas(cod, primeira, demais, diaria, mensalidade) values (1, '10.00', '5.00', '20.00', '100.00');

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

insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (1, 'GBQ9512', '2023-09-10 09:32:17', '2023-09-10 10:32:17', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (2, 'HUI3049', '2023-09-11 10:14:09', '2023-09-11 11:14:09', 1, '10', 'mariaclara');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (3, 'KIO3289', '2023-09-12 08:54:34', '2023-09-12 09:54:34', 1, '10', 'pedror');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (10, 'GBQ9510', '2023-09-10 09:10:00', '2023-09-10 10:10:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (11, 'GBQ9511', '2023-09-11 09:11:00', '2023-09-11 10:11:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (12, 'GBQ9512', '2023-09-12 09:12:00', '2023-09-12 10:12:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (13, 'GBQ9513', '2023-09-13 09:13:00', '2023-09-13 10:13:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (14, 'GBQ9514', '2023-09-14 09:14:00', '2023-09-14 10:14:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (15, 'GBQ9515', '2023-09-15 09:15:00', '2023-09-15 10:15:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (16, 'GBQ9516', '2023-09-16 09:16:00', '2023-09-16 10:16:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (17, 'GBQ9517', '2023-09-17 09:17:00', '2023-09-17 10:17:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (18, 'GBQ9518', '2023-09-18 09:18:00', '2023-09-18 10:18:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (19, 'GBQ9519', '2023-09-19 09:19:00', '2023-09-19 10:19:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (20, 'GBQ9520', '2023-09-20 09:20:00', '2023-09-20 10:20:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (21, 'GBQ9521', '2023-09-21 09:21:00', '2023-09-21 10:21:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (22, 'GBQ9522', '2023-09-22 09:22:00', '2023-09-22 10:22:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (23, 'GBQ9523', '2023-09-23 09:23:00', '2023-09-23 10:23:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (24, 'GBQ9524', '2023-09-24 09:24:00', '2023-09-24 10:24:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (25, 'GBQ9525', '2023-09-25 09:25:00', '2023-09-25 10:25:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (26, 'GBQ9526', '2023-09-26 09:26:00', '2023-09-26 10:26:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (27, 'GBQ9527', '2023-09-27 09:27:00', '2023-09-27 10:27:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (28, 'GBQ9528', '2023-09-28 09:28:00', '2023-09-28 10:28:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (29, 'GBQ9529', '2023-09-29 09:29:00', '2023-09-29 10:29:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (30, 'GBQ9530', '2023-09-30 09:30:00', '2023-09-30 10:30:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (31, 'GBQ9531', '2023-10-01 09:31:00', '2023-10-01 10:31:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (32, 'GBQ9532', '2023-10-02 09:32:00', '2023-10-02 10:32:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (33, 'GBQ9533', '2023-10-03 09:33:00', '2023-10-03 10:33:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (34, 'GBQ9534', '2023-10-04 09:34:00', '2023-10-04 10:34:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (35, 'GBQ9535', '2023-10-05 09:35:00', '2023-10-05 10:35:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (36, 'GBQ9536', '2023-10-06 09:36:00', '2023-10-06 10:36:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (37, 'GBQ9537', '2023-10-07 09:37:00', '2023-10-07 10:37:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (38, 'GBQ9538', '2023-10-08 09:38:00', '2023-10-08 10:38:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (39, 'GBQ9539', '2023-10-09 09:39:00', '2023-10-09 10:39:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (40, 'GBQ9540', '2023-10-10 09:40:00', '2023-10-10 10:40:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (41, 'GBQ9541', '2023-10-11 09:41:00', '2023-10-11 10:41:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (42, 'GBQ9542', '2023-10-12 09:42:00', '2023-10-12 10:42:00', 1, '10', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (43, 'GBQ9543', '2023-10-13 09:43:00', '2023-10-13 10:43:00', 1, '10', 'joao.silva');

insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (44, 'GBQ9544', '2023-10-14 09:44:00', '2023-10-14 09:44:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (45, 'GBQ9545', '2023-10-14 09:45:00', '2023-10-14 09:45:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (46, 'GBQ9546', '2023-10-14 09:46:00', '2023-10-14 09:46:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (47, 'GBQ9547', '2023-10-14 09:47:00', '2023-10-14 09:47:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (48, 'GBQ9548', '2023-10-14 09:48:00', '2023-10-14 09:48:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (49, 'GBQ9549', '2023-10-14 09:49:00', '2023-10-14 09:49:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (50, 'GBQ9550', '2023-10-14 09:50:00', '2023-10-14 09:50:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (51, 'GBQ9551', '2023-10-14 09:51:00', '2023-10-14 09:51:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (52, 'GBQ9552', '2023-10-14 09:52:00', '2023-10-14 09:52:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (53, 'GBQ9553', '2023-10-14 09:53:00', '2023-10-14 09:53:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (54, 'GBQ9554', '2023-10-14 09:54:00', '2023-10-14 09:54:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (55, 'GBQ9555', '2023-10-14 09:55:00', '2023-10-14 09:55:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (56, 'GBQ9556', '2023-10-14 09:56:00', '2023-10-14 09:56:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (57, 'GBQ9557', '2023-10-14 09:57:00', '2023-10-14 09:57:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (58, 'GBQ9558', '2023-10-14 09:58:00', '2023-10-14 09:58:00', 1, '0', 'joao.silva');
insert into tbl_registros(cod, placa, entrada, saida, tarifa, valor, usuario) values (59, 'GBQ9559', '2023-10-14 09:59:00', '2023-10-14 09:59:00', 1, '0', 'joao.silva');

select * from tbl_registros;
