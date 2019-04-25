package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import model.DAO.PermissoesDAO;

public class Permissoes {
	
	private int id;
	private String nome;
	private boolean chat;
	private boolean logs;
	private boolean alterarPasta;
	private boolean cadUsu;
	private boolean cadFun;
	private boolean cadPerm;
	private boolean cadModelo;
	private boolean cadLocal;
	private boolean cadEmpresa;
	private boolean cadDocumento;
	private boolean cadEquipamento;

	public Permissoes(int id, String nome, boolean chat, boolean logs, boolean alterarPastas, boolean cadUsu,
			boolean cadFun, boolean cadPerm, boolean cadModelo, boolean cadLocal, boolean cadEmpresa,
			boolean cadDocumento, boolean cadEquipamento) {

		this.id = id;
		this.nome = nome;
		this.chat = chat;
		this.logs = logs;
		this.alterarPasta = alterarPastas;
		this.cadUsu = cadUsu;
		this.cadFun = cadFun;
		this.cadPerm = cadPerm;
		this.cadModelo = cadModelo;
		this.cadLocal = cadLocal;
		this.cadEmpresa = cadEmpresa;
		this.cadDocumento = cadDocumento;
		this.cadEquipamento = cadEquipamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isChat() {
		return chat;
	}

	public void setChat(boolean chat) {
		this.chat = chat;
	}

	public boolean isLogs() {
		return logs;
	}

	public void setLogs(boolean logs) {
		this.logs = logs;
	}

	public boolean isAlterarPastas() {
		return alterarPasta;
	}

	public void setAlterarPastas(boolean alterarPastas) {
		this.alterarPasta = alterarPastas;
	}

	public boolean isCadUsu() {
		return cadUsu;
	}

	public void setCadUsu(boolean cadUsu) {
		this.cadUsu = cadUsu;
	}

	public boolean isCadFun() {
		return cadFun;
	}

	public void setCadFun(boolean cadFun) {
		this.cadFun = cadFun;
	}

	public boolean isCadPerm() {
		return cadPerm;
	}

	public void setCadPerm(boolean cadPerm) {
		this.cadPerm = cadPerm;
	}

	public boolean isCadModelo() {
		return cadModelo;
	}

	public void setCadModelo(boolean cadModelo) {
		this.cadModelo = cadModelo;
	}

	public boolean isCadLocal() {
		return cadLocal;
	}

	public void setCadLocal(boolean cadLocal) {
		this.cadLocal = cadLocal;
	}

	public boolean isCadEmpresa() {
		return cadEmpresa;
	}

	public void setCadEmpresa(boolean cadEmpresa) {
		this.cadEmpresa = cadEmpresa;
	}

	public boolean isCadDocumento() {
		return cadDocumento;
	}

	public void setCadDocumento(boolean cadDocumento) {
		this.cadDocumento = cadDocumento;
	}

	public boolean isCadEquipamento() {
		return cadEquipamento;
	}

	public void setCadEquipamento(boolean cadEquipamento) {
		this.cadEquipamento = cadEquipamento;
	}

	public int getId() {
		return id;
	}
	
	public static JComboBox<Permissoes> cboxNiveis() {

		JComboBox<Permissoes> cbox0 = new JComboBox<Permissoes>();

		List<Permissoes> listaPermissoes = new ArrayList<Permissoes>();
		listaPermissoes = PermissoesDAO.carregarNiveis();

		Permissoes permissoes = null;

		for (int i = 1; i <= listaPermissoes.size(); i++) {
			permissoes = listaPermissoes.get(i - 1);
			cbox0.addItem(permissoes);
		}

		return cbox0;

	}

	@Override
	public String toString() {
		return getNome();
	}


}
