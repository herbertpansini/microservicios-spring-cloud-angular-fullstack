CREATE TABLE respuestas (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  texto VARCHAR(255) NOT NULL,
  alumno_id BIGINT NOT NULL,
  pregunta_id BIGINT NOT NULL,
  CONSTRAINT pk_respuestas PRIMARY KEY (id),
  CONSTRAINT fk_respuestas_pregunta FOREIGN KEY (pregunta_id) REFERENCES preguntas (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO respuestas (texto, alumno_id, pregunta_id) VALUES ('Cristóbal Colón', 2, 1);
INSERT INTO respuestas (texto, alumno_id, pregunta_id) VALUES ('1492', 2, 2);
INSERT INTO respuestas (texto, alumno_id, pregunta_id) VALUES ('Cusco',	2, 3);