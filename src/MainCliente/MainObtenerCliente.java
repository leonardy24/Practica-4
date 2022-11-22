package MainCliente;

import java.util.ArrayList;
import java.util.Scanner;

import app.curso.banco.db.DateBaseCliente;
import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Cliente;
import cliente.gestor.Gestor;

public class MainObtenerCliente {

	public static void main(String[] args) {

		Scanner Keyboard = new Scanner(System.in);

		DateBaseCliente obtenerClientes = new DateBaseCliente();

		System.out.println("DESEAS OBTENER TODOS LOS GESTORES");
		System.out.println("--------------------------------------");
	

		ArrayList<Cliente> clientesMain = obtenerClientes.obtenertodosClientes();

		System.out.println("MOSTRANDO GESTORES:");

		clientesMain.forEach((llamado) -> {

			System.out.println("id del cliente :" + llamado.getId());
			System.out.println("usuario : " + llamado.getUsuario());
			System.out.println("contraseña :" + "  " + llamado.getPassword());
			System.out.println("id_gestor :" + llamado.getId_Gestor());
			System.out.println("saldo :" + llamado.getSaldo());

		});

	}

}
