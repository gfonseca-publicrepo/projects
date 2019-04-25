package model;

public class Empresa {

	private int id;
	private String ramo;
	private String nome;
	private String tipo;
	private String descricao;
	private String cnpj;
	private String inscMunicipal;
	private String inscEstadual;
	private Endereco endereco;

	public Empresa(int id, String ramo, String nome, String tipo, String descricao, String cnpj, String inscMunicipal,
			String inscEstadual, Endereco endereco) {
		super();
		this.id = id;
		this.ramo = ramo;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.cnpj = cnpj;
		this.inscMunicipal = inscMunicipal;
		this.inscEstadual = inscEstadual;
		this.endereco = endereco;
	}

	public Empresa(int id, String ramo, String nome, String tipo, String descricao, String cnpj, String inscMunicipal,
			String inscEstadual) {
		super();
		this.id = id;
		this.ramo = ramo;
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
		this.cnpj = cnpj;
		this.inscMunicipal = inscMunicipal;
		this.inscEstadual = inscEstadual;

	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

}
