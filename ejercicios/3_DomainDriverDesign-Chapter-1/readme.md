# <span style="color:orange"> PLANTEANDO UN DOMINIO
> Si ya tienes conocimientos de DDD y arquitectura,  
puedes revisar el enunciado y ver como planteo el dominio de
la aplicación directamente 
(Ten en cuenta que de momento no existe ninguna otra capa). 

A partir de aquí plantearemos como empezar a diseñar un servidor 
backend con arquitectura hexagonal, sin embargo, para empezar hablaremos
de domain driver design. tendremos distintos capítulos donde hablaré sobre
una misma kata / ejercicio: [UserSignup](https://github.com/nicovegasr/actividades_lean__mind/tree/master/katas/UserSignUp)

La idea será ir explicando cada capa de la arquitectura hexagonal, sin embargo,
si no te sientes cómodo con los siguientes conceptos:

* Patrón repository.
* Patrón factory.
* Mocks.

Además, será más fácil si conoces:

* Inyección de dependencias.
* Inversión de dependencias.

Si no, te comento estas dos últimas rápidamente (aunque creo que es más fácil verlo en código).

### Inyección de dependencias
Cuando trabajamos con interfaces en programación, estamos estableciendo
un contrato y obligando a las clases que las implemente a seguir dicho contrato.
Por ejemplo, todas las clases que implementen una interfaz en particular, tendrán 
los mismos métodos con los mismos comportamientos de entrada y de salida.

Esto hace que podamos pensar en las interfaces como un tipado propio de nuestra
aplicación, por lo tanto, si tenemos la siguiente estructura:

```java
interface Animal{
    Float getWeight();
    Float getHeight();
}

public class Dog implements Animal { }
public class Cat implements Animal { }
```

Tanto nuestro "Dog" como "Cat" son de tipo Animal, eso implica que una función:

```java
    public Float calculateIMC(Animal animal) {}
```

Puede recibir tanto un "Dog" como un "Cat", por lo que estamos inyectando dependencias
distintas en nuestra función porque ambas cumplen un mismo contrato (interfaz).

### Inversión de dependencia

Este concepto siento que es más fácil verlo en un proyecto, creo que en parte lo que hace
que sea tan difícil de ver para algunas personas es que al nunca haber trabajado con una arquitectura
de software no están relacionados con conceptos como: "Dominio o clases de capas inferiores"

Para no adelantarnos a explicar DDD o Arquitectura hexagonal, pensemos de momentos en la inversión de dependencia
como un concepto en el que adecuamos una clase para que no dependa de ningún factor externo, las clases de nuestro dominio
tienen que ser definidas únicamente por nosotros después de analizar el "negocio", no
debe depender de nada de fuera, por lo que cuando usemos herramientas externas, hay que *invertir la dependencia*.

Seguiremos hablando de este concepto a lo largo de este texto asi que no te preocupes si aun no te queda claro, lo verás al plantear el dominio 
de este capítulo y cuando lleguemos al capítulo 3 donde veamos la infraestructura lo verás mucho mas claro.

### <span style="color:orange"> DOMAIN DRIVER DESIGN

Al aprender la arquitectura hexagonal, es importante no saltarte el DDD
(Te lo digo porque yo me lo salté y de no ser por todos los compañeros de lean mind estaría muy perdido)
entonces, vamos a plantear una aplicación que solo tenga un dominio.

> *Importante:* En temas de arquitectura hay demasiadas cosas subjetivas, a lo largo de estos 3 capítulos
casi todo lo que hable será valoración personal, habran algunos casos en que ponga 2 enfoques de cosas que me gusten,
pero ten en cuenta que si sigues algún criterio propio que justifique el porqué de lo que haces, no hay problema

Ninguno de los conocimientos aquí es absoluto, por lo que puedes hacer tu dominio a tu forma sin ningún problema
mientras sigas los correspondientes principios, si te interesa más de este tema y no te gusta mi perspectiva te animo a investigar sobre él.

# <span style="color:orange"> ENUNCIADO GENERAL

## User Sign Up

Cuando hacemos una página web, necesitamos tener en cuenta a priori 3 componentes:
1. Frontend: Interfaz visual.
2. Backend: Servidor que gestiona todas las peticiones del frontend.
3. Sistema de persistencia: Comúnmente una base de datos de toda la vida.

Cuando un usuario se registra en un sitio web, hay que tener algunas consideraciones (no hablaremos de temas de seguridad)
por ejemplo: si el usuario existe o no, si los campos rellenados en el frontend tienen distintas validaciones que queramos aplicar, entre
otras.

## Enunciado particular
En este momento vamos a plantear el dominio de nuestra aplicación:

* Dominio: En él residen todos los modelos, entidades, value-objects que son propios de 
nuestra lógica de negocio (En este caso nuestra lógica de negocio es: Validar campos y almacenar los usuarios de nuestra aplicación)

Por ello, definiremos el dominio con el modelo de Usuario y aquí estableceremos la primera problemática:

* La forma de persistir de la aplicación es externa a nuestra lógica de negocio, por lo que como podemos decirle al dominio que tendremos un repositorio.

Básicamente, en el dominio tendremos definidas las interfaces de los repositorios, no nos interesa saber como están implementados, solo
nos interesa definir un contrato que nuestro exterior tiene que cumplir para comunicarse con nosotros como dominio
(A esto es lo que se denomina inversión de dependencias) así logramos que todo lo exterior dependa del dominio y no al revés.

A la hora de plantear nuestro dominio, hay algunos debates sobre como validar los datos, yo conozco 2 formas y ambas me gustan:
1. Crear value objects con métodos factory (create) donde se compruebe todo lo que queramos.
2. Crear métodos de validación en los servicios para que los modelos de dominio sean nuestro happy path.

Con esto en mente ya podemos empezar a programar.

> TAGS: PATRON REPOSITORY, DOMINIO, INVERSION_DEPENDENCIA, INYECCIÓN_DEPENDENCIAS, PATRON_FACTORY