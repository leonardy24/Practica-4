package MainTransferencia;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import app.curso.banco.db.DateBaseTransferencia;

public class MainEliminarTransferencia {

	public static void main(String[] args) {

		Scanner Keyboard = new Scanner(System.in);

		DateBaseTransferencia dataBaseEliminarTransferencia = new DateBaseTransferencia();

		System.out.println("ELIMINADO TRANSFERENCIA :");
		System.out.println("----------------------- :");

		System.out.println("Inserte id de la transferencia que deseas eliminar :");

		int transferenciaEliminar = Keyboard.nextInt();

		boolean transferenciaBorrado = dataBaseEliminarTransferencia.eliminarTransferencia(transferenciaEliminar);

		if (transferenciaBorrado) {

			System.out.println("la transferencia" + " " + transferenciaBorrado + " " + "se ha eliminado :");
		} else {
			System.out.println("el mensaje no se ha eliminado :");

		}
		;
	}

}
