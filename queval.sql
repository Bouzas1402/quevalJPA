create table pregunta (
    id  bigint primary key,
    codigo  char(8) not null unique,
    texto text null,
	eval_tipo       int not null,
	es_visible      boolean not null,
    es_activa       boolean null,
	tiempo_restante int null,
	tema_id         int not null,
	dificultad      int null, 
)

create table respuesta (
    id          bigint  primary key,
    codigo      char(3) not null,
    pregunta_id int not null,
	texto       text,
    correcta    boolean not null,
    orden       smallint not null
);

create table evaluacion (
    id          bigint primary key,
    exam_id     bigint not null,
    user_id     bigint not null,
	fecha       date not null,
	calificacion int not null,
	duracion    int not null  -- en minutos
);

create table examen (
    id          bigint primary key,
    codigo      char(8) null,
    area_id      int not null,
	dificultad  int not null,
	eval_tipo   int not null,
	nombre       varchar(255) not null,
	fecha_final  date not null,
	es_aleatorio boolean not null,
	num_preguntas int not null,
	duracion     int not null 
);

create table tema (
    id      int primary key,
    code    char(8) null,
	area_id int not null,
	nombre  varchar(255) null
);

create table area (
    id  int  primary key,
    codigo char(8) not null  ,
	nombre  varchar(255) not null 
);

create table resultado_aprendizaje (
    id  int primary key,
	codigo char(8) not null,
	tema_id int not null,
	nombre text null
)

create table user (
    id  bigint primary key,
    username varchar(255) not null,
	password varchar(32)  not null
);

create table evaluacion_pregunta (
    evaluacion_id   int not null,
    pregunta_id     int not null,
	respuesta_id    int not null,
	tiempo          int null, -- en segundos
	CONSTRAINT evaluacion_pregunta_pk PRIMARY KEY ( evaluation_id, question_id ) 
);

create table examen_pregunta (
	examen_id    int not null,
	pregunta_id  int not null,
	CONSTRAINT examen_pregunta_pk PRIMARY KEY ( exam_id, question_id ) 
);

create table rap_pregunta (
	rap_id  int not null,
	pregunta_id int not null,
	CONSTRAINT rap_pregunta_pk PRIMARY KEY ( rap_id, pregunta_id) 
);

alter table evaluacion
    add constraint evaluation_examen_fk FOREIGN KEY (examen_id) REFERENCES examen(id);

alter table evaluacion
    add constraint evaluacion_user_fk FOREIGN KEY (user_id) REFERENCES user(id);

alter table evaluacion_pregunta
    add constraint evaluacion_pregunta_pregunta_fk FOREIGN KEY (pregunta_id) REFERENCES pregunta(id);

alter table evaluacion_pregunta
    add constraint evaluacion_pregunta_evaluacion_fk FOREIGN KEY (evaluacion_id) REFERENCES evaluacion(id);

alter table examen
    add constraint examen_area_fk FOREIGN KEY (area_id) REFERENCES area(id);

alter table examen_pregunta
    add constraint examen_pregunta_pregunta_fk FOREIGN KEY (pregunta_id) REFERENCES pregunta(id);

alter table examen_pregunta
    add constraint examen_pregunta_evaluacion_fk FOREIGN KEY (evaluacion_id) REFERENCES evaluacion(id);

alter table rap_pregunta
    add constraint rap_pregunta_pregunta_fk FOREIGN KEY (pregunta_id) REFERENCES pregunta(id);

alter table rap_pregunta
    add constraint rap_pregunta_rap_fk FOREIGN KEY (rap_id) REFERENCES resultado_aprendizaje(id);

alter table pregunta
    add constraint pregunta_tema_fk FOREIGN KEY (tema_id) REFERENCES tema(id);

alter table tema
    add constraint tema_area_fk FOREIGN KEY (area_id) REFERENCES area(id);








