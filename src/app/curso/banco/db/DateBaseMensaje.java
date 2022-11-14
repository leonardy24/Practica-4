package app.curso.banco.db;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.sql.*;
import cliente.gestor.Cliente;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;

public class DateBaseMensaje {

	private Connection conexion;
	
	
	public DateBaseMensaje() {
		
		
		try {

		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");

									
	} catch (SQLException e) {
		e.printStackTrace();
}
			
}
	
	public boolean insertarMensaje (Mensaje mensaje) {
		
		PreparedStatement IngresarMensaje = null;

		try {
			
			String mensaje1 = "INSERT INTO mensaje(id_destino,id_origen,texto)VALUES(?,?,?)";
			
			IngresarMensaje = conexion.prepareStatement(mensaje1);
			
			IngresarMensaje.setInt(1, mensaje.getId_destino());
			
			IngresarMensaje.setInt(2, mensaje.getId_origen());
			
			IngresarMensaje.setString(3, mensaje.getTexto());
			
			IngresarMensaje.executeUpdate();
			
			IngresarMensaje.close();
			
			return true;
			//insertarCliente.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (IngresarMensaje != null) {

				try {
					IngresarMensaje.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	return false;	
	}
		
	
		public ArrayList<Mensaje> obtenerMensaje() {

			Statement instruccion = null;

			ArrayList<Mensaje> clientes = new ArrayList<Mensaje>();

			try {

				instruccion = conexion.createStatement();

				String codigo = "SELECT * FROM mensaje";

				ResultSet resultados = instruccion.executeQuery(codigo);

				while (resultados.next()) {

					int id = resultados.getInt("id");
					int id_origen = resultados.getInt("id_origen");
					int id_destino = resultados.getInt("id_destino");
					String texto = resultados.getString("texto");
					java.sql.Timestamp fecha = resultados.getTimestamp("fecha");

					Mensaje mensaje = new Mensaje(id, id_origen, id_destino, texto,fecha);

					clientes.add(mensaje);
				}

				instruccion.close();

				return clientes;

			
			
			
			
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

		
	public boolean eliminarMensaje(int id) {
		
		PreparedStatement instruccion=null;
		
		try {
			String EliminarGestor ="DELETE FROM mensaje WHERE id=?";
			
			instruccion = conexion.prepareStatement(EliminarGestor);
			
			instruccion.setInt(1, id);
			
			int llamadoEliminar =instruccion.executeUpdate();
			
			return llamadoEliminar!=0;
			
			
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

	
	public Mensaje obtenerMensajeId(int id) {
		
		PreparedStatement instruccion =null;
		
		Mensaje mensaje=null;
		
		try {
			
			String obtener ="SELECT * FROM mensaje WHERE id=?";
			
			instruccion = conexion.prepareStatement(obtener);
			
			instruccion.setInt(1, id);
			
			ResultSet resultado = instruccion.executeQuery();
			
			if(resultado.next()) {
				mensaje = new Mensaje();
				mensaje.setId(resultado.getInt("id"));
				mensaje.setId_origen(resultado.getInt("id_origen"));
				mensaje.setId_destino(resultado.getInt("id_destino"));
				mensaje.setTexto(resultado.getString("texto"));
				mensaje.setDatetime(resultado.getTimestamp("fecha"));
			};
			
			
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
		
		
		return mensaje;
	}
		
	public boolean actualizarMensaje(Mensaje mensaje) {
		
		PreparedStatement instruccion =null;
		
		try {
			
		String actualizar ="UPDATE mensaje SET  id_origen = ?, id_destino = ?, texto =?, fecha=? WHERE id =?";
		
		
		instruccion = conexion.prepareStatement(actualizar);
		
		
		instruccion.setInt(1, mensaje.getId_origen());
		
		instruccion.setInt(2, mensaje.getId_destino());
		
		instruccion.setString(3, mensaje.getTexto());
		
		instruccion.setTimestamp(4, mensaje.getDatetime());

		instruccion.setInt(5, mensaje.getId());
		
		
		int filasActualizadas = instruccion.executeUpdate();

		return filasActualizadas !=0;

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

	
	
}
