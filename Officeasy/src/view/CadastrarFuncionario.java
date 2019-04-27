package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;
import model.Beneficio;
import model.Certificado;
import model.Contrato;
import model.DadosBancarios;
import model.DadosBancarios.Banco;
import model.DadosBancarios.TipoConta;
import model.DadosFun;
import model.Funcionario;
import model.Dependente;
import model.DocFun;
import model.Endereco;
import model.Local;
import model.DAO.BeneficioDAO;
import model.DAO.CertificadoDAO;
import model.DAO.DadosBancariosDAO;
import model.DAO.DadosFunDAO;
import model.DAO.DependenteDAO;
import model.DAO.DocFunDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FuncionarioDAO;
import util.Box;
import util.FerramentaString;
import util.Mascaras;
import util.ValorMonetario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class CadastrarFuncionario extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
	 * @author Gabriel Fonseca
	 */
	private static Funcionario funcionarioC;
	private static Beneficio beneficio;
	private static Contrato contrato;
	private static Endereco endereco;
	private static DadosBancarios dadosBanco;
	private static Local local;
	private static DadosFun dados;
	private static DocFun docFun;
	private static JComboBox<String> boxEstadoCivil;
	private static JComboBox<String> boxSexo;
	private static JComboBox<String> boxUF;
	private static List<Certificado> certificados;
	private static List<Dependente> dependentes;
	private static int maxMatricula;

	public CadastrarFuncionario() {

		setVisible(true);
		setSize(674, 539);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Novo Funcionário");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));

		beneficio = new Beneficio(0, null, null, null, null);
		dependentes = new ArrayList<Dependente>();
		certificados = new ArrayList<Certificado>();
		maxMatricula = FuncionarioDAO.contarMatriculaNova();

		JPanel frame = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 12, 645, 492);

		JPanel panels = new JPanel();
		scrollPane.setViewportView(panels);

		JLabel lblFichaDeFuncionrio = new JLabel("Ficha de Funcionário");

		JLabel lblCadastro = new JLabel("Cadastro");

		JLabel lblMatricula = new JLabel("Matricula");

		JTextField textMatricula = new JTextField();
		textMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		textMatricula.setText(String.valueOf(maxMatricula));
		textMatricula.setEditable(false);
		textMatricula.setColumns(10);

		JLabel lblSituacao = new JLabel("Situação");

		JTextField textSituacao = new JTextField();
		textSituacao.setHorizontalAlignment(SwingConstants.CENTER);
		textSituacao.setText("Ativo");
		textSituacao.setEditable(false);
		textSituacao.setColumns(10);

		JPanel painel12 = new JPanel();

		JPanel painel14 = new JPanel();

		JPanel painel18 = new JPanel();

		JPanel painel8 = new JPanel();

		FlowLayout fl_painel8 = (FlowLayout) painel8.getLayout();
		fl_painel8.setAlignment(FlowLayout.LEFT);

		JPanel painel9 = new JPanel();

		JLabel lblLogradouro = new JLabel("Logradouro");

		JFormattedTextField textLogradouro = new JFormattedTextField(new Mascaras().Mask100());
		textLogradouro.setColumns(20);

		JLabel lblNmero = new JLabel("Número");

		JFormattedTextField textNumero = new JFormattedTextField(new Mascaras().MaskEnderecoNumero());
		textNumero.setColumns(5);

		JLabel lblCep = new JLabel("CEP");

		JFormattedTextField textCep = new JFormattedTextField(new Mascaras().MaskCEP());
		textCep.setColumns(9);
		textCep.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor no apos perder o foco 

		JLabel lblNomeDoPai = new JLabel("Nome do Pai");
		painel8.add(lblNomeDoPai);

		JFormattedTextField textPai = new JFormattedTextField(new Mascaras().Mask100());
		painel8.add(textPai);
		textPai.setColumns(15);

		JLabel lblMae = new JLabel("Nome da Mãe");
		painel8.add(lblMae);

		JFormattedTextField textMae = new JFormattedTextField(new Mascaras().Mask100());
		painel8.add(textMae);
		textMae.setColumns(15);

		JLabel lblRg = new JLabel("RG");

		JFormattedTextField textRG = new JFormattedTextField(new Mascaras().MaskRG());
		textRG.setColumns(12);
		textRG.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor apos perder o foco

		JLabel lblEmissor = new JLabel("Emissor");

		JFormattedTextField textEmissorRG = new JFormattedTextField(new Mascaras().Mask100());
		textEmissorRG.setColumns(10);

		JLabel lblDataDeEmisso = new JLabel("Data de Emissão");

		JDateChooser dateEmissaoRG = new JDateChooser(new Date(), "dd/MM/yy");

		JLabel lblBanco = new JLabel("Banco");

		JComboBox<Banco> boxBancos = Banco.cboxBanco();

		JLabel lblTipoDeConta = new JLabel("Tipo de Conta");

		JComboBox<DadosBancarios.TipoConta> boxTipoConta = TipoConta.cboxTipoConta();

		JLabel lblTelefone = new JLabel("Telefone");

		JFormattedTextField textTelefone = new JFormattedTextField(new Mascaras().MaskTelefone());
		textTelefone.setColumns(11);
		textTelefone.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor apos perder o foco

		JLabel lblCelular = new JLabel("Celular");

		JFormattedTextField textCelular = new JFormattedTextField(new Mascaras().MaskCelular());
		textCelular.setColumns(11);
		textCelular.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor apos perder o foco

		JPanel painel3 = new JPanel();

		JPanel painel16 = new JPanel();

		JButton btnCertificados = new JButton("Certificados");
		btnCertificados.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnBeneficios = new JButton("Beneficios");
		btnBeneficios.setHorizontalAlignment(SwingConstants.RIGHT);

		JButton btnDependentes = new JButton("Dependentes");
		btnDependentes.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblLocal = new JLabel("Local de Trabalho  ");

		JComboBox<Local> boxLocais = model.Local.cboxLocais();

		JLabel lblContrato = new JLabel("  Contrato  ");

		JComboBox<Contrato> boxContrato = model.Contrato.cboxContrato();

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel painel13 = new JPanel();
		FlowLayout fl_painel13 = (FlowLayout) painel13.getLayout();
		fl_painel13.setAlignment(FlowLayout.LEFT);

		JPanel painel5 = new JPanel();
		FlowLayout fl_painel5 = (FlowLayout) painel5.getLayout();
		fl_painel5.setAlignment(FlowLayout.LEFT);

		JPanel painel15 = new JPanel();
		FlowLayout fl_painel15 = (FlowLayout) painel15.getLayout();
		fl_painel15.setAlignment(FlowLayout.LEFT);

		JPanel painel10 = new JPanel();
		FlowLayout fl_painel10 = (FlowLayout) painel10.getLayout();
		fl_painel10.setAlignment(FlowLayout.LEFT);

		JLabel labelBairro = new JLabel("Bairro");
		painel10.add(labelBairro);

		JFormattedTextField textBairro = new JFormattedTextField(new Mascaras().Mask60());
		textBairro.setColumns(10);
		painel10.add(textBairro);

		JLabel labelCidade = new JLabel("Cidade");
		painel10.add(labelCidade);

		JFormattedTextField textCidade = new JFormattedTextField(new Mascaras().Mask60());
		textCidade.setColumns(15);
		painel10.add(textCidade);

		JLabel label_7 = new JLabel("Estado");
		painel10.add(label_7);

		JLabel label_3 = new JLabel("Conta");
		painel15.add(label_3);

		JFormattedTextField textConta = new JFormattedTextField(new Mascaras().Mask10Numerica());
		textConta.setColumns(5);
		painel15.add(textConta);

		JLabel label_4 = new JLabel("Agência");
		painel15.add(label_4);

		JFormattedTextField textAgencia = new JFormattedTextField(new Mascaras().Mask10Numerica());
		textAgencia.setColumns(10);
		painel15.add(textAgencia);

		JLabel labelEstadoCivil = new JLabel("Estado Civil");
		painel5.add(labelEstadoCivil);

		boxEstadoCivil = new JComboBox<String>();
		boxEstadoCivil = Box.boxEstadoCivil();
		painel5.add(boxEstadoCivil);

		JLabel labelSexo = new JLabel("Sexo");
		painel5.add(labelSexo);

		boxSexo = new JComboBox<String>();
		boxSexo = Box.boxSexo();
		painel5.add(boxSexo);

		JLabel label = new JLabel("E-mail");
		painel13.add(label);

		JFormattedTextField textEmail = new JFormattedTextField(new Mascaras().Mask100());
		textEmail.setColumns(25);

		JPanel painel7 = new JPanel();
		FlowLayout fl_painel7 = (FlowLayout) painel7.getLayout();
		fl_painel7.setAlignment(FlowLayout.LEFT);

		JPanel painel11 = new JPanel();
		FlowLayout fl_painel11 = (FlowLayout) painel11.getLayout();
		fl_painel11.setAlignment(FlowLayout.LEFT);

		JLabel label_11 = new JLabel("Complemento");
		painel11.add(label_11);

		JFormattedTextField textComplemento = new JFormattedTextField(new Mascaras().Mask60());
		textComplemento.setColumns(20);
		painel11.add(textComplemento);

		JLabel label_8 = new JLabel("CPF");

		JFormattedTextField textCPF = new JFormattedTextField(new Mascaras().MaskCPF());
		textCPF.setColumns(14);
		textCPF.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor apos perder o foco

		JLabel label_9 = new JLabel("CTPS");

		JFormattedTextField textCTPS = new JFormattedTextField(new Mascaras().MaskCtps());
		textCTPS.setColumns(10);
		textCTPS.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor apos perder o foco

		JLabel label_10 = new JLabel("PIS");

		JFormattedTextField textPIS = new JFormattedTextField(new Mascaras().MaskPis());
		textPIS.setColumns(12);
		textPIS.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor apos perder o foco

		JPanel painel1 = new JPanel();
		FlowLayout fl_painel1 = (FlowLayout) painel1.getLayout();
		fl_painel1.setAlignment(FlowLayout.LEFT);

		JLabel lblNomeCompleto = new JLabel("Nome Completo");

		JFormattedTextField textNomeCompleto = new JFormattedTextField(new Mascaras().Mask100());
		textNomeCompleto.setColumns(20);

		JLabel lblCargo = new JLabel("Cargo");

		JFormattedTextField textCargo = new JFormattedTextField(new Mascaras().Mask100());
		textCargo.setColumns(15);

		JLabel labelNascimento = new JLabel("Nascimento");

		JDateChooser dateNascimento = new JDateChooser(new Date(), "dd/MM/yy");

		JPanel painel17 = new JPanel();

		JLabel lblSalario = new JLabel("Salário");

		JLabel lblJornada = new JLabel("Jornada");

		JFormattedTextField textJornada = new JFormattedTextField(new Mascaras().MaskJornada());
		textJornada.setHorizontalAlignment(SwingConstants.RIGHT);
		textJornada.setColumns(6);
		textJornada.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST); // Mantem o valor apos perder o foco

		JLabel lblAso = new JLabel("ASO");
		painel17.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		painel17.add(lblSalario);

		JFormattedTextField textSalario = new JFormattedTextField(new ValorMonetario());
		//textSalario.setColumns(10);
		//textSalario.setHorizontalAlignment(JTextField.RIGHT);
		//textSalario.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
		//textSalario.setDocument(new NumerosDecimais(9));

		JDateChooser dateASO = new JDateChooser(new Date(), "dd/MM/yy");

		JPanel painel2 = new JPanel();

		JLabel lblAdmissao = new JLabel("Admissão");

		JDateChooser dateAdmissao = new JDateChooser(new Date(), "dd/MM/yy");

		JButton btnCancelar = new JButton("Cancelar");

		boxUF = new JComboBox<String>();
		boxUF = Box.boxUF();

		// Layout
		painel7.add(label_8);
		painel7.add(textCPF);
		painel7.add(label_9);
		painel7.add(textCTPS);
		painel7.add(label_10);
		painel7.add(textPIS);
		painel1.add(lblNomeCompleto);
		painel1.add(textNomeCompleto);
		painel1.add(lblCargo);
		painel1.add(textCargo);
		painel5.add(labelNascimento);
		painel5.add(dateNascimento);
		painel12.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		painel12.add(lblTelefone);
		painel12.add(textTelefone);
		painel12.add(lblCelular);
		painel12.add(textCelular);
		painel9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		painel9.add(lblLogradouro);
		painel9.add(textLogradouro);
		painel9.add(lblNmero);
		painel9.add(textNumero);
		painel9.add(lblCep);
		painel9.add(textCep);
		painel18.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		painel18.add(lblRg);
		painel18.add(textRG);
		painel18.add(lblEmissor);
		painel18.add(textEmissorRG);
		painel18.add(lblDataDeEmisso);
		painel18.add(dateEmissaoRG);
		painel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		painel3.add(lblLocal);
		painel3.add(boxLocais);
		painel3.add(lblContrato);
		painel3.add(boxContrato);
		painel13.add(textEmail);
		painel16.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		painel16.add(btnCertificados);
		painel16.add(btnBeneficios);
		painel16.add(btnDependentes);
		painel14.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		painel14.add(lblBanco);
		painel14.add(boxBancos);
		painel14.add(lblTipoDeConta);
		painel14.add(boxTipoConta);
		FlowLayout fl_painel2 = (FlowLayout) painel2.getLayout();
		painel17.add(textSalario);
		painel17.add(lblJornada);
		painel17.add(textJornada);
		painel17.add(lblAso);
		painel17.add(dateASO);
		fl_painel2.setAlignment(FlowLayout.LEFT);
		painel2.add(lblAdmissao);
		painel2.add(dateAdmissao);
		painel10.add(boxUF);

		GroupLayout gl_panels = new GroupLayout(panels);
		gl_panels.setHorizontalGroup(gl_panels.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panels.createSequentialGroup().addGroup(gl_panels.createParallelGroup(Alignment.LEADING)
						.addComponent(painel2, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel3, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel5, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel7, GroupLayout.PREFERRED_SIZE, 603, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel8, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel9, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel10, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel11, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel12, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel13, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel14, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel15, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE)
						.addComponent(painel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panels.createSequentialGroup().addGap(149).addComponent(lblMatricula).addGap(4)
								.addComponent(textMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(4).addComponent(lblSituacao).addGap(4).addComponent(textSituacao,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panels.createSequentialGroup().addGap(266).addComponent(btnSalvar,
								GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panels.createSequentialGroup().addGap(294).addComponent(lblCadastro))
						.addGroup(gl_panels.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(painel17, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(painel18, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 603,
										Short.MAX_VALUE))
						.addGroup(
								gl_panels.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panels.createSequentialGroup().addGap(262)
												.addComponent(lblFichaDeFuncionrio)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(btnCancelar))
										.addComponent(painel1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 612,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(22, Short.MAX_VALUE)));
		gl_panels.setVerticalGroup(gl_panels.createParallelGroup(Alignment.LEADING).addGroup(gl_panels
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panels.createParallelGroup(Alignment.BASELINE).addComponent(lblFichaDeFuncionrio)
						.addComponent(btnCancelar))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblCadastro)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panels.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panels.createSequentialGroup().addGap(3).addComponent(lblMatricula))
						.addComponent(textMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panels.createSequentialGroup().addGap(3).addComponent(lblSituacao))
						.addComponent(textSituacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(painel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(7)
				.addComponent(painel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6).addComponent(painel3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(painel17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(painel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(6).addComponent(painel10, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addGap(6)
				.addComponent(painel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(6)
				.addComponent(painel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(6).addComponent(painel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(28).addComponent(btnSalvar).addContainerGap()));

		panels.setLayout(gl_panels);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(frame, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(frame, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(209, Short.MAX_VALUE)));
		frame.setLayout(null);
		frame.add(scrollPane);
		getContentPane().setLayout(groupLayout);
		// Layout end

		// Funções
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					if (textNomeCompleto.getText().trim().equals("") || textCargo.getText().trim().equals("")
							|| textSalario.getText().trim().equals("")) {

						JOptionPane.showMessageDialog(null, "Preencha os campos 'Nome', 'Cargo' e 'Salário'", "",
								JOptionPane.ERROR_MESSAGE);
						return;

					}

					if (textLogradouro.getText().trim().equals("") || textNumero.getText().trim().equals("")
							|| textComplemento.getText().trim().equals("") || textBairro.getText().trim().equals("")
							|| textCidade.getText().trim().equals("") || textCep.getText().trim().equals("")) {

						JOptionPane.showMessageDialog(null, "Preencha os campos de endereço", "",
								JOptionPane.ERROR_MESSAGE);
						return;

					}

					if (textRG.getText().trim().equals("") || textEmissorRG.getText().trim().equals("")
							|| textCPF.getText().trim().equals("") || textCTPS.getText().trim().equals("")
							|| textPIS.getText().trim().equals("") || textPai.getText().trim().equals("")
							|| textMae.getText().trim().equals("")) {

						JOptionPane.showMessageDialog(null, "Preencha os campos de documentos", "",
								JOptionPane.ERROR_MESSAGE);
						return;

					}

					if (textConta.getText().trim().equals("") || textAgencia.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha os campos referente a Conta e Agência bancaria",
								"", JOptionPane.ERROR_MESSAGE);
						return;

					}

					if (textConta.getText().trim().equals("") || textAgencia.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha os campos referente a Conta e Agência bancaria",
								"", JOptionPane.ERROR_MESSAGE);
						return;

					}

					if (String.valueOf(beneficio.getVtValor()).trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha os benefícios", "", JOptionPane.ERROR_MESSAGE);
						return;

					}

					contrato = (Contrato) boxContrato.getSelectedItem();

					local = (Local) boxLocais.getSelectedItem();

					funcionarioC = new Funcionario(FuncionarioDAO.contarMatriculaNova(), textNomeCompleto.getText(),
							textCargo.getText(), true, contrato, local);

					dados = new DadosFun(dateAdmissao.getDate(),
							Double.parseDouble(FerramentaString.limpaDinheiro(textSalario.getText())),
							Integer.parseInt(textJornada.getText().substring(0, textJornada.getText().indexOf("h"))),
							dateNascimento.getDate(), boxEstadoCivil.getSelectedItem().toString(),
							boxSexo.getSelectedItem().toString(), textTelefone.getText(), textCelular.getText(),
							textEmail.getText());

					endereco = new Endereco(textLogradouro.getText(), textNumero.getText(), textComplemento.getText(),
							textBairro.getText(), textCidade.getText(), boxUF.getSelectedItem().toString(),
							textCep.getText());

					docFun = new DocFun(FerramentaString.limpaDoc(textRG.getText()), textEmissorRG.getText(),
							dateEmissaoRG.getDate(), FerramentaString.limpaDoc(textCPF.getText()), textCTPS.getText(),
							FerramentaString.limpaDoc(textPIS.getText()), textPai.getText(), textMae.getText(),
							dateASO.getDate(), certificados);

					dadosBanco = new DadosBancarios(textConta.getText(), textAgencia.getText(),
							(TipoConta) boxTipoConta.getSelectedItem(), (Banco) boxBancos.getSelectedItem());

				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente", "Erro ao Cadastrar",
							JOptionPane.ERROR_MESSAGE);
					return;
				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente", "Erro ao Cadastrar",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {

					FuncionarioDAO.novoFuncionario(funcionarioC.getMatricula(), funcionarioC.getStatus(),
							funcionarioC.getNome(), funcionarioC.getCargo(), contrato.getNumero(), local.getId());

					DadosFunDAO.novo(dados.getDtAdmissao(), dados.getSalario(), dados.getCargaH(),
							dados.getDtNascimento(), dados.getEstadoCivil(), dados.getSexo(), dados.getTelefone(),
							dados.getCelular(), dados.getEmail(), funcionarioC.getMatricula());

					EnderecoDAO.novoEndFun(endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(),
							endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep(),
							funcionarioC.getMatricula());

					DocFunDAO.novo(docFun.getRg(), docFun.getOrgaoEmissor(), docFun.getDtEmissao(), docFun.getCpf(),
							docFun.getCtps(), docFun.getPis(), docFun.getPai(), docFun.getMae(), docFun.getAso(),
							funcionarioC.getMatricula());

					BeneficioDAO.inserirBeneficio(beneficio.getVtValor(), beneficio.getAlimentacao().getId(),
							beneficio.getTransporte().getId(), beneficio.getSeguroOdonto().getId(),
							beneficio.getSeguroSaude().getId(), funcionarioC.getMatricula());
					if (certificados.isEmpty()) {
						CertificadoDAO.inserirCertificados(certificados, funcionarioC.getMatricula());
					}
					DadosBancariosDAO.inserirDadosFuncionario(dadosBanco, funcionarioC.getMatricula());
					if (dependentes.isEmpty()) {
						DependenteDAO.novaLista(dependentes, funcionarioC.getMatricula());
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Não foi possivel salvar", "Erro ao Cadastrar",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new FuncionarioView();

			}
		});

		btnBeneficios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarBeneficio(beneficio);

			}
		});

		btnDependentes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarDependente(dependentes);

			}
		});

		btnCertificados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarCertificado(certificados);

			}
		});

	}
	
	// Objetos das janelas parentes

	public static void setDep(List<Dependente> list) {

		dependentes = list;

	}

	public static void setCert(List<Certificado> list) {

		certificados = list;
	}

	public static void setBen(Beneficio b) {

		beneficio = b;
	}
}
