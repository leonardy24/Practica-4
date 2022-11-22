package MainMensaje;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;

public class MainEliminarMensaje {

	public static void main(String[] args) {

		Scanner Keyboard = new Scanner(System.in);

		DateBaseMensaje dataBaseEliminarMensaje = new DateBaseMensaje();

		System.out.println("ELIMINADO MENSAJE :");
		System.out.println("----------------------- :");

		System.out.println("Inserte id del mensaje que deseas eliminar :");

		int mensajeEliminar = Keyboard.nextInt();

		boolean mensajeBorrado = dataBaseEliminarMensaje.eliminarMensaje(mensajeEliminar);

		if (mensajeBorrado) {

			System.out.println("el mensaje" + " " + mensajeEliminar + " " + "se ha eliminado :");
		} else {
			System.out.println("el mensaje no se ha eliminado :");

		}
		;
	}

}
