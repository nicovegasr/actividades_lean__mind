# Algunas dudas de implementacion.


1. Los objetos de dominios deberian ser creados en el frontEnd para tener una respuesta inmediata en los campos, por ejemplo, que cuando el usuario escriba el email, el input field le diga ``El email no cumple el formato`` o que una vez dado al boton ``Sign Up `` sea el backend el que procese todo y le diga al usuario los campos que estan mal devolviendo los ``status code`` correspondientes y que sea el frontend el que los interprete
>  Tambien podria ser que al darle al boton ``Sign Up`` sea el propio front el que procese los datos y le diga al usuario si fallo en algun campo manejando los throws, no tiene porque ser una respuesta a tiempo real mientras el usuraio escribe en el formulario o una vez que cambie de foco.

**Implementacion actual:** No creare errores particulares, en los casos de uso sera un try catch con solo errores y devolviendo los mensajes correspondientes que les lleguen de los errores para luego en los controladores hacer:
```ts
async saveUser(request, response) {
  try {
    UserService.saveUser(User)
    send(200, User)
  }
  catch(Error) {
    send(400, Error as str)
  }
}
```

**Conclusion:**    Debemos validar en los dos sitios porque se puedn consumir ambos

2. ¿Los errores en dominio deberian usarse? ¿Es recomendable crear una carpeta ErrorHandlers para personalizar mis propios errores en dominio?
 
**Conclusion:**  se hacen throws desde dominio y se manejan en infraestructuras. En algunos casos con infraestructuras variables se hacen handle de infr a alpicacion y  de aplicacion a dominio

**Matiz**: Los errores lanzados desde domino deberian encapsularse luego en la parte de casos de usos en errores propios para tener mas claro porque falla la aplicacion.

3. ¿La lógica de si el usuario existe debe ser guardado o no debe ir en el repository o en el servicio? 

**Conclusion:**  En el caso de uso. Si es una decision de negocio tiene que estar en el caso de uso, el repositorio solo se ocupa de cosas de la base de datos.

---

Anotaciones: A la hora de trabajar con base de datos hay una parte de transacciones donde hay que tener en cuenta el tema de rollback y de abrir transacciones de guardado, si se hace un save y se corrompe la base de datos a pelo no hay rollback y se complica todo.