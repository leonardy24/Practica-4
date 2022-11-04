package cliente.gestor;

public class Persona {

	protected int id;
	protected String usuario;
	protected int password;
	protected String correo;
	
	
	
	
	//constructor por defecto
	public Persona (){
		
	};
	
	//contructor parametrizado
	
	public Persona(int id, String usuario, int password, String correo){
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
		
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	};
	
	
	
	
	
	
}
