package model;

public abstract class Usuario {

	private int login;
	private String senha;
	private Permissoes nivel;
	private boolean status;
	private boolean manterLogado;
	private boolean logado;

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Permissoes getNivel() {
		return nivel;
	}

	public void setNivel(Permissoes nivel) {
		this.nivel = nivel;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isManterLogado() {
		return manterLogado;
	}

	public void setManterLogado(boolean manterLogado) {
		this.manterLogado = manterLogado;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Usuario(int login, String senha, Permissoes nivel, boolean status, boolean manterLogado, boolean logado) {
		super();
		this.login = login;
		this.senha = senha;
		this.nivel = nivel;
		this.status = status;
		this.manterLogado = manterLogado;
		this.logado = logado;
	}

	public Usuario(int login, String senha) {

		this.login = login;
		this.senha = senha;
	}

	public Usuario() {

	}

}
