insert into cozinha (id ,nome) values(1,'brasileira');
insert into cozinha (id ,nome) values(2,'japonesa');


insert into restaurante (nome, taxa_frete, cozinha_id) values('Brasileiro', 10.0,1);
insert into restaurante (nome, taxa_frete, cozinha_id) values('Japonés', 9.90,2);
insert into restaurante (nome, taxa_frete, cozinha_id) values('Ceilandence', 9.90,1);


insert into formaPagamento(id,descricao) values(1,'Crédito');
insert into formaPagamento(id,descricao) values(2,'Débito');
insert into formaPagamento(id,descricao) values(3,'Pix');
insert into formaPagamento(id,descricao) values(4,'Dinheiro');


insert into permissao(id, nome, descricao) values(1,'Estoque', 'Este usuario tem permissao para adcionar ou retirar do estoque.');
insert into permissao(id, nome, descricao) values(2,'Entrega', 'Este usuario tem permissao para realizar entregas.');


insert into estado(id, nome) values(1, 'Distrito Federal');
insert into estado(id, nome) values(2, 'Goias');
insert into estado(id, nome) values(3, 'Bahia');



insert into cidade(id, nome, estado_id) values(1, 'Riacho fundo 2', 1);
insert into cidade(id, nome, estado_id) values(2, 'Riacho fundo 1', 1);
insert into cidade(id, nome, estado_id) values(3, 'Recanto das emas', 1);
insert into cidade(id, nome, estado_id) values(4, 'Valparaiso', 2);
insert into cidade(id, nome, estado_id) values(5, 'Goiania', 2);
insert into cidade(id, nome, estado_id) values(6, 'Luziania', 2);
insert into cidade(id, nome, estado_id) values(7, 'correntina', 3);
insert into cidade(id, nome, estado_id) values(8, 'Salvador', 3);
insert into cidade(id, nome, estado_id) values(9, 'Barreiras', 3);

