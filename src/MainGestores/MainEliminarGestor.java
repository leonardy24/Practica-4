package MainGestores;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;

public class MainEliminarGestor {

	public static void main(String[] args) {
		
		Scanner Keyboard = new Scanner (System.in);

		DateBaseGestor dataBaseEliminar = new DateBaseGestor();
		
		
		System.out.println("ELIMINADO GESTOR :" );
		System.out.println("----------------------- :" );
		
		System.out.println("Inserte id del gestor que deseas eliminar :" );
		
		int GestorEliminar = Keyboard.nextInt();
	
		
		
		
		/*if(GestorEliminar) {
			
		}*/
		
		
		
		boolean gestorBorrado = dataBaseEliminar.eliminarGestor(GestorEliminar);
		
		if(gestorBorrado) {
			
		System.out.println("el gestor" +" "+ GestorEliminar+" " + "se ha eliminado :" );
		}else {
			System.out.println("el gestor no se ha eliminado :" );

		};
	}

}
