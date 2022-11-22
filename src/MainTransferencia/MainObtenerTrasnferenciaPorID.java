package MainTransferencia;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import app.curso.banco.db.DateBaseTransferencia;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;
import cliente.gestor.Transferencia;

public class MainObtenerTrasnferenciaPorID {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);

		DateBaseTransferencia obtenerTransferenciaPorId = new DateBaseTransferencia();

		System.out.println("OBTENIENDO TRANSFERENCIA POR ID");
		System.out.println("------------------------------");
		System.out.println("COLOQUE EL ID DE TRANSFERENCIA:");

		int id = Keyboard.nextInt();

		Transferencia transferencia = obtenerTransferenciaPorId.obtenerTransferenciaId(id);

		if (transferencia != null) {
			System.out.println("id de transferencia:" + transferencia.getId());
			System.out.println("id ordenante:" + transferencia.getId_ordenante());
			System.out.println("id beneficiario:" + transferencia.getId_beneficiario());
			System.out.println("Importe :" + transferencia.getImporte());
			System.out.println("Concepto:" + transferencia.getFecha());

		} else {
			System.out.println("");
		}
	}

}
