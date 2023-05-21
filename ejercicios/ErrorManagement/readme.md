# <span style="color:orange">MANEJO DE ERRORES</span>
La idea de este ejercicio es aprender sobre las 
distintas formas de manejar errores. El objetivo es que cualquiera
entienda el código sin importar el nivel por lo que no usaremos ningun tipo
de patron de diseño ni arquitectura en especial.

---

## <span style="color:orange">ENUNCIADO</span>

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

### Ejemplos de funcionamiento:

1. `create_my_feature(CREATE_TEST, MAKE_BABY_STEP_CODE, REFACTOR_CODE` ➜ 0
2. `create_my_feature(MAKE_BABY_STEP_CODE, CREATE_TEST, REFACTOR_CODE` ➜ Error

## <span style="color:orange">ADICIONAL</span>

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
### Ejemplos de salidas:
1. `create_my_feature(CREATE_TEST, MAKE_BABY_STEP_CODE, REFACTOR_CODE, NO_DEADLINE` ➜ 0
2. `create_my_feature(MAKE_ALL_THE_CODE, INFORM_TECHNICAL_DEBTS, STOP_WORKING, DEADLINE_SOON` ➜ 0

Ahora con esta explicación, puedes añadir los distintos errores que pueden existir con la combinacion de las distintas acciones. No hace falta añadirlos todos, lo importante es el planteamiento.

---

# <span style="color:orange">FORMAS DE MANEJAR ERRORES</span>

1. ``Loggear y detener la aplicación``.
2. ``Try - Catch``.
3. ``Either``.
---

# <span style="color:orange">CONSIDERACIONES</span>

Cualquier acercamiento para resolver el problema es válido, 
lo realmente importante es analizar el porqué de cada solución.
No hay soluciones incorrectas, cualquier solución argumentada
es válida, las formas de manejar los errores son las que se me ocurren 
a mí, pero existen muchas más y pueden proponer cualquiera.

La idea es que al terminar el ejercicio tengamos nociones iniciales de TDD y practiquemos el manejo de errores
que más queramos refinar.

<span style="color:red">Deuda a futuro:</span> Tras resolver el ejercicio con el uso de `Either` Quiero manejar los errores devolviendo una traza de todos los errores en cada acción (1º Error en la primera accion, 1º error en la segunda accion, 1º Error en la tercera acción))
y debatir sobre las ventajas de esto, por ejemplo, si en la traza deben intentarse todos los errores posibles en cada accion,
o si solo vale con la 1º como comenté, o si los errores deberian ser mas genericos dependiendo del ámbito

Luego de realizar todas las katas y temas que tenga pendiente en este repositorio
me gustaría tener mis propias conclusiones personales de cada tema, me gustaría tener 2 conclusiones.
1. La mejor forma de hacerlo desde mi punto de vista
2. La forma más eficiente pero que conserve cierto criterio de calidad (no quiero hacer las cosas por hacerlas)
> TAGS: TDD, MANEJO_ERRORES, EITHER, TRY-CATCH, LOGS.