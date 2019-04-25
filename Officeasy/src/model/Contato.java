package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.DAO.ContatoDAO.CategoriaCTDAO;

public class Contato {

	private int id;
	private String nome;
	private String telefone;
	private String celular;
	private String email;
	private String descricao;
	private CategoriaCT categoria;

	public Contato(int id, String nome, String telefone, String celular, String email, String descricao,
			CategoriaCT categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaCT getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaCT categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public static class CategoriaCT {

		private int id;
		private String categoria;

		public CategoriaCT(int id, String categoria) {

			this.id = id;
			this.categoria = categoria;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public int getId() {
			return id;
		}

		public static JComboBox<CategoriaCT> cboxCategoriaContato() {

			JComboBox<CategoriaCT> cbox = new JComboBox<CategoriaCT>();

			List<CategoriaCT> listaCategoriaCT = new ArrayList<CategoriaCT>();
			listaCategoriaCT = CategoriaCTDAO.listarCategoriasCT();

			CategoriaCT categoriaCT = null;

			for (int i = 1; i <= listaCategoriaCT.size(); i++) {
				categoriaCT = listaCategoriaCT.get(i - 1);
				cbox.addItem(categoriaCT);
			}

			return cbox;

		}

		@Override
		public String toString() {
			return categoria;
		}

	}

}
