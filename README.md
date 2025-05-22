CREATE DATABASE modeloparcial;
Ejemplos POSTMAN
Alumno
POST http://localhost:8080/alumno
{
    "nombre": "Gianluca",
    "apellido": "Castorina",
    "email": "gcastorina234@gmail.com",
    "fichaMedica": {
        "observacion" : "Está bien"
    }
}
PUT http://localhost:8080/alumno/2
{
    "nombre": "Lucas",
    "apellido": "Rodriguez",
    "email": "lucasrodriguez@hotmail.com",
    "fichaMedica": {
        "observacion" : "Esta perfecto"
    }
}
GET http://localhost:8080/alumno
GET http://localhost:8080/alumno/email/gcastorina234@gmail.com
DELETE http://localhost:8080/alumno/id/2
DELETE http://localhost:8080/alumno/email/lucasrodriguez@hotmail.com




Área
POST http://localhost:8080/area
{
    "nombre":"Matematica"
}
GET http://localhost:8080/area
DELETE http://localhost:8080/area/id/2
DELETE http://localhost:8080/area/nombre/Base de datos
Profesor
POST http://localhost:8080/profesor
{
    "nombre":"profesor",
    "apellido":"profe",
    "email":"profesorprofe@gmail.com",
    "area":5
}
GET http://localhost:8080/profesor
GET http://localhost:8080/profesor/email/profesorprofe@gmail.com
DELETE http://localhost:8080/profesor/id/4
DELETE http://localhost:8080/profesor/email/profesorprofe@gmail.com
PUT http://localhost:8080/profesor/id/6
{
    "nombre":"profesor",
    "apellido":"profe",
    "email":"profesorprofee@gmail.com",
}



Curso
POST http://localhost:8080/curso
{
    "duracionSemanas":6,
    "cupoMaximo":5,
    "profesor":6
}
PUT http://localhost:8080/curso
{
"duracionSemanas":4,
    "cupoMaximo":6,
}
GET http://localhost:8080/curso
GET http://localhost:8080/curso/email/profesorprofe@gmail.com
GET http://localhost:8080/curso/id/3
DELETE http://localhost:8080/curso/id/2
Inscripcion
POST http://localhost:8080/inscripcion
{
	"fechaInscripcion":"2025-01-02",
    "estado": "aceptada",
  "alumno" : 1,
  "curso" : 3
}
GET http://localhost:8080/inscripcion
GET http://localhost:8080/inscripcion/id/5
DELETE http://localhost:8080/inscripcion/id/1




