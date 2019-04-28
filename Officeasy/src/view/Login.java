package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.Officeasy;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.BorderLayout;

public class Login extends JFrame {
	/**
	 * @author Gabriel Fonseca
	 */

	private static final long serialVersionUID = 1L;

	public Login() {

		super();

		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// Componentes e Layout

		JButton fazerLogin = new JButton("Login");

		JButton cancelar = new JButton("Sair");

		JPanel panel3 = new JPanel();
		FlowLayout fl_panel3 = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel3.setLayout(fl_panel3);
		panel3.add(fazerLogin);
		panel3.add(cancelar);

		JPanel login = new JPanel();

		JPanel panel0 = new JPanel();

		getContentPane().add(login);

		JLabel labelIcon = new JLabel("");
		labelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		labelIcon.setIcon(new ImageIcon(Login.class.getResource("/imagens/loginLogo.png")));
		login.setLayout(new BorderLayout(0, 0));
		panel0.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel usuario = new JLabel("Login");
		panel0.add(usuario);
		usuario.setHorizontalAlignment(SwingConstants.LEFT);

		JTextField usu = new JTextField("Digite usuário e senha para entrar");
		usu.setColumns(14);
		panel0.add(usu);
		JLabel senha = new JLabel("Senha");
		panel0.add(senha);
		senha.setHorizontalAlignment(SwingConstants.LEFT);
		JPasswordField sen = new JPasswordField();
		panel0.add(sen);
		sen.setColumns(14);
		login.add(panel0, BorderLayout.NORTH);
		login.add(panel3, BorderLayout.CENTER);
		login.add(labelIcon, BorderLayout.SOUTH);

		// Dica de Texto (Campos de Login)
		usu.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (usu.getText().equals("")) {
					usu.setText("Digite usuário e senha para entrar");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (usu.getText().equals("Digite usuário e senha para entrar")) {
					usu.setText("");
				}

			}
		});

		// Funções
		fazerLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					String pw = new String(sen.getPassword()).trim();
					if (Officeasy.efetuarLogin(Integer.parseInt(usu.getText().trim()), pw)) { // Verifica se é possivel
																								// fazer login

						dispose();

					}

				} catch (NumberFormatException n) {

					JOptionPane.showMessageDialog(null, "Login inválido");

				}

			}
		});

		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		setTitle("officEasy - Gestão Inteligente");
		setSize(320, 200);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
	}

}
