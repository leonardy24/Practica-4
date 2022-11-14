package MainMensaje;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;
import java.security.*;
import java.sql.*;
public class MainCrearMensaje {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner (System.in);
		DateBaseMensaje dateBaseCrear = new  DateBaseMensaje();
		
		System.out.println("CREANDO MENSAJE:");
		System.out.println("-----------------------");

		System.out.println("Ingrese Id origen :");
		int id_origen = Keyboard.nextInt();
	
		
		System.out.println("Ingrese Id destino :");
		int id_destino = Keyboard.nextInt();
		
		System.out.println("Por favor ingrese mensaje a enviar:");
		String envioMensaje = Keyboard.next();
		
	
		
		Date fecha = new Date();
		
		long ms= fecha.getTime();
		Timestamp datetime = new Timestamp(ms);
		
		//inserta mensaje
		Mensaje mensaje = new Mensaje(1, id_origen,id_destino,envioMensaje,datetime );
		
		dateBaseCrear.insertarMensaje(mensaje);

		System.out.println("-----------------------");

		System.out.println("SU MENSAjE SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");


	}

}
