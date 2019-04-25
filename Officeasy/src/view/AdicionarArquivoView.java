package view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.TipoDoc;
import model.DAO.ModeloDAO;
import model.DAO.TipoDocDAO;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class AdicionarArquivoView extends JDialog {

	private JTextField textField;
	private JTextField textField_1;

	String dado;
	String[] tiposDoc = { "Selecione um tipo" };

	List<TipoDoc> lista = TipoDocDAO.listarTipoDoc();

	@SuppressWarnings("rawtypes")
	public AdicionarArquivoView() {
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Abrir");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					encontrarArquivo(e);
				} catch (NullPointerException e2) {
					System.out.println(e2);
				}

			}
		});
		btnNewButton.setBounds(246, 92, 66, 20);
		getContentPane().add(btnNewButton);

		JLabel lblSelecioneOArquivo = new JLabel("Selecione o arquivo:");
		lblSelecioneOArquivo.setBounds(10, 67, 302, 14);
		getContentPane().add(lblSelecioneOArquivo);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 92, 226, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 179, 302, 9);
		getContentPane().add(separator);

		JLabel lblDUmTtulo = new JLabel("T\u00EDtulo:");
		lblDUmTtulo.setBounds(10, 11, 302, 14);
		getContentPane().add(lblDUmTtulo);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 36, 302, 20);
		getContentPane().add(textField_1);

		JLabel lblTipoDoDocumento = new JLabel("Tipo do documento");
		lblTipoDoDocumento.setBounds(10, 123, 299, 14);
		getContentPane().add(lblTipoDoDocumento);

		@SuppressWarnings("unchecked")
		JComboBox<String> comboBox = new JComboBox(tiposDoc);
		for (TipoDoc t : lista) {
			comboBox.addItem(t.getTipo());
		}
		comboBox.setToolTipText("d\r\ng");
		comboBox.setBounds(10, 148, 163, 21);
		getContentPane().add(comboBox);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int erro = 0;

				if (textField.getText() == null || textField.getText().trim().equals("")) {
					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione o caminho do arquivo");
				}

				if (textField_1.getText() == null || textField_1.getText().trim().equals("")) {
					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione um título");
				}

				if (comboBox.getSelectedItem() == "Selecione um tipo") {
					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione um tipo de documento");
				}

				if (erro == 0) {

					String s = String.valueOf(comboBox.getSelectedItem());
					TipoDoc tipoDocOBJ = TipoDocDAO.encontrarTipoDoc(s);
					ModeloDAO.inserirModelo(textField.getText(), textField_1.getText(), tipoDocOBJ.getId());
					JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
					new ModelosView(null);
					dispose();

				}

			}
		});

		btnAdicionar.setBounds(165, 192, 89, 23);
		getContentPane().add(btnAdicionar);

		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new NovoTipoDocView();
			}
		});
		btnNewButton_1.setBounds(183, 148, 35, 22);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ModelosView(null);
			}
		});
		btnNewButton_2.setBounds(66, 192, 89, 23);
		getContentPane().add(btnNewButton_2);
		setModal(true);
		setTitle("Adicionar Modelo");
		setSize(325, 255);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void encontrarArquivo(java.awt.event.ActionEvent evt) {
		try {
			JFileChooser buscar = new JFileChooser();
			buscar.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos PDF", "pdf"));
			buscar.setAcceptAllFileFilterUsed(false);
			buscar.setCurrentDirectory(new File(""));
			buscar.setDialogTitle("Buscar Arquivo");
			buscar.showOpenDialog(this);
			String arq = "" + buscar.getSelectedFile().getParentFile() + "\\" + "" + buscar.getSelectedFile().getName();
			textField.setText(arq);
		} catch (NullPointerException e2) {
			System.out.println(e2);
		}

	}

	public void atualizarComboBox() {
		JComboBox<String> comboBox = new JComboBox<String>(tiposDoc);
		for (TipoDoc t : lista) {
			comboBox.addItem(t.getTipo());
		}
	}
}
