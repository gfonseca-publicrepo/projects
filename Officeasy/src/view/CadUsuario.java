package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.Funcionario;
import model.Permissoes;
import model.DAO.FuncionarioDAO;
import model.DAO.UsuarioDAO;
import util.TableUsuario;

public class CadUsuario extends JDialog {

	/**
	 * @author Gabriel Fonseca
	 * 
	 */

	private static final long serialVersionUID = 1L;
	static Funcionario usu = null;
	static Permissoes perm = null;

	public CadUsuario() {

		super();

		// INICIO DA ABA NOVO USUARIO

		JLabel titulo0 = new JLabel("Novo Usuário"); // TITULO DA ABA
		titulo0.setHorizontalAlignment(SwingConstants.CENTER); // DEFININDO ALINHAMENTO NO CENTRO

		JLabel matricula = new JLabel("Matrícula");
		matricula.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField matriculaText = new JTextField(20);

		JLabel login = new JLabel("Login");
		login.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField loginText = new JTextField(20);

		JLabel senha = new JLabel("Senha");
		senha.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField senhaText = new JTextField(20);

		JLabel nivel = new JLabel("Nível de Acesso");
		nivel.setHorizontalAlignment(SwingConstants.CENTER);

		JComboBox<Permissoes> boxNivel = Permissoes.cboxNiveis();

		JPanel campos = new JPanel(new GridLayout(4, 4));
		campos.add(matricula);
		campos.add(matriculaText);
		campos.add(login);
		campos.add(loginText);
		campos.add(senha);
		campos.add(senhaText);
		campos.add(nivel);
		campos.add(boxNivel);

		JPanel panelButtons = new JPanel();

		JButton salvar = new JButton("Confirmar");
		panelButtons.add(salvar);

		// AÇÃO DO BOTAO SALVAR
		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (matriculaText.getText().equals("") || loginText.getText().equals("")
						|| senhaText.getText().equals("")) { // VERIFICANDO SE TODOS OS CAMPOS ESTAO PREENCHIDOS

					JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
					return;
				} else if (!FuncionarioDAO.verificarMatricula(Integer.parseInt(matriculaText.getText()))) { // VERIFICANDO
																											// SE A
																											// MATRICULA
																											// È VALIDA

					JOptionPane.showMessageDialog(null, "Matrícula invalida.");
					return;
				}

				perm = (Permissoes) boxNivel.getSelectedItem(); // INSTANCIANDO OBJETO DE PERMISSOES DO USUARIO

				usu.setLogin(Integer.parseInt(loginText.getText()));
				usu.setSenha(senhaText.getText());
				usu.setNivel(perm);

				UsuarioDAO.inserirUsuario(usu.getLogin(), usu.getSenha(), usu.getNivel(),
						Integer.parseInt(matriculaText.getText())); // PASSANDO OBJETO PARA O BANCO

			}

		});

		JButton cancelar = new JButton("Cancelar");
		panelButtons.add(cancelar);

		// AÇÃO DO BOTAO CANCELAR
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // ENCERRA A JANELA E MANTEM A APLICAÇÃO

			}
		});

		JPanel panelTitulo0 = new JPanel();
		panelTitulo0.add(titulo0);

		JPanel panelNovo = new JPanel(new BorderLayout());
		panelNovo.add(panelTitulo0, BorderLayout.PAGE_START); // ADICIONANDO TITULO AO INICIO DA PAGINA (PAINEL)
		panelNovo.add(campos); // ADICIONANDO OS CAMPOS AO CENTRO DA PAGINA (PAINEL)
		panelNovo.add(panelButtons, BorderLayout.SOUTH); // ADICIONANDO BOTOES AO FINAL DA PAGINA (PAINEL)

		// FIM DA ABA NOVO USUARIO

		// INICIO DA ABA MODIFICAR USUARIO

		JLabel titulo = new JLabel("Modificar Usuário");

		JLabel modMatricula = new JLabel("Buscar por matrícula: ");
		JTextField modMatriculaText = new JTextField(20);
		modMatriculaText.setEditable(true);

		JLabel modNomeText = new JLabel("");
		modNomeText.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel modLogin = new JLabel("Login ");
		modLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField modLoginText = new JTextField(10);
		modLoginText.setEditable(false);

		JLabel modSenha = new JLabel("Senha ");
		modSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		JTextField modSenhaText = new JTextField(10);
		modSenhaText.setEditable(false);

		JLabel modSituacao = new JLabel("Situação ");
		modSituacao.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox<String> modSituacaoBox = new JComboBox<>();
		modSituacaoBox.addItem("Ativo");
		modSituacaoBox.addItem("Inativo");

		JLabel modNivel = new JLabel("Nível de Acesso ");
		modNivel.setHorizontalAlignment(SwingConstants.RIGHT);
		JComboBox<Permissoes> modCboxNivel = Permissoes.cboxNiveis();

		JButton modSalvar = new JButton("Salvar");
		modSalvar.setSize(20, 20);
		modSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				usu.setLogin(Integer.parseInt(loginText.getText()));
				usu.setSenha(senhaText.getText());

				if (modSituacaoBox.getSelectedIndex() == 0) {
					usu.setStatus(true);
				} else {
					usu.setStatus(false);
				}
				perm = (Permissoes) modCboxNivel.getSelectedItem();
				usu.setNivel(perm);

				UsuarioDAO.modificarUsuario(usu);

			}
		});

		JButton modCancelar = new JButton("Cancelar");
		modCancelar.setSize(20, 20);
		modCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // ENCERRA A JANELA E MANTEM A APLICACAO

			}
		});

		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Funcionario usu = UsuarioDAO.buscarUsuarioPorMatricula(Integer.parseInt(modMatriculaText.getText()));

				usu.setNome(FuncionarioDAO.buscarNome(Integer.parseInt(modMatriculaText.getText())));

				modNomeText.setText(usu.getNome());
				modLoginText.setText(String.valueOf(usu.getLogin()));
				modSenhaText.setText(usu.getSenha());
				modSenhaText.setEditable(true);

				if (usu.getStatus()) {
					modSituacaoBox.setSelectedIndex(0);
				} else {
					modSituacaoBox.setSelectedIndex(1);
				}

				modCboxNivel.setSelectedItem(usu.getNivel());

			}
		});

		modMatriculaText.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buscar.doClick();

			}
		});

		JPanel titleBar = new JPanel(new FlowLayout());
		titleBar.add(titulo);

		JPanel panelBusca = new JPanel(new FlowLayout());
		panelBusca.add(modMatricula);
		panelBusca.add(modMatriculaText);
		panelBusca.add(buscar);

		JPanel panelExibicao = new JPanel(new FlowLayout());
		panelExibicao.add(modNomeText);

		JPanel campLogin = new JPanel(new FlowLayout());
		campLogin.add(modLogin);
		campLogin.add(modLoginText);

		JPanel campSenha = new JPanel(new FlowLayout());
		campSenha.add(modSenha);
		campSenha.add(modSenhaText);

		JPanel campSit = new JPanel(new FlowLayout());
		campSit.add(modSituacao);
		campSit.add(modSituacaoBox);

		JPanel campNivel = new JPanel(new FlowLayout());
		campNivel.add(modNivel);
		campNivel.add(modCboxNivel);

		JPanel panelCampos1 = new JPanel(new FlowLayout());
		panelCampos1.add(campLogin);
		panelCampos1.add(campSenha);

		JPanel panelCampos2 = new JPanel(new FlowLayout());
		panelCampos2.add(campSit);
		panelCampos2.add(campNivel);

		JPanel panelCampos0 = new JPanel(new BorderLayout());
		panelCampos0.add(panelCampos1, BorderLayout.NORTH);
		panelCampos0.add(panelCampos2);

		JPanel modButtons = new JPanel(new FlowLayout());
		modButtons.add(modSalvar);
		modButtons.add(modCancelar);

		JPanel panel1 = new JPanel(new GridLayout(3, 1));
		panel1.add(titleBar);
		panel1.add(panelBusca);
		panel1.add(panelExibicao);

		JPanel panel2 = new JPanel();
		panel2.add(panelCampos0);
		panel2.add(modButtons);

		JPanel panelModificar = new JPanel(new BorderLayout());
		panelModificar.add(panel1, BorderLayout.NORTH);
		panelModificar.add(panel2);

		// FIM DA ABA MODIFICAR ------------------------------------------------------

		// INICIO DA ABA USUARIOS CADASTRADOS
		// ---------------------------------------------

		JLabel cadMatricula = new JLabel("Matrícula");
		JTextField cadMatriculaText = new JTextField(10);
		JLabel cadLogin = new JLabel("Login");
		JTextField cadLoginText = new JTextField(10);

		JRadioButton ativo = new JRadioButton("Ativos");

		JRadioButton inativo = new JRadioButton("Inativos");

		ButtonGroup group = new ButtonGroup();

		group.add(ativo);
		group.add(inativo);
		ativo.setSelected(true);
		inativo.setSelected(false);

		JTable tabela = new JTable();
		TableUsuario tableModel = new TableUsuario(UsuarioDAO.listarUsuariosAtivos());
		tabela.setModel(tableModel);

		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setViewportView(tabela);

		JButton cadBuscar = new JButton("Buscar");
		cadBuscar.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (modMatriculaText.getText() == null && modLoginText == null) {

					if (ativo.isSelected()) {
						TableUsuario tableModel = new TableUsuario(UsuarioDAO.listarUsuariosAtivos());
						tabela.setModel(tableModel);
					} else if (inativo.isSelected()) {
						TableUsuario tableModel = new TableUsuario(UsuarioDAO.listarUsuariosInativos());
						tabela.setModel(tableModel);
					}

				}

				if (modMatriculaText.getText() != null) {
					modLoginText.setText("");

					TableUsuario tableModel = new TableUsuario(
							UsuarioDAO.buscarUsuariosPorMatricula(Integer.parseInt(modMatriculaText.getText())));

				} else if (modLoginText.getText() != null) {
					modMatriculaText.setText("");

					TableUsuario tableModel = new TableUsuario(
							UsuarioDAO.buscarUsuariosPorLogin(modLoginText.getText()));

				}

			}
		});

		JPanel panelLista = new JPanel();
		panelLista.add(cadMatricula);
		panelLista.add(cadMatriculaText);
		panelLista.add(cadLogin);
		panelLista.add(cadLoginText);
		panelLista.add(cadBuscar);
		panelLista.add(ativo);
		panelLista.add(inativo);

		JPanel panelCadastrados = new JPanel(new BorderLayout());
		panelCadastrados.add(panelLista, BorderLayout.NORTH);
		panelCadastrados.add(scrollTable);

		// FIM DA ABA USUARIOS CADASTRADOS

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Novo Usuário", panelNovo);
		tabbedPane.addTab("Modificar", panelModificar);
		tabbedPane.addTab("Usuários Cadastrados", panelCadastrados);

		getContentPane().add(tabbedPane);

		setTitle("Cadastro de Usuários");
		setModal(true);
		setSize(650, 310);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));

	}

}
