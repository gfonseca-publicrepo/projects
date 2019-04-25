package model;

import java.util.Date;

public class DadosFun {

	private int id;
	private Date dtAdmissao;
	private Date dtDesligamento;
	private double salario;
	private int cargaH;
	private Date dtNascimento;
	private String estadoCivil;
	private String sexo;
	private String telefone;
	private String celular;
	private String email;
	private int FKMatricula;

	// CONSTRUTOR PADRAO
	public DadosFun(int id, Date dtAdmissao, Date dtDesligamento, double salario, int cargaH, Date dtNascimento,
			String estadoCivil, String sexo, String telefone, String celular, String email, int FKMatricula) {
		super();
		this.id = id;
		this.dtAdmissao = dtAdmissao;
		this.dtDesligamento = dtDesligamento;
		this.salario = salario;
		this.cargaH = cargaH;
		this.dtNascimento = dtNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.FKMatricula = FKMatricula;
	}

	// CONSTRUTOR NOVOS DADOS DE FUNCIONARIO
	public DadosFun(Date dtAdmissao, double salario, int cargaH, Date dtNascimento, String estadoCivil, String sexo,
			String telefone, String celular, String email) {

		this.dtAdmissao = dtAdmissao;
		this.salario = salario;
		this.cargaH = cargaH;
		this.dtNascimento = dtNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public Date getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	public Date getDtDesligamento() {
		return dtDesligamento;
	}

	public void setDtDesligamento(Date dtDesligamento) {
		this.dtDesligamento = dtDesligamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCargaH() {
		return cargaH;
	}

	public void setCargaH(int cargaH) {
		this.cargaH = cargaH;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public int getFKMatricula() {
		return FKMatricula;
	}

	public void setFKMatricula(int fKMatricula) {
		FKMatricula = fKMatricula;
	}

}
