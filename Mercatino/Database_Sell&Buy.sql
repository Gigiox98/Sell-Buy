create database SellBuy;

use sellbuy;
select * from categoria;
select * from prodotto where (nome LIKE '%%' OR descrizione LIKE '%%') AND categoria = 'Altro...' AND prezzo <= 0 AND stato = 'usato';
select * from prodotto;
create table utente(
	username varchar(30) primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    password varchar(30) not null,
    via varchar(60) not null,
    civico int not null,
    città varchar(30) not null,
    email varchar(30),
    adminflag bool not null
);


delete from utente where username = 'MarRos4';
create table categoria(
    categoria varchar(30) primary key
);

insert into categoria set categoria="Auto";
insert into categoria set categoria="Elettronica";
insert into categoria set categoria="Casa";
insert into categoria set categoria="Ferramenta";
insert into categoria set categoria="Altro...";

create table prodotto(
    cod_p varchar(30) primary key,
    nome varchar(30),
    quantità int not null,
    prezzo float not null,
    descrizione varchar(100),
    località varchar(30) not null,
    data_inserimento varchar(50)not null,
	stato varchar(30) not null,
    pathImmagine varchar(500) not null,
    immagine longtext,
    codice_venditore varchar(30),
    categoria varchar(30),
    acquistato integer default 0,
    flag_sconto boolean default false,
	FOREIGN KEY (codice_venditore) REFERENCES utente (username)
	on update cascade on delete cascade,
    FOREIGN KEY (categoria) REFERENCES categoria (categoria)
	on update cascade on delete cascade
);

delete from prodotto where cod_p = '7979144592';
update prodotto set quantità = '4', nome = 'Smerigliatrice Angolare', prezzo = '300', 
descrizione = 'smerigliatrice angolare ultima tecnologia', data_inserimento = 'Sun Apr 21 12:29:33 CEST 2019', 
stato = 'Nuovo', località = 'Roma', codice_venditore = 'Felix88', categoria = 'Ferramenta' where cod_p='1452351942';

select * from prodotto;



delete from sconto;

create table prodotto_carrello(
	cod_prodotto varchar(30) not null,
    cod_user varchar(30) not null,
    primary key(cod_prodotto, cod_user),
    quantità integer,
	FOREIGN KEY(cod_prodotto) REFERENCES prodotto(cod_p)
    on update cascade on delete cascade,
    FOREIGN KEY(cod_user) REFERENCES utente(username)
    on update cascade on delete cascade
);
select * from ordine;


create table ordine(
	codice_ordine varchar (30)  primary key key,
    indirizzo_spedizione varchar(30) not null,
    stato varchar(30) not null,
    quantita_articolo int not null,
    prezzo_acquisto float not null,
    pagamento varchar(30) not null,
    username_a varchar(30),
    codice_prodotto varchar(30),
    data VARCHAR(30),
    FOREIGN KEY(codice_prodotto) REFERENCES prodotto(cod_p)
    on update cascade on delete cascade,
    FOREIGN KEY(username_a) REFERENCES utente(username)
    on update cascade on delete cascade
);

select * from ordine where username_a = 'MikeTony19' AND stato = 'in carrello';
select * from ordine where username_a = 'MikeTony19' AND stato = 'in carrello';
select * from ordine where username_a = 'MikeTony19' AND stato = 'in carrello';
select * from ordine;

delete from ordine where stato = "in carrello";

create table sconto(
codice varchar(30) primary key,
ammontare int,
flag_utilizzo bool default 0
);

delete from sconto;
delete from recensioni;
create table recensioni(
codice varchar(15) primary key,
codice_p varchar(30),
FOREIGN KEY(codice_p) REFERENCES prodotto(cod_p)
on update cascade on delete cascade,
utente varchar(30),
FOREIGN KEY(utente) REFERENCES utente(username),
testo longtext,
voto int
);

select * from ordine;
update categoria  set ricavo_tot = (select sum(costo) 
from iscrizione, studente
where iscrizione.cod_studente = studente.codice 
and iscrizione.licenza_corso = corso_guida.tipo_licenza
and iscrizione.data_inizio = corso_guida.data_inizio);
