package MainGestores;

import java.util.Scanner;

import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Gestor;

public class MainActualizandoGestores {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);

		DateBaseGestor dataBaseactualizarGestor = new DateBaseGestor();

		System.out.println("NOTA: si no desea actualizar el campo ingrese O");
		String noActualizar = "O";

		System.out.println("-----------------------------------------");

		System.out.println("ingresar id del gestor a actualizar");
		int idActualizar = Keyboard.nextInt();

		Gestor gestor = dataBaseactualizarGestor.obtenerUnGestor(idActualizar);

		System.out.println("ingresar nuevo nombre de Usuario");
		String newUser = Keyboard.next();

		System.out.println("ingresar nueva contraseña");
		String newPassword = Keyboard.next();

		System.out.println("ingresar nuevo correo");
		String newCorreo = Keyboard.next();

		System.out.println("---------------------------");

		if (newUser.equals(noActualizar)) {

			System.out.println("usuario no se ha actualizado");

		} else {
			gestor.setUsuario(newUser);
		}
		;

		if (newPassword.equals(noActualizar)) {
			System.out.println("contraseña no se ha actualizado");

		} else {
			gestor.setPassword(newPassword);
		}
		;

		if (newCorreo.equals(noActualizar)) {
			System.out.println("correo no se ha actualizado");

		} else {
			gestor.setCorreo(newCorreo);

		}
		;

		System.out.println("----------------------------------");

		boolean gestorActualizado = dataBaseactualizarGestor.actualizarGestor(gestor);

		if (gestorActualizado) {
			System.out.println("ACTUALIZACION DE GESTOR");
			System.out.println("ID :" + gestor.getId());
			System.out.println("USUARIO :" + gestor.getUsuario());
			System.out.println("CONTRASEÑA :" + gestor.getPassword());
			System.out.println("CORREO :" + gestor.getCorreo());

		} else {
			System.out.println("no se ha actualizado el gestor ");
		}

	}

}