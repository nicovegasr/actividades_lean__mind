# Manejo de errores
La idea de este ejercicio es aprender sobre las 
distintas formas de manejar errores. El objetivo es que cualquiera
entienda el código sin importar el nivel por lo que no usaremos ningun tipo
de patron de diseño ni arquitectura en especial.

---

# Enunciado

A la hora de programar código sostenible es importante seguir ciertas buenas prácticas. 
En este momento nos interesa aprender a aplicar ``Desarrollo dirigido por pruebas (TDD)``
Para ello es importante entender el flujo de trabajo a la hora de aplicar esta metodología:

1. Hacer un test en rojo ya que no hemos creado nada.
2. Implementar el código mínimo para que el test pase (baby steps).
3. Leer el código y refactorizar el código escrito.

La idea de este ejercicio es realizar una herramienta que facilite el aprendizaje de este flujo, para ello haremos
uso de una funcion ``void create_my_feature(action1, action2, action3)`` las acciones disponibles serán:

```java
enum Actions {
   CREATE_TEST,
   MAKE_BABY_STEP_CODE,
   REFACTOR_CODE,
}
```
Para que el usuario sepa si todo está bien, hay dos posiblidades, que la función devuelva un 0 
(funcionamiento común de los programas exit code) o que informe de los errores que han sucedido.

Ejemplos de salidas:
1. `create_my_featue(CREATE_TEST, MAKE_BABY_STEP_CODE, REFACTOR_CODE` ➜ 0
2. `create_my_featue(MAKE_BABY_STEP_CODE, CREATE_TEST, REFACTOR_CODE` ➜ Error

## Adicional.

Cuando desarrollamos código, no siempre es posible aplicar TDD, todo depende de un contexto.
Para establecer dicho contexto podemos introducir las siguientes FLAGS:

```java
enum FeatureFlags {
   DEADLINE_SOON,
   NO_DEADLINE,
}
```
Ahora podemos añadir a la función otro parámetro: ``void create_my_feature(action1, action2, action3, flag)``.
Sin embargo, también es importante dejar documentadas las deudas técnicas, por lo que podemos añadir a la acciones:

```java
enum Actions {
   CREATE_TEST,
   MAKE_BABY_STEP_CODE,
   REFACTOR_CODE,
   
   MAKE_ALL_THE_CODE,
   INFORM_TECHNICAL_DEBTS,
   STOP_WORKING,
}
```
Ejemplos de salidas:
1. `create_my_featue(CREATE_TEST, MAKE_BABY_STEP_CODE, REFACTOR_CODE, NO_DEADLINE` ➜ 0
2. `create_my_featue(MAKE_ALL_THE_CODE, INFORM_TECHNICAL_DEBTS, STOP_WORKING, DEADLINE_SOON` ➜ 0

Ahora con esta explicación, puedes añadir los distintos errores que pueden existir con la combinacion de las distintas acciones. No hace falta añadirlos todos, lo importante es el planteamiento.

---

# Formas de manejar erorres
En esta sección comentare 3 formas de manejar errores que yo conozco
con 1 ventaja y 1 desventaja para ser breve.
1. ``Loggear y detener la aplicación``: El primer acercamiento 
que me enseñaron a mí particularmente y creo que es el más común
al inicio es hacer un ``console.log()`` y detener la aplicación,
informandole al usuario de porqué se ha detenido la ejecución para
que en futuras ocasiones no cometa el mismo error.
   1. Ventaja: La aplicación es estricta y robusta, un enfoque
   ventajoso en algunos ámbitos.
   2. Desventaja: La aplicación no es resiliente ya que no puede
   recuperarse de fallos y en entornos dinámicos no es válido.
2. ``Try - Catch``: Con esta sentencia podemos manejar los distintos errores dependiendo
3. ``Either``: 
---

# Aclaración

Cualquier acercamiento para resolver el problema es válido, 
lo realmente importante es analizar el porqué de cada solución.
No hay soluciones incorrectas, cualquier solución argumentada
es válida, las formas de manejar los errores son las que se me ocurren 
a mí, pero existen muchas más y pueden proponer cualquiera.