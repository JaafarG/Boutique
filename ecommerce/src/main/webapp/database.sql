create schema boutique;

insert into boutique.ARTICLE (name, prix, nbRestant) values ("Table", 200, 2);
insert into boutique.ARTICLE (name, prix, nbRestant) values ("Chaises", 50, 10);
insert into boutique.ARTICLE (name, prix, nbRestant) values ("Banc", 100, 5);

insert into boutique.USER (login, name, password) values ('alice', 'Alice', 'mdpa');
insert into boutique.USER (login, name, password) values ('bob', 'Bob', 'mdpb');