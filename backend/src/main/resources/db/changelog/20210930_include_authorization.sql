create table aut_autorization (
     aut_id bigint not null primary key,
     aut_name varchar(20) not null unique

);

create table uau_usuario_autorizacao (
     usr_id bigint  not null primary key,
     aut_id bigint  not null,
     constraint uau_usr_fk foreign key  (usr_id)
         references us_user (us_id)
         on delete restrict on update cascade,
     constraint uau_aut_fk foreign key (aut_id)
         references aut_autorization (aut_id)
         on delete restrict on update cascade
);