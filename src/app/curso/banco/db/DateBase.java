package app.curso.banco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DateBase {
	
	

	public static void main(String[] args) throws SQLException {
		
		Statement instruccion = null;
		Scanner keyboard = new Scanner(System.in);
		int menuSeleccionado = -1;
		PreparedStatement creandoGestor;
		 Connection conexion = null;
		 
		try {
		  conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","banco","banco");


		


			 System.out.println("Base de datos: " + conexion.getMetaData().getDriverVersion());
		
		
			instruccion = conexion.createStatement();
			

			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		do {
			System.out.println("1. Crear Gestor");
			System.out.println("2. Insercion masiva de gestores con datos aleatorios");
			System.out.println("3. Obtención de un Gestor");
			System.out.println("4. Ver todos Gestores");
			menuSeleccionado = keyboard.nextInt();
			
			switch (menuSeleccionado) {
			
			case 0:
				System.out.println("Saliendo...");
				break;
			case 1:
				
				System.out.println("ingrese nombre del usuario:");

				String usuario = keyboard.next();

				System.out.println("--------------------------------------------");

				System.out.println("ingrese contraseña :");

				String password = keyboard.next();

				System.out.println("--------------------------------------------");

				System.out.println("ingrese correo :");

				String correo  = keyboard.next();
				System.out.println("--------------------------------------------");

				creandoGestor = conexion.prepareStatement("INSERT INTO gestor1(usuario,password,correo)VALUES (?,?,?)");


				creandoGestor.setString(1, usuario);
				
				creandoGestor.setString(2, password);

				creandoGestor.setString(3, correo);

				 creandoGestor.executeUpdate();
				
				System.out.println("SE HA CREADO UN NUEVO GESTOR");

				
				
				break;
			default:
				System.out.println("Opción desconocida...");
				break;
			}
			
			
		}while ( menuSeleccionado!= 0);
		
		
		
		
	
			
		
			
			
		

	}

}
