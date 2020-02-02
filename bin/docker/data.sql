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
