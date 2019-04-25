package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.DAO.BeneficioDAO.AlimentacaoDAO;
import model.DAO.BeneficioDAO.SeguroOdontologicoDAO;
import model.DAO.BeneficioDAO.SeguroSaudeDAO;
import model.DAO.BeneficioDAO.TransporteDAO;

public class Beneficio {

	private int id;
	private double vtValor;
	private Transporte transporte;
	private Alimentacao alimentacao;
	private SeguroSaude seguroSaude;
	private SeguroOdontologico seguroOdonto;

	public Beneficio(int id, double vtValor, Transporte transporte, Alimentacao alimentacao, SeguroSaude seguroSaude,
			SeguroOdontologico seguroOdonto) {
		super();
		this.id = id;
		this.vtValor = vtValor;
		this.transporte = transporte;
		this.alimentacao = alimentacao;
		this.seguroSaude = seguroSaude;
		this.seguroOdonto = seguroOdonto;
	}

	public Beneficio(double vtValor, Transporte transporte, Alimentacao alimentacao, SeguroSaude seguroSaude,
			SeguroOdontologico seguroOdonto) {
		super();
		this.vtValor = vtValor;
		this.transporte = transporte;
		this.alimentacao = alimentacao;
		this.seguroSaude = seguroSaude;
		this.seguroOdonto = seguroOdonto;
	}

	public double getVtValor() {
		return vtValor;
	}

	public void setVtValor(double vtValor) {
		this.vtValor = vtValor;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Alimentacao getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(Alimentacao alimentacao) {
		this.alimentacao = alimentacao;
	}

	public SeguroSaude getSeguroSaude() {
		return seguroSaude;
	}

	public void setSeguroSaude(SeguroSaude seguroSaude) {
		this.seguroSaude = seguroSaude;
	}

	public SeguroOdontologico getSeguroOdonto() {
		return seguroOdonto;
	}

	public void setSeguroOdonto(SeguroOdontologico seguroOdonto) {
		this.seguroOdonto = seguroOdonto;
	}

	public int getId() {
		return id;
	}

	public static class Transporte {

		private int id;
		private String tipo;

		public Transporte(int id, String tipo) {
			super();
			this.id = id;
			this.tipo = tipo;
		}

		public Transporte(String tipo) {
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

		public static JComboBox<Transporte> cboxTransporte() {

			JComboBox<Transporte> cbox = new JComboBox<Transporte>();

			List<Transporte> listaTrans = new ArrayList<Transporte>();
			listaTrans = TransporteDAO.carregarBox();

			Transporte t = null;

			for (int i = 1; i <= listaTrans.size(); i++) {
				t = listaTrans.get(i - 1);
				cbox.addItem(t);
			}

			return cbox;

		}

		@Override
		public String toString() {
			return tipo;
		}

	}

	public static class Alimentacao {

		private int id;
		private String tipo;
		private double vaValor;

		public Alimentacao(int id, String tipo, double valor) {
			super();
			this.id = id;
			this.tipo = tipo;
			this.vaValor = valor;
		}

		public Alimentacao(String tipo, double valor) {
			this.tipo = tipo;
			this.vaValor = valor;
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

		public double getVaValor() {
			return vaValor;
		}

		public void setVaValor(double valor) {
			this.vaValor = valor;
		}

		public static JComboBox<Alimentacao> cboxAlimentacao() {

			JComboBox<Alimentacao> cbox = new JComboBox<Alimentacao>();

			List<Alimentacao> listaA = new ArrayList<Alimentacao>();
			listaA = AlimentacaoDAO.carregarBox();

			Alimentacao t = null;

			for (int i = 1; i <= listaA.size(); i++) {
				t = listaA.get(i - 1);
				cbox.addItem(t);
			}

			return cbox;

		}

		@Override
		public String toString() {
			return tipo;
		}

	}

	public static class SeguroSaude {

		private int id;
		private String plano;
		private double valor;

		public SeguroSaude(int id, String plano, double valor) {
			super();
			this.id = id;
			this.plano = plano;
			this.valor = valor;
		}

		public SeguroSaude(String plano, double valor) {
			this.plano = plano;
			this.valor = valor;
		}

		public String getPlano() {
			return plano;
		}

		public void setPlano(String plano) {
			this.plano = plano;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public int getId() {
			return id;
		}

		public static JComboBox<SeguroSaude> cboxSaude() {

			JComboBox<SeguroSaude> cbox = new JComboBox<SeguroSaude>();
			List<SeguroSaude> lista = new ArrayList<SeguroSaude>();
			lista = SeguroSaudeDAO.carregarBox();

			SeguroSaude t = null;

			for (int i = 1; i <= lista.size(); i++) {
				t = lista.get(i - 1);
				cbox.addItem(t);
			}

			return cbox;

		}

		@Override
		public String toString() {
			return plano;
		}

	}

	public static class SeguroOdontologico {

		private int id;
		private String plano;
		private double valor;

		public SeguroOdontologico(int id, String plano, double valor) {
			super();
			this.id = id;
			this.plano = plano;
			this.valor = valor;
		}

		public SeguroOdontologico(String plano, double valor) {

			this.plano = plano;
			this.valor = valor;
		}

		public String getPlano() {
			return plano;
		}

		public void setPlano(String plano) {
			this.plano = plano;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

		public int getId() {
			return id;
		}

		public static JComboBox<SeguroOdontologico> cboxOdonto() {

			JComboBox<SeguroOdontologico> cbox = new JComboBox<SeguroOdontologico>();

			List<SeguroOdontologico> lista = new ArrayList<SeguroOdontologico>();
			lista = SeguroOdontologicoDAO.carregarBox();

			SeguroOdontologico t = null;

			for (int i = 1; i <= lista.size(); i++) {
				t = lista.get(i - 1);
				cbox.addItem(t);
			}

			return cbox;

		}

		@Override
		public String toString() {
			return plano;
		}

	}
}
