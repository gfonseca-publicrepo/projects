package view;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import model.Contato.CategoriaCT;
import model.DAO.ContatoDAO;
import util.table.TableContatos;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class ContatosView extends JFrame {

	public ContatosView() {

		super("Contatos Corporativos");
		definirIcone();

		JPanel panelP = new JPanel();

		JPanel panelBuscar = new JPanel();

		JPanel panelButtons = new JPanel();
		FlowLayout fl_panelButtons = (FlowLayout) panelButtons.getLayout();
		fl_panelButtons.setAlignment(FlowLayout.RIGHT);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GroupLayout gl_panelP = new GroupLayout(panelP);
		gl_panelP.setHorizontalGroup(gl_panelP.createParallelGroup(Alignment.LEADING)
				.addComponent(panelBuscar, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE).addGroup(Alignment.TRAILING,
						gl_panelP.createSequentialGroup()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(panelButtons,
										GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)));
		gl_panelP.setVerticalGroup(gl_panelP.createParallelGroup(Alignment.LEADING).addGroup(gl_panelP
				.createSequentialGroup().addContainerGap()
				.addComponent(panelBuscar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelP.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelButtons, GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)));

		JButton button = new JButton("< Voltar");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Principal(null);
				dispose();

			}
		});
		panel.add(button);

		Component horizontalStrut = Box.createHorizontalStrut(80);
		panel.add(horizontalStrut);

		JLabel lblCategoria = new JLabel("Categoria");
		panel.add(lblCategoria);

		JComboBox<CategoriaCT> comboBox = CategoriaCT.cboxCategoriaContato();
		panel.add(comboBox);

		JTable table;
		table = new JTable();

		TableContatos tableModel = new TableContatos(ContatoDAO.listarContatos());
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(tableModel);
		table.getColumn("Nome").setPreferredWidth(140);
		table.getColumn("Descrição").setPreferredWidth(160);

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

		JButton btnAdicionar = new JButton("Adicionar");
		panelButtons.add(btnAdicionar);

		JButton btnExcluir = new JButton("Excluir");
		panelButtons.add(btnExcluir);

		JButton btnAlterar = new JButton("Alterar");
		panelButtons.add(btnAlterar);

		JTextField textField;
		textField = new JTextField();
		panelBuscar.add(textField);
		textField.setColumns(25);

		JButton btnBuscar = new JButton("Buscar");
		panelBuscar.add(btnBuscar);
		panelP.setLayout(gl_panelP);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panelP,
				GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panelP,
				GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);

		setSize(608, 451);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void definirIcone() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
	}
}
