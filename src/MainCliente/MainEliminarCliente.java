package MainCliente;

import java.util.Scanner;

import app.curso.banco.db.DateBaseCliente;
import app.curso.banco.db.DateBaseGestor;

public class MainEliminarCliente {

	public static void main(String[] args) {

		Scanner Keyboard = new Scanner(System.in);

		DateBaseCliente dataBaseEliminar = new DateBaseCliente();

		System.out.println("ELIMINADO CLIENTE :");
		System.out.println("----------------------- :");

		System.out.println("Inserte id del cliente que deseas eliminar :");

		int clienteEliminar = Keyboard.nextInt();

	
		boolean gestorBorrado = dataBaseEliminar.eliminarCliente(clienteEliminar);

		if (gestorBorrado) {

			System.out.println("el cliente" + "se ha eliminado :");
		} else {
			System.out.println("el ggestor no se ha eliminado :");

		}
		;
	}

}
