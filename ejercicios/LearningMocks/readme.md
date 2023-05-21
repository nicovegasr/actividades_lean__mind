# <span style="color:orange"> MOCKS

La idea de este ejercicio es entender como funcionan los mocks 
y el patrón de diseño repository desde 0. Intentaré explicar 
todos los conceptos con analogías para no entrar en términos 
técnicos que algunos no puedan entender.

## <span style="color:orange"> ENUNCIADO

Imagina que estás organizando una biblioteca con muchos libros.
Existen muchos tipos de libro (enciclopedias, revistas, libros), 
ahora, en lugar de tener todos los libros mezclados y desorganizados en un montón,
decides crear un sistema de clasificación.

Para simplificar el ejercicio podemos definir primero un libro:

```java
enum BookTypes {
    Book,
}
```

Ahora, si nuestra aplicación representa la biblioteca y los servicios que ofrece, podemos
crear una estantería que nos permita almacenar y obtener libros.

```java
class Library {
    void put_a_book();
    Book get_this_book(Book book);
}
```

Sin embargo, cada vez que hagamos una prueba no queremos ir a buscar
cada libro, si definimos 1000 tests, nos tenemos que levantar
1000 veces a buscar un libro y no nos pagan suficiente.

La idea de este ejercicio es hacer las funciones:

```java
    public void put_a_book_in_my_library(Book book);
    public Book get_a_book_from_my_library(Book book);
```

Piensa en los casos de errores también y elige la forma que te resulte más cómoda
para manejarlos, si es tu primera vez viendo mocks te recomiendo hacer una biblioteca
muy sencilla, sin tener muchas consideraciones.

Si quieres complicarlo un poco más
puedes separar los tipos de libros, así en vez de tener una clase o enum Book, tendrás
una clase para libros normales, otra para enciclopedias, otra para revistas, y cada tipo
tendrá su estantería particular, un libro no puede guardarse en la estantería de enciclopedias
por lo que ahora tendremos muchos tipos distintos de estanterías, cada uno con sus consideraciones
y sus funciones particulares.

A continuación veremos las conclusiones, por lo que te recomiendo terminar el ejercicio antes de 
leer el siguiente apartado.

