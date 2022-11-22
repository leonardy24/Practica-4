package MainMensaje;

import java.util.ArrayList;
import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import cliente.gestor.Cliente;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;

public class MainObtenerMensaje {

	public static void main(String[] args) {

		Scanner Keyboard = new Scanner(System.in);

		DateBaseMensaje obtenerMensajesTodos = new DateBaseMensaje();

		System.out.println("DESEAS OBTENER TODOS LOS MENSAJE");
		System.out.println("--------------------------------------");

		ArrayList<Mensaje> mensajeMain = obtenerMensajesTodos.obtenerMensaje();

		System.out.println("MOSTRANDO GESTORES:");

		mensajeMain.forEach((llamado) -> {

			System.out.println("id del Mensaje :" + llamado.getId());
			System.out.println("id de origen : " + llamado.getId_origen());
			System.out.println("id de destino :" + llamado.getId_destino());

			System.out.println("Texto de mensaje:" + llamado.getTexto());
			System.out.println("Fecha y hora de envio de mensaje" + llamado.getDatetime());
			System.out.println("--------------------------------------");

		});

	}

}
