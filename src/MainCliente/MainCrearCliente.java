package MainCliente;

import java.util.Scanner;

import app.curso.banco.db.DateBaseCliente;
import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Cliente;
import cliente.gestor.Gestor;

public class MainCrearCliente {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner (System.in);
		DateBaseCliente dateBaseCrear = new  DateBaseCliente();
		
		System.out.println("CREANDO CLIENTE:");
		System.out.println("-----------------------");

		
		System.out.println("Ingrese nombre del cliente:");
		String user = Keyboard.next();
		
		System.out.println("Ingrese su Contraseña :");
		String password = Keyboard.next();
		
		System.out.println("Ingrese su Correo :");
		String correo = Keyboard.next();
		
		System.out.print("Ingrese id del gestor :");
		String id_Gestor = Keyboard.next();
		
		System.out.print("Coloque monto con el que desea aperturar su cuenta : :");
		String saldo = Keyboard.next();

		
		
		//inserta cliente
		Cliente cliente = new Cliente(1,user, password,correo,id_Gestor,saldo );
		
		dateBaseCrear.insertarCliente(cliente);

		System.out.println("-----------------------");

		System.out.println("SU CLIENTE SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");


	}

}
