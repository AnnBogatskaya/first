create table records
(
	id bigint default nextval('records_id_seq'::regclass) not null
		constraint records_pkey
			primary key,
	date date not null,
	time time not null,
	complaint varchar(99) not null,
	user_id bigint not null
);

create table roles
(
	id bigint default nextval('roles_id_seq'::regclass) not null
		constraint roles_pkey
			primary key,
	name varchar(55) not null
);

create table schedules
(
	id bigint default nextval('schedules_id_seq'::regclass) not null
		constraint schedules_pkey
			primary key,
	date date not null,
	timefrom time not null,
	timeto time not null,
	isavailable boolean
);

create table users
(
	id bigint default nextval('users_id_seq'::regclass) not null
		constraint users_pkey
			primary key,
	login varchar(55) not null,
	password varchar(255) not null,
	email varchar(99) not null,
	fullname varchar(99) not null,
	isconfirmed boolean
);

create unique index users_login_uindex
	on users (login);

create table confirmation
(
	id bigint default nextval('confirmation_id_seq'::regclass) not null
		constraint confirmation_pkey
			primary key,
	login varchar(99) not null
		constraint confirmation_users_login_fk
			references users (login),
	token varchar(255) not null
);

create unique index confirmation_user_name_uindex
	on confirmation (login);

create table users_roles
(
	id bigint default nextval('users_roles_id_seq'::regclass) not null
		constraint users_roles_pkey
			primary key,
	user_id bigint not null
		constraint users_roles_users_id_fk
			references users,
	role_id bigint not null
		constraint users_roles_roles_id_fk
			references roles
);

create table users_records
(
	id bigint default nextval('users_records_id_seq'::regclass) not null
		constraint users_records_pkey
			primary key,
	record_id bigint not null
		constraint users_records_records_id_fk
			references records,
	user_id bigint not null
		constraint users_records_users_id_fk
			references users
);

