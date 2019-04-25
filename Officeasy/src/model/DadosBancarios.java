package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.DAO.DadosBancariosDAO.BancoDAO;
import model.DAO.DadosBancariosDAO.TipoContaDAO;

public class DadosBancarios {

	private int id;
	private String numeroConta;
	private String agencia;
	private TipoConta tpConta;
	private Banco banco;

	public DadosBancarios(int id, String numeroConta, String agencia, TipoConta tpConta, Banco banco) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.tpConta = tpConta;
		this.banco = banco;
	}
	
	public DadosBancarios(String numeroConta, String agencia, TipoConta tpConta, Banco banco) {
		
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.tpConta = tpConta;
		this.banco = banco;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public TipoConta getTpConta() {
		return tpConta;
	}

	public void setTpConta(TipoConta tpConta) {
		this.tpConta = tpConta;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public int getId() {
		return id;
	}

	public static class TipoConta {

		private int id;
		private String tipo;

		public TipoConta(int id, String tipo) {
			super();
			this.id = id;
			this.tipo = tipo;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public int getId() {
			return id;
		}

		public static JComboBox<TipoConta> cboxTipoConta() {

			JComboBox<TipoConta> cbox = new JComboBox<TipoConta>();

			List<TipoConta> listaTipos = new ArrayList<TipoConta>();
			listaTipos = TipoContaDAO.carregarBox();

			TipoConta tipos = null;

			for (int i = 1; i <= listaTipos.size(); i++) {
				tipos = listaTipos.get(i - 1);
				cbox.addItem(tipos);
			}

			return cbox;

		}

		@Override
		public String toString() {

			return getTipo();
		}

	}

	public static class Banco {

		private int id;
		private String codBanco;
		private String nomeBanco;

		public Banco(int id, String codBanco, String nomeBanco) {
			super();
			this.id = id;
			this.codBanco = codBanco;
			this.nomeBanco = nomeBanco;
		}

		public String getCodBanco() {
			return codBanco;
		}

		public void setCodBanco(String codBanco) {
			this.codBanco = codBanco;
		}

		public String getNomeBanco() {
			return nomeBanco;
		}

		public void setNomeBanco(String nomeBanco) {
			this.nomeBanco = nomeBanco;
		}

		public int getId() {
			return id;
		}

		public static JComboBox<Banco> cboxBanco() {

			JComboBox<Banco> cbox = new JComboBox<Banco>();

			List<Banco> listaBancos = new ArrayList<Banco>();
			listaBancos = BancoDAO.carregarBox();

			Banco bancos = null;

			for (int i = 1; i <= listaBancos.size(); i++) {
				bancos = listaBancos.get(i - 1);
				cbox.addItem(bancos);
			}

			return cbox;

		}

		@Override
		public String toString() {

			return getNomeBanco();
		}

	}

}
