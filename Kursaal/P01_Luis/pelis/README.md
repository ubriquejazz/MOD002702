# Base de Datós de Pelí culas

## CineDB
### Atributos
conn, de tipo Connection (java.sql.Connection)

### Constructor
Un constructor al que le pasamos un String con el nombre del fichero de base de datos y nos abre la conexión con la base de datos para poder realizar consultas.

### Métodos
- int insertaPelicula(String titulo, int anno, boolean tieneOscar, double valoracion), nos inserta una película en la base de datos con los datos proporcionados. El método devolverá un int que será el id de la película que insertamos (con “SELECT last_insert_rowid();” podemos obtenerlo en SQLite).

- int insertaActor(String nombre, LocalDate fechaNacimiento) nos inserta un actor en la base de datos y nos devuelve un int con el id del actor.

- asociaActorPelicula(int idActor, int idPelicula, boolean principal) nos asocia una película con un actor insertando el registro correspondiente en la tabla actoresPeliculas.

- int buscaActor(String nombre) nos busca el actor en la base de datos y
nos devuelve su id (o -1 si no lo encontramos).

- int buscaPelicula(String titulo) nos busca la película en la base de datos
y nos devuelve su id (o -1 si no la encontramos).

- Pelicula datosPelicula(int idPelicula) nos devuelve los datos de una
película pasándole el id.

- Actor datosActor(int idActor) nos devuelve los datos de un actor
pasándole el id.

- List<Pelicula> listadoPeliculas() nos devuelve un listado de todas las
películas que hay en la base de datos.

- List<Actor> listadoActores() nos devuelve un listado de todos los
actores que hay en la base de datos.

- List<Pelicula> listadoPeliculasPorActores(int idActor) nos devuelve un
listado de todas las películas en las que aparece un actor.

- List<ActorPelicula> listadoActoresPorPelicula(int idPelicula) nos devuelve un listado de todos los actores que salen en una película, incluyendo la información de si es principal o no en esa película.

---

Para estos últimos métodos de la clase CineDB, necesitaremos un par de clases que contengan
los datos de un actor y una película. Como sólo los vamos a usar para esto, van a ser muy simples:

```
public class Pelicula {
    public int id;
    public String titulo;
    public int anno;
    public boolean tieneOscar;
    public double valoracion;
}
public class Actor {
    public int id;
    public String nombre;
    public LocalDate fechaNacimiento;
}
public class ActorPelicula {
    public int id;
    public String nombre;
    public LocalDate fechaNacimiento;
    public boolean principal;
}
```

Una vez montada toda nuestra estructura de clases, tendremos que hacer un programa en el
main para gestionar nuestra base de datos. El programa contará con las siguientes opciones:

- Insertar una película: primero se pedirán los datos de la película y se introducirán en la
base de datos y luego se añadirán los actores que participarán en la película. Para esto, se le podrá dar al usuario la opción de elegir un actor que ya está en la base de datos o insertar uno nuevo.
- Listado de todas las películas.
- Listado de todos los actores.
- Listado de todas las películas de un actor: se le pedirá al usuario el nombre del actor y
se buscará su id en la base de datos. Después se sacará un listado de todas las películas
de este actor.
- Información de una película: se mostrarán todos los datos de una películas, incluyendo
todos los actores que participan en ella, listando primero los actores principales.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
