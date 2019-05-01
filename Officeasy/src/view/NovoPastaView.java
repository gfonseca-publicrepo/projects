package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Dpto;
import model.DAO.DptoDAO;
import model.DAO.PastaDAO;
import javax.swing.JSeparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class NovoPastaView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_2;
	List<Dpto> listaDpto = DptoDAO.listarAtivos();
	DefaultListModel<String> modelList = new DefaultListModel<String>();
	JList<String> list = new JList<String>();
	Dpto d;
	int idList;

	public NovoPastaView() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome da pasta:");
		lblNewLabel.setBounds(10, 11, 364, 14);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(10, 36, 364, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setBounds(10, 67, 364, 14);
		getContentPane().add(lblAssunto);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 92, 364, 20);
		getContentPane().add(textField_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 421, 364, 8);
		getContentPane().add(separator);

		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AdicionarDocumentoView();
			}
		});
		button.setBounds(95, 430, 89, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("Adicionar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int erro = 0;

				if (PastaDAO.isRegistro(idList, textField.getText().trim().toLowerCase()) == true) {

					JOptionPane.showMessageDialog(null, "Nome de pasta j� existe!");
					erro += 1;
				}

				if (textField.getText() == null || textField.getText().trim().equals("")) {

					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione um nome");
				}

//				if (textField_1.getText() == null || textField_1.getText().trim().equals("")) {
//
//					erro += 1;
//					JOptionPane.showMessageDialog(null, "Adicione um caminho");
//				}

				if (textField_2.getText() == null || textField_2.getText().trim().equals("")) {

					erro += 1;
					JOptionPane.showMessageDialog(null, "Adicione um assunto");
				}

				if (list.isSelectionEmpty()) {

					erro += 1;
					JOptionPane.showMessageDialog(null, "Selecione um dpto");
				}

				if (erro == 0) {
					if (JOptionPane.showConfirmDialog(null, "Deseja mesmo adicionar a pasta '"
							+ textField.getText().trim() + "' ao sistema?") == JOptionPane.YES_OPTION) {

						PastaDAO.inserirPasta(textField.getText().trim().toLowerCase(), "caminho",
								textField_2.getText(), d.getId());
						JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
						dispose();
						new AdicionarDocumentoView();
					}

				}
			}
		});

		button_1.setBounds(194, 430, 89, 23);
		getContentPane().add(button_1);

		JLabel lblSelecioneODpto = new JLabel("Selecione o dpto da pasta:");
		lblSelecioneODpto.setBounds(10, 123, 364, 14);
		getContentPane().add(lblSelecioneODpto);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 364, 253);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);

		MouseListener mouseListener = new MouseAdapter() {

			public void mouseClicked(MouseEvent mouseEvent) {

				JList<?> theList = (JList<?>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						d = DptoDAO.encontrarId(o.toString());
						idList = d.getId();

					}
				}
			}
		};
		list.addMouseListener(mouseListener);

		JButton button_2 = new JButton("Adicionar Dpto");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new NovoDptoView();
			}
		});
		button_2.setBounds(254, 123, 120, 22);
		getContentPane().add(button_2);

		for (Dpto t : listaDpto) {
			construirDptos(t.getId(), t.getNome(), t.getAssunto());
		}

		setSize(390, 490);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void construirDptos(int id, String nome, String Assunto) {
		modelList.addElement(nome);
		list.setModel(modelList);
	}
}
