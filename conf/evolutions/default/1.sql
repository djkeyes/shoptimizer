
# --- !Ups

create table search_result (
  id                        integer not null,
  brand                     varchar(255),
  size                      double,
  organic                   varchar(255),
  price                     double,
  unit_price                double,
  weight                    double,
  rating                    integer,
  name                      varchar(255),
  location                  varchar(255),
  constraint pk_search_result primary key (id))
;

create sequence search_result_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists search_result;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists search_result_seq;

