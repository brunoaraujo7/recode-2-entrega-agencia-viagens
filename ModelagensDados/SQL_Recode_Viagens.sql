create database Recode_Viagens;

CREATE TABLE Pacote (
    id INT PRIMARY KEY auto_increment,
    modal VARCHAR(25),
    diaria INT,
    valor DOUBLE,
    id_destino INT,
    foreign key (id_destino) references destino (id)
);

insert into pacote(id_destino, modal, diaria, valor) values (1, "Rodoviário", 2, 1000.00);
insert into pacote(id_destino, modal, diaria, valor) values (2, "Aéreo", 4, 2500.00);
insert into pacote(id_destino, modal, diaria, valor) values (4, "Marítimo", 5, 3500.00);
insert into pacote(id_destino, modal, diaria, valor) values (3, "Aéreo", 4, 2500.00);
insert into pacote(id_destino, modal, diaria, valor) values (3, "Rodoviario", 4, 1500.00);
insert into pacote(id_destino, modal, diaria, valor) values (2, "Rodoviario", 4, 1800.00);

select * from destino;

CREATE TABLE Destino (
    id INT PRIMARY KEY auto_increment,
    cidade VARCHAR(30),
    pais VARCHAR(20)
);
 
insert into destino(cidade, pais) values ("Duque de Caxias", "Brasil");
insert into destino(cidade, pais) values ("Belo Horizonte", "Brasil");
insert into destino(cidade, pais) values ("São Paulo", "Brasil");
insert into destino(cidade, pais) values ("Salvador", "Brasil");
insert into destino(cidade, pais) values ("Miami", "Estados Unidos");

