package app.curso.banco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MainGestores.MainCrearGestor;
import cliente.gestor.Gestor;

public class DateBaseGestor {

	private Connection conexion;

	public DateBaseGestor() {

		try {

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// inserta gestor
	public boolean insertarGestor(Gestor gestor) {
		
		//MainCrear creando = new MainCrear();
		PreparedStatement ps = null;

		try {
			

			 
			ps = conexion.prepareStatement("INSERT INTO gestor1(usuario,password, correo) VALUES (?,?,?)");

			ps.setString(1, gestor.getUsuario());

			ps.setString(2, gestor.getPassword());

			ps.setString(3, gestor.getCorreo());

			// ejecuta sentencia SQL
			ps.executeUpdate();
			// cierra la sentencia
			ps.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {

				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	// obtener todos los gestores
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

	// obtener un gestor
	public Gestor obtenerUnGestor(int id) {

		PreparedStatement instruccion = null;

		Gestor gestor = null;

		try {
			String idLlamado = "SELECT * FROM gestor1 WHERE id = ?";

			instruccion = conexion.prepareStatement(idLlamado);

			instruccion.setInt(1, id);

			ResultSet resultados = instruccion.executeQuery();

			if (resultados.next()) {
				gestor = new Gestor();
				gestor.setId(resultados.getInt("id"));
				gestor.setUsuario(resultados.getString("usuario"));
				gestor.setPassword(resultados.getString("password"));
				gestor.setCorreo(resultados.getString("correo"));
			}

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

		return gestor;

	};
	//emilinar gestores
	public boolean eliminarGestor(int id) {

		PreparedStatement instruccion = null;

		try {
			String eliminar = "DELETE FROM gestor1 WHERE id = ?";

			instruccion = conexion.prepareStatement(eliminar);

			instruccion.setInt(1, id);

			int filasEliminadas = instruccion.executeUpdate();
			return filasEliminadas != 0;

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

		return false;
	}
	//actualizar gestores
	public boolean actualizarGestor(Gestor gestor) {
	
		PreparedStatement instruccion = null;
		
		
		
		try {
			
			String actualizar = "UPDATE gestor1 SET usuario = ?, password = ?, correo = ? WHERE id =?";
			
			
			instruccion = conexion.prepareStatement(actualizar);
			
			instruccion.setString(1, gestor.getUsuario());
			
			instruccion.setString(2, gestor.getPassword());
			
			instruccion.setString(3, gestor.getCorreo());
			
			instruccion.setInt(4, gestor.getId());
			
			int filasActualizadas = instruccion.executeUpdate();
			
			return filasActualizadas != 0;
			
			
			
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
		
		
		return false;
	};
	
	
	
	
	
	
};
