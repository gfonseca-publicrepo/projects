package model;

public class Dpto {

	private int id;
	private String nome;
	private String assunto;
	
	public Dpto(int id, String nome, String assunto) {
		super();
		this.id = id;
		this.nome = nome;
		this.assunto = assunto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	

	
}
