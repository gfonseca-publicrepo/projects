package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	public Login() {

		super();

		JButton fazerLogin = new JButton("Login");

		JButton cancelar = new JButton("Sair");

		fazerLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// if (OfficeEasy.efetuarLogin(usu.getText(), sen.getText())) {
				// dispose();
				// }

				new Principal(null);
				dispose();

			}
		});

		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel3.add(fazerLogin);
		panel3.add(cancelar);

		JPanel login = new JPanel();

		JPanel panel0 = new JPanel();

		getContentPane().add(login);

		JLabel labelIcon = new JLabel("");
		labelIcon.setIcon(new ImageIcon(Login.class.getResource("/imagens/loginLogo.png")));
		GroupLayout gl_login = new GroupLayout(login);
		gl_login.setHorizontalGroup(gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
						.addGroup(gl_login.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_login.createSequentialGroup().addContainerGap().addComponent(panel0,
										GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
								.addGroup(gl_login.createSequentialGroup().addContainerGap().addComponent(panel3,
										GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
								.addGroup(gl_login.createSequentialGroup().addGap(88).addComponent(labelIcon)))
						.addContainerGap()));
		gl_login.setVerticalGroup(gl_login.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, gl_login
				.createSequentialGroup().addContainerGap()
				.addComponent(panel0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelIcon)
				.addContainerGap(130, Short.MAX_VALUE)));
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

		// DICA DE TEXTO "LOGIN"
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
		login.setLayout(gl_login);

		setTitle("Officeasy - Gestão Inteligente");
		setSize(382, 264);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));

	}
}
