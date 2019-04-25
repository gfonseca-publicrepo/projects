package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import com.toedter.calendar.JDateChooser;
import model.DAO.ContratoDAO;
import util.TableContratos;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ContratosView extends JFrame {
	private JTextField textBusca;
	private JTable table;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ContratosView() {

		super("Contratos");
		definirIcone();

		JPanel panelBusca = new JPanel();

		JPanel panelFiltros = new JPanel();

		JPanel panelAcoes2 = new JPanel();
		FlowLayout fl_panelAcoes2 = (FlowLayout) panelAcoes2.getLayout();
		fl_panelAcoes2.setAlignment(FlowLayout.RIGHT);

		JPanel panelAcoes = new JPanel();
		FlowLayout fl_panelAcoes = (FlowLayout) panelAcoes.getLayout();
		fl_panelAcoes.setAlignment(FlowLayout.LEFT);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelBusca, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(panelFiltros, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup()
								.addComponent(panelAcoes, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelAcoes2, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(panelBusca, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panelFiltros, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelAcoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelAcoes2, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)));

		table = new JTable();

		TableContratos tableModel = new TableContratos(ContratoDAO.carregarContratos());
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(tableModel);

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

		scrollPane.setViewportView(table);

		JButton buttonVoltar = new JButton("< Voltar");
		panelAcoes.add(buttonVoltar);
		buttonVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Principal(null);
				dispose();

			}
		});

		JButton btnAbrir = new JButton("Abrir");
		panelAcoes2.add(btnAbrir);

		JButton btnNovo = new JButton("Novo");
		panelAcoes2.add(btnNovo);

		JLabel lblCond = new JLabel("Condição");
		panelFiltros.add(lblCond);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Ativo", "Encerrado" }));
		panelFiltros.add(comboBox);

		JLabel lblData = new JLabel("Data");
		panelFiltros.add(lblData);

		JDateChooser date1 = new JDateChooser(new Date(), "dd/MM/yy");
		panelFiltros.add(date1);

		JLabel label = new JLabel("-");
		panelFiltros.add(label);

		JDateChooser date2 = new JDateChooser(new Date(), "dd/MM/yy");
		panelFiltros.add(date2);

		textBusca = new JTextField();
		panelBusca.add(textBusca);
		textBusca.setColumns(25);

		JButton btnBuscar = new JButton("Buscar");
		panelBusca.add(btnBuscar);
		getContentPane().setLayout(groupLayout);

		setSize(455, 305);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void definirIcone() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
	}
}
