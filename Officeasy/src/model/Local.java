package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import model.DAO.LocalDAO;

public class Local {

	private int id;
	private String nome;
	private String descricao;

	public Local(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return getNome();
	}

	public static JComboBox<Local> cboxLocais() { // CARREGA COMBO BOX DE "LOCAIS"

		JComboBox<Local> cbox = new JComboBox<Local>(); // Cria JComboBox do tipo "Local"

		List<Local> listaLocais = new ArrayList<Local>(); // Cria array de objetos de "Local"
		listaLocais = LocalDAO.carregarNiveis(); // Carrega objetos no array direto do banco

		Local locais = null; // Instancia de objeto "Local"

		// Loop para adicionar objetos da combo box
		for (int i = 1; i <= listaLocais.size(); i++) {
			locais = listaLocais.get(i - 1);
			cbox.addItem(locais);
		}
		// retorna a combo box pronta
		return cbox;

	}

}
