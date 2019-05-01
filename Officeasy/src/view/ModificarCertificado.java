package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import model.Certificado;
import util.table.TableCertificado;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;

public class ModificarCertificado extends JDialog {

	private static final long serialVersionUID = 1L;
	private TableCertificado model;
	private List<Certificado> listaTabela;
	private JTable table;

	public ModificarCertificado(List<Certificado> list) {

		super();

		// TABELA

		this.listaTabela = list;
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable();
		model = new TableCertificado(listaTabela);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(model);
		DefaultTableCellRenderer dc = new DefaultTableCellRenderer();
		dc.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 1; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(dc);
		}

		scrollPane.setViewportView(table);

		// FIM TABELA

		// COMPONENTES

		JPanel panelP = new JPanel();

		JLabel lblCertificados = new JLabel("Certificados");

		JButton btnRemover = new JButton("Remover");

		JButton btnAdicionar = new JButton("Adicionar");

		JButton btnConcluir = new JButton("Concluir");

		JPanel panel1 = new JPanel();

		JPanel panel2 = new JPanel();

		JPanel panel3 = new JPanel();

		JLabel lblDescricao = new JLabel("  Descri\u00E7\u00E3o  ");
		panel3.add(lblDescricao);

		JTextPane textDescricao = new JTextPane();
		textDescricao.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel3.add(textDescricao);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel3.add(horizontalStrut);

		JLabel lblInstituicao = new JLabel("Institui\u00E7\u00E3o");
		panel2.add(lblInstituicao);

		JTextField textInstituicao = new JTextField();
		textInstituicao.setBorder(new LineBorder(Color.BLACK));
		panel2.add(textInstituicao);
		textInstituicao.setColumns(20);

		JLabel lblValidade = new JLabel("Validade");
		panel2.add(lblValidade);

		JLabel lblCertificado = new JLabel("Certificado");
		panel1.add(lblCertificado);

		JTextField textCertificado = new JTextField();
		textCertificado.setBorder(new LineBorder(Color.BLACK));
		panel1.add(textCertificado);
		textCertificado.setColumns(20);

		JLabel lblEmisso = new JLabel("Emiss\u00E3o");
		panel1.add(lblEmisso);

		JDateChooser dateValidade = new JDateChooser();
		dateValidade.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.add(dateValidade);
		dateValidade.setDateFormatString("dd/MM/yy");
		dateValidade.setDate(new Date());

		JDateChooser dateEmissao = new JDateChooser();
		dateEmissao.setDate(new Date());
		dateEmissao.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.add(dateEmissao);
		dateEmissao.setDateFormatString("dd/MM/yy");

		// FIM COMPONENTES

		// LAYOUT

		GroupLayout gl_panelP = new GroupLayout(panelP);
		gl_panelP.setHorizontalGroup(gl_panelP.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelP.createSequentialGroup()
						.addGroup(gl_panelP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelP.createSequentialGroup().addContainerGap().addComponent(panel3,
										GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
								.addGroup(gl_panelP.createSequentialGroup().addContainerGap().addComponent(panel2,
										GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
								.addGroup(gl_panelP.createSequentialGroup().addGap(217).addComponent(lblCertificados))
								.addGroup(gl_panelP.createSequentialGroup().addContainerGap().addComponent(panel1,
										GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
								.addGroup(gl_panelP.createSequentialGroup().addGap(131).addComponent(btnConcluir)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAdicionar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnRemover)))
						.addContainerGap()));
		gl_panelP.setVerticalGroup(gl_panelP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelP.createSequentialGroup().addGap(19).addComponent(lblCertificados)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelP.createParallelGroup(Alignment.BASELINE).addComponent(btnConcluir)
								.addComponent(btnAdicionar).addComponent(btnRemover))
						.addGap(5)));
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));

		panelP.setLayout(gl_panelP);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelP, 0, 0, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelP, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(groupLayout);

		// FIM LAYOUT

		// BOTOES E ACOES

		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (textCertificado.getText().trim().equals("") || textInstituicao.getText().trim().equals("")
						|| textDescricao.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "", JOptionPane.ERROR_MESSAGE);
					return;
				}

				listaTabela.add(new Certificado(textCertificado.getText(), dateEmissao.getDate(),
						textInstituicao.getText(), textDescricao.getText(), dateEmissao.getDate()));

				textCertificado.setText("");
				dateEmissao.setDate(new Date());
				textInstituicao.setText("");
				textDescricao.setText("");
				dateValidade.setDate(new Date());

				model = new TableCertificado(listaTabela);
				table.setModel(model);
				for (int i = 1; i < table.getColumnCount(); i++) {
					table.getColumnModel().getColumn(i).setCellRenderer(dc);
				}

			}
		});

		btnConcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ModificarFuncionario.setCert(listaTabela);
				dispose();

			}
		});

		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					listaTabela.remove(table.getSelectedRow());
					model = new TableCertificado(listaTabela);
					table.setModel(model);

					for (int i = 1; i < table.getColumnCount(); i++) {
						table.getColumnModel().getColumn(i).setCellRenderer(dc);
					}

				} catch (ArrayIndexOutOfBoundsException a) {

				}
			}
		});

		setTitle("Certificados");
		setModal(true);
		setAlwaysOnTop(true);
		setSize(524, 457);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));

	}
}
