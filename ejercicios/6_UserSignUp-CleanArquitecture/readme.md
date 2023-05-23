# User Sign Up
> Aquí trabajaremos con try-catch

Tengo que empezar diciendo que cambiaré muchas cosas 😂

La razón de esto es una y tiene nombre:
1. Validaciones.

De momento no tengo claro donde deberían ir ni el nombre, sin embargo, saqué algunas conclusiones de [este](http://www.modestosanjuan.com/post/validaciones-donde-os-pongo/) blog.

Mi idea es la siguiente:

* Crear una clase `UserRequestValidate` que tenga todas las validaciones en infraestructura.
* Crear un DTO `UserDTO` que con un método de factoría que devuelva el usuario de dominio.

Con esto, entraremos a nuestra lógica de negocio solo cuando nuestros datos estén bien y la las capas de dentro como por ejemplo aplicación solo manejarán comportamientos excepcionales propios como que no se pueda guardar un usuario en la base de datos.

Lo voy a hacer en un servidor de express porque tengo más experiencia con TypeScript.
