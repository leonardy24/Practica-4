package app.cursor.banco.main;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import cliente.gestor.Cliente;
import cliente.gestor.Gestor;
import cliente.gestor.Mensaje;
import cliente.gestor.Transferencia;
import app.curso.banco.db.DateBaseCliente;
import app.curso.banco.db.DateBaseGestor;
import app.curso.banco.db.DateBaseMensaje;
import app.curso.banco.db.DateBaseTransferencia;

public class MainPrincipal {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int menuSeleccionado = -1;
		String noActualizar = "0";
		do {
			System.out.println("GESTOR");
			System.out.println("_______________________________________");
			System.out.println("1. CREAR GESTOR");
			System.out.println("2. OBTENER TODOS LOS GESTORES");
			System.out.println("3. OBTENER GESTORES POR ID");
			System.out.println("4. ELIMINAR GESTORES");
			System.out.println("5. ACTUALIZAR GESTOR");
			System.out.println("_______________________________________");
			System.out.println("CLIENTE");
			System.out.println("_______________________________________");
			System.out.println("6. CREAR CLIENTE");
			System.out.println("7. OBTENER TODOS LOS CLIENTE");
			System.out.println("8. OBTENER CLIENTES POR ID");
			System.out.println("9. ELIMINAR CLIENTES");
			System.out.println("10. ACTUALIZAR CLIENTE");
			System.out.println("_______________________________________");
			System.out.println("MENSAJE");
			System.out.println("_______________________________________");
			System.out.println("11. CREAR MENSAJE");
			System.out.println("12. OBTENER TODOS LOS MENSAJE");
			System.out.println("13. OBTENER MENSAJE POR ID");
			System.out.println("14. ELIMINAR MENSAJE");
			System.out.println("15. ACTUALIZAR  MENSAJE");
			System.out.println("_______________________________________");
			System.out.println("TRANSFERENCIA");
			System.out.println("_______________________________________");
			System.out.println("16. CREAR TRANSFERENCIA");
			System.out.println("17. OBTENER TODAS LAS TRANSFERENCIA");
			System.out.println("18. OBTENER TRANSFERENCIA POR ID");
			System.out.println("19. ELIMINAR TRANSFERENCIA");
			System.out.println("20. ACTUALIZAR TRANSFERENCIA");
			System.out.println("0. SALIR");
			System.out.println("_______________________________________");

			menuSeleccionado = keyboard.nextInt();

			switch (menuSeleccionado) {
			// salir
			case 0:
				System.out.println("Saliendo...");
				break;

			case 1:
				DateBaseGestor dateBaseCrear = new DateBaseGestor();

				System.out.println("CREANDO GESTOR:");
				System.out.println("-----------------------");

				System.out.println("Ingrese nombre de  Usuario del gestor a crear:");
				String user = keyboard.next();

				System.out.println("Ingrese su Contraseña :");
				String password = keyboard.next();

				System.out.println("Ingrese su Correo :");
				String correo = keyboard.next();

				// inserta gestor
				Gestor gestor = new Gestor(1, user, password, correo);

				dateBaseCrear.insertarGestor(gestor);

				System.out.println("-----------------------");

				System.out.println("SU GESTRO SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");

				break;

			case 2:

				Scanner Keyboard = new Scanner(System.in);

				DateBaseGestor obtenerG = new DateBaseGestor();

				// System.out.println("MARQUE CON UN SI O NO" );
				// String respuesta = Keyboard.next();

				ArrayList<Gestor> gestoresMain = obtenerG.obtenerGestores();

				System.out.println("MOSTRANDO TODOS LOS GESTORES:");
				System.out.println("--------------------------------------");

				gestoresMain.forEach((llamado) -> {

					System.out.println("id del gestor :" + llamado.getId());
					System.out.println("usuario : " + llamado.getUsuario());
					System.out.println("contraseña : " + llamado.getPassword());
					System.out.println("correo : " + llamado.getCorreo());
					System.out.println("--------------------------------------");

				});

				break;

			case 3:
				DateBaseGestor obtenerGestoresPorId = new DateBaseGestor();

				System.out.println("OBTENIENDO GESTORES POR ID");
				System.out.println("------------------------------");
				System.out.println("COLOQUE EL ID DE GESTOR:");

				int id = keyboard.nextInt();

				Gestor gestor1 = obtenerGestoresPorId.obtenerUnGestor(id);

				if (gestor1 != null) {
					System.out.println("id del gestor :" + gestor1.getId() + "  " + "usuario : " + gestor1.getUsuario()
							+ " " + "contraseña :" + "  " + gestor1.getPassword());

				} else {
					System.out.println("");
				}

				break;

			case 4:
				DateBaseGestor dataBaseEliminar = new DateBaseGestor();

				System.out.println("ELIMINADO GESTOR :");
				System.out.println("----------------------- :");

				System.out.println("Inserte id del gestor que deseas eliminar :");

				int GestorEliminar = keyboard.nextInt();

				boolean gestorBorrado = dataBaseEliminar.eliminarGestor(GestorEliminar);

				if (gestorBorrado) {

					System.out.println("el gestor" + " " + GestorEliminar + " " + "se ha eliminado :");
				} else {
					System.out.println("el gestor no se ha eliminado :");

				}
				;

				break;
			case 5:
				DateBaseGestor dataBaseactualizarGestor = new DateBaseGestor();

				System.out.println("NOTA: si no desea actualizar el campo ingrese 0");
				

				System.out.println("-----------------------------------------");

				System.out.println("ingresar id del gestor a actualizar");
				int idActualizar = keyboard.nextInt();

				Gestor gestor2 = dataBaseactualizarGestor.obtenerUnGestor(idActualizar);

				System.out.println("ingresar nuevo nombre de Usuario");
				String newUser = keyboard.next();

				System.out.println("ingresar nueva contraseña");
				String newPassword = keyboard.next();

				System.out.println("ingresar nuevo correo");
				String newCorreo = keyboard.next();

				System.out.println("---------------------------");

				if (newUser.equals(noActualizar)) {

					System.out.println("----------Usuario no se ha Actualizado------------");

				} else {
					gestor2.setUsuario(newUser);
				}
				;

				if (newPassword.equals(noActualizar)) {
					System.out.println("-------------contraseña no se ha actualizado------------");

				} else {
					gestor2.setPassword(newPassword);
				}
				;

				if (newCorreo.equals(noActualizar)) {
					System.out.println("--------------correo no se ha actualizado-----------------");

				} else {
					gestor2.setCorreo(newCorreo);

				}
				;

				System.out.println("----------------------------------");

				boolean gestorActualizado = dataBaseactualizarGestor.actualizarGestor(gestor2);

				if (gestorActualizado) {
					System.out.println("ACTUALIZACION DE GESTOR");
					System.out.println("ID :" + gestor2.getId());
					System.out.println("USUARIO :" + gestor2.getUsuario());
					System.out.println("CONTRASEÑA :" + gestor2.getPassword());
					System.out.println("CORREO :" + gestor2.getCorreo());

				} else {
					System.out.println("no se ha actualizado el gestor ");
				}

				break;
			case 6:

				DateBaseCliente dateBaseCrearCliente = new DateBaseCliente();

				System.out.println("CREANDO CLIENTE:");
				System.out.println("-----------------------");

				System.out.println("Ingrese nombre del cliente:");
				String userCliente = keyboard.next();

				System.out.println("Ingrese su Contraseña :");
				String passwordCliente = keyboard.next();

				System.out.println("Ingrese su Correo :");
				String correoCliente = keyboard.next();

				System.out.print("Ingrese id del gestor :");
				String id_Gestor = keyboard.next();

				System.out.print("Coloque monto con el que desea aperturar su cuenta : ");
				String saldo = keyboard.next();

				// inserta cliente
				Cliente cliente = new Cliente(1, userCliente, passwordCliente, correoCliente, id_Gestor, saldo);

				dateBaseCrearCliente.insertarCliente(cliente);

				System.out.println("-----------------------");

				System.out.println("SU CLIENTE SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");

				break;
			case 7:
				DateBaseCliente obtenerClientes = new DateBaseCliente();

				System.out.println("MOSTRANDO TODOS LOS CLIENTES");
				System.out.println("--------------------------------------");
				// System.out.println("MARQUE CON UN SI O NO" );
				// String respuesta = Keyboard.next();

				ArrayList<Cliente> clientesMain = obtenerClientes.obtenertodosClientes();


				clientesMain.forEach((llamado) -> {

					System.out.println("ID DEL CLIENTE :" + llamado.getId());
					System.out.println("USUARIO : " + llamado.getUsuario());
					System.out.println("CONTRASEÑA :" + "  " + llamado.getPassword());
					System.out.println("ID_GESTOR :" + llamado.getId_Gestor());
					System.out.println("SALDO :" + llamado.getSaldo());
					System.out.println("--------------------------------------");

				});
				break;
			case 8:
				//OBTENER CLIENTESD POR ID
				DateBaseCliente obtenerClientesPorId = new DateBaseCliente();
				
				System.out.println("OBTENIENDO CLIENTE POR ID" );
				System.out.println("------------------------------" );
				System.out.println("COLOQUE EL ID DE CLIENTE:" );


				int id1 = keyboard.nextInt();
				
				Cliente cliente1 = obtenerClientesPorId.obtenerUnCliente(id1);
				
				if(cliente1 != null) {
					System.out.println("--------------------------------------");
					System.out.println("id:" + cliente1.getId());
					System.out.println("usuario :"  + cliente1.getUsuario());
					System.out.println("contraseña :" + cliente1.getPassword());
					System.out.println("id del gestor:"+ cliente1.getId_Gestor());
					System.out.println("salgo:" + cliente1.getSaldo());
				}else {
					System.out.println("no se ha conseguido el cliente");
				}
				break;
			case 9:
				DateBaseCliente dataBaseEliminarCliente = new DateBaseCliente();
				
				
				System.out.println("ELIMINADO CLIENTE :" );
				System.out.println("----------------------- :" );
				
				System.out.println("Inserte id del cliente que deseas eliminar :" );
				
				int clienteEliminar = keyboard.nextInt();
			
				
				
				
				/*if(GestorEliminar!=null) {
					quieron colocar que cuando, uno coloque el id del cliente se erronero mande un mensaje
				}*/
			
				
				
				boolean clienteBorrado = dataBaseEliminarCliente.eliminarCliente(clienteEliminar);
				
				if(clienteBorrado) {
					
				System.out.println("el cliente"  + "se ha eliminado :" );
				}else {
					System.out.println("el cliente no se ha eliminado :" );

				};

				break;
			case 10:
				DateBaseCliente dataBaseActualizarCliente = new DateBaseCliente();

				System.out.println("NOTA: si no desea actualizar el campo ingrese 0");
					
				
				System.out.println("-----------------------------------------");

				System.out.println("ingresar id del cliente a actualizar");
				int idActualizarCliente = keyboard.nextInt();
				
				
				
				Cliente clienteActualizar = dataBaseActualizarCliente.obtenerUnCliente(idActualizarCliente);
				
				System.out.println("ingresar nuevo nombre de Usuario:");
				String newUserCliente = keyboard.next();
				
				System.out.println("ingresar nueva contraseña:");
				String newPasswordCliente = keyboard.next();
				
				System.out.println("ingresar nuevo correo:");
				String newCorreoCliente = keyboard.next();
				
				System.out.println("ingrese nuevo id del gestor:");
				String newId_Cliente = keyboard.next();
				
				System.out.println("ingresar nuevo saldo:");
				String newSaldoCliente = keyboard.next();
				
				
				
				System.out.println("---------------------------");

				
				if(newUserCliente.equals(noActualizar)) {
					
					System.out.println("-------usuario no se ha actualizado-------");

				}else {
					clienteActualizar.setUsuario(newUserCliente);
				};
				
				if(newPasswordCliente.equals(noActualizar)) {
					System.out.println("-----contraseña no se ha actualizado-----");

				}else {
					clienteActualizar.setPassword(newPasswordCliente);
				};
				
				if(newCorreoCliente.equals(noActualizar)) {
					System.out.println("-----correo no se ha actualizado-------");

				}else {
					clienteActualizar.setCorreo(newCorreoCliente);
					
				};
				
				if(newId_Cliente.equals(noActualizar)){
					System.out.println("-----id de gestor  no se ha actualizado-----");

				}else{
					clienteActualizar.setId_Gestor(newId_Cliente);
				}
				
				if(newSaldoCliente.equals(noActualizar)){
					System.out.println("-----el saldo  no se ha actualizado-----");

				}else {
					clienteActualizar.setSaldo(newSaldoCliente);
				}
				
				System.out.println("----------------------------------");

				
				boolean ActualizadoC = dataBaseActualizarCliente.actualizarCliente(clienteActualizar);
				
				if(ActualizadoC) {
					System.out.println("ACTUALIZACION DE cliente");
					System.out.println("ID :"+clienteActualizar.getId());
					System.out.println("ID_GESTOR :"+clienteActualizar.getId_Gestor());
					System.out.println("USUARIO :"+clienteActualizar.getUsuario());
					System.out.println("CONTRASEÑA :"+clienteActualizar.getPassword());
					System.out.println("CORREO :" +clienteActualizar.getCorreo());
					System.out.println("SALDO:"+clienteActualizar.getSaldo());
					System.out.println("-------------------------------------");

					
				}else {
					System.out.println("no se ha actualizado el gestor ");
				}
				
				break;
			case 11:
				DateBaseMensaje dateBaseCrearMensaje = new  DateBaseMensaje();
				
				System.out.println("CREANDO MENSAJE:");
				System.out.println("-----------------------");

				System.out.println("Ingrese Id origen :");
				int id_origenMensaje = keyboard.nextInt();
			
				
				System.out.println("Ingrese Id destino :");
				int id_destinoMensaje = keyboard.nextInt();
				
				System.out.println("Por favor ingrese mensaje a enviar:");
				String envioMensaje = keyboard.next();
				
			
				
				Date fecha = new Date();
				
				long ms= fecha.getTime();
				Timestamp datetimeMensaje = new Timestamp(ms);
				
				//inserta mensaje
				Mensaje mensaje = new Mensaje(1, id_origenMensaje,id_destinoMensaje,envioMensaje,datetimeMensaje );
				
				dateBaseCrearMensaje.insertarMensaje(mensaje);

				System.out.println("-----------------------");

				System.out.println("SU MENSAjE SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");


				break;
			case 12:
				// OBTEENR TODOS LOS MENSAJE
				DateBaseMensaje obtenerMensajesTodos = new DateBaseMensaje();
				
				System.out.println("DESEAS OBTENER TODOS LOS MENSAJE" );
				System.out.println("--------------------------------------" );
				//System.out.println("MARQUE CON UN SI O NO" );
			//	String respuesta =  Keyboard.next();
				
				ArrayList<Mensaje> mensajeMain = obtenerMensajesTodos.obtenerMensaje();
				
				
					System.out.println("MOSTRANDO MENSAJE:" );

				mensajeMain.forEach((llamado) -> {
					
					System.out.println("ID DE MENSAJE :"+llamado.getId());
					System.out.println("ID DE ORIGEN : " + llamado.getId_origen());
					System.out.println("ID DESTINO :"+llamado.getId_destino());

					System.out.println("TEXTO DE MENSAJE:"+ llamado.getTexto());
					System.out.println("FECHA Y HORA DE ENVIO DE MENSAJE:"+llamado.getDatetime());
					System.out.println("--------------------------------------" );

				});
				break;
			case 13:
				// obteccion de un mensaje
				
				DateBaseMensaje obtenerMensajePorId = new DateBaseMensaje();
				
				System.out.println("OBTENIENDO MENSAJE POR ID" );
				System.out.println("------------------------------" );
				System.out.println("COLOQUE EL ID DE MENSAJE:" );


				int idMensaje = keyboard.nextInt();
				
				Mensaje mensajeId = obtenerMensajePorId.obtenerMensajeId(idMensaje);
				
				if(mensajeId != null) {
					System.out.println("id de mensaje:"+ mensajeId.getId());
					System.out.println("id de origen:"+ mensajeId.getId_origen());
					System.out.println("id de destino:"+ mensajeId.getId_destino());
					System.out.println("Mensaje:"+ mensajeId.getTexto());
					System.out.println("fecha y hora de envio:"+ mensajeId.getDatetime());
					System.out.println("-----------------------------------------------" );




					
				}else {
					System.out.println("");
				}

				break;
			case 14:
				DateBaseMensaje dataBaseEliminarMensaje = new DateBaseMensaje();
				
				
				System.out.println("ELIMINADO MENSAJE :" );
				System.out.println("----------------------- :" );
				
				System.out.println("INSERTE EL ID DEL MENSAJE QUE DESEAS ELIMINAR :" );
				
				int mensajeEliminar = keyboard.nextInt();
			
				
				
				
				/*if(GestorEliminar) {
					
				}*/
				
				
				
				boolean mensajeBorrado = dataBaseEliminarMensaje.eliminarMensaje(mensajeEliminar);
				
				if(mensajeBorrado) {
					
				System.out.println("EL MENSAJE" +" "+mensajeEliminar+ " " + "SE HA ELIMINADO :" );
				}else {
					System.out.println("EL MENSAJE NO SE HA ELIMINADO :" );

				};

				break;
			case 15:
				DateBaseMensaje dataBaseActualizarMensaje = new DateBaseMensaje();

				System.out.println("NOTA: si no desea actualizar el campo ingrese 0");
				
				System.out.println("-----------------------------------------");

				System.out.println("INGRESE EL ID DEL MENSAJE QUE DESEAS ACTUALIZAR:");
				int idActualizarMensaje = keyboard.nextInt();
				
				
				
				Mensaje mensaje1 = dataBaseActualizarMensaje.obtenerMensajeId(idActualizarMensaje);
				
				System.out.println("ingresar nuevo id de origen");
				int newIdOrigenMensaje = keyboard.nextInt();
				
				System.out.println("ingresar nuevo id destino");
				int newIdDestinoMensaje = keyboard.nextInt();
				
				System.out.println("ingresar nuevo texto");
				String newTextoMensaje = keyboard.next();
				
				System.out.println("ingrese 'si' para actualizar la fecha");
				String respuesta =keyboard.next();
				Date fecha1 = new Date();
				
				long ms1= fecha1.getTime();
				Timestamp datetime1 = new Timestamp(ms1);
				
				
				
				System.out.println("---------------------------");

				
				if(newIdOrigenMensaje==0) {
					
					System.out.println("id_origen no se ha actualizado");

				}else {
					mensaje1.setId_origen(newIdOrigenMensaje);
				};
				
				if(newIdDestinoMensaje ==0) {
					System.out.println("id_destino no se ha actualizado");

				}else {
					mensaje1.setId_destino(newIdDestinoMensaje);
				
				};
				
				if(newTextoMensaje.equals(noActualizar)) {
					System.out.println("texto no se ha actualizado");

				}else {
					mensaje1.setTexto(newTextoMensaje);
					
				};
				
				if(respuesta.equals(noActualizar)) {
					System.out.println("fecha y hora no se ha actualizado");
				
				}else {
					mensaje1.setDatetime(datetime1);
				}
				
				
				System.out.println("----------------------------------");

				
				boolean mensajeActualizado = dataBaseActualizarMensaje.actualizarMensaje(mensaje1);
				
				if(mensajeActualizado) {
					System.out.println("ACTUALIZACION DE MENSAJE");
					System.out.println("ID :"+mensaje1.getId());
					System.out.println("ID_ORIGEN:"+mensaje1.getId_origen());
					System.out.println("ID_DESTINO :"+mensaje1.getId_destino());
					System.out.println("TEXTO :" +mensaje1.getTexto());
					System.out.println("FECHA :" +mensaje1.getDatetime());
					System.out.println("----------------------------------");


					
				}else {
					System.out.println("no se ha actualizado el gestor ");
				}
				

				break;
			case 16:
				DateBaseTransferencia dateBaseCrearTransferencia = new  DateBaseTransferencia();
				
				System.out.println("CREANDO TRANSFERENCIA:");
				System.out.println("-----------------------");

			
				
				System.out.println("Ingrese Id ordenante :");
				int id_ordenanteTransferencia = keyboard.nextInt();
				
				System.out.println("ingrese Id Benefeciario:");
				int id_beneficiarioTransferencia = keyboard.nextInt();
				
				System.out.println("Ingrese Importe:");
				double importeTransferencia = keyboard.nextDouble();
			
				System.out.println("Ingrese Concepto:");
				String conceptoTransferencia = keyboard.next();
				
				
				
				Date fecha2 = new Date();
				
				long ms2= fecha2.getTime();
				Timestamp datetime2 = new Timestamp(ms2);
				
				//inserta mensaje
				Transferencia transferencia = new Transferencia(1,id_ordenanteTransferencia,id_beneficiarioTransferencia,importeTransferencia,conceptoTransferencia,datetime2 );
				
				dateBaseCrearTransferencia.insertarTransferencia(transferencia);

				System.out.println("-----------------------");

				System.out.println("SU TRANSFERENCIA SE HA CREADO CORRECTAMENTE. PUEDE VERIFICARLO EN LA BASE DE DATOS");

				break;
			case 17:
				DateBaseTransferencia obtenerTransferenciaTodos = new DateBaseTransferencia();
				
				System.out.println("MOSTRANDO TODAS LAS TRANSFERENCIA" );
				System.out.println("--------------------------------------" );
				//System.out.println("MARQUE CON UN SI O NO" );
			//	String respuesta =  Keyboard.next();
				
				ArrayList<Transferencia> transferenciaMain = obtenerTransferenciaTodos.obtenerTodasTransferencia();
				
				

				transferenciaMain.forEach((llamado) -> {
					
					System.out.println("id de transferencia:"+llamado.getId());
					System.out.println("id ordenante : " + llamado.getId_ordenante());
					System.out.println("id benefeciario :"+llamado.getId_beneficiario());
					System.out.println("Importe:"+ llamado.getImporte());
					System.out.println("Concepto:"+ llamado.getImporte());
					System.out.println("Fecha y hora de envio de transferencia: "+llamado.getFecha());
					System.out.println("--------------------------------------" );

				});
				break;
			case 18:
				DateBaseTransferencia obtenerTransferenciaPorId = new DateBaseTransferencia();
				
				System.out.println("OBTENIENDO TRANSFERENCIA POR ID" );
				System.out.println("------------------------------" );
				System.out.println("COLOQUE EL ID DE TRANSFERENCIA:" );


				int idTransferencia = keyboard.nextInt();
				
				Transferencia transferencia1 = obtenerTransferenciaPorId.obtenerTransferenciaId(idTransferencia);
				
				if(transferencia1 != null) {
					System.out.println("id de transferencia:"+ transferencia1.getId());
					System.out.println("id ordenante:"+ transferencia1.getId_ordenante());
					System.out.println("id beneficiario:"+ transferencia1.getId_beneficiario());
					System.out.println("Importe :"+ transferencia1.getImporte());
					System.out.println("Concepto :"+ transferencia1.getConcepto());
					System.out.println("Concepto:" + transferencia1.getFecha());



					
				}else {
					System.out.println("");
				}
				break;
			case 19:
				DateBaseTransferencia dataBaseEliminarTransferencia = new DateBaseTransferencia();
				
				
				System.out.println("ELIMINADO TRANSFERENCIA :" );
				System.out.println("----------------------- :" );
				
				System.out.println("Inserte id de la transferencia que deseas eliminar :" );
				
				int transferenciaEliminar = keyboard.nextInt();
			
				
				
				
				/*if(GestorEliminar) {
					
				}*/
				
				
				
				boolean transferenciaBorrado = dataBaseEliminarTransferencia.eliminarTransferencia(transferenciaEliminar);
				
				if(transferenciaBorrado) {
					
				System.out.println("la transferencia" +" "+transferenciaEliminar+ " " + "se ha eliminado :" );
				}else {
					System.out.println("el mensaje no se ha eliminado :" );

				};
				break;
			case 20:
				DateBaseTransferencia dataBaseActualizarTransferencia = new DateBaseTransferencia();

				System.out.println("NOTA: si no desea actualizar el campo ingrese 0");
				
				System.out.println("-----------------------------------------");

				System.out.println("ingresar id de la transferencia a actualizar");
				int idActualizarTransferencia = keyboard.nextInt();

				Transferencia transferencia2 = dataBaseActualizarTransferencia.obtenerTransferenciaId(idActualizarTransferencia);

				System.out.println("ingresar nuevo id de ordenante:");
				int newIdOrdenanteTransferencia = keyboard.nextInt();

				System.out.println("ingresar nuevo id beneficiario:");
				int newIdBeneficiarioTransferencia = keyboard.nextInt();

				System.out.println("ingresar nuevo importe:");
				double newImporteTransferencia = keyboard.nextDouble();
				
				System.out.println("ingresar nuevo concepto:");
				String newConceptoTransferencia = keyboard.next();

				System.out.println("coloque 'si' para actualizar fecha");
				String respuesta2 = keyboard.next();
				
				
				
				
				Date fecha3 = new Date();

				long ms3 = fecha3.getTime();
				Timestamp datetime3 = new Timestamp(ms3);

				System.out.println("---------------------------");

				if (newIdOrdenanteTransferencia == 0) {

					System.out.println("-----id ordenante no se ha actualizado-------");

				} else {
					transferencia2.setId_ordenante(newIdOrdenanteTransferencia);
				}
				;

				if (newIdBeneficiarioTransferencia == 0) {
					System.out.println("-----------id beneficiario no se ha actualizado------------");

				} else {
					transferencia2.setId_beneficiario(newIdBeneficiarioTransferencia);

				}
				if (newImporteTransferencia == 0) {
					System.out.println("----------importe no se ha actualizado-----------");

				} else {
					transferencia2.setImporte(newImporteTransferencia);
				}
				

				if (newConceptoTransferencia.equals(noActualizar)) {
					System.out.println("---------concepto no se ha actualizado---------");

				} else {
					transferencia2.setConcepto(newConceptoTransferencia);

				}
				if(respuesta2.equals(noActualizar)){
					System.out.println("-------fecha y hora no se ha actualizado-----");

				}else {
					transferencia2.setFecha(datetime3);

				};

				/*if (datetime.equals(noActualizar)) {
					System.out.println("fecha y hora no se ha actualizado");

				} else {
					transferencia.setFecha(datetime);
				}*/

				System.out.println("----------------------------------");

				boolean transferenciaActualizado = dataBaseActualizarTransferencia.actualizarTransferencia(transferencia2);

				if (transferenciaActualizado) {
					System.out.println("ACTUALIZACION TRANSFERENCIA");
					
					System.out.println("ID :" + transferencia2.getId());
					System.out.println("ID ORDENANTE :" + transferencia2.getId_ordenante());
					System.out.println("ID BENEFICIARIO :" + transferencia2.getId_beneficiario());
					System.out.println("IMPORTE:" + transferencia2.getImporte());
					System.out.println("CONCEPTO:" + transferencia2.getConcepto());
					System.out.println("FECHA Y HORA:" + transferencia2.getFecha()); 	


				} else {
					System.out.println("no se ha actualizado el gestor ");
				}

				break;
			default:
				System.out.println("Opción desconocida...");
				break;
			}

		} while (menuSeleccionado != 0);

	}

}
