package view;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import com.toedter.calendar.JDateChooser;
import model.Contrato;
import model.Funcionario;
import model.Local;
import model.DAO.FuncionarioDAO;
import util.table.TableFuncionario;

public class FuncionarioView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField campoBusca;
	private JTable table;

	public FuncionarioView(Funcionario usu) {

		// FRAME
		setResizable(false);
		setTitle("Funcionários");
		setSize(663, 590);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// COMPONENTES
		JPanel panelBusca = new JPanel();
		getContentPane().add(panelBusca);
		panelBusca.setBorder(new EmptyBorder(10, 0, 0, 0));
		GridBagLayout gbl_panelBusca = new GridBagLayout();
		gbl_panelBusca.columnWidths = new int[] { 60, 419, 158, 0 };
		gbl_panelBusca.rowHeights = new int[] { 23, 10, 20, 180 };
		gbl_panelBusca.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelBusca.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
		panelBusca.setLayout(gbl_panelBusca);

		campoBusca = new JTextField();
		GridBagConstraints gbc_campoBusca = new GridBagConstraints();
		gbc_campoBusca.fill = GridBagConstraints.BOTH;
		gbc_campoBusca.anchor = GridBagConstraints.NORTH;
		gbc_campoBusca.insets = new Insets(0, 0, 5, 5);
		gbc_campoBusca.gridx = 1;
		gbc_campoBusca.gridy = 0;
		panelBusca.add(campoBusca, gbc_campoBusca);
		campoBusca.setColumns(10);

		JButton buttonBuscar = new JButton("Buscar");
		GridBagConstraints gbc_buttonBuscar = new GridBagConstraints();
		gbc_buttonBuscar.anchor = GridBagConstraints.NORTHWEST;
		gbc_buttonBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_buttonBuscar.gridx = 2;
		gbc_buttonBuscar.gridy = 0;
		panelBusca.add(buttonBuscar, gbc_buttonBuscar);

		JPanel panelFiltros = new JPanel();
		GridBagConstraints gbc_panelFiltros = new GridBagConstraints();
		gbc_panelFiltros.insets = new Insets(0, 0, 5, 0);
		gbc_panelFiltros.anchor = GridBagConstraints.NORTHWEST;
		gbc_panelFiltros.gridwidth = 3;
		gbc_panelFiltros.gridx = 0;
		gbc_panelFiltros.gridy = 1;
		panelBusca.add(panelFiltros, gbc_panelFiltros);

		JLabel lblSituacao = new JLabel("Situação");

		JComboBox<String> boxSituacao = new JComboBox<String>();
		boxSituacao.addItem("Ativo");
		boxSituacao.addItem("Inativo");

		JLabel lblCargo = new JLabel("Cargo");

		JComboBox<String> boxCargo = model.Funcionario.boxCargos();

		JLabel lblLocal = new JLabel("Local");

		JComboBox<Local> boxLocal = Local.cboxLocais();

		JLabel lblContrato = new JLabel("Contrato");

		JComboBox<Contrato> boxContrato = Contrato.cboxContrato();

		JLabel lblPeriodo = new JLabel("Período");

		JDateChooser dateChooser1 = new JDateChooser(new Date(), "dd/MM/yy");

		JLabel lblPeriodo2 = new JLabel("Até");

		JDateChooser dateChooser2 = new JDateChooser(new Date(), "dd/MM/yy");

		panelFiltros.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelFiltros.add(lblSituacao);
		panelFiltros.add(boxSituacao);
		panelFiltros.add(lblCargo);
		panelFiltros.add(boxCargo);
		panelFiltros.add(lblLocal);
		panelFiltros.add(boxLocal);
		panelFiltros.add(lblContrato);
		panelFiltros.add(boxContrato);
		panelFiltros.add(lblPeriodo);
		panelFiltros.add(dateChooser1);
		panelFiltros.add(lblPeriodo2);
		panelFiltros.add(dateChooser2);

		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelButtons = new GridBagConstraints();
		gbc_panelButtons.anchor = GridBagConstraints.EAST;
		gbc_panelButtons.insets = new Insets(0, 0, 5, 0);
		gbc_panelButtons.gridwidth = 3;
		gbc_panelButtons.gridx = 0;
		gbc_panelButtons.gridy = 2;
		panelBusca.add(panelButtons, gbc_panelButtons);

		JButton btnVoltar = new JButton("< Voltar");
		panelButtons.add(btnVoltar);

		JButton buttonCadastrar = new JButton("Cadastrar");
		panelButtons.add(buttonCadastrar);

		JButton buttonModificar = new JButton("Modificar");
		panelButtons.add(buttonModificar);

		JButton buttonAbrir = new JButton("Detalhes");
		buttonAbrir.setHorizontalAlignment(SwingConstants.RIGHT);
		panelButtons.add(buttonAbrir);

		// TABELA
		table = new JTable();
		TableFuncionario tableModel = new TableFuncionario(FuncionarioDAO.listarAtivos());
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(tableModel);
		table.getColumn("Matricula").setPreferredWidth(70);
		table.getColumn("Nome").setPreferredWidth(160);
		table.getColumn("Cargo").setPreferredWidth(140);
		table.getColumn("Situacao").setPreferredWidth(70);
		table.getColumn("Contrato").setPreferredWidth(140);
		table.getColumn("Local de Trabalho").setPreferredWidth(140);

		DefaultTableCellRenderer dc = new DefaultTableCellRenderer();
		dc.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 1; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(dc);
		}

		// LISTENER CHECK BOX
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (!(boolean) table.getModel().getValueAt(table.getSelectedRow(), 0)) {

					table.getModel().setValueAt(false, table.getSelectedRow(), 0);

					return;

				}

				for (int i = 0; i < tableModel.getRowCount(); i++) {
					table.getModel().setValueAt(false, i, 0);
				}

				table.getModel().setValueAt(true, table.getSelectedRow(), 0);

			}
		});

		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setViewportView(table);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;
		panelBusca.add(scrollTable, gbc_table);

		// AÇÔES
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Principal(usu);
				dispose();

			}
		});

		buttonCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarFuncionario(usu);
				dispose();

			}
		});

		buttonModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() <= -1) {

					JOptionPane.showMessageDialog(null, "Selecione um funcionário para modificar", "",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				System.out.println((Integer) tableModel.getValueAt(table.getSelectedRow(), 1));

				Funcionario f = FuncionarioDAO
						.selecionarPorMatricula((Integer) tableModel.getValueAt(table.getSelectedRow(), 1));
				new ModificarFuncionario(usu, f);
				dispose();
			}
		});

	}
}
