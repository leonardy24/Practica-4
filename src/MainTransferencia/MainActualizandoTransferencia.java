package MainTransferencia;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import app.curso.banco.db.DateBaseTransferencia;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;
import cliente.gestor.Transferencia;

public class MainActualizandoTransferencia {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);

		DateBaseTransferencia dataBaseActualizarTransferencia = new DateBaseTransferencia();

		System.out.println("NOTA: si no desea actualizar el campo ingrese 0");
		String noActualizar = "0";
		int noActuazalizar1 = 0;
		String noActualizarFecha = "no";
		System.out.println("-----------------------------------------");

		System.out.println("ingresar id de la transferencia a actualizar");
		int idActualizar = Keyboard.nextInt();

		Transferencia transferencia = dataBaseActualizarTransferencia.obtenerTransferenciaId(idActualizar);

		System.out.println("ingresar nuevo id de ordenante:");
		int newIdOrdenante = Keyboard.nextInt();

		System.out.println("ingresar nuevo id beneficiario:");
		int newIdBeneficiario = Keyboard.nextInt();

		System.out.println("ingresar nuevo importe:");
		double newImporte = Keyboard.nextDouble();

		System.out.println("ingresar nuevo concepto:");
		String newConcepto = Keyboard.next();

		System.out.println("coloque 'si' para actualizar fecha");
		System.out.println("coloque 'no' para  no actualizar fecha");
		String respuesta = Keyboard.next();

		Date fecha = new Date();

		long ms = fecha.getTime();
		Timestamp datetime = new Timestamp(ms);

		System.out.println("---------------------------");

		if (newIdOrdenante == 0) {

			System.out.println("id ordenante no se ha actualizado");

		} else {
			transferencia.setId_ordenante(newIdOrdenante);
		}
		;

		if (newIdBeneficiario == 0) {
			System.out.println("id beneficiario no se ha actualizado");

		} else {
			transferencia.setId_beneficiario(newIdBeneficiario);

		}
		if (newImporte == 0) {
			System.out.println("importe no se ha actualizado");

		} else {
			transferencia.setImporte(newImporte);
		}

		if (newConcepto.equals(noActualizar)) {
			System.out.println("concepto no se ha actualizado");

		} else {
			transferencia.setConcepto(newConcepto);

		}
		if (respuesta.equals(noActualizarFecha)) {
			System.out.println("fecha y hora no se ha actualizado");

		} else {
			transferencia.setFecha(datetime);

		}
		;

		System.out.println("----------------------------------");

		boolean transferenciaActualizado = dataBaseActualizarTransferencia.actualizarTransferencia(transferencia);

		if (transferenciaActualizado) {
			System.out.println("ACTUALIZACION TRANSFERENCIA");

			System.out.println("ID :" + transferencia.getId());
			System.out.println("ID ORDENANTE :" + transferencia.getId_ordenante());
			System.out.println("ID BENEFICIARIO :" + transferencia.getId_beneficiario());
			System.out.println("IMPORTE:" + transferencia.getImporte());
			System.out.println("CONCEPTO:" + transferencia.getConcepto());
			System.out.println("FECHA Y HORA:" + transferencia.getFecha());

		} else {
			System.out.println("no se ha actualizado el gestor ");
		}

	}

}