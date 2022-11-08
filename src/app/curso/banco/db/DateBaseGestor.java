package app.curso.banco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cliente.gestor.Gestor;

public class DateBaseGestor {

	private Connection conexion;
	
	public DateBaseGestor() {
		
		
		
		try {
			
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco",	"banco", "banco");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//inserta gestor
	public boolean insertarGestor(Gestor gestor) {
		
		Statement instruccion = null;
		
		try {
			instruccion = conexion.createStatement();
			
			PreparedStatement ps = conexion.prepareStatement("INSERT INTO gestor1(usuario,password, correo) VALUES (?,?,?)");
		
			ps.setString(1, gestor.getUsuario());
			
			ps.setString(2, gestor.getPassword() );
			
			ps.setString(3, gestor.getCorreo());
			
			// ejecuta sentencia SQL
			ps.executeUpdate();
			// cierra la sentencia
			instruccion.close();
			
			
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
				if (instruccion != null) {
					
				try {
					instruccion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		return false;
	}
	
	//obtener todos los gestores
	public ArrayList<Gestor> obtenerGestores() {
	
		Statement instruccion = null;
	
	ArrayList<Gestor> gestores = new ArrayList<Gestor>();	
		
		
	try {
		
		
		instruccion = conexion.createStatement();
		
		String codigo = "SELECT * FROM gestor1";
		
		
		ResultSet resultados = instruccion.executeQuery(codigo);
		
		while (resultados.next()) {
		
		
			int id = resultados.getInt("id");
			String usuario = resultados.getString("usuario");
			String password = resultados.getString("password");
			String correo = resultados.getString("correo");
			
			Gestor gestor = new Gestor(id, usuario, password, correo);
			
			gestores.add(gestor);
		}
		
		instruccion.close();
		
		
		return gestores;
			
		
	} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		if (instruccion != null) {
		try {
		instruccion.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		}
	  }
	}
		
	return null;
	
	}
		
	/*
	public boolean obtenerUnGestor() {
		
		Statement instruccion = null;
		
		
		try {
			instruccion = conexion.createStatement();
			
			
		};
		
		
		
		return false;
	};*/
		
	
			
			
			
			

		
		
		
		
		
		
		
	}
	
		
		
		
		
		
	
	
	


