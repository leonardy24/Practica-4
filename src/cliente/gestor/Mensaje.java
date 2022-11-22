package cliente.gestor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Timestamp;

public class Mensaje {

	private int id;
	private int id_origen;
	private int id_destino;
	private String texto;
	private Timestamp datetime;

	// contructor por defecto
	public Mensaje() {

	};

	// constructor parametrizado
	public Mensaje(int id, int id_origen, int id_destino, String texto, Timestamp datetime) {

		this.id = id;
		this.id_origen = id_origen;
		this.id_destino = id_destino;
		this.texto = texto;
		this.datetime = datetime;

	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_origen() {
		return id_origen;
	}

	public void setId_origen(int id_origen) {
		this.id_origen = id_origen;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
