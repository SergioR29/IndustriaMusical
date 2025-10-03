# PROYECTO_ORACLE
Proyecto que consiste en una BD relacional con SGBD **ORACLE** de una industria musical en la que se ha utilizado Java, PL/SQL y SQL a fondo, con ello, poniendo en práctica los conocimientos aprendidos sobre las bases de datos orientadas a objetos en su momento en el CFGS DAM.

- **_src/main/java/Main.java_**: Aquí está el módulo principal del programa a ejecutar. Por cada consulta que se elija se guardará un fichero de texto (.txt) con el resultado de la consulta.
  
- **_src/main/resources_**: En este directorio están los archivos .sql que contienen los scripts SQL y PL/SQL, los tipos e inserts necesarios para crear la BD

## TECNOLOGÍAS UTILIZADAS
Tipo de proyecto: **Maven**  
Versión SGBD: **XE 21c**  

Lenguaje de Programación: **Java** 21 y **PL/SQL**  
Entornos de Desarrollo: **Eclipse IDE** y **SQL Developer**

## DIAGRAMA DE BASE DE DATOS
<img width="1057" height="654" alt="Captura de pantalla 2025-10-03 130434" src="https://github.com/user-attachments/assets/04e4c4f0-bae6-42c2-8976-607cc33ef81c" />

## ESTRUCTURA DEL PROYECTO
│   .classpath  
│   .project  
│   pom.xml  
│   Resultado Query.txt  
│  
├───.settings  
│       org.eclipse.core.resources.prefs  
│       org.eclipse.jdt.core.prefs  
│       org.eclipse.m2e.core.prefs  
│  
├───src  
│   ├───main  
│   │   ├───java  
│   │   │       Main.java  
│   │   │  
│   │   └───resources  
│   │       ├───scripts  
│   │       │       ActualizarCancionesAlbumes.sql  
│   │       │       ActualizarCancionesBailarinesPR.sql  
│   │       │       ActualizarCategoriasPremiaciones.sql  
│   │       │       ActualizarJuradosCategorias.sql  
│   │       │       ActualizarNominacionesCategorias.sql  
│   │       │       borrarTodo.sql  
│   │       │       borrar_parte2.sql  
│   │       │  
│   │       └───tipos_e_inserts  
│   │               Inserts.sql  
│   │               Tipos.sql  
│   │  
│   └───test  
│       ├───java  
│       └───resources  
└───target  
    ├───classes  
    │   │   Main.class  
    │   │  
    │   ├───META-INF  
    │   │   │   MANIFEST.MF  
    │   │   │  
    │   │   └───maven  
    │   │       └───PROYECTORA4  
    │   │           └───PROYECTORA4_romerotejedor_sergio  
    │   │                   pom.properties  
    │   │                   pom.xml  
    │   │  
    │   ├───scripts  
    │   │       ActualizarCancionesAlbumes.sql  
    │   │       ActualizarCancionesBailarinesPR.sql  
    │   │       ActualizarCategoriasPremiaciones.sql  
    │   │       ActualizarJuradosCategorias.sql  
    │   │       ActualizarNominacionesCategorias.sql  
    │   │       borrarTodo.sql  
    │   │       borrar_parte2.sql  
    │   │  
    │   └───tipos_e_inserts  
    │           Inserts.sql  
    │           Tipos.sql  
    │  
    └───test-classes  
