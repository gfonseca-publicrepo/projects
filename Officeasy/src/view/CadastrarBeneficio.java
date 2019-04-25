package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import model.Beneficio;
import model.Beneficio.Alimentacao;
import model.Beneficio.SeguroOdontologico;
import model.Beneficio.SeguroSaude;
import model.Beneficio.Transporte;
import util.Mascaras;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CadastrarBeneficio extends JDialog {

	private static final long serialVersionUID = 1L;
	private double valorTransporte = 0;
	private Beneficio b = null;

	public CadastrarBeneficio(Beneficio ben) {

		this.valorTransporte = ben.getVtValor();
		this.b = ben;

		JPanel panel = new JPanel();

		JLabel lblBenefcios = new JLabel("Benefícios");

		JLabel lblValeTransporte = new JLabel("Transporte");

		JLabel lblValor = new JLabel("Valor");

		JLabel lblAlimentao = new JLabel("Alimentação");

		JLabel lblPlanoDeSade = new JLabel("Plano de Saúde");

		JLabel lblPlanoOdontologico = new JLabel("Plano Odontologico");

		JFormattedTextField valorVt = new JFormattedTextField(new Mascaras().Mask2Digitos());
		valorVt.setToolTipText("Valor Diário");
		valorVt.setColumns(6);
		if (valorTransporte != 0) {
			valorVt.setText(String.valueOf(valorTransporte));
		}

		JComboBox<Beneficio.Transporte> boxVt = Transporte.cboxTransporte();

		JComboBox<Beneficio.Alimentacao> boxVa = Alimentacao.cboxAlimentacao();

		JComboBox<Beneficio.SeguroSaude> boxSaude = SeguroSaude.cboxSaude();

		JComboBox<Beneficio.SeguroOdontologico> boxOdonto = SeguroOdontologico.cboxOdonto();

		try {
			boxVt.setSelectedItem(b.getTransporte().getTipo());
			boxVa.setSelectedItem(b.getAlimentacao().getTipo());
			boxSaude.setSelectedItem(b.getSeguroSaude().getPlano());
			boxOdonto.setSelectedItem(b.getSeguroOdonto().getPlano());
		} catch (NullPointerException e) {

		}

		// AÇÕES

		boxVt.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				b.setTransporte((Transporte) boxVt.getSelectedItem());

			}
		});

		boxVa.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				b.setAlimentacao((Alimentacao) boxVa.getSelectedItem());

			}
		});

		boxSaude.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				b.setSeguroSaude((SeguroSaude) boxSaude.getSelectedItem());

			}
		});

		boxOdonto.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {

				b.setSeguroOdonto((SeguroOdontologico) boxOdonto.getSelectedItem());

			}
		});

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					b = new Beneficio(Double.parseDouble(valorVt.getText().substring(2)),
							(Transporte) boxVt.getSelectedItem(), (Alimentacao) boxVa.getSelectedItem(),
							(SeguroSaude) boxSaude.getSelectedItem(), (SeguroOdontologico) boxOdonto.getSelectedItem());

					CadastrarFuncionario.setBen(b);

					JOptionPane.showMessageDialog(null, "     Salvo", "", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Preencha corretamente o campo 'Valor'. Ex: R$10.50");
				}

			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				valorTransporte = 0;
				b.setTransporte(null);
				b.setAlimentacao(null);
				b.setSeguroSaude(null);
				b.setSeguroOdonto(null);
				Beneficio c = new Beneficio(valorTransporte, b.getTransporte(), b.getAlimentacao(), b.getSeguroSaude(),
						b.getSeguroOdonto());
				CadastrarFuncionario.setBen(c);
				dispose();

			}
		});

		// LAYOUT

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE).addContainerGap()));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addContainerGap()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPlanoOdontologico, Alignment.TRAILING)
												.addComponent(lblPlanoDeSade, Alignment.TRAILING)
												.addComponent(lblAlimentao, Alignment.TRAILING)
												.addComponent(lblValeTransporte, Alignment.TRAILING))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(boxOdonto, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(boxSaude, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(boxVa, 0, 142, Short.MAX_VALUE)
												.addComponent(boxVt, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(37).addComponent(lblValor).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(valorVt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addGap(183).addComponent(lblBenefcios))
								.addGroup(gl_panel.createSequentialGroup().addGap(135).addComponent(btnSalvar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancelar)))
						.addContainerGap(95, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblBenefcios).addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblValeTransporte)
								.addComponent(boxVt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblValor).addComponent(valorVt, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblAlimentao)
								.addComponent(boxVa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPlanoDeSade)
								.addComponent(boxSaude, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPlanoOdontologico)
								.addComponent(boxOdonto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(31).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvar)
								.addComponent(btnCancelar))
						.addContainerGap(44, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		setTitle("Cadastro de Beneficios");
		setModal(true);
		setResizable(false);
		setSize(500, 300);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));
	}
}