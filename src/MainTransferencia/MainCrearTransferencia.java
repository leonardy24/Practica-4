package MainTransferencia;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import app.curso.banco.db.DateBaseTransferencia;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;
import cliente.gestor.Transferencia;

import java.security.*;
import java.sql.*;

public class MainCrearTransferencia {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);
		DateBaseTransferencia dateBaseCrearTransferencia = new DateBaseTransferencia();

		System.out.println("CREANDO TRANSFERENCIA:");
		System.out.println("-----------------------");

		System.out.println("Ingrese Id ordenante :");
		int id_ordenante = Keyboard.nextInt();

		System.out.println("ingrese Id Benefeciario:");
		int id_beneficiario = Keyboard.nextInt();

		System.out.println("Ingrese Importe:");
		double importe = Keyboard.nextDouble();

		System.out.println("Ingrese Concepto");
		String concepto = Keyboard.next();

		Date fecha = new Date();

		long ms = fecha.getTime();
		Timestamp datetime = new Timestamp(ms);

		// inserta mensaje
		Transferencia transferencia = new Transferencia(1, id_ordenante, id_beneficiario, importe, concepto, datetime);

		dateBaseCrearTransferencia.insertarTransferencia(transferencia);

		System.out.println("-----------------------");

		System.out.println("SU TRANSFERENCIA SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");

	}

}
