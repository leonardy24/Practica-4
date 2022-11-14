package MainGestores;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Gestor;

public class MainObtenerGestoresPorID {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);
		
		DateBaseGestor obtenerGestoresPorId = new DateBaseGestor();
		
		System.out.println("OBTENIENDO GESTORES POR ID" );
		System.out.println("------------------------------" );
		System.out.println("COLOQUE EL ID DE GESTOR:" );


		int id = Keyboard.nextInt();
		
		Gestor gestor = obtenerGestoresPorId.obtenerUnGestor(id);
		
		if(gestor != null) {
			System.out.println("id del gestor :" + gestor.getId() + "  " + "usuario : " + gestor.getUsuario()+ " "+ "contraseña :" +"  "+ gestor.getPassword());
			
		}else {
			System.out.println("");
		}
	}

}
