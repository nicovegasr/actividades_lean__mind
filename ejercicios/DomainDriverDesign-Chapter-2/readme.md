# Domain Driver design - aplication

Ahora que tenemos nuestro modelo de dominio vamos a establecer algunas cosas:

1. Podríamos crear nuestro propios UUID de la base de datos para no depender de una base de datos.
2. Podríamos validar los datos en la capa de aplicación en vez de en nuestro dominio con los value objects.

Con esto en mente, también comentar que si tenemos más de un modelo que se relacionen, mi opinión personal
sería crear una carpeta de servicios en dominio donde se encuentren los servicios de cada modelo por separado
y luego en la capa de aplicación tener casos de uso que relacionen los servicios de cada modelo.

Por ejemplo, si un usuario tiene productos la estructura de la capa de aplicación sería:

```java
public class UseCaseSaveUser {
    private final SaveUserService saveUserService;
    private final SaveProductService saveProductService;
    
    public UseCaseSaveUser(UserRepository userRepository, ProductRepository productRepository) {
        this.saveUserService = new SaveUserService(userRepository);
        this.productRepository = new SaveProductService(productRepository);
    }

    public void saveUser(User user) {
        try {
            tx.begin();
            saveUserService.save(user);
            user.getProducts().forEach(product -> saveProductService.save(product));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }
    }
}
```

Con esto en mente, para no complicar el código y entender la estructura general, solo tendremos el caso de uso de guardar un usuario.

## Capa de aplicación

Esta capa actúa como intermediaria entre infraestructura y dominio, recibe el repositorio desde infraestructura y realiza la lógica de negocio establecida utilizando los modelos de dominio ya definidos.