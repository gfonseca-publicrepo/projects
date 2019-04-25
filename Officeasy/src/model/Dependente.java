package model;

import java.util.Date;

public class Dependente {

	private int id;
	private String nome;
	private String rg;
	private String cpf;
	private Date nascimento;
	private String grau;

	public Dependente(int id, String nome, String rg, String cpf, Date nascimento, String grau) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.grau = grau;
	}

	public Dependente(String nome, String rg, String cpf, Date nascimento, String grau) {
	
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.grau = grau;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return nome;
	}

}
