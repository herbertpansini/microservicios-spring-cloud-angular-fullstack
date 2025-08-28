CREATE TABLE public.alumnos (
	id bigserial NOT NULL,
	nombre varchar(255) NULL,
	apellido varchar(255) NULL,
	email varchar(255) NULL,
	foto oid NULL,
	created_at timestamp(6) NOT NULL,
	CONSTRAINT alumnos_pkey PRIMARY KEY (id)
);

insert into alumnos (nombre, apellido, email, created_at) values ('Andrés', 'Guzman', 'andres@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('John', 'Doe', 'john@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Jose', 'Doe', 'jose@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Pepa', 'García', 'pepa@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Lalo', 'Mena', 'lalo@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Pepe', 'Fernández', 'pepa@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Bea', 'González', 'bea@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Luci', 'Martínez', 'luci@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Pato', 'Rodríguez', 'Pato@mail.com', NOW());
insert into alumnos (nombre, apellido, email, created_at) values ('Jano', 'Pérez', 'jano@mail.com', NOW());