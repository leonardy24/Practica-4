package MainMensaje;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;

public class MainActualizandoMensaje {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);

		DateBaseMensaje dataBaseActualizarMensaje = new DateBaseMensaje();

		System.out.println("NOTA: si no desea actualizar el campo ingrese O");
		String noActualizar = "0";
		int noActuazalizar1 = 0;
		System.out.println("-----------------------------------------");

		System.out.println("ingresar id del mensaje a actualizar");
		int idActualizar = Keyboard.nextInt();

		Mensaje mensaje = dataBaseActualizarMensaje.obtenerMensajeId(idActualizar);

		System.out.println("ingresar nuevo id de origen");
		int newIdOrigen = Keyboard.nextInt();

		System.out.println("ingresar nuevo id destino");
		int newIdDestino = Keyboard.nextInt();

		System.out.println("ingresar nuevo texto");
		String newTexto = Keyboard.next();

		System.out.println("ingresando nueva fecha y hora");

		Date fecha = new Date();

		long ms = fecha.getTime();
		Timestamp datetime = new Timestamp(ms);

		System.out.println("---------------------------");

		if (newIdOrigen == 0) {

			System.out.println("id_origen no se ha actualizado");

		} else {
			mensaje.setId_origen(newIdOrigen);
		}
		;

		if (newIdDestino == 0) {
			System.out.println("id_destino no se ha actualizado");

		} else {
			mensaje.setId_destino(newIdDestino);

		}
		;

		if (newTexto.equals(noActualizar)) {
			System.out.println("texto no se ha actualizado");

		} else {
			mensaje.setTexto(newTexto);

		}
		;

		if (datetime.equals(noActualizar)) {
			System.out.println("fecha y hora no se ha actualizado");

		} else {
			mensaje.setDatetime(datetime);
		}

		System.out.println("----------------------------------");

		boolean mensajeActualizado = dataBaseActualizarMensaje.actualizarMensaje(mensaje);

		if (mensajeActualizado) {
			System.out.println("ACTUALIZACION DE GESTOR");
			System.out.println("ID :" + mensaje.getId());
			System.out.println("USUARIO :" + mensaje.getId_origen());
			System.out.println("CONTRASEÑA :" + mensaje.getId_destino());
			System.out.println("CORREO :" + mensaje.getTexto());
			System.out.println("CORREO :" + mensaje.getDatetime());

		} else {
			System.out.println("no se ha actualizado el gestor ");
		}

	}

}