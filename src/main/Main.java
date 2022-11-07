package main;

import java.sql.Connection;
import java.util.ArrayList;

import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Gestor;

public class Main {

	
	
	public static void main(String[] args) {
		
		
		DateBaseGestor dateBase = new  DateBaseGestor();
		
		/*
		//inserta gestor
		Gestor gestor = new Gestor(1,"gestor1", "gestor1","gestro@gmail.com" );
		
		database.insertarGestor(gestor);*/
		
		//llamar gestores
		//ArrayList<Gestor>gestores = database.getGestores() ;
		
		ArrayList<Gestor> gestores = dateBase.getGestores();
		System.out.println(gestores);
		
		
		
		
		
		
		
		System.out.println(gestores);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
