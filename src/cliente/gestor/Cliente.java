package cliente.gestor;

public class Cliente extends Persona {

	protected String id_Gestor ;
	
	protected String saldo;
	
	
	public Cliente() {
		
	};
	
	
	
	
	public Cliente (int id, String usuario, String password, String correo, String id_Gestor, String saldo) {
		super(id,usuario, password,correo);
		this.id_Gestor = id_Gestor;
	
		this.saldo = saldo;
		
		
	}


	public String getId_Gestor() {
		return id_Gestor;
	}


	public void setId_Gestor(String id_Gestor) {
		this.id_Gestor = id_Gestor;
	}


	public String getSaldo() {
		return saldo;
	}


	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}




	
	
	
}
