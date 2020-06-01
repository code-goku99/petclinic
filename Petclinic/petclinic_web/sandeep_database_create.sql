create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table pet_type (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table pets (id bigint not null auto_increment, bithday date, name varchar(255), owner_id bigint, pet_type_id bigint, primary key (id)) engine=InnoDB
create table speciality (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table vet_speciality (vet_id bigint not null, speciality_id bigint not null, primary key (vet_id, speciality_id)) engine=InnoDB
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB
create table visits (id bigint not null auto_increment, date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id)
alter table pets add constraint FKle3fweh34cdasdukatfapgib9 foreign key (pet_type_id) references pet_type (id)
alter table vet_speciality add constraint FKns25xuxcyf46sbycxgsblcvja foreign key (speciality_id) references speciality (id)
alter table vet_speciality add constraint FKfyjofcc36gwypb5n7kn9afep foreign key (vet_id) references vets (id)
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id)
create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table pet_type (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table pets (id bigint not null auto_increment, bithday date, name varchar(255), owner_id bigint, pet_type_id bigint, primary key (id)) engine=InnoDB
create table speciality (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table vet_speciality (vet_id bigint not null, speciality_id bigint not null, primary key (vet_id, speciality_id)) engine=InnoDB
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB
create table visits (id bigint not null auto_increment, date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id)
alter table pets add constraint FKle3fweh34cdasdukatfapgib9 foreign key (pet_type_id) references pet_type (id)
alter table vet_speciality add constraint FKns25xuxcyf46sbycxgsblcvja foreign key (speciality_id) references speciality (id)
alter table vet_speciality add constraint FKfyjofcc36gwypb5n7kn9afep foreign key (vet_id) references vets (id)
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id)
