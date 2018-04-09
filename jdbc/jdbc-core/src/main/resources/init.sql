-- DROP TABLE employee;

CREATE TABLE employee
(
  id   INTEGER NOT NULL,
  name CHARACTER VARYING(20),
  role CHARACTER VARYING(20),
  CONSTRAINT employee_pkey PRIMARY KEY (id)
);