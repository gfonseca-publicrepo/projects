package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DAO.DptoDAO;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NovoDptoView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;

	public NovoDptoView() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome Dpto:");
		lblNewLabel.setBounds(10, 11, 245, 14);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 36, 245, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(10, 67, 414, 14);
		getContentPane().add(lblAssunto);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 92, 245, 20);
		getContentPane().add(textField_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 123, 245, 7);
		getContentPane().add(separator);

		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AdicionarDocumentoView();
			}
		});
		button.setBounds(37, 137, 89, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("Adicionar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int erro = 0;

				if (DptoDAO.isRegistro(textField.getText().trim().toLowerCase()) == true) {

					JOptionPane.showMessageDialog(null, "Nome de dpto j� existe!");
					erro += 1;
				}

				if (textField.getText() == null || textField.getText().trim().equals("")) {

					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione um nome");
				}

				if (textField_2.getText() == null || textField_2.getText().trim().equals("")) {

					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione um assunto");
				}

				if (erro == 0) {

					if (JOptionPane.showConfirmDialog(null, "Deseja mesmo adicionar o dpto '"
							+ textField.getText().trim() + "' ao sistema?") == JOptionPane.YES_OPTION) {
						DptoDAO.inserirDpto(textField.getText().trim().toLowerCase(), textField_2.getText());
						JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
						dispose();
						new AdicionarDocumentoView();
					}

				}

			}
		});

		button_1.setBounds(136, 137, 89, 23);
		getContentPane().add(button_1);

		setSize(271, 200);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
