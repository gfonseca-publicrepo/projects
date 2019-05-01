package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import model.Dependente;
import util.JCBox;
import util.Mascaras;
import util.table.TableDependente;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class CadastrarDependente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tableDependentes;
	private TableDependente tableModel;
	private Dependente d;
	private List<Dependente> dependentes;

	public CadastrarDependente(List<Dependente> list) {

		// TABELA
		// PASSANDO LIST DE OBJETOS PARA O MODELO
		dependentes = new ArrayList<Dependente>();
		this.dependentes = list;
		tableModel = new TableDependente(dependentes); // MODELO DA TABELA

		tableDependentes = new JTable(tableModel);

		tableDependentes.setRowSelectionAllowed(false);
		tableDependentes.setColumnSelectionAllowed(false);
		tableDependentes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDependentes.setModel(tableModel);

		// LISTENER CHECK BOX
		tableDependentes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (!(boolean) tableDependentes.getModel().getValueAt(tableDependentes.getSelectedRow(), 0)) {

					tableDependentes.getModel().setValueAt(false, tableDependentes.getSelectedRow(), 0);

					return;

				}

				for (int i = 0; i < tableModel.getRowCount(); i++) {
					tableDependentes.getModel().setValueAt(false, i, 0);
				}

				tableDependentes.getModel().setValueAt(true, tableDependentes.getSelectedRow(), 0);

			}
		});

		DefaultTableCellRenderer dc = new DefaultTableCellRenderer();
		dc.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 1; i < tableDependentes.getColumnCount(); i++) {
			tableDependentes.getColumnModel().getColumn(i).setCellRenderer(dc);
		}

		// PAINEL COM SCROLL
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tableDependentes);

		// FIM TABELA

		// COMPONENTES

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();

		JPanel panel_3 = new JPanel();

		JLabel lblCadastroDeDependentes = new JLabel("Cadastro de Dependentes");
		lblCadastroDeDependentes.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNome = new JLabel("Nome");

		JLabel lblCpf = new JLabel("CPF");
		panel_3.add(lblCpf);

		JTextField textNome = new JTextField();
		textNome.setColumns(25);

		JFormattedTextField textCPF = new JFormattedTextField(new Mascaras().MaskCPF());
		panel_3.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblRg = new JLabel("Registro Geral");
		panel_3.add(lblRg);

		JFormattedTextField textRG = new JFormattedTextField(new Mascaras().MaskRG());
		panel_3.add(textRG);
		textRG.setColumns(10);

		JLabel lblParentesco = new JLabel("Grau");
		panel_2.add(lblParentesco);

		JComboBox<String> boxParentesco = JCBox.parentesco();
		panel_2.add(boxParentesco);

		JLabel lblNascimento = new JLabel("Nascimento");
		panel_2.add(lblNascimento);

		JDateChooser dateNascimento = new JDateChooser(new Date(), "dd/MM/yy");
		panel_2.add(dateNascimento);

		// LAYOUT

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(12)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(11, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(161).addComponent(lblCadastroDeDependentes)
						.addContainerGap(160, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(18)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE).addGap(18)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap().addComponent(lblCadastroDeDependentes).addGap(8)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(12)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE).addContainerGap()));
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] { panel_3, panel, panel_1, panel_2 });

		JButton btnAdicionar = new JButton("Adicionar");
		panel_1.add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		panel_1.add(btnRemover);

		JButton btnConcluir = new JButton("Concluir");
		panel_1.add(btnConcluir);

		// AÇÔES

		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (textNome.getText().trim().equals("") || textRG.getText().trim().equals("")
						|| textCPF.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "", JOptionPane.ERROR_MESSAGE);
					return;
				}

				d = new Dependente(textNome.getText(), textRG.getText(), textCPF.getText(), dateNascimento.getDate(),
						boxParentesco.getSelectedItem().toString());
				dependentes.add(d);
				tableModel = new TableDependente(dependentes);
				tableDependentes.setModel(tableModel);
				for (int i = 1; i < tableDependentes.getColumnCount(); i++) {
					tableDependentes.getColumnModel().getColumn(i).setCellRenderer(dc);
				}

			}
		});

		btnConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CadastrarFuncionario.setDep(dependentes);
				dispose();
			}
		});

		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					dependentes.remove(tableDependentes.getSelectedRow());
					tableModel = new TableDependente(dependentes);
					tableDependentes.setModel(tableModel);

					for (int i = 1; i < tableDependentes.getColumnCount(); i++) {
						tableDependentes.getColumnModel().getColumn(i).setCellRenderer(dc);
					}

				} catch (ArrayIndexOutOfBoundsException a) {

				}
			}
		});

		// FRAME
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(lblNome);
		panel.add(textNome);
		getContentPane().setLayout(groupLayout);

		setTitle("Cadastro de Dependente");
		setModal(true);
		setAlwaysOnTop(true);
		setSize(486, 341);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));

	}

}
