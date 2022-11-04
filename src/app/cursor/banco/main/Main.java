package app.cursor.banco.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		
		/*jdbc: indica que la conexión es de tipo jdbc.
		subprotocolo: es el tipo de sistema de base de datos utilizada. En este caso su valor
		es mysql.
		localizador: indica la dirección IP, puerto y nombre de la base de datos a la que
		conectar.*/
		
		
		
		
		try {  //nueva conexion
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/primera_bd", "primera_bd", "primera_bd");
				System.out.println("Base de datos: " + conexion.getMetaData().getDriverVersion());
					//capturamos  posibeles execiones	
				Statement instruccion = conexion.createStatement();
				
				/*String query = "INSERT INTO gestor (usuario, password, correo) VALUES ('jose',	'leonardy', 'leonardy@correo.com')";
				
				//primera forma de hacerlo. esta es una mierda
				boolean resultado = instruccion.execute(query);
				
				if (!resultado) {
					
					System.out.println("Registros insertados: " + instruccion.getUpdateCount());
				}
				
				//segunda forma de hacerlo. esta es mucho mas facil
				int registroInsertado = instruccion.executeUpdate(query);
				
				System.out.println("Registro insertado: " + registroInsertado);*/
				
				/*
				String query = "SELECT * FROM gestor";
				ResultSet resultados1 = instruccion.executeQuery(query);
				
				System.out.println("Listado de gestores (con executeQuery): ");
				// ejecutar instrucción con el método executeQuery
				while (resultados1.next()) {
				System.out.println("Gestor " + resultados1.getInt("id"));
				System.out.println("Usuario: " + resultados1.getString("usuario"));
				System.out.println("Password: " + resultados1.getString("password"));
				System.out.println("Correo: " + resultados1.getString("correo"));
				System.out.println("...");
				}
				
				System.out.println("-------------------------------------------------");
				
				executeUpdate(String sql): para ejecución de consultas INSERT, UPDATE, DELETE.
				Devuelve el número de registros afectados.
				
				executeQuery(String sql): para ejecución de consultas SELECT. Devuelve un objeto
				de tipo ResultSet.
				
				execute(String sql): para la ejecución de todo tipo de consultas. Devuelve true si el
				resultado es de tipo ResultSet o false si es una inserción, actualización o
				eliminación. Posteriormente se requiere de la invocación de métodos como
				getResultSet o getUpdateCount del objeto de tipo Statement.*/
				
				
				
				
				
				
				
				
				//instruciones preparadas
				
				/*PreparedStatement ps = conexion.prepareStatement("INSERT INTO gestor (usuario, password, correo) VALUES (?,?,?)");
				
				//reemplaza los valores ?
				ps.setString(1,"gestor10" );
				
				ps.setString(2, "gestor10");
				
				ps.setString(3, "gestor10@gmail.com");

	
				
				
				
				if(ps.executeUpdate()!=1 ) {
						
					throw new SQLException("Error en la Inserción" );
				}
				
				System.out.println("Programa finalizado");*/
				;
				
				
				///llamado de base de ddato
				
				PreparedStatement remplazo = conexion.prepareStatement(" SELECT * from gestor WHERE id  IN (?,?)");
				// el primer numero indica la posicion de los interrogantes ?,? = 1,2/// y el 3 y el 4 el numero de id a llamar
				remplazo.setInt(1, 3);
				
				remplazo.setInt(2, 4);
				
				ResultSet resultados = remplazo.executeQuery();
				
				System.out.println("Listado de gestores: ");
				
				while (resultados.next()) {
					System.out.println("Gestor : " + resultados.getInt("id"));
					System.out.println("Usuario: " + resultados.getString("usuario"));
					System.out.println("Password: " + resultados.getString("password"));
					System.out.println("Correo: " + resultados.getString("correo"));
					System.out.println("...");
					}
				
				
				
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//liberarar la instrucuion
			
		}
		
		
		
		
	}

}
