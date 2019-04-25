package model;

public class HistFun {

	private int id;
	private String cargo;
	private double salario;
	private Local local;
	private String cargaH;
	private Contrato contrato;
	private String estadoCivil;
	private String telefone;
	private String celular;
	private String email;

	public HistFun(int id, String cargo, double salario, Local local, String cargaH, Contrato contrato,
			String estadoCivil, String telefone, String celular, String email) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.salario = salario;
		this.local = local;
		this.cargaH = cargaH;
		this.contrato = contrato;
		this.estadoCivil = estadoCivil;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getCargaH() {
		return cargaH;
	}

	public void setCargaH(String cargaH) {
		this.cargaH = cargaH;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
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

}
