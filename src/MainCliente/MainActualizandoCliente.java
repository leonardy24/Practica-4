package MainCliente;

import java.util.Scanner;

import app.curso.banco.db.DateBaseCliente;
import app.curso.banco.db.DateBaseGestor;
import cliente.gestor.Cliente;
import cliente.gestor.Gestor;

public class MainActualizandoCliente {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);

		DateBaseCliente dataBaseActualizarCliente = new DateBaseCliente();

		System.out.println("NOTA: si no desea actualizar el campo ingrese O");
		String noActualizar = "O";

		System.out.println("-----------------------------------------");

		System.out.println("ingresar id del cliente a actualizar");
		int idActualizar = Keyboard.nextInt();

		Cliente cliente = dataBaseActualizarCliente.obtenerUnCliente(idActualizar);

		System.out.println("ingresar nuevo nombre de Usuario");
		String newUser = Keyboard.next();

		System.out.println("ingresar nueva contraseña");
		String newPassword = Keyboard.next();

		System.out.println("ingresar nuevo correo");
		String newCorreo = Keyboard.next();

		System.out.println("ingrese nuevo id del gestor:");
		String newId_Gestor = Keyboard.next();

		System.out.println("ingresar nuevo saldo");
		String newSaldo = Keyboard.next();

		System.out.println("---------------------------");

		if (newUser.equals(noActualizar)) {

			System.out.println("usuario no se ha actualizado");

		} else {
			cliente.setUsuario(newUser);
		}
		;

		if (newPassword.equals(noActualizar)) {
			System.out.println("contraseña no se ha actualizado");

		} else {
			cliente.setPassword(newPassword);
		}
		;

		if (newCorreo.equals(noActualizar)) {
			System.out.println("correo no se ha actualizado");

		} else {
			cliente.setCorreo(newCorreo);

		}
		;

		if (newId_Gestor.equals(noActualizar)) {
			System.out.println("id de gestor  no se ha actualizado");

		} else {
			cliente.setId_Gestor(newId_Gestor);
		}

		if (newSaldo.equals(noActualizar)) {
			System.out.println("el saldo  no se ha actualizado");

		} else {
			cliente.setSaldo(newSaldo);
		}

		System.out.println("----------------------------------");

		boolean gestorActualizado = dataBaseActualizarCliente.actualizarCliente(cliente);

		if (gestorActualizado) {
			System.out.println("ACTUALIZACION DE GESTOR");
			System.out.println("ID :" + cliente.getId());
			System.out.println("USUARIO :" + cliente.getUsuario());
			System.out.println("CONTRASEÑA :" + cliente.getPassword());
			System.out.println("CORREO :" + cliente.getCorreo());

		} else {
			System.out.println("no se ha actualizado el gestor ");
		}

	}

}