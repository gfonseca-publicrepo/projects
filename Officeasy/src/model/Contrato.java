package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import model.DAO.ContratoDAO;

public class Contrato {

	private int numero;
	private String nome;
	private int vigencia;
	private Date data;
	private String status;
	private String anotacoes;
	private Empresa empresa;

	public Contrato(String nome, int numero, int vigencia, Date data, String status, String anotacoes,
			Empresa empresa) {

		super();
		this.nome = nome;
		this.numero = numero;
		this.vigencia = vigencia;
		this.data = data;
		this.status = status;
		this.anotacoes = anotacoes;
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getVigencia() {
		return vigencia;
	}

	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return getNome();
	}

	public static JComboBox<Contrato> cboxContrato() {

		JComboBox<Contrato> cbox = new JComboBox<Contrato>();

		List<Contrato> listaContratos = new ArrayList<Contrato>();
		listaContratos = ContratoDAO.carregarContratos();

		Contrato contrato = null;

		for (int i = 1; i <= listaContratos.size(); i++) {
			contrato = listaContratos.get(i - 1);
			cbox.addItem(contrato);
		}

		return cbox;

	}

}
