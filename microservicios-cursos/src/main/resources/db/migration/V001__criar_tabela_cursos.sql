CREATE TABLE `cursos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

insert into cursos (nombre, created_at) values ('1º Primaria', NOW());
insert into cursos (nombre, created_at) values ('2º Primaria', NOW());
insert into cursos (nombre, created_at) values ('3º Primaria', NOW());
insert into cursos (nombre, created_at) values ('1º Secundaria', NOW());
insert into cursos (nombre, created_at) values ('2º Secundaria', NOW());
insert into cursos (nombre, created_at) values ('3º Secundaria', NOW());
insert into cursos (nombre, created_at) values ('4º Secundaria', NOW());

CREATE TABLE cursos_alumnos (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `alumno_id` BIGINT NOT NULL,
  `curso_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_cursos_alumnos_curso FOREIGN KEY (curso_id) REFERENCES cursos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO cursos_alumnos (alumno_id, curso_id) VALUES (2, 7);
INSERT INTO cursos_alumnos (alumno_id, curso_id) VALUES (3, 7);