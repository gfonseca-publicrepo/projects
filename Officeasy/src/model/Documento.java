package model;

import java.util.Date;

public class Documento {

	private int id;
	private String titulo;
	private String autor;
	private String assunto;
	private Date date;
	private String caminho;

	public Documento(int id, String titulo, String autor, String assunto, Date date, String caminho) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.assunto = assunto;
		this.date = date;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
