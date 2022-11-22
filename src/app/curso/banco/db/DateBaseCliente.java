package app.curso.banco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cliente.gestor.Cliente;
import cliente.gestor.Gestor;

public class DateBaseCliente {
	private Connection conexion;

	public DateBaseCliente() {

		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "banco", "banco");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// insertar cliente
	public boolean insertarCliente(Cliente cliente) {

		PreparedStatement insertar = null;

		try {

			String agregarClientes = "INSERT INTO cliente(id_gestor,usuario,password,correo,saldo)VALUES(?,?,?,?,?)";

			insertar = conexion.prepareStatement(agregarClientes);

			insertar.setString(1, cliente.getId_Gestor());

			insertar.setString(2, cliente.getUsuario());

			insertar.setString(3, cliente.getPassword());

			insertar.setString(4, cliente.getCorreo());

			insertar.setString(5, cliente.getSaldo());

			insertar.executeUpdate();

			insertar.close();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (insertar != null) {

				try {
					insertar.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return true;
	};

	// obtener todos los cliente
	public ArrayList<Cliente> obtenertodosClientes() {

		PreparedStatement obtener = null;

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try {

			String obtenerClientes = "SELECT * from cliente";

			obtener = conexion.prepareStatement(obtenerClientes);

			ResultSet resultado = obtener.executeQuery();

			while (resultado.next()) {

				int id = resultado.getInt("id");
				String id_Gestor = resultado.getString("id_gestor");
				String usuario = resultado.getString("usuario");
				String password = resultado.getString("password");
				String correo = resultado.getString("correo");
				String saldo = resultado.getString("saldo");

				Cliente cliente = new Cliente(id, usuario, password, correo, id_Gestor, saldo);

				clientes.add(cliente);

			}

			obtener.close();

			return clientes;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (obtener != null) {

				try {
					obtener.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	// eliminar cliente
	public boolean eliminarCliente(int id) {

		PreparedStatement instruccion = null;

		try {
			String eliminar = "DELETE FROM cliente WHERE id = ?";

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

	// obtener un cliente
	public Cliente obtenerUnCliente(int id) {

		PreparedStatement obtenerCliente = null;

		Cliente cliente = null;

		try {

			String llamado = "SELECT * from cliente WHERE id=?";

			obtenerCliente = conexion.prepareStatement(llamado);

			obtenerCliente.setInt(1, id);

			ResultSet resultado = obtenerCliente.executeQuery();

			if (resultado.next()) {
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setUsuario(resultado.getString("usuario"));
				cliente.setPassword(resultado.getString("password"));
				cliente.setCorreo(resultado.getString("correo"));
				cliente.setId_Gestor(resultado.getString("id_gestor"));
				cliente.setSaldo(resultado.getString("saldo"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (obtenerCliente != null) {
				try {
					obtenerCliente.close();
				} catch (SQLException e) {

					e.printStackTrace();

				}
			}
		}

		return cliente;
	};

	public boolean actualizarCliente(Cliente cliente) {

		PreparedStatement actualizacion = null;

		try {

			String actualizar = "UPDATE cliente SET usuario = ?, password = ?, correo = ?, id_gestor=?,saldo=? WHERE id =?";

			actualizacion = conexion.prepareStatement(actualizar);

			actualizacion.setString(1, cliente.getUsuario());

			actualizacion.setString(2, cliente.getPassword());

			actualizacion.setString(3, cliente.getCorreo());

			actualizacion.setString(4, cliente.getId_Gestor());

			actualizacion.setString(5, cliente.getSaldo());

			actualizacion.setInt(6, cliente.getId());

			int filasActualizadas = actualizacion.executeUpdate();

			return filasActualizadas != 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (actualizacion != null) {
				try {
					actualizacion.close();
				} catch (SQLException e) {

					e.printStackTrace();

				}
			}
		}

		return false;
	};

}
