CREATE TABLE asignaturas (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  padre_id BIGINT(20) DEFAULT NULL,
  CONSTRAINT pk_asignaturas PRIMARY KEY (id),
  CONSTRAINT fk_asignaturas_padre FOREIGN KEY (padre_id) REFERENCES asignaturas (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO asignaturas (nombre) VALUES ('Matemáticas');
INSERT INTO asignaturas (nombre) VALUES ('Lenguaje');
INSERT INTO asignaturas (nombre) VALUES ('Inglés');
INSERT INTO asignaturas (nombre) VALUES ('Ciencias Naturales');
INSERT INTO asignaturas (nombre) VALUES ('Ciencias Sociales y Historia');
INSERT INTO asignaturas (nombre) VALUES ('Música');
INSERT INTO asignaturas (nombre) VALUES ('Artes');

CREATE TABLE examenes (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  created_at DATETIME(6) NOT NULL,
  asignatura_id BIGINT(20) NOT NULL,
  CONSTRAINT pk_examenes PRIMARY KEY (id),
  CONSTRAINT fk_examenes_asignatura FOREIGN KEY (asignatura_id) REFERENCES asignaturas (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO examenes (nombre, created_at, asignatura_id) VALUES ('Examen de Historia', NOW(), 5);

CREATE TABLE preguntas (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  texto VARCHAR(255) NOT NULL,
  examen_id BIGINT(20) NOT NULL,
  CONSTRAINT pk_preguntas PRIMARY KEY (id),
  CONSTRAINT fk_preguntas_examen FOREIGN KEY (examen_id) REFERENCES examenes (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO preguntas (texto, examen_id) VALUES ('Quién descubrió América', 1);
INSERT INTO preguntas (texto, examen_id) VALUES ('En qué año se descubrió América', 1);
INSERT INTO preguntas (texto, examen_id) VALUES ('Capital del imperio Inca', 1);

CREATE TABLE cursos_examenes (
  curso_id BIGINT(20) NOT NULL,
  examen_id BIGINT(20) NOT NULL,
  CONSTRAINT pk_cursos_examenes PRIMARY KEY (curso_id, examen_id),
  CONSTRAINT fk_cursos_examenes_curso FOREIGN KEY (curso_id) REFERENCES cursos (id),
  CONSTRAINT fk_cursos_examenes_examen FOREIGN KEY (examen_id) REFERENCES examenes (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO cursos_examenes (curso_id, examen_id) VALUES (7, 1);