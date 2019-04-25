package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO.TipoDocDAO;

import javax.swing.JSeparator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class NovoTipoDocView extends JDialog {
	private JTextField textField_1;

	public NovoTipoDocView() {
		getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 67, 302, 9);
		getContentPane().add(separator);

		JLabel lblDUmTtulo = new JLabel("Digite o tipo de arquivo:");
		lblDUmTtulo.setBounds(10, 11, 302, 14);
		getContentPane().add(lblDUmTtulo);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 36, 302, 20);
		getContentPane().add(textField_1);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int erro = 0;

				if (textField_1.getText() == null || textField_1.getText().trim().equals("")) {
					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione um tipo de documento");
				}

				if (erro == 0) {
					if (JOptionPane.showConfirmDialog(null, "Deseja mesmo adicionar o tipo '" + textField_1.getText()
							+ "' ao sistema?") == JOptionPane.YES_OPTION) {
						TipoDocDAO.inserirTipoDoc(textField_1.getText());
						JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
						dispose();
						new AdicionarArquivoView();
					}

				}

			}
		});

		btnAdicionar.setBounds(223, 75, 89, 23);
		getContentPane().add(btnAdicionar);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AdicionarArquivoView();
			}
		});
		btnNewButton.setBounds(10, 75, 89, 23);
		getContentPane().add(btnNewButton);

		setSize(325, 135);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
