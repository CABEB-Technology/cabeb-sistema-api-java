-- Drop table

-- DROP TABLE usuario;

CREATE TABLE usuario (
	id int8 NOT NULL,
	cpf varchar(255) NULL,
	criado timestamp NULL,
	email varchar(255) NULL,
	modificado timestamp NULL,
	senha varchar(255) NULL,
	usuario varchar(255) NULL,
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);