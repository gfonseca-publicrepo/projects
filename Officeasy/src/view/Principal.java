package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import model.Funcionario;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	Funcionario usu = null;
	private JMenuBar menuBar;

	public Principal(Funcionario usu) {

		super("officEasy - Gestão Inteligente");
		definirIcone();

		JPanel frame = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		// PAINEL LATERAL

		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new EmptyBorder(5, 0, 0, 0));

		JLabel menuNome = new JLabel("Gabriel");

		JLabel menuMatricula = new JLabel("20180001");

		JLabel menuNivel = new JLabel("Administrador");

		JButton buttonSenha = new JButton("Senha");
		buttonSenha.setToolTipText("Alterar Senha");
		buttonSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		// EXIBINDO E OCULTANDO PAINEL LATERAL
		panelMenu.setVisible(false);
		GroupLayout gl_panelMenu = new GroupLayout(panelMenu);
		gl_panelMenu.setHorizontalGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING).addGroup(gl_panelMenu
				.createSequentialGroup()
				.addGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMenu.createSequentialGroup().addGap(13).addGroup(gl_panelMenu
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelMenu.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(buttonSenha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(menuNivel, Alignment.LEADING))
								.addGroup(gl_panelMenu.createSequentialGroup().addGap(9).addComponent(menuMatricula))))
						.addGroup(gl_panelMenu.createSequentialGroup().addGap(30).addComponent(menuNome)))
				.addContainerGap(14, Short.MAX_VALUE)));
		gl_panelMenu.setVerticalGroup(gl_panelMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMenu.createSequentialGroup().addContainerGap()
						.addComponent(menuNome, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE).addGap(4)
						.addComponent(menuMatricula, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(menuNivel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(buttonSenha)
						.addContainerGap(212, Short.MAX_VALUE)));
		panelMenu.setLayout(gl_panelMenu);

		JMenu adm = new JMenu("Administrador");
		adm.setMnemonic(KeyEvent.VK_A);

		JMenuItem permissoes = new JMenuItem("Permissões de Acesso");
		permissoes.setMnemonic(KeyEvent.VK_P);
		permissoes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadPermissoes();

			}
		});
		adm.add(permissoes);

		JMenuItem usuarios = new JMenuItem("Usuários");
		usuarios.setMnemonic(KeyEvent.VK_U);
		usuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CadUsuario();

			}
		});
		adm.add(usuarios);

		menuBar = new JMenuBar();
		scrollPane.setColumnHeaderView(menuBar);
		menuBar.add(adm);

		JMenu mnCadastros = new JMenu("Cadastros");
		adm.add(mnCadastros);

		JMenuItem mntmValeTransporte = new JMenuItem("Vale Transporte");
		mnCadastros.add(mntmValeTransporte);

		JMenuItem mntmValeAlimentao = new JMenuItem("Vale Alimentação");
		mnCadastros.add(mntmValeAlimentao);

		JMenuItem mntmSeguroSade = new JMenuItem("Seguro Saúde");
		mnCadastros.add(mntmSeguroSade);

		JMenuItem mntmSeguroOdontologico = new JMenuItem("Seguro Odontologico");
		mnCadastros.add(mntmSeguroOdontologico);

		JMenuItem mntmBancos = new JMenuItem("Bancos");
		mnCadastros.add(mntmBancos);

		JMenuItem mntmEmpresas = new JMenuItem("Empresas");
		mnCadastros.add(mntmEmpresas);

		JMenuItem mntmContratos = new JMenuItem("Contratos");
		mnCadastros.add(mntmContratos);

		JMenuItem mntmLocaisendereos = new JMenuItem("Locais/Endereços");
		mnCadastros.add(mntmLocaisendereos);

		JMenuItem logs = new JMenuItem("Logs");
		adm.add(logs);

		JMenu tools = new JMenu("Ferramentas");
		tools.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(tools);

		JMenuItem notes = new JMenuItem("Anotações");
		tools.add(notes);

		JMenuItem mntmContatos = new JMenuItem("Contatos");
		tools.add(mntmContatos);

		mntmContatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ContatosView();
				dispose();

			}
		});

		JMenuItem mntmEndereos = new JMenuItem("Endereços");
		tools.add(mntmEndereos);

		// FIM DO PAINEL DE BOTOES

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setViewportView(panelPrincipal);
		panelPrincipal.setFocusTraversalPolicyProvider(true);
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonsPanel.setOpaque(false);

		JButton buttonMenu = new JButton();
		buttonMenu.setText("Menu");
		buttonMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		buttonMenu.setIconTextGap(0);
		buttonMenu.setPreferredSize(new Dimension(25, 20));
		buttonMenu.setMinimumSize(new Dimension(0, 0));
		buttonMenu.setMaximumSize(new Dimension(0, 0));
		buttonMenu.setSize(10, 10);
		buttonMenu.setMargin(new Insets(0, 0, 0, 0));

		JButton documentos = new JButton("Documentos");

		JButton equipamentos = new JButton("Equipamentos");

		equipamentos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EquipamentosView();
				dispose();

			}
		});

		JButton modelos = new JButton("Modelos");
		modelos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new ModelosView(usu);

			}
		});

		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// OfficeEasy.saidaSistema(usu.getLogin());
				System.exit(0);

			}
		});

		// FIM DA BARRA DE MENU

		// INICIOS DO PAINEL DE BOTOES

		JButton funcionarios = new JButton("Funcionários");
		funcionarios.setSize(40, 40);

		funcionarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionarioView();
				dispose();

			}
		});

		// AÇÃO - MENU LATERAL

		buttonMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelMenu.isVisible()) {
					panelMenu.setVisible(false);
				} else {
					panelMenu.setVisible(true);
				}

			}
		});
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup().addGap(38)
						.addComponent(buttonsPanel, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE).addGap(66)));
		gl_panelPrincipal.setVerticalGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal
						.createSequentialGroup().addContainerGap().addComponent(buttonsPanel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(241, Short.MAX_VALUE)));
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		buttonsPanel.add(buttonMenu);
		buttonsPanel.add(documentos);
		buttonsPanel.add(equipamentos);

		JButton contratos = new JButton("Contratos");
		buttonsPanel.add(contratos);
		buttonsPanel.add(funcionarios);
		buttonsPanel.add(modelos);
		buttonsPanel.add(sair);
		panelPrincipal.setLayout(gl_panelPrincipal);

		contratos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ContratosView();
				dispose();

			}
		});

		getContentPane().add(frame, BorderLayout.SOUTH);
		GroupLayout gl_frame = new GroupLayout(frame);
		gl_frame.setHorizontalGroup(gl_frame.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_frame.createSequentialGroup().addGap(4)
						.addComponent(panelMenu, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)));
		gl_frame.setVerticalGroup(gl_frame.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_frame.createSequentialGroup().addGap(5).addComponent(panelMenu, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_frame.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)));
		frame.setLayout(gl_frame);

		setSize(781, 361);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		// DEFINIR TAMANHO MAXIMO DA TELA | FULL SCREEN
		// Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		// int lar = (int) tela.getWidth();
		// int alt = (int) tela.getHeight() - 25;
		// setSize(lar, alt);

	}

	public void definirIcone() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
	}
}
