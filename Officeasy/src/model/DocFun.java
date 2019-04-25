package model;

import java.util.Date;
import java.util.List;

public class DocFun {

	private int id;
	private String rg;
	private String orgaoEmissor;
	private Date dtEmissao;
	private String cpf;
	private String ctps;
	private String pis;
	private String pai;
	private String mae;
	private Date aso;
	private List<Certificado> certificados;

	public DocFun(int id, String rg, String orgaoEmissor, Date dtEmissao, String cpf, String ctps, String pis,
			String pai, String mae, Date aso, List<Certificado> certificados) {
		super();
		this.id = id;
		this.rg = rg;
		this.orgaoEmissor = orgaoEmissor;
		this.dtEmissao = dtEmissao;
		this.cpf = cpf;
		this.ctps = ctps;
		this.pis = pis;
		this.pai = pai;
		this.mae = mae;
		this.aso = aso;
		this.certificados = certificados;

	}

	public DocFun(String rg, String orgaoEmissor, Date dtEmissao, String cpf, String ctps, String pis, String pai,
			String mae, Date aso, List<Certificado> certificados) {

		this.rg = rg;
		this.orgaoEmissor = orgaoEmissor;
		this.dtEmissao = dtEmissao;
		this.cpf = cpf;
		this.ctps = ctps;
		this.pis = pis;
		this.pai = pai;
		this.mae = mae;
		this.aso = aso;
		this.certificados = certificados;

	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Date getAso() {
		return aso;
	}

	public void setAso(Date aso) {
		this.aso = aso;
	}

	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}

	public int getId() {
		return id;
	}

}
