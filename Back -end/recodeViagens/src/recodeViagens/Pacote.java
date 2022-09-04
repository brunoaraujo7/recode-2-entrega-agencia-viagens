package recodeViagens;

public class Pacote {

	private int id;
	private int id_destino;
	private double valor;
	private int diaria;
	private String modal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getDiaria() {
		return diaria;
	}

	public void setDiaria(int diaria) {
		this.diaria = diaria;
	}

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}

}