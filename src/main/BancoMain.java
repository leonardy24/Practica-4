package main;

import java.sql.Connection;
import java.util.ArrayList;

import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Gestor;

public class BancoMain {

	
	
	public static void main(String[] args) {
		
		
		DateBaseGestor dateBase = new  DateBaseGestor();
		
		/*
		//inserta gestor
		Gestor gestor = new Gestor(1,"gestor1", "gestor1","gestro@gmail.com" );
		
		dateBase.insertarGestor(gestor);*/
		
		//llamar gestores
		
		
		ArrayList<Gestor> gestoresMain = dateBase.obtenerGestores();
		
		gestoresMain.forEach((llamado) -> {
			
			System.out.println("id del gestor :" + llamado.getId() + "  " + "usuario : " + llamado.getUsuario()+ " "+ "contraseña :" +"  "+ llamado.getPassword());
		});
		
		
	
		//Gestor llamarGestores = dateBase.getClass();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
