package MainCliente;

import java.util.Scanner;

import app.curso.banco.db.DateBaseCliente;
import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Cliente;
import cliente.gestor.Gestor;

public class MainObtenerClientePorID {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);

		DateBaseCliente obtenerClientesPorId = new DateBaseCliente();

		System.out.println("OBTENIENDO CLIENTE POR ID");
		System.out.println("------------------------------");
		System.out.println("COLOQUE EL ID DE CLIENTE:");

		int id = Keyboard.nextInt();

		Cliente cliente = obtenerClientesPorId.obtenerUnCliente(id);

		if (cliente != null) {
			System.out.println("id:" + cliente.getId());
			System.out.println("usuario :" + cliente.getUsuario());
			System.out.println("contraseña :" + cliente.getPassword());
			System.out.println("id del gestor:" + cliente.getId_Gestor());
			System.out.println("salgo:" + cliente.getSaldo());
		} else {
			System.out.println("no se ha conseguido el cliente");
		}
	}

}
