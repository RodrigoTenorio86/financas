create database if not exists financas;
USE financas;


    create table if not exists Conta (
       id integer not null auto_increment,
        agencia varchar(255),
        banco varchar(255),
        numero varchar(255),
        titular varchar(255),
        primary key (id)
    ) ENGINE=InnoDB


insert into tbl_movimentacao(data, valor, conta_id, descricao, tipo) values ('2017-01-26', 80.0, 2, "Restaurante", "SAIDA");
insert into tbl_movimentacao(data, valor, conta_id, descricao, tipo) values ('2017-01-26', 100.0, 2, "Cinema", "SAIDA");
insert into tbl_movimentacao(data, valor, conta_id, descricao, tipo) values ('2017-01-27', 40.0, 2, "Café da manhã", "SAIDA");
insert into tbl_movimentacao(data, valor, conta_id, descricao, tipo) values ('2017-01-27', 20.0, 2, "Lanche", "SAIDA");
