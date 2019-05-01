package view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Dpto;
import model.Pasta;
import model.TipoDoc;
import model.DAO.DptoDAO;
import model.DAO.ModeloDAO;
import model.DAO.PastaDAO;
import model.DAO.TipoDocDAO;
import javax.swing.JSeparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;

@SuppressWarnings("serial")
public class AdicionarDocumentoView extends JDialog {

	private JTextField textField;
	private JTextField textField_1;
	JPanel painelDpto;
	JLabel nomeDpto;
	JButton botaoDpto = new JButton();

	JList<String> list = new JList<String>();

	DefaultListModel<String> modelList = new DefaultListModel<String>();

	DefaultListModel<String> modelList2 = new DefaultListModel<String>();
	JList<String> list_1 = new JList<String>();
	String dado;
	String[] tiposDoc = { "--Selecione um tipo--" };

	List<TipoDoc> listaTipoDoc = TipoDocDAO.listarTipoDoc();
	List<Dpto> listaDpto = DptoDAO.listarAtivos();
	List<Pasta> listaPasta = new ArrayList<Pasta>();

	public AdicionarDocumentoView() {
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
		separator.setBounds(10, 370, 302, 7);
		getContentPane().add(separator);

		JLabel lblDUmTtulo = new JLabel("T\u00EDtulo:");
		lblDUmTtulo.setBounds(10, 11, 302, 14);
		getContentPane().add(lblDUmTtulo);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 36, 302, 20);
		getContentPane().add(textField_1);

		JLabel lblTipoDoDocumento = new JLabel("Tipo do documento:");
		lblTipoDoDocumento.setBounds(10, 123, 299, 14);
		getContentPane().add(lblTipoDoDocumento);

		JComboBox<String> comboBox = new JComboBox<String>(tiposDoc);
		for (TipoDoc t : listaTipoDoc) {
			comboBox.addItem(t.getTipo());
		}
		comboBox.setToolTipText("d\r\ng");
		comboBox.setBounds(10, 148, 226, 21);
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

		btnAdicionar.setBounds(161, 383, 89, 23);
		getContentPane().add(btnAdicionar);

		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new NovoTipoDocDocumento();
			}
		});
		btnNewButton_1.setBounds(246, 148, 66, 22);
		getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new DocumentosView(null);
			}
		});
		btnNewButton_2.setBounds(62, 383, 89, 23);
		getContentPane().add(btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(322, 31, 226, 341);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(list);

		MouseListener mouseListener = new MouseAdapter() {

			public void mouseClicked(MouseEvent mouseEvent) {
				list_1.clearSelection();
				modelList2.clear();
				JList<?> theList = (JList<?>) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 1) {
					int index = theList.locationToIndex(mouseEvent.getPoint());
					if (index >= 0) {
						Object o = theList.getModel().getElementAt(index);
						Dpto d = DptoDAO.encontrarId(o.toString());
						int id = d.getId();

						listaPasta = PastaDAO.listarPastasComId(id);
						for (Pasta t : listaPasta) {
							construirPastas(t.getNomePast());

						}
						listaPasta.clear();

					}
				}
			}
		};
		list.addMouseListener(mouseListener);

		JButton btnAdicionarPasta = new JButton("Adicionar Pasta");
		btnAdicionarPasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new NovoPastaView();
			}
		});
		btnAdicionarPasta.setBounds(690, 383, 120, 22);
		getContentPane().add(btnAdicionarPasta);
		for (Dpto t : listaDpto) {
			construirDptos(t.getId(), t.getNome(), t.getAssunto());
		}

		JButton btnBuscar = new JButton("Adicionar Dpto");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new NovoDptoView();

			}
		});
		btnBuscar.setBounds(428, 383, 120, 22);
		getContentPane().add(btnBuscar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(584, 31, 226, 341);
		getContentPane().add(scrollPane_1);

		scrollPane_1.setViewportView(list_1);

		JLabel label = new JLabel(">>");
		label.setBounds(558, 186, 27, 28);
		getContentPane().add(label);

		JLabel lblDpto = new JLabel("Dpto:");
		lblDpto.setBounds(322, 11, 226, 14);
		getContentPane().add(lblDpto);

		JLabel lblPasta = new JLabel("Pasta:");
		lblPasta.setBounds(584, 11, 226, 14);
		getContentPane().add(lblPasta);

		JLabel lblSelecioneDptoE = new JLabel("*Selecione Dpto e Pasta");
		lblSelecioneDptoE.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSelecioneDptoE.setBounds(10, 345, 299, 14);
		getContentPane().add(lblSelecioneDptoE);
		setModal(true);
		setSize(832, 447);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void construirDptos(int id, String nome, String Assunto) {
		modelList.addElement(nome);
		list.setModel(modelList);
	}

	private void construirPastas(String nome) {
		modelList2.addElement(nome);
		list_1.setModel(modelList2);
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

	@SuppressWarnings("unused")
	private void encontrarDiretorio(java.awt.event.ActionEvent evt) {
		try {
			JFileChooser buscar = new JFileChooser();
			buscar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			buscar.setAcceptAllFileFilterUsed(false);
			buscar.setCurrentDirectory(new File(""));
			buscar.setDialogTitle("Buscar Diret�rio");
			buscar.showOpenDialog(this);
			String arq = "" + buscar.getSelectedFile().getParentFile() + "\\" + "" + buscar.getSelectedFile().getName();
			textField.setText(arq);
		} catch (NullPointerException e2) {
			System.out.println(e2);
		}

	}

//	public void copiarArquivos(Path origem, Path destino) throws IOException {
//	      // se � um diret�rio, tentamos criar. se j� existir, n�o tem problema.
//	      if(Files.isDirectory(origem)){
//	        Files.createDirectories(destino);
//	        // listamos todas as entradas do diret�rio
//	        DirectoryStream entradas = Files.newDirectoryStream(origem);
//	        for (Path entrada : entradas ) {
//	          // para cada entrada, achamos o arquivo equivalente dentro de cada arvore
//	          Path novaOrigem = origem.resolve(entrada.getFileName());
//	          Path novoDestino = destino.resolve(entrada.getFileName());
//	          // invoca o metodo de maneira recursiva
//	          copiarArquivos(novaOrigem, novoDestino);
//	        }
//	      } else {
//	        // copiamos o arquivo
//	        Files.copy(origem, destino);
//	      }
//	    }

	public void atualizarComboBox() {
		JComboBox<String> comboBox = new JComboBox<String>(tiposDoc);
		for (TipoDoc t : listaTipoDoc) {
			comboBox.addItem(t.getTipo());
		}
		JComboBox<String> comboBox_2 = new JComboBox<String>(tiposDoc);
		for (Dpto t : listaDpto) {
			comboBox_2.addItem(t.getNome());
		}
		JComboBox<String> comboBox_1 = new JComboBox<String>(tiposDoc);
		for (Pasta t : listaPasta) {
			comboBox_1.addItem(t.getNomePast());
		}
	}
}

//File arquivo = new File("teste.txt");
//
//if (!arquivo.exists()) {
//    System.out.println("Arquivo n�o encontrado");
//} else {
//
//    // Diretorio de destino
//    File diretorioDestino = new File("/tmp");
//
//    // Move o arquivo para o novo diretorio
//    boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
//    if (sucesso) {
//        System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
//    } else {
//        System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
//                + diretorioDestino.getAbsolutePath() + "'");
//    }
//}
