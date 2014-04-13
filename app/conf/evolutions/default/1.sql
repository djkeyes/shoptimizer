# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table search_result (
  name                      varchar(255) not null,
  constraint pk_search_result primary key (name))
;

create sequence search_result_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists search_result;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists search_result_seq;

