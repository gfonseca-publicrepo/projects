package model;

public class Pasta {

	private int id;
	private String nomePast;
	private String caminho;
	private String assunto;
	private int fkdpto;

	public Pasta(int id, String nomePast, String caminho, String assunto, int fkdpto) {
		super();
		this.id = id;
		this.nomePast = nomePast;
		this.caminho = caminho;
		this.assunto = assunto;
		this.fkdpto = fkdpto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomePast() {
		return nomePast;
	}

	public void setNomePast(String nomePast) {
		this.nomePast = nomePast;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public int getFkdpto() {
		return fkdpto;
	}

	public void setFkdpto(int fkdpto) {
		this.fkdpto = fkdpto;
	}

	

}
