package model;

import java.util.Date;

public class Certificado {

	private int id;
	private String nomeCertificado;
	private Date emissao;
	private String instituicao;
	private String descricao;
	private Date validade;

	public Certificado(int id, String nomeCertificado, Date emissao, String instituicao, String descricao,
			Date validade) {
		super();
		this.id = id;
		this.nomeCertificado = nomeCertificado;
		this.emissao = emissao;
		this.instituicao = instituicao;
		this.descricao = descricao;
		this.validade = validade;
	}

	public Certificado(String nomeCertificado, Date emissao, String instituicao, String descricao,
			Date validade) {
		super();
		this.nomeCertificado = nomeCertificado;
		this.emissao = emissao;
		this.instituicao = instituicao;
		this.descricao = descricao;
		this.validade = validade;
	}


	public String getNomeCertificado() {
		return nomeCertificado;
	}

	public void setNomeCertificado(String nomeCertificado) {
		this.nomeCertificado = nomeCertificado;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getId() {
		return id;
	}

}
