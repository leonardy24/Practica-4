package cliente.gestor;

public class Cliente extends Persona {

	protected int id_Gestor ;
	
	protected int saldo;
	
	
	public Cliente (int id, String usuario, String password, String correo, int id_Gestor,  int saldo) {
		super(id,usuario, password,correo);
		this.id_Gestor = id_Gestor;
	
		this.saldo = saldo;
		
		
	};
	
	
}
