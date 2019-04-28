package view;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import controller.Officeasy;
import javax.swing.SwingConstants;
import model.Funcionario;
import model.DAO.UsuarioDAO;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarSenha extends JDialog {

	/**
	 * @author Gabriel Fonseca
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField pwOld;
	private JPasswordField pwNew;

	public AlterarSenha(Funcionario usu) {

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(16, Short.MAX_VALUE)));
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] { panel, panel_1, panel_2 });

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pw = new String(pwNew.getPassword()).trim();
				String pwO = new String(pwOld.getPassword()).trim();
				if (pwO.equals(usu.getSenha())) {

					int confirma = JOptionPane.showConfirmDialog(null,
							"Para alterar a senha será necessário sair e reabrir o sistema\nDeseja continuar?",
							"Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

					switch (confirma) {

					case JOptionPane.OK_OPTION:
						UsuarioDAO.alterarSenha(usu.getLogin(), pw);

						Officeasy.saida(usu.getLogin());

						break;
					case JOptionPane.CANCEL_OPTION:
						break;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Senha invalida");
				}

			}

		});
		panel_2.add(btnSalvar);

		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		panel_1.add(lblNovaSenha);

		pwNew = new JPasswordField();
		pwNew.setColumns(10);
		panel_1.add(pwNew);

		JLabel lblSenhaAtual = new JLabel("Senha Atual:");
		panel.add(lblSenhaAtual);

		pwOld = new JPasswordField();
		pwOld.setColumns(10);
		panel.add(pwOld);
		getContentPane().setLayout(groupLayout);

		setSize(215, 130);
		setModal(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
	}

}
