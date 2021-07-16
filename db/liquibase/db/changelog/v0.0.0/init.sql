--liquibase formatted sql

--changeset kuzmina:add_contact_table
create table contact
(
    id uuid not null,
    email varchar(50),
    name  varchar(20),
    phone varchar(11),
    bookuuid uuid,
    primary key (id)
);



comment on table contact is 'Контакт';
comment on column contact.email is 'Email';
comment on column contact.name is 'Имя';
comment on column contact.phone is 'Телефон';
comment on column contact.bookuuid is 'Ссылка на книгу контактов';


-------------------------------------------------


create table phonebook
(
    id uuid not null,
    name varchar(20),
    primary key (id)
);

comment on table phonebook is 'Телефонаая книга';
comment on column phonebook.id is 'Идентификатор записи';
comment on column phonebook.name is 'Наименование';


alter table contact
    add constraint uk_contact_name_bookuuid unique (name, bookuuid);
alter table phonebook
    add constraint uk_book_name unique (name);
alter table contact
    add constraint fk_contact_bookuuid foreign key (bookuuid) references phonebook

