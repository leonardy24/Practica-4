package MainGestores;

import java.sql.Connection;
import java.util.ArrayList;

import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Gestor;

public class BancoMain {

	public static void main(String[] args) {

		DateBaseGestor dateBase = new DateBaseGestor();

		// llamar gestores
		ArrayList<Gestor> gestoresMain = dateBase.obtenerGestores();

		gestoresMain.forEach((llamado) -> {

			System.out.println("id del gestor :" + llamado.getId() + "  " + "usuario : " + llamado.getUsuario() + " "
					+ "contraseña :" + "  " + llamado.getPassword());
		});

		// llamar un gestor por id

		Gestor gestor = dateBase.obtenerUnGestor(1);

		if (gestor != null) {
			System.out.println("el gestor 1 es :" + gestor.getUsuario());

		} else {
			System.out.println("");
		}

		// eliminar

		boolean gestorBorrado = dateBase.eliminarGestor(1);

		if (gestorBorrado) {

			System.out.println("el gestor 1 se ha eliminado :");
		} else {
			System.out.println("el ggestor no se ha eliminado :");

		}
		;

		// actualizar

		gestor.setCorreo("otro@gmail.com");

		boolean gestorActualizado = dateBase.actualizarGestor(gestor);

		if (gestorActualizado) {
			System.out.println("se ha actualizado el gestor");
		} else {
			System.out.println("no se ha actualizado el gestor ");
		}

	}

}
