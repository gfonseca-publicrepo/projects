package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.Funcionario;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EquipamentosView extends JFrame {
	/**
	 * @author Gabriel
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textBuscar;
	private JTable table;

	public EquipamentosView(Funcionario usu) {

		setResizable(false);
		setTitle("Equipamentos");
		setSize(650, 380);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panelBusca = new JPanel();

		JPanel panelFiltros = new JPanel();

		JPanel panel2 = new JPanel();

		JPanel panel1 = new JPanel();
		FlowLayout fl_panel1 = (FlowLayout) panel1.getLayout();
		fl_panel1.setAlignment(FlowLayout.LEFT);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelBusca, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(panelFiltros, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
						.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel2, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addComponent(panelBusca, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(panelFiltros, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)));

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnVoltar = new JButton("< Voltar");
		panel1.add(btnVoltar);

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Principal(usu);
				dispose();
			}
		});

		JButton btnNovo = new JButton("Novo");
		panel2.add(btnNovo);

		JButton btnDetalhes = new JButton("Detalhes");
		panel2.add(btnDetalhes);

		JButton btnHist = new JButton("Histórico");
		panel2.add(btnHist);

		JLabel lblTipo = new JLabel("Tipo");
		panelFiltros.add(lblTipo);

		JComboBox<String> boxTipo = new JComboBox<String>();
		panelFiltros.add(boxTipo);

		JLabel lblCondio = new JLabel("Condição");
		panelFiltros.add(lblCondio);

		JComboBox<String> boxCond = new JComboBox<String>();
		panelFiltros.add(boxCond);

		textBuscar = new JTextField();
		panelBusca.add(textBuscar);
		textBuscar.setColumns(25);

		JButton btnBuscar = new JButton("Buscar");
		panelBusca.add(btnBuscar);
		getContentPane().setLayout(groupLayout);

	}
}
