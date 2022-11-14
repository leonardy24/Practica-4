package MainGestores;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Gestor;

public class MainCrearGestor {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner (System.in);
		DateBaseGestor dateBaseCrear = new  DateBaseGestor();
		
		System.out.println("CREANDO GESTOR:");
		System.out.println("-----------------------");

		
		System.out.println("Ingrese nombre de  Usuario del gestor a crear:");
		String user = Keyboard.next();
		
		System.out.println("Ingrese su Contraseña :");
		String password = Keyboard.next();
		
		System.out.println("Ingrese su Correo :");
		String correo = Keyboard.next();
		

		
		
		//inserta gestor
		Gestor gestor = new Gestor(1,user, password,correo );
		
		dateBaseCrear.insertarGestor(gestor);

		System.out.println("-----------------------");

		System.out.println("SU GESTRO SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");


	}

}
