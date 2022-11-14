package app.curso.banco.db;


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
import cliente.gestor.Transferencia;
import java.sql.*;
public class DateBaseTransferencia {

	private Connection conexion;
	
	
	public DateBaseTransferencia() {
		
		
		try {

		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");

									
	} catch (SQLException e) {
		e.printStackTrace();
}
			
}
	
	public boolean insertarTransferencia (Transferencia transferencia) {
		
		PreparedStatement IngresarTransferencia = null;

		try {
			
			String transferenciaBaseDatos = "INSERT INTO transferencia(id_ordenante,id_beneficiario,importe,concepto,fecha)VALUES(?,?,?,?,?)";
			
			IngresarTransferencia = conexion.prepareStatement(transferenciaBaseDatos);
			
			IngresarTransferencia.setInt(1, transferencia.getId_ordenante());
			
			IngresarTransferencia.setInt(2, transferencia.getId_beneficiario());
			
			IngresarTransferencia.setDouble(3, transferencia.getImporte());
			
			IngresarTransferencia.setString(4,transferencia.getConcepto());

			IngresarTransferencia.setTimestamp(5, transferencia.getFecha());

			
			
			IngresarTransferencia.executeUpdate();
			
			IngresarTransferencia.close();
			
			return true;
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (IngresarTransferencia != null) {

				try {
					IngresarTransferencia.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	return false;	
	}
		
	
		public ArrayList<Transferencia> obtenerTodasTransferencia() {

			Statement instruccion = null;

			ArrayList<Transferencia> transferenciaMain = new ArrayList<Transferencia>();

			try {

				instruccion = conexion.createStatement();

				String codigo = "SELECT * FROM transferencia";

				ResultSet resultados = instruccion.executeQuery(codigo);

				while (resultados.next()) {

					int id = resultados.getInt("id");
					int id_ordenante=resultados.getInt("id_ordenante");
					int id_beneficiario= resultados.getInt("id_beneficiario");
					double importe=resultados.getDouble("importe");
					String concepto=resultados.getString("concepto");
					Timestamp fecha = resultados.getTimestamp("fecha");

					Transferencia transferencia = new Transferencia(id, id_ordenante, id_beneficiario, importe,concepto,fecha);

					transferenciaMain.add(transferencia);
				}

				instruccion.close();

				return transferenciaMain;

			
			
			
			
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

		
	public boolean eliminarTransferencia(int id) {
		
		PreparedStatement instruccion=null;
		
		try {
			String EliminarTransferencia ="DELETE FROM transferencia WHERE id=?";
			
			instruccion = conexion.prepareStatement(EliminarTransferencia);
			
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

	
	public Transferencia obtenerTransferenciaId(int id) {
		
		PreparedStatement instruccion =null;
		
		Transferencia transferencia=null;
		
		try {
			
			String obtener ="SELECT * FROM transferencia WHERE id=?";
			
			instruccion = conexion.prepareStatement(obtener);
			
			instruccion.setInt(1, id);
			
			ResultSet resultado = instruccion.executeQuery();
			
			if(resultado.next()) {
				transferencia = new Transferencia();
				transferencia.setId(resultado.getInt("id"));
				transferencia.setId_ordenante(resultado.getInt("id_ordenante"));;
				transferencia.setId_beneficiario(resultado.getInt("id_beneficiario"));
				transferencia.setImporte(resultado.getDouble("importe"));
				transferencia.setConcepto(resultado.getString("concepto"));
				transferencia.setFecha(resultado.getTimestamp("fecha"));

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
		
		
		return transferencia;
	}
		
	public boolean actualizarTransferencia(Transferencia transferencia) {
		
		PreparedStatement instruccion =null;
		
		try {
			
		String actualizar ="UPDATE transferencia SET  id_ordenante = ?, id_beneficiario = ?, importe =?, concepto=?,fecha=? WHERE id =?";
		
		
		instruccion = conexion.prepareStatement(actualizar);
		
		
		instruccion.setInt(1, transferencia.getId_ordenante());
		
		instruccion.setInt(2, transferencia.getId_beneficiario());
		
		instruccion.setDouble(3, transferencia.getImporte());
		
		instruccion.setString(4, transferencia.getConcepto());

		instruccion.setTimestamp(5, transferencia.getFecha());;
		
		instruccion.setInt(6, transferencia.getId());
		
		
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
