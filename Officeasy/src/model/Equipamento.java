package model;

import java.util.Date;

public class Equipamento {

	private int id;
	private String nome;
	private String marca;
	private String modelo;
	private String descricao;
	private double vlCompra;
	private TipoEquip tipo;
	private CondEquip condicao;
	private DadosEquip dados;
	private HistEquip historico;
	private Funcionario responsavel;
	private Local local;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getVlCompra() {
		return vlCompra;
	}

	public void setVlCompra(double vlCompra) {
		this.vlCompra = vlCompra;
	}

	public TipoEquip getTipo() {
		return tipo;
	}

	public void setTipo(TipoEquip tipo) {
		this.tipo = tipo;
	}

	public CondEquip getCondicao() {
		return condicao;
	}

	public void setCondicao(CondEquip condicao) {
		this.condicao = condicao;
	}

	public DadosEquip getDados() {
		return dados;
	}

	public void setDados(DadosEquip dados) {
		this.dados = dados;
	}

	public HistEquip getHistorico() {
		return historico;
	}

	public void setHistorico(HistEquip historico) {
		this.historico = historico;
	}

	public Funcionario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public int getId() {
		return id;
	}

	public static class TipoEquip {

		private int id;
		private String tipo;

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public int getId() {
			return id;
		}

	}

	public static class CondEquip {

		private int id;
		private String condicao;

		public String getCondicao() {
			return condicao;
		}

		public void setCondicao(String condicao) {
			this.condicao = condicao;
		}

		public int getId() {
			return id;
		}

	}

	public static class DadosEquip {

		private int id;
		private String acessorios;
		private String numSerie;
		private String numPart;
		private String fornecedor;
		private Date dtCompra;
		private Date dtCalibracao;
		private String vencimento;

		public String getAcessorios() {
			return acessorios;
		}

		public void setAcessorios(String acessorios) {
			this.acessorios = acessorios;
		}

		public String getNumSerie() {
			return numSerie;
		}

		public void setNumSerie(String numSerie) {
			this.numSerie = numSerie;
		}

		public String getNumPart() {
			return numPart;
		}

		public void setNumPart(String numPart) {
			this.numPart = numPart;
		}

		public String getFornecedor() {
			return fornecedor;
		}

		public void setFornecedor(String fornecedor) {
			this.fornecedor = fornecedor;
		}

		public Date getDtCompra() {
			return dtCompra;
		}

		public void setDtCompra(Date dtCompra) {
			this.dtCompra = dtCompra;
		}

		public Date getDtCalibracao() {
			return dtCalibracao;
		}

		public void setDtCalibracao(Date dtCalibracao) {
			this.dtCalibracao = dtCalibracao;
		}

		public String getVencimento() {
			return vencimento;
		}

		public void setVencimento(String vencimento) {
			this.vencimento = vencimento;
		}

		public int getId() {
			return id;
		}

	}

	public static class HistEquip {

		private int id;
		private Local local;
		private Funcionario responsavel;
		private Date dtVerificao;
		private Date vencimento;
		private CondEquip condicao;

		public Local getLocal() {
			return local;
		}

		public void setLocal(Local local) {
			this.local = local;
		}

		public Funcionario getResponsavel() {
			return responsavel;
		}

		public void setResponsavel(Funcionario responsavel) {
			this.responsavel = responsavel;
		}

		public Date getDtVerificao() {
			return dtVerificao;
		}

		public void setDtVerificao(Date dtVerificao) {
			this.dtVerificao = dtVerificao;
		}

		public Date getVencimento() {
			return vencimento;
		}

		public void setVencimento(Date vencimento) {
			this.vencimento = vencimento;
		}

		public CondEquip getCondicao() {
			return condicao;
		}

		public void setCondicao(CondEquip condicao) {
			this.condicao = condicao;
		}

		public int getId() {
			return id;
		}

	}

}