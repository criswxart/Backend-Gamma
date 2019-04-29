/* Tabla usuarios */
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("GONZALO","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("DSADS","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("CASDAian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");
INSERT INTO usuario(nombre,apellidos,direccion,telefono,fecha_nac)VALUES ("Cristian","Godoy","itihue 354","+56985432154","2010-01-01");

/*
Se crearán algunos profesionales con sus roles
*/

INSERT INTO
INSERT INTO profesionales (username, password, enabled) VALUES ('andres','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1);
INSERT INTO profesionales (username, password, enabled) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1);

INSERT INTO roles (nombre) VALUES ('ROLE_PROF');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO profesionales_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO profesionales_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO profesionales_roles (usuario_id, role_id) VALUES (2, 1);
