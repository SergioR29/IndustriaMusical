import java.io.*;
import java.sql.*;
import java.util.*;

public class Main {
	private static Connection con;
	private static Scanner sc = new Scanner(System.in, "UTF-8");
	private static String resultado_Query = "";

	public static void main(String[] args) {
		abrirConexion();
		elegirConsulta();
		cerrarConexion();
	}
	
	private static void elegirConsulta() {
		int opcion = -1;
		while(opcion != 0) {
			System.out.println("\n\nElige entre las siguientes consultas: (Puede ver el resultado de la consulta en 'Resultado Query.txt')\n");
			System.out.println("1. Todos los artistas y sus países de procedencia.");
			System.out.println("2. Información de todas las personas que son bailarines.");
			System.out.println("3. Nombre de todos los álbumes y su duración total.");
			System.out.println("4. Mostrar el álbum con el ranking más alto.");
			System.out.println("5. Artistas, el año de lanzamiento de su primer álbum, y su género recurrente agrupados "
					+ "por grupo (si pertenecen a uno).");
			System.out.println("6. Mostrar los álbumes y su fecha de publicación ordenado por artista y fecha.");
			System.out.println("7. Obtén la letra, el nombre de la canción y el nombre del álbum de todas las canciones "
					+ "principales de ‘Carlos’ o ‘Laura’.");
			System.out.println("8. Obtén todas las canciones en las que ha colaborado ‘Alberto’.");
			System.out.println("9. Canciones y sus letras, junto con el álbum y el ranking máximo alcanzado por el "
					+ "álbum del grupo ‘Solas’.");
			System.out.println("10. Encontrar las canciones que son sencillos y pertenecen a álbumes con un ranking "
					+ "máximo en el top 5.");
			System.out.println("11. Obtener los artistas con más de un álbum publicado y el total de álbumes que tienen.");
			System.out.println("12. Listar los premios musicales que se van a llevar a cabo este año en orden por fecha.");
			System.out.println("13. Jurados asignados a cada categoría.");
			System.out.println("14. Todos los premios musicales y la cantidad de en efectivo que dan.");
			System.out.println("15. Ver todas las presentaciones de los premios Experimentales ordenadas por orden actuación.");
			System.out.println("16. Ve todas las canciones de cada presentacion de los premios Sol ordenadas por orden alfabético del artista.");
			System.out.println("17. Ver aquellos artistas que son parte de un grupo ordenados por orden alfabético los grupos y dentro del grupo ordenado por apellido.");
			System.out.println("18. Listar los premios a los que ha sido invitado y ha aparecido como jurado la persona con id 24. (Muestra el nombre de los premios y el nombre de la categoría).");
			System.out.println("19. Premios, sus categorías, y el ganador de cada categoría. (Si no hay ganador se muestra el mensaje “No se ha decidido ganador”).");
			System.out.println("20. Canción más nominada en cada premio, cantidad de nominaciones y artista principal.(Si hay más de una con la misma cantidad de nominaciones se muestran todas).");
			System.out.println("21. Premios en los que los bailarines de id 13 y 10 han participado juntos.");
			System.out.println("22. Obtener el artista más ganador en los premios de la academia 'Academia Española de Música'.");
			System.out.println("23. Listar los álbumes con más de 3 canciones nominadas (puede ser la misma, más de una vez).");
			System.out.println("24. Obtener todas las nominaciones de MissCaffeina.");
			
			System.out.print("\nElige consulta: ");
			try {
				opcion = sc.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("\tOpción inválida.\n");
				opcion = -1;
				sc.nextLine();
			}
			
			switch(opcion) {
			case 1:
				resultado_Query += "Consulta realizada: Todos los artistas y sus países de procedencia.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta1();
				generarInforme();
				
				break;
			case 2:
				resultado_Query += "Consulta realizada: Información de todas las personas que son bailarines.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta2();
				generarInforme();
				
				break;
			case 3:
				resultado_Query += "Consulta realizada: Nombre de todos los álbumes y su duración total.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta3();
				generarInforme();
				
				break;
			case 4:
				resultado_Query += "Consulta realizada: Mostrar el álbum con el ranking más alto.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta4();
				generarInforme();
				
				break;
			case 5:
				resultado_Query += "Consulta realizada: Artistas, el año de lanzamiento de su primer álbum, y su género recurrente agrupados por grupo (si pertenecen a uno).\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta5();
				generarInforme();
				
				break;
			case 6:
				resultado_Query += "Consulta realizada: Mostrar los álbumes y su fecha de publicación ordenado por artista y fecha.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta6();
				generarInforme();
				
				break;
			case 7:
				resultado_Query += "Consulta realizada: Obtén la letra, el nombre de la canción y el nombre del álbum de todas las canciones principales de ‘Carlos’ o ‘Laura’.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta7();
				generarInforme();
				
				break;
			case 8:
				resultado_Query += "Consulta realizada: Obtén todas las canciones en las que ha colaborado ‘Alberto’.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta8();
				generarInforme();
				
				break;
			case 9:
				resultado_Query += "Consulta realizada: Canciones y sus letras, junto con el álbum y el ranking máximo alcanzado por el álbum del grupo ‘Solas’.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta9();
				generarInforme();
				
				break;
			case 10:
				resultado_Query += "Consulta realizada: Encontrar las canciones que son sencillos y pertenecen a álbumes con un ranking máximo en el top 5.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta10();
				generarInforme();
				
				break;
			case 11:
				resultado_Query += "Consulta realizada: Obtener los artistas con más de un álbum publicado y el total de álbumes que tienen.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta11();
				generarInforme();
				
				break;
			case 12:
				//2ºBloque
				resultado_Query += "Consulta realizada: Listar los premios musicales que se van a llevar a cabo este año en orden por fecha.\n\n"
						+ "------------------------------------------------------------\n\n";
				
				consulta12();
				generarInforme();
				
				break;
			case 13:
				resultado_Query += "Consulta realizada: Jurados asignados a cada categoría.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta13();
				generarInforme();
				
				break;
			case 14:
				resultado_Query += "Consulta realizada: Todos los premios musicales y la cantidad de en efectivo que dan.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta14();
				generarInforme();
				
				break;
				
			case 15:
				resultado_Query += "Consulta realizada: Ver todas las presentaciones de los premios Experimentales ordenadas por orden actuación.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta15();
				generarInforme();
				
				break;
			case 16:
				resultado_Query += "Consulta realizada: Ver todas las canciones de cada presentacion de los premios Sol ordenadas por orden alfabético del artista.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta16();
				generarInforme();
				
				break;
			case 17:
				resultado_Query += "Consulta realizada: Ver aquellos artistas que son parte de un grupo ordenados por orden alfabético los grupos y dentro del grupo ordenado por apellido.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta17();
				generarInforme();
				
				break;
			case 18:
				resultado_Query += "Consulta realizada: Listar los premios a los que ha sido invitado y ha aparecido como jurado la persona con id 24. (Muestra el nombre de los premios y el nombre de la categoría).\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta18();
				generarInforme();
				
				break;
			case 19:
				resultado_Query += "Consulta realizada: Premios, sus categorías, y el ganador de cada categoría. (Si no hay ganador se muestra el mensaje “No se ha decidido ganador”).\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta19();
				generarInforme();
				
				break;
			case 20:
				resultado_Query += "Consulta realizada: Canción más nominada en cada premio, cantidad de nominaciones y artista principal.(Si hay más de una con la misma cantidad de nominaciones se muestran todas).\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta20();
				generarInforme();
				
				break;
			case 21:
				resultado_Query += "Consulta realizada: Premios en los que los bailarines de id 13 y 10 han participado juntos.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta21();
				generarInforme();
				
				break;
			case 22:
				resultado_Query += "Consulta realizada: Obtener el artista más ganador en los premios de la academia 'Academia Española de Música'.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta22();
				generarInforme();
				
				break;
			case 23:
				resultado_Query += "Consulta realizada: Listar los álbumes con más de 3 canciones nominadas (puede ser la misma, más de una vez).\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta23();
				generarInforme();
				
				break;
			case 24:
				resultado_Query += "Consulta realizada: Obtener todas las nominaciones de MissCaffeina.\n\n"
						+ "------------------------------------------------------------\n\n";
				consulta24();
				generarInforme();
				
				break;
			default:
				if(opcion > 24 || opcion < 0)
				System.out.println("\tOpción inválida.\n");
			}
			resultado_Query = "";
		}
	}
	
