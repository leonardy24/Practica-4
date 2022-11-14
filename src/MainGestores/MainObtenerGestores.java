package MainGestores;

import java.util.ArrayList;
import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Gestor;

public class MainObtenerGestores {

	public static void main(String[] args) {
		
		Scanner Keyboard = new Scanner(System.in);
		
		DateBaseGestor obtenerG = new DateBaseGestor();
		
		System.out.println("DESEAS OBTENER TODOS LOS GESTORES" );
		System.out.println("--------------------------------------" );
		//System.out.println("MARQUE CON UN SI O NO" );
	//	String respuesta =  Keyboard.next();
		
		ArrayList<Gestor> gestoresMain = obtenerG.obtenerGestores();
		
		
			System.out.println("MOSTRANDO GESTORES:" );

		gestoresMain.forEach((llamado) -> {
			
			System.out.println("id del gestor :" + llamado.getId() + "  " + "usuario : " + llamado.getUsuario()+ " "+ "contraseña :" +"  "+ llamado.getPassword());
		});
		
		
	}

}
