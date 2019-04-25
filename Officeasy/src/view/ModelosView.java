package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import java.awt.FlowLayout;

import model.Funcionario;
import model.Modelo;
import model.TipoDoc;
import model.DAO.ModeloDAO;
import model.DAO.TipoDocDAO;
import util.Leitor;
import util.TableModelo;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ModelosView extends JFrame {
	Funcionario usu = null;
	private JTextField campoBusca;
	private JTextField campoData1;
	private JTextField campoData2;
	private JTable table;
	private TableModelo tableModel;
	private List<Modelo> modelos;
	private List<TipoDoc> tipos;

	public ModelosView(Funcionario usu) {
		this.usu = usu;
		modelos = new ArrayList<Modelo>();
		this.modelos = ModeloDAO.listarAtivos();
		this.tipos = TipoDocDAO.listarTipoDoc();

		// Componentes da tabela
		table = new JTable();
		List<Modelo> tableListModelo = new ArrayList<Modelo>();
		List<TipoDoc> tableListTipo = new ArrayList<TipoDoc>();
		tableListTipo.addAll(tipos);
		tableListModelo.addAll(modelos);
		tableModel = new TableModelo(tableListModelo, tableListTipo);
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(350);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(465);

		GridBagLayout gbl_panelPrincipal = new GridBagLayout();
		gbl_panelPrincipal.columnWidths = new int[] { 60, 419, 0, 0, 400, 0 };
		gbl_panelPrincipal.rowHeights = new int[] { 23, 10, 20, 180 };
		gbl_panelPrincipal.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelPrincipal.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };

		GridBagConstraints gbc_panelBusca = new GridBagConstraints();
		gbc_panelBusca.anchor = GridBagConstraints.EAST;
		gbc_panelBusca.fill = GridBagConstraints.VERTICAL;
		gbc_panelBusca.insets = new Insets(0, 0, 5, 0);
		gbc_panelBusca.gridx = 4;
		gbc_panelBusca.gridy = 0;

		GridBagConstraints gbc_panelFuncao = new GridBagConstraints();
		gbc_panelFuncao.anchor = GridBagConstraints.EAST;
		gbc_panelFuncao.insets = new Insets(0, 0, 5, 0);
		gbc_panelFuncao.fill = GridBagConstraints.VERTICAL;
		gbc_panelFuncao.gridx = 4;
		gbc_panelFuncao.gridy = 2;

		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 5;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 3;

		// ScrollPane da table
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setViewportBorder(null);
		scrollTable.setViewportView(table);

		JPanel panelFuncao = new JPanel();

		JPanel panelBusca = new JPanel();

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(10, 100, 0, 100));
		panelPrincipal.setLayout(gbl_panelPrincipal);

		getContentPane().add(panelPrincipal);

		// componentes
		JButton button = new JButton("Excluir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i;
				i = table.getSelectedRow();
				Modelo m = modelos.get(i);
				if (JOptionPane.showConfirmDialog(null,
						"Deseja excluir o arquivo " + m.getTitulo() + "?") == JOptionPane.YES_OPTION) {

					int id = m.getId();
					ModeloDAO.deleteModelo(id);
					dispose();
					new ModelosView(null);
				}

			}
		});

		JButton button_1 = new JButton("< Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new view.Principal(usu);
			}
		});
		panelFuncao.add(button_1);

		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int i;
					i = table.getSelectedRow();
					Modelo m = modelos.get(i);
					String caminho = m.getCaminho();
					new Leitor(caminho);
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Selecione um arquivo");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não foi possivel abrir o arquivo arquivo");
				}

			}
		});
		panelFuncao.add(btnExibir);
		panelFuncao.add(button);

		JButton btnAdicionarDocumento = new JButton("Adicionar Modelo");
		btnAdicionarDocumento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdicionarArquivoView();
				dispose();
			}
		});
		panelFuncao.add(btnAdicionarDocumento);

		campoData1 = new JTextField(20);

		campoData1.setEditable(false);
		campoData2 = new JTextField(20);
		campoData2.setEditable(false);

		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		campoBusca = new JTextField();
		GridBagConstraints gbc_campoBusca = new GridBagConstraints();
		gbc_campoBusca.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoBusca.insets = new Insets(0, 0, 5, 5);
		gbc_campoBusca.gridx = 1;
		gbc_campoBusca.gridy = 0;
		panelPrincipal.add(campoBusca, gbc_campoBusca);
		campoBusca.setHorizontalAlignment(SwingConstants.LEFT);
		campoBusca.setToolTipText("");
		campoBusca.setColumns(30);
		JButton buttonBuscar = new JButton("Buscar");
		GridBagConstraints gbc_buttonBuscar = new GridBagConstraints();
		gbc_buttonBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBuscar.gridx = 2;
		gbc_buttonBuscar.gridy = 0;
		panelPrincipal.add(buttonBuscar, gbc_buttonBuscar);
		panelPrincipal.add(panelBusca, gbc_panelBusca);

		JPanel panelAbrirFiltros = new JPanel();
		GridBagConstraints gbc_panelAbrirFiltros = new GridBagConstraints();
		gbc_panelAbrirFiltros.anchor = GridBagConstraints.WEST;
		gbc_panelAbrirFiltros.insets = new Insets(0, 0, 5, 5);
		gbc_panelAbrirFiltros.gridx = 1;
		gbc_panelAbrirFiltros.gridy = 1;
		panelPrincipal.add(panelAbrirFiltros, gbc_panelAbrirFiltros);
		panelPrincipal.add(panelFuncao, gbc_panelFuncao);
		panelPrincipal.add(scrollTable, gbc_table);

		// config

		setResizable(false);
		setTitle("Selecionar Modelos");
		setSize(1000, 590);
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
