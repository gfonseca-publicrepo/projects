package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import model.DAO.FuncionarioDAO;

public class Funcionario extends Usuario {

	// Atributos básicos de funcionário
	private int matricula;
	private String nome;
	private String cargo;
	private boolean situacao;
	private Contrato contrato;
	private Local local;
	// Atributos completos
	private DadosFun dados;
	private Endereco endFun;
	private DocFun documentos;
	private DadosBancarios dadosBanco;
	private HistFun historico;
	private List<Dependente> dependentes;
	private Beneficio beneficios;

	// Objeto de funcionário completo + Objeto de usuário
	public Funcionario(int login, String senha, Permissoes nivel, boolean status, boolean manterLogado, boolean logado,
			int matricula, String nome, String cargo, boolean situacao, Contrato contrato, Local local, DadosFun dados,
			Endereco endFun, List<Dependente> dependentes, Beneficio beneficios, DocFun documentos,
			DadosBancarios dadosBanco, HistFun historico) {
		super(login, senha, nivel, status, manterLogado, logado);
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.situacao = situacao;
		this.contrato = contrato;
		this.local = local;
		this.dados = dados;
		this.endFun = endFun;
		this.dependentes = dependentes;
		this.beneficios = beneficios;
		this.documentos = documentos;
		this.dadosBanco = dadosBanco;
		this.historico = historico;
	}

	// Objeto de funcionário completo
	public Funcionario(int matricula, String nome, String cargo, boolean situacao, Contrato contrato, Local local,
			DadosFun dados, Endereco endFun, List<Dependente> dependentes, Beneficio beneficios, DocFun documentos,
			DadosBancarios dadosBanco, HistFun historico) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.situacao = situacao;
		this.contrato = contrato;
		this.local = local;
		this.dados = dados;
		this.endFun = endFun;
		this.dependentes = dependentes;
		this.beneficios = beneficios;
		this.documentos = documentos;
		this.dadosBanco = dadosBanco;
		this.historico = historico;
	}

	// Objeto de usuário simples
	public Funcionario(int login, String senha, Permissoes nivel, boolean status, boolean manterLogado,
			boolean logado) {
		super(login, senha, nivel, status, manterLogado, logado);
	}

	public Funcionario(int login, String senha) {
		super(login, senha);
	}

	// Objeto de funcionário simples
	public Funcionario(int matricula, String nome, String cargo, boolean situacao, Contrato contrato, Local local) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.situacao = situacao;
		this.contrato = contrato;
		this.local = local;
	}

	// Construtor de nomes
	public Funcionario(String nome) {
		super();
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public DadosFun getDados() {
		return dados;
	}

	public void setDados(DadosFun dados) {
		this.dados = dados;
	}

	public Endereco getEndFun() {
		return endFun;
	}

	public void setEndFun(Endereco endFun) {
		this.endFun = endFun;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	public Beneficio getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Beneficio beneficios) {
		this.beneficios = beneficios;
	}

	public DocFun getDocumentos() {
		return documentos;
	}

	public void setDocumentos(DocFun documentos) {
		this.documentos = documentos;
	}

	public DadosBancarios getDadosBanco() {
		return dadosBanco;
	}

	public void setDadosBanco(DadosBancarios dadosBanco) {
		this.dadosBanco = dadosBanco;
	}

	public HistFun getHistorico() {
		return historico;
	}

	public void setHistorico(HistFun historico) {
		this.historico = historico;
	}

	@Override
	public String toString() {
		return getNome() + " " + getMatricula();
	}

	// Busca no banco e monta uma JCBox com os objetos de 'cargo'
	public static JComboBox<String> boxCargos() {

		JComboBox<String> cbox = new JComboBox<String>();

		List<String> listaCargos = new ArrayList<String>();
		listaCargos = FuncionarioDAO.listarCargos();

		String cargo = null;

		for (int i = 1; i <= listaCargos.size(); i++) {
			cargo = listaCargos.get(i - 1);
			cbox.addItem(cargo);
		}

		return cbox;

	}

}
