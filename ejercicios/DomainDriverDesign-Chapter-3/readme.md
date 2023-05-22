# Domain Driver Design - Infrastucture

Una vez que tenemos definido el dominio y la capa de aplicación, es hora de definir la capa de infraestructura. Esta capa es la que se encarga de implementar los detalles técnicos de la aplicación, como por ejemplo, la persistencia de datos, la comunicación con otros sistemas, los controladores y en general todo lo referente al framework que utilicemos (SpringBoot por ejemplo).

Hasta ahora hemos estado utilizando interfaces de repositorios, es la hora de crear adaptadores, estos adaptadores pueden volverse un poco más complicados cuando se usa ORM.

En este caso, crearemos la estructura y los repositorios serán mocks ya que no quiero crear la aplicación como tal, lo que me interesa que se entienda en esta capa son:

* Validar los datos que llegan desde fuera para adaptarlos a nuestro dominio.
* Entender el uso de ResumedViews para devolver solo los datos que necesitamos.
* Utilizar el tipo Either para devolver códigos de status con la traza de varios errores.

Otra cosa interesante, como mencioné antes, es el tema de adaptadores para ORMs como JPA, esta problemática la abordamos y pueden ver un video explicativo en el drive de aprendices o en el backend del proyecto de aprendices.

Una vez terminemos esta infraestructura que en su gran mayoría estará mockeada. Haré un último capítulo con el nombre de conclusiones donde planteo el mismo proyecto pero con vertical slicing que es como me gustaría aplicarlo a mí. 