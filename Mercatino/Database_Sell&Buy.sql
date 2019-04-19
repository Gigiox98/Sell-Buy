create database SellBuy;

use SellBuy;

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
select * from utente;
delete from utente;




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
    data_inserimento date not null,
	stato varchar(30) not null,
    percorso varchar(100),
    codice_venditore varchar(30),
    categoria varchar(30),
	FOREIGN KEY (codice_venditore) REFERENCES utente (username)
	on update cascade on delete cascade,
    FOREIGN KEY (categoria) REFERENCES categoria (categoria)
	on update cascade on delete cascade
);

create table ordine(
	codice_ordine varchar (30)  primary key key,
    indirizzo_spedizione varchar(30) not null,
    stato varchar(30) not null,
    quantita_articolo int not null,
    prezzo_acquisto float not null,
    pagamento varchar(30) not null,
    username_a varchar(30),
    codice_prodotto varchar(30),
    FOREIGN KEY(codice_prodotto) REFERENCES prodotto(cod_p)
    on update cascade on delete cascade,
    FOREIGN KEY(username_a) REFERENCES utente(username)
    on update cascade on delete cascade
);



create table sconto(
sconto int,
codice_p varchar(30),
FOREIGN KEY(codice_p) REFERENCES prodotto(cod_p)
on update cascade on delete cascade,
primary key(sconto, codice_p)
);

update categoria  set ricavo_tot = (select sum(costo) 
from iscrizione, studente
where iscrizione.cod_studente = studente.codice 
and iscrizione.licenza_corso = corso_guida.tipo_licenza
and iscrizione.data_inizio = corso_guida.data_inizio);
