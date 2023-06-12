# TODO-APP-RecyclerView
Proyecto de una **App TODO** para organizar tareas por categorías, utilizando **RecyclerView** para su diseño y desarrollo.

Es una de las prácticas propuestas en el curso de [ANDROID CON KOTLIN de AristiDevs](https://youtu.be/vJapzH_46a8) el cual es gratis y si prefieres consumir más de su contenido, puedes visitar su [canal de YouTube:](https://www.youtube.com/@AristiDevs)

# Tecnologías Utilizadas
- Kotlin
- Sealed Class
- Data Class
- Funciones Lambdas
- Diseño basado en XML
  - RecyclerView
  - LinearLayout

# Funcionalidad
La app está compuesta por una sola vista y un dialog para agregar nuevas tareas:

- **Vista principal:** Muestra un texto de saludo, las **Categorías (*Negocios, Personal y Otros*)** y las **Tareas** creadas por el usuario. Además de un botón, para agregar una **Nueva tarea**.<br>
<p align="center">
      <img width="20%" src="https://i.postimg.cc/g0ysTQ9P/Screenshot-1.png">
  </p>

- **Nueva tarea (Dialog):** Permite crear una nueva tarea, colocándole un nombre y seleccionando su categoría, ambos campos obligatorios.<br>
<p align="center">
      <img width="20%" src="https://i.postimg.cc/D00cmzS2/Screenshot-2.png">
  </p>


La aplicación permite **"marcar"** la tarea que se considere completada o **"desmarcarla"** en caso contrario, presionando encima de ella o en su casilla correspondiente.<br>
<p align="center">
      <img width="20%" src="https://i.postimg.cc/QCzJ7r7c/Screenshot-3.png">
  </p>

También permite **filtrar** por categorías las tareas a mostrar en pantalla, **"activando"** o **"desactivando"** el nombre de la categoría, para las tareas que se deseen **mostrar** u **ocultar**, respectivamente.

Para esto basta con presionar sobre la categoría deseada:

- **"Activada":** Se mostrará de un color en tonalidad **<span style="color: rgba(8,26,74,1)">azul marino</span>**  y automáticamente se **muestran** las tareas pertenecientes a esta categoría.
- **"Desactivada"**: Se mostrará de un color en tonalidad **<span style="color:#787878">gris</span>** y automáticamente se **ocultan** las tareas pertenecientes a esta categoría.<br>


<p align="center">
      <img style="margin-right:60px" width="20%" src="https://i.postimg.cc/ydVj4jB3/Screenshot-4.png">
      <img width="20%" src="https://i.postimg.cc/63Y09Z5j/Screenshot-5.png">
  </p>

**Nota:** El valor por defecto de las categorías al iniciar la aplicación,  es **"Activada"**, mostrando todas las tareas existentes.

# Enlaces
- [ANDROID CON KOTLIN de AristiDevs](https://youtu.be/vJapzH_46a8)
- [Canal de YouTube de AristiDevs](https://www.youtube.com/@AristiDevs)