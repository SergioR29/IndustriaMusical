# INDUSTRIA MUSICAL
Proyecto que consiste en una aplicación de consola con una BD relacional con SGBD **ORACLE** de una industria musical en la que se ha utilizado Java, PL/SQL y SQL a fondo, con ello, poniendo en práctica los conocimientos aprendidos sobre las bases de datos orientadas a objetos en su momento en el CFGS DAM. Este proyecto permite al usuario final consultar mucha información acerca de la industria musical.  

Se nos plantea una base de datos que almacena datos sobre la industria musical, esta almacena los datos de todas las personas involucradas en el proceso creativo. En concreto, almacena datos extra sobre los artistas (cantantes solistas o parte de un grupo), sus álbumes y sus canciones (en caso de los grupos, el cantante será el que tenga asociados los álbumes y las canciones). Por otro lado, contamos con las Academias de la Música que a lo largo del año convocan premiaciones para coronar a los mejores artistas. Cada premiación cuenta con presentaciones de algunos artistas que presentarán hasta un máximo de 3 canciones y pueden contar con un grupo de baile de hasta 12 personas. También tendrán hasta 12 invitados del mundo de la música y una serie de categorías. Las categorías tendrán un jurado de 2 miembros y un total de 3 canciones nominadas.

## ESTRUCTURA GENERAL DEL PROYECTO
<img width="357" height="250" alt="estructura_ProyectoOracle" src="https://github.com/user-attachments/assets/e6cbab3f-7887-400c-9fd7-e8ecbe5a0ea1" />  

- **_src/main/java/Main.java_**: Aquí está el módulo principal del programa a ejecutar. Por cada consulta que se elija se guardará un fichero de texto (.txt) con el resultado de la consulta en la raíz del proyecto.
  
- **_src/main/resources_**: En este directorio están los archivos .sql que contienen los scripts SQL y PL/SQL, los tipos e inserts necesarios para crear la BD.

## TECNOLOGÍAS UTILIZADAS
Tipo de proyecto: **Maven**  
Versión SGBD (**ORACLE**): **XE 21c**  

Lenguaje de Programación: **Java 21** y **PL/SQL**  
Entornos de Desarrollo: **Eclipse IDE** y **SQL Developer**

## DIAGRAMA DE BASE DE DATOS
<img width="1057" height="654" alt="Captura de pantalla 2025-10-03 130434" src="https://github.com/user-attachments/assets/04e4c4f0-bae6-42c2-8976-607cc33ef81c" />

## Más información 
Consulte la memoria de este proyecto en PDF [aquí](https://drive.google.com/file/d/1spoiqFIGesKtOsw1zZWXvK99wm2VRe-D/view?usp=sharing).