	private static void consulta24() {
		//Consulta 24.
		String sql = "SELECT C.NOMBRE, C.NOMBRE_PREMIACION FROM CATEGORIAS C, TABLE(C.NOMINADAS) CN WHERE DEREF(CN.ID_CANCION.ID_ARTISTA).GRUPO_NOMBRE = 'Miss Caffeina'";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			resultado_Query += "MissCaffeina ha estado nominado en:\n";
			while(resultSet.next()) {
				resultado_Query += "- " + resultSet.getString(1) + " de los premios " + resultSet.getString(2) + "\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta23() {
		//Consulta 23.
		String sql = "SELECT A.ID, A.NOMBRE, DEREF(A.AUTOR).NOMBRE FROM ALBUMES A";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				int ID_Album = resultSet.getInt(1);
				String nombre_Album = resultSet.getString(2);
				String autor = resultSet.getString(3);
				
				sql = "SELECT COUNT(*) AS NS FROM NOMINACIONES N WHERE DEREF(N.ID_CANCION).ID_ALBUM = ?";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, ID_Album);
				
				ResultSet subResultSet = statement.executeQuery();
				while(subResultSet.next()) {
					int nominaciones = subResultSet.getInt(1);
					if(nominaciones >= 3) {
						resultado_Query += nombre_Album + " de " + autor + " tiene " + nominaciones + " con las canciones:\n";
						
						sql = "SELECT DEREF(N.ID_CANCION).TITULO FROM NOMINACIONES N WHERE DEREF(N.ID_CANCION).ID_ALBUM = ?";
						PreparedStatement subPreparedStatement = con.prepareStatement(sql);
						subPreparedStatement.setInt(1, ID_Album);
						
						ResultSet subResultSet2 = subPreparedStatement.executeQuery();
						while(subResultSet2.next()) {
							resultado_Query += "- " + subResultSet2.getString(1) + "\n";
						}
						resultado_Query += "\n";
					}
				}
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta22() {
		//Consulta 22.
		String sql = "SELECT DEREF(C.GANADOR).NOMBRE, COUNT(DEREF(C.GANADOR).NOMBRE) AS MAX_GN FROM CATEGORIAS C WHERE DEREF(C.ACADEMIA_).NOMBRE = 'Academia Esp. de Música' AND LENGTH(DEREF(C.GANADOR).NOMBRE) > 0 GROUP BY DEREF(C.GANADOR).NOMBRE ORDER BY MAX_GN DESC";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			int premios = 0, max_Premios = 0;
			String ganador_anterior = "";
			while(resultSet.next()) {
				String ganador = resultSet.getString(1);
				premios = resultSet.getInt(2);
				
				if(premios > max_Premios) {
					max_Premios = premios;
					resultado_Query += "El artista más ganador de la academia 'Academia Española de Música' es " + ganador + " con " + max_Premios + " premios.\n";
					
				}
				else if(premios == max_Premios && !ganador_anterior.equals(ganador)) {
					resultado_Query += "El artista más ganador de la academia 'Academia Española de Música' es " + ganador + " con " + max_Premios + " premios.\n";
				}
					
				ganador_anterior = ganador;
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta21() {
		//Consulta 21.
		String[] bailarines = NombresBailarines();
		try {
			if(bailarines.length == 2) {
				String bailarin13 = bailarines[0];
				String bailarin10 = bailarines[1];
				
				String sql = "SELECT DISTINCT(DEREF(P.PREMIO).NOMBRE) FROM PRESENTACIONES P, TABLE(P.GRUPO_BAILE) B WHERE (DEREF(B.ID_PERSONA).ID = 13 OR DEREF(B.ID_PERSONA).ID = 10) AND LENGTH(DEREF(P.PREMIO).NOMBRE) > 0";
				Statement st = con.createStatement();
				ResultSet resultSet = st.executeQuery(sql);
				
				resultado_Query += bailarin13 + " y " + bailarin10 + " han participado en los premios\n";
				String[] premios = {};
				while(resultSet.next()) {
					premios = Arrays.copyOf(premios, premios.length+1);
					premios[premios.length-1] = resultSet.getString(1);
				}
				for(int i = 0; i < premios.length; i++) {
					if(i == premios.length - 1) {
						resultado_Query += " y " + premios[i] + " juntos.";
					}
					if(i == premios.length - 2) {
						resultado_Query += premios[i];
					}
					if(i < premios.length - 2) {
						resultado_Query += premios[i] + ", ";
					}
				}
				System.out.println(resultado_Query);
			} else {
				resultado_Query += "Los bailarines 13 y 10 no han participado juntos.";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String[] NombresBailarines() {
		//Consulta 21.
		String[] bailarines = {};
		String sql = "SELECT P.NOMBRE FROM PERSONAS P WHERE P.ID = 13 OR P.ID = 10 ORDER BY P.ID DESC";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				bailarines = Arrays.copyOf(bailarines, bailarines.length + 1);
				bailarines[bailarines.length-1] = resultSet.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return bailarines;
	}

	private static void consulta20() {
		//Consulta 20.
		String sql = "SELECT DISTINCT(C.NOMBRE_PREMIACION) FROM CATEGORIAS C";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				String premiacion = resultSet.getString(1);
				
				sql = "SELECT DISTINCT(DEREF(N.ID_CANCION).TITULO), DEREF(N.ID_CANCION.ID_ARTISTA).NOMBRE, COUNT(*) AS NS FROM CATEGORIAS C, TABLE(C.NOMINADAS) N WHERE C.NOMBRE_PREMIACION = ? GROUP BY DEREF(N.ID_CANCION).TITULO, DEREF(N.ID_CANCION.ID_ARTISTA).NOMBRE ORDER BY NS DESC";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, premiacion);
				
				ResultSet subResultSet = statement.executeQuery();
				String cancion = "";
				String cancion_anterior = "";
				String artista = "";
				int max_Nominaciones = 0;
				int nominaciones = 0;
				while(subResultSet.next()) {
					cancion = subResultSet.getString(1);
					artista = subResultSet.getString(2);
					nominaciones = subResultSet.getInt(3);
					
					if(nominaciones > max_Nominaciones) {
						max_Nominaciones = nominaciones;
						resultado_Query += premiacion + ": " + cancion + " (" + artista + ") " + max_Nominaciones + "\n";
					}
					else if(nominaciones == max_Nominaciones && !cancion_anterior.equals(cancion)) {
						resultado_Query += premiacion + ": " + cancion + " (" + artista + ") " + max_Nominaciones + "\n";
					}
					
					cancion_anterior = cancion;
				}
				
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta19() {
		//Consulta 19.
		String sql = "SELECT P.NOMBRE, C.NOMBRE, DEREF(C.GANADOR).NOMBRE FROM PREMIACIONES P, TABLE(P.CATEGORIAS_TABLA) C";
		String premio_anterior = "";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				String premio = resultSet.getString(1);
				if(!premio.equals(premio_anterior)) {
					resultado_Query += premio + ":\n";
				}
				String ganador = resultSet.getString(3);
				if(ganador != null && ganador.length() > 0) resultado_Query += "- " + resultSet.getString(2) + ": " + ganador + "\n";
				else resultado_Query += "- " + resultSet.getString(2) + ": No se ha decidido ganador\n";
			
				premio_anterior = premio;
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta18() {
		//Consulta 18.
		String sql = "SELECT DISTINCT(DEREF(I.PREMIOS).NOMBRE), C.NOMBRE FROM INVITADOS I, JURADOS J, TABLE(DEREF(I.PREMIOS).CATEGORIAS_TABLA) C WHERE DEREF(I.ID_PERSONA).ID = 24 AND DEREF(J.ID_PERSONA).ID = 24";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				resultado_Query += resultSet.getString(1) + " - " + resultSet.getString(2) + "\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta17() {
		//Consulta 17.
		String grupo_anterior = "";
		
		String sql = "SELECT A.ID, A.GRUPO_NOMBRE, (SELECT AP.COLUMN_VALUE FROM TABLE(A.APELLIDOS_) AP WHERE ROWNUM = 1) AS APELLIDO FROM ARTISTAS A WHERE LENGTH(A.GRUPO_NOMBRE) > 0 ORDER BY A.GRUPO_NOMBRE, APELLIDO";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				int ID_Artista = resultSet.getInt(1);
				String grupo = resultSet.getString(2);
				if(!grupo.equals(grupo_anterior)) {
					resultado_Query += "\n" + grupo + ":\n";
				}
				sql = "SELECT A.NOMBRE, A.PROFESION, (SELECT AP.COLUMN_VALUE FROM TABLE(A.APELLIDOS_) AP WHERE ROWNUM = 1) AS APELLIDO FROM ARTISTAS A WHERE LENGTH(A.GRUPO_NOMBRE) > 0 AND A.GRUPO_NOMBRE = ? AND A.ID = ? ORDER BY A.GRUPO_NOMBRE, APELLIDO";
				PreparedStatement pSt = con.prepareStatement(sql);
				pSt.setString(1, grupo);
				pSt.setInt(2, ID_Artista);
				
				ResultSet subResultSet = pSt.executeQuery();
				while(subResultSet.next()) {
					String apellido = subResultSet.getString(3);
					resultado_Query += apellido + ", " + subResultSet.getString(1) + " (" + subResultSet.getString(2) + ")\n";
				}
				grupo_anterior = grupo;
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta16() {
		//Consulta 16.
		String sql = "SELECT P.ID_ARTISTA.NOMBRE FROM PRESENTACIONES P WHERE P.PREMIO.NOMBRE = 'Premios Sol' ORDER BY P.ID_ARTISTA.NOMBRE";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				String nombre_Artista = resultSet.getString(1);
				resultado_Query += nombre_Artista + ":\n";
				
				sql = "SELECT DEREF(PC.CANCION_P).TITULO FROM PRESENTACIONES P, TABLE(P.CANCIONES) PC WHERE P.PREMIO.NOMBRE = 'Premios Sol' AND P.ID_ARTISTA.NOMBRE = ? ORDER BY P.ID_ARTISTA.NOMBRE";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, nombre_Artista);
				ResultSet subResultSet = statement.executeQuery();
				
				int contador = 1;
				while(subResultSet.next()) {
					resultado_Query += (contador++) + ". " + subResultSet.getString(1) + "\n";
				}
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta15() {
		//Consulta 15.
		String sql = "SELECT P.ORDEN_ACTUACION, DEREF(P.ID_ARTISTA).NOMBRE, P.DURACION, P.ATREZZO FROM PRESENTACIONES P WHERE DEREF(P.PREMIO).NOMBRE = 'Premios Experimentales' ORDER BY ORDEN_ACTUACION";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			System.out.println("Premios Experimentales");
			while(resultSet.next()) {
				resultado_Query += resultSet.getInt(1) + " . " + resultSet.getString(2) + " (" + String.format("%2.2f", resultSet.getFloat(3)) + ") " + resultSet.getClob(4).getSubString( 1, (int) resultSet.getClob(4).length()) + "\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta14() {
		//Consulta 14.
		String sql = "SELECT C.NOMBRE_PREMIACION, SUM(C.PREMIO_EFECTIVO) FROM CATEGORIAS C GROUP BY C.NOMBRE_PREMIACION";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				resultado_Query += resultSet.getString(1) + " : " + resultSet.getFloat(2) + " €\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta13() {
		//Consulta 13.
		String sql = "SELECT P.NOMBRE FROM PREMIACIONES P";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				String nombre_Premio = resultSet.getString(1);
				resultado_Query += nombre_Premio + ":\n";
				
				sql = "SELECT PC.NOMBRE FROM PREMIACIONES P, TABLE(P.CATEGORIAS_TABLA) PC WHERE P.NOMBRE = ?";
				PreparedStatement subStatement = con.prepareStatement(sql);
				subStatement.setString(1, nombre_Premio);
				
				ResultSet subResultSet = subStatement.executeQuery();
				while(subResultSet.next()) {
					String nombre_Categoria = subResultSet.getString(1);
					resultado_Query += "\t" + nombre_Categoria + ":\n";
					
					obtenerJuradosCategoria(nombre_Premio, nombre_Categoria);
				}
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void obtenerJuradosCategoria(String nombre_Premio, String nombre_Categoria) {
		String sql = "SELECT DEREF(J.ID_PERSONA).NOMBRE, DEREF(J.ID_PERSONA).PROFESION FROM PREMIACIONES P, TABLE(P.CATEGORIAS_TABLA) PC, TABLE(PC.JURADOS) J WHERE P.NOMBRE = ? AND PC.NOMBRE = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nombre_Premio);
			st.setString(2, nombre_Categoria);
			
			ResultSet resultSet = st.executeQuery();
			while(resultSet.next()) {
				resultado_Query += "\t- " + resultSet.getString(1) + " (" + resultSet.getString(2) + ")\n";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta12() {
		//Consulta 12 (2ºBloque).
		
		String sql = "SELECT P.NOMBRE, P.FECHA_EVENTO FROM PREMIACIONES P ORDER BY P.FECHA_EVENTO";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				resultado_Query += resultSet.getString(1) + " (" + resultSet.getDate(2).toString() + ")\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta11() {
		//Consulta 11.
		String sql = "SELECT DISTINCT(A.AUTOR.NOMBRE), A.AUTOR.GRUPO_NOMBRE FROM ALBUMES A WHERE (SELECT COUNT(*) FROM ALBUMES A2 WHERE A.AUTOR = A2.AUTOR) > 1";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				String nombre = resultSet.getString(1);
				int albumes_Publicados = albumesPublicados(nombre);
				
				String grupo = resultSet.getString(2);
				if(grupo == null) {
					resultado_Query += nombre + " - " + albumes_Publicados + "\n";
				} else {
					resultado_Query += nombre + "/";
					resultado_Query += grupo + " - " + albumes_Publicados + "\n";
				}
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static int albumesPublicados(String nombre) {
		String sql = "SELECT COUNT(A.ID) FROM ALBUMES A WHERE A.AUTOR.NOMBRE = ?";
		int albumes = 0;
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, nombre);
			
			ResultSet resultSet = st.executeQuery();
			while(resultSet.next()) {
				albumes = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albumes;
	}

	private static void consulta10() {
		//Consulta 10.
		
		String sql = "SELECT C.TITULO, A.NOMBRE, A.RANKING_MAX FROM CANCIONES C, ALBUMES A WHERE C.SINGLE = 1 AND C.ID_ALBUM = A.ID AND (A.RANKING_MAX >= 1 AND RANKING_MAX <= 5)";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				resultado_Query += "\t" + resultSet.getString(1) + " (" + resultSet.getString(2) + " - " + resultSet.getInt(3) + ")\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta9() {
		//Consulta 9.
		
		String sql = "SELECT A.NOMBRE, A.RANKING_MAX, ACS.TITULO, ACS.LETRA FROM ALBUMES A, TABLE(A.CANCIONES_ALB) ACS WHERE ACS.ID_ARTISTA.GRUPO_NOMBRE = 'Solas'";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			String nombre_anterior = "";
			String nombre = "";
			while(resultSet.next()) {
				nombre = resultSet.getString(1);
				
				if(!nombre_anterior.equals(nombre)) {
					resultado_Query += "\n" + nombre + " : " + resultSet.getInt(2) + "\n";
				}
				resultado_Query += resultSet.getString(3) + " : " + resultSet.getString(4) + "\n";
				nombre_anterior = resultSet.getString(1);
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta8() {
		//Consulta 8.
		
		String sql = "SELECT C.TITULO, C.ID_ARTISTA.ID, C.ID_ARTISTA.NOMBRE FROM CANCIONES C WHERE C.COLABORADOR.NOMBRE = 'Alberto'";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				resultado_Query += resultSet.getString(1) + " (" + resultSet.getInt(2) + ", " + resultSet.getString(3) + ")\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta7() {
		//Consulta 7.
		
		String sql = "SELECT C.TITULO, C.LETRA, A.NOMBRE FROM CANCIONES C, ALBUMES A WHERE A.ID = C.ID_ALBUM AND (C.ID_ARTISTA.NOMBRE = 'Carlos')";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			resultado_Query += "Canciones principales de Carlos\n";
			while(resultSet.next()) {
				resultado_Query += resultSet.getString(1) + " : " + resultSet.getString(2) + " / " + resultSet.getString(3) + "\n";
			}
			
			sql = "SELECT C.TITULO, C.LETRA, A.NOMBRE FROM CANCIONES C, ALBUMES A WHERE A.ID = C.ID_ALBUM AND (C.ID_ARTISTA.NOMBRE = 'Laura')";
			resultSet = st.executeQuery(sql);
			
			resultado_Query += "\nCanciones principales de Laura\n";
			while(resultSet.next()) {
				resultado_Query += resultSet.getString(1) + " : " + resultSet.getString(2) + " / " + resultSet.getString(3) + "\n";
			}
			
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta6() {
		//Consulta 6.
		
		String sql = "SELECT A.AUTOR.ID, A.AUTOR.NOMBRE, A.AUTOR.GRUPO_NOMBRE, A.ID, A.FECHA_PUBLICACION FROM ALBUMES A ORDER BY A.AUTOR.ID, A.FECHA_PUBLICACION";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			String nombre_anterior = "";
			String nombre_Art = "";
			String grupo_anterior = "";
			String grupo = "";
			while(resultSet.next()) {
				grupo = resultSet.getString(3);
				nombre_Art = resultSet.getString(2);
				
				if(grupo == null) {
					if(!nombre_anterior.equals(nombre_Art))
					resultado_Query += "Artista: " + resultSet.getInt(1) + ", " + nombre_Art + "\n";
				} else {
					if(!grupo_anterior.equals(grupo))
					resultado_Query += "Grupo: " + grupo + "\n";
				}
				resultado_Query += "Álbum " + resultSet.getInt(4) + ": " + resultSet.getDate(5) + "\n";
				
				nombre_anterior = nombre_Art;
				grupo_anterior = grupo == null ? "" : grupo;
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta5() {
		//Consulta 5.
		
		String sql = "SELECT ID, NOMBRE, GRUPO_NOMBRE, ANYO_LANZAMIENTO_PRIMER_ALBUM, GENERO_RECURRENTE FROM ARTISTAS";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			//1º) Mostramos los artistas sin grupo para que no se nos complique el proceso y así poder mostrar luego más fácilmente los artistas vinculados a un grupo (se mostrará)
			while(resultSet.next()) {
				int ID_Artista = resultSet.getInt(1);
				String apellidos = obtenerApellidosPersona(ID_Artista);
				
				String grupo = resultSet.getString(3);
				if(grupo == null) {
					resultado_Query += "\tArtista " + ID_Artista + ": " + resultSet.getString(2) + " " + apellidos + " (" + resultSet.getInt(4) + ") " + resultSet.getString(5) + "\n";
				}
			}
			//2º) Ya podemos mostrar los artistas vinculados a un grupo
			sql = "SELECT DISTINCT(A.GRUPO_NOMBRE), A.ANYO_LANZAMIENTO_PRIMER_ALBUM, A.GENERO_RECURRENTE FROM ARTISTAS A";
			resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				String grupo = resultSet.getString(1);
				if(grupo != null) resultado_Query += "\n" + grupo + " (" + resultSet.getInt(2) + ") " + resultSet.getString(3) + "\n";
				
				sql = "SELECT ID, NOMBRE FROM ARTISTAS WHERE GRUPO_NOMBRE = ?";
				PreparedStatement st2 = con.prepareStatement(sql);
				st2.setString(1, grupo);
				
				ResultSet resultSet2 = st2.executeQuery();
				while(resultSet2.next()) {
					int ID_Artista = resultSet2.getInt(1);
					String apellidos = obtenerApellidosPersona(ID_Artista);
					resultado_Query += "\tArtista " + ID_Artista + ": " + resultSet2.getString(2) + " " + apellidos + "\n";
				}
			}
			
			System.out.println(resultado_Query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta4() {
		//Consulta 4.
		
		String sql = "SELECT A.NOMBRE, A.RANKING_MAX FROM ALBUMES A WHERE A.RANKING_MAX = (SELECT MIN(AMAX.RANKING_MAX) FROM ALBUMES AMAX)";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				resultado_Query += "Album: " + resultSet.getString(1) + " - " + resultSet.getInt(2) + "\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta3() {
		/*Consulta 3.*/
		
		String sql = "SELECT A.NOMBRE, SUM(FLOOR(ACS.DURACION)*60 + MOD(ACS.DURACION, 1)*60)/60 FROM ALBUMES A, TABLE(A.CANCIONES_ALB) ACS GROUP BY A.NOMBRE";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				Double duracion_valor = resultSet.getDouble(2);
				Integer minutos = duracion_valor.intValue();
				Double segundos_decimal = duracion_valor - minutos;
				
				Double segundos = 0.0;
				String duracion = "";
				if(segundos_decimal >= 0.6) {
					segundos = segundos_decimal * 60;
					segundos = Math.floor(segundos); //Redondeo los segundos
					
					duracion = minutos.intValue() + "." + String.format("%02d", segundos.intValue());
				} else {
					segundos = segundos_decimal;
					
					String segundos_formateados = String.format("%,2f", segundos);
					duracion = minutos.intValue() + "." + segundos_formateados.substring(2, 4); //Cogo los caracteres adecuados de la parte decimal de los segundos
				}
				resultado_Query += "Álbum: " + resultSet.getString(1) + " : " + duracion + "\n";
			}
			System.out.println(resultado_Query);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void consulta2() {
		/*Consulta 2.*/
		
		String sql = "SELECT p.id, p.nombre, p.fecha_nac, p.dir.calle AS calle, p.dir.numero AS numero, p.dir.ciudad AS ciudad, p.dir.pais AS pais FROM personas p WHERE p.profesion = 'Bailarín'";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			System.out.println("Bailarines:");
			while(resultSet.next()) {
				int ID_Persona = resultSet.getInt(1);
				String apellidos = obtenerApellidosPersona(ID_Persona);
				
				resultado_Query += resultSet.getString(2) + " " + apellidos + ", " + resultSet.getDate(3).toString() + ", " + resultSet.getString(4) + " Nº" + resultSet.getInt(5) + ", " + resultSet.getString(6) + ", " + resultSet.getString(7) + "\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String obtenerApellidosPersona(int iD_Persona) {
		//Método con el que obtenemos los apellidos de una persona de ID correspondiente.
		
		String sql = "SELECT a.COLUMN_VALUE FROM personas p, TABLE(p.apellidos_) a WHERE p.ID = ?";
		String apellidos = "";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, iD_Persona);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				apellidos += rs.getString(1) + " ";
				
				//Al final del método sobreescribimos la variable apellidos para omitir su último espacio.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		apellidos = apellidos.substring(0, apellidos.length()-1);
		return apellidos;
	}

	private static void generarInforme() {
		/*Método para generar el resultado de la consulta.*/
		
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File("Resultado Query.txt")))) {
			bWriter.write(resultado_Query);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void consulta1() {
		/*Consulta 1.*/
		
		String sql = "SELECT NOMBRE, PAIS_PROCEDENCIA FROM ARTISTAS";
		try {
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()) {
				resultado_Query += resultSet.getString(1) + " proviene de " + resultSet.getString(2) + "\n";
			}
			System.out.println(resultado_Query);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	static void abrirConexion() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "PROYECTO_RA4", "PROYECTO_RA4");
			System.out.println("Conexión OK\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void cerrarConexion() {
		try {
			System.out.println("\nConexión cerrada");
			System.out.println("(Puede ver el resultado de la consulta en 'Resultado Query.txt')");
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
