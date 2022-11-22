package MainMensaje;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;

public class MainObtenerMensajePorID {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);

		DateBaseMensaje obtenerMensajePorId = new DateBaseMensaje();

		System.out.println("OBTENIENDO MENSAJE POR ID");
		System.out.println("------------------------------");
		System.out.println("COLOQUE EL ID DE MENSAJE:");

		int id = Keyboard.nextInt();

		Mensaje mensaje = obtenerMensajePorId.obtenerMensajeId(id);

		if (mensaje != null) {
			System.out.println("id de mensaje:" + mensaje.getId());
			System.out.println("id de origen:" + mensaje.getId_origen());
			System.out.println("id de destino:" + mensaje.getId_destino());
			System.out.println("Mensaje:" + mensaje.getTexto());
			System.out.println("fecha y hora de envio:" + mensaje.getDatetime());

		} else {
			System.out.println("");
		}
	}

}
