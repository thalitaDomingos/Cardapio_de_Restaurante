drop database if exists BancoProjeto;
create database BancoProjeto;
use BancoProjeto;

create table Pratos_Individuais(
	id int auto_increment primary key,
    nome varchar(30) not null,
    descricao varchar(200) not null,
    valor double not null,
    tempo double not null
);

create table Porcoes(
	id int auto_increment primary key,
    nome varchar(30) not null,
    descricao varchar(200) not null,
    valor double not null,
    quantPorcao int not null,
    tempo double not null
);

create table CodigoBarra(
    id int auto_increment primary key,
    codigo varchar(50) not null
);

create table FabricanteBebida(
	id int auto_increment primary key,
    nome varchar(50) not null
);

create table Bebidas(
    id int auto_increment primary key,
    nome varchar(30) not null,
    descricao varchar(200) not null,
    valor double not null,
    comGelo boolean not null,
    tempo double not null,
    codigoBarraId int NOT NULL,
    fabricanteId INT NOT NULL,
    CONSTRAINT `fk_Bebidas_CodigoBarra`
	  FOREIGN KEY (`codigoBarraId`)
	  REFERENCES `BancoProjeto`.`CodigoBarra` (`id`) 
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION,
    CONSTRAINT `fk_Bebida_FabricanteBebida`
	  FOREIGN KEY (`fabricanteId`)
	  REFERENCES `BancoProjeto`.`FabricanteBebida` (`id`)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
);
	
create table Sobremesas(
    id int auto_increment primary key,
    nome varchar(30) not null,
    descricao varchar(200) not null,
    valor double not null,
    diet boolean not null,
    tempo double not null
);
    
CREATE TABLE IF NOT EXISTS `BancoProjeto`.`Combo` (
  `Pratos_IndividuaisId` int NOT NULL,
  `Bebidas_id` INT NOT NULL,
  PRIMARY KEY (`Pratos_IndividuaisId`, `Bebidas_id`),
  CONSTRAINT `fk_Combo_Pratos_Individuais`
    FOREIGN KEY (`Pratos_IndividuaisId`)
    REFERENCES `BancoProjeto`.`Pratos_Individuais` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Combo_Bebidas`
    FOREIGN KEY (`Bebidas_id`)
    REFERENCES `BancoProjeto`.`Bebidas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 
select * from Pratos_Individuais;
select *, FabricanteBebida.nome as fabricante from Bebidas, CodigoBarra, FabricanteBebida where Bebidas.codigoBarraId = CodigoBarra.id and Bebidas.fabricanteId = FabricanteBebida.id;
select * from 	Combo;

select Pratos_Individuais.nome as prato, Bebidas.nome as bebida from Pratos_Individuais, Bebidas, Combo
where Combo.Pratos_IndividuaisId = Pratos_Individuais.id and Combo.Bebidas_id = Bebidas.id;

insert into codigoBarra(id, codigo) values (1, "000001");
insert into codigoBarra(id, codigo) values (2, "000002");
insert into codigoBarra(id, codigo) values (3, "000003");
insert into codigoBarra(id, codigo) values (4, "000004");
insert into codigoBarra(id, codigo) values (5, "000005");
insert into codigoBarra(id, codigo) values (6, "000006");

insert into fabricanteBebida(id, nome) values (1, "Coca-Cola");
insert into fabricanteBebida(id, nome) values (2, "Antartica");
insert into fabricanteBebida(id, nome) values (3, "Brasil Kirin");

insert into porcoes(id,nome, descricao, valor, quantPorcao, tempo) values
(1, "Fritas Tradicional","Batata cortada e frita na hora.",20.00,250,20),
(2, "Tilápia", "Tilápia frita na hora.", 35.00, 300, 20),
(3, "Tábua de Frios", "Queijo provolone, salame e azeitonas verdes.", 40.00, 350, 15),
(4, "Filé com fritas", "File mignon cortado em cubos com fritas.", 47.00, 500, 25),
(5, "Kibre Cru", "Consiste de uma massa de carne moída e trigo tabule, recheada originalmente com carne de carneiro e ervas.", 39.99, 300, 25);

insert into bebidas(id,nome, descricao, valor, comGelo, tempo, codigoBarraId, fabricanteId) values    
(6, "Coca-Cola", "Lata de 350ml", 5.90, true, 1, 1, 1),
(7, "Suco de Morango", "Copo de 500ml", 8.00, false, 5, 2, 2),
(8, "Suco de Laranja", "Copo de 500ml", 8.00, false, 5, 3, 2),
(9, "Agua", "Garrafa de 500ml", 5.00, false, 1, 4, 2),
(10, "Agua com gás", "Garrafa de 500ml", 6.00, false, 1, 6, 3);

insert into sobremesas(id,nome, descricao, valor, diet, tempo) values 
(11, "Petit gâteau", "Recheio cremoso de chocolate, sorvete de creme e chantilly.", 18.00, false, 10 ),
(12, "Brownie Doce de Leite", "Descrição: bolo de chocolate meio amargo e nozes, recheado com doce de leite. É servido com sorvete de creme e calda de doce de leite.", 25.00, false, 10 ),
(13,"Abacaxi a Francesa", "Abacaxi coberto com raspas de limão.", 13.00, true, 5 ),
(14, "Bolo de Nozes", "Recheado com creme de nozes e cobertura de chocolate belga.", 20.00, false, 10 ),
(15, "Sorvete de Queijo", "Sabor diferenciado.", 10.00, true, 5);

select * from fabricanteBebida;
select * from codigoBarra;
