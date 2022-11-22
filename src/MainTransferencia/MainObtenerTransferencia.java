package MainTransferencia;

import java.util.ArrayList;
import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import app.curso.banco.db.DateBaseTransferencia;
import cliente.gestor.Cliente;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;
import cliente.gestor.Transferencia;

public class MainObtenerTransferencia {

	public static void main(String[] args) {

		Scanner Keyboard = new Scanner(System.in);

		DateBaseTransferencia obtenerTransferenciaTodos = new DateBaseTransferencia();

		System.out.println("DESEAS OBTENER TODOS LAS TRANSFERENCIA");
		System.out.println("--------------------------------------");

		ArrayList<Transferencia> transferenciaMain = obtenerTransferenciaTodos.obtenerTodasTransferencia();

		System.out.println("MOSTRANDO TRANSFERENCIA:");

		transferenciaMain.forEach((llamado) -> {

			System.out.println("id de transferencia:" + llamado.getId());
			System.out.println("id ordenante : " + llamado.getId_ordenante());
			System.out.println("id benefeciario :" + llamado.getId_beneficiario());

			System.out.println("Importe:" + llamado.getImporte());
			System.out.println("Fecha y hora de envio de transferencia: " + llamado.getFecha());
			System.out.println("--------------------------------------");

		});

	}

}
