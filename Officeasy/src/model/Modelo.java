package model;

public class Modelo {

	private int id;
	private String titulo;
	private String caminho;

	public Modelo(int id, String titulo, String caminho) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.caminho = caminho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
