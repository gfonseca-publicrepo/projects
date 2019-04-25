package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Permissoes;
import model.DAO.PermissoesDAO;

public class CadPermissoes extends JDialog {

	private static final long serialVersionUID = 1L;
	Permissoes permissoes = null;

	public CadPermissoes() {

		super();

		JLabel cboxLabel = new JLabel("Selecione um nível");
		JComboBox<Permissoes> cbox = Permissoes.cboxNiveis();
		permissoes = (Permissoes) cbox.getSelectedItem();

		cbox.setToolTipText("Selecione um nível");

		JPanel cboxPanel = new JPanel();
		cboxPanel.add(cboxLabel, BorderLayout.NORTH);
		cboxPanel.add(cbox, BorderLayout.SOUTH);

		JCheckBox chat = new JCheckBox();
		chat.setText("Chat");

		chat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chat.isSelected()) {
					permissoes.setChat(true);
				} else {
					permissoes.setChat(false);
				}

			}
		});

		chat.setToolTipText("Marque para ativar ou Desmarque para desativar");

		JCheckBox logs = new JCheckBox();
		logs.setText("Logs");

		logs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (logs.isSelected()) {
					permissoes.setLogs(true);
				} else {
					permissoes.setLogs(false);
				}

			}
		});

		logs.setToolTipText("Marque para ativar ou Desmarque para desativar");

		JCheckBox pasta = new JCheckBox();
		pasta.setText("Pastas do Sistema");

		pasta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pasta.isSelected()) {
					permissoes.setAlterarPastas(true);
				} else {
					permissoes.setAlterarPastas(false);
				}

			}
		});

		pasta.setToolTipText("Marque para ativar ou Desmarque para desativar");

		JCheckBox cadUsu = new JCheckBox();
		cadUsu.setText("Cadastro de Usuários");

		cadUsu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadUsu.isSelected()) {
					permissoes.setCadUsu(true);
				} else {
					permissoes.setCadUsu(false);
				}

			}
		});

		cadUsu.setToolTipText("Marque para ativar ou desmarque para desativar");

		JCheckBox cadFun = new JCheckBox();
		cadFun.setText("Cadastro de Funcionários");

		cadFun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadFun.isSelected()) {
					permissoes.setCadFun(true);
				} else {
					permissoes.setCadFun(false);
				}

			}
		});

		cadFun.setToolTipText("Marque para ativar ou desmarque para desativar");

		JCheckBox cadPerm = new JCheckBox();
		cadPerm.setText("Permissões de Acesso");

		if (permissoes.isCadPerm()) {
			cadPerm.setSelected(true);
		} else {
			cadPerm.setSelected(false);
		}

		cadPerm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadPerm.isSelected()) {
					permissoes.setCadPerm(true);
				} else {
					permissoes.setCadPerm(false);
				}

			}
		});

		cadPerm.setToolTipText("Marque para ativar ou desmarque para desativar");

		JCheckBox cadModelo = new JCheckBox();
		cadModelo.setText("Cadastro de Modelos");

		cadModelo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadModelo.isSelected()) {
					permissoes.setCadModelo(true);
				} else {
					permissoes.setCadModelo(false);
				}

			}
		});

		cadModelo.setToolTipText("Marque para ativar ou desmarque para desativar");

		JCheckBox cadLocal = new JCheckBox();
		cadLocal.setText("Cadastro de Locais/Endereços");

		cadLocal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadLocal.isSelected()) {
					permissoes.setCadLocal(true);
				} else {
					permissoes.setCadLocal(false);
				}

			}
		});

		cadLocal.setToolTipText("Marque para ativar ou desmarque para desativar");

		JCheckBox cadEmpresa = new JCheckBox();
		cadEmpresa.setText("Cadastro de Empresas");

		cadEmpresa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadEmpresa.isSelected()) {
					permissoes.setCadEmpresa(true);
				} else {
					permissoes.setCadEmpresa(false);
				}

			}
		});

		cadEmpresa.setToolTipText("Marque para ativar ou desmarque para desativar");

		JCheckBox cadDocumento = new JCheckBox();
		cadDocumento.setText("Cadastro de Documentos");

		cadDocumento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadDocumento.isSelected()) {
					permissoes.setCadDocumento(true);
				} else {
					permissoes.setCadDocumento(false);
				}

			}
		});

		cadDocumento.setToolTipText("Marque para ativar ou desmarque para desativar");

		JCheckBox cadEquipamento = new JCheckBox();
		cadEquipamento.setText("Cadastro de Equipamentos");

		cadEquipamento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cadEquipamento.isSelected()) {
					permissoes.setCadEquipamento(true);
				} else {
					permissoes.setCadEquipamento(false);
				}

			}
		});

		cadEquipamento.setToolTipText("Marque para ativar ou desmarque para desativar");

		JPanel cboxs = new JPanel(new GridLayout(4, 2));
		cboxs.add(chat);
		cboxs.add(logs);
		cboxs.add(pasta);
		cboxs.add(cadUsu);
		cboxs.add(cadFun);
		cboxs.add(cadPerm);
		cboxs.add(cadModelo);
		cboxs.add(cadLocal);
		cboxs.add(cadEmpresa);
		cboxs.add(cadDocumento);
		cboxs.add(cadEquipamento);

		JButton confirmar = new JButton("Salvar");
		confirmar.setSize(20, 20);
		confirmar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PermissoesDAO.modificar(permissoes);
			}

		});

		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize(20, 20);
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		// INICIANDO CHECK BOXES

		permissoes = (Permissoes) cbox.getSelectedItem();

		if (permissoes.isChat()) {
			chat.setSelected(true);
		} else {
			chat.setSelected(false);
		}
		if (permissoes.isLogs()) {
			logs.setSelected(true);
		} else {
			logs.setSelected(true);
		}
		if (permissoes.isAlterarPastas()) {
			pasta.setSelected(true);
		} else {
			pasta.setSelected(false);
		}
		if (permissoes.isCadUsu()) {
			cadUsu.setSelected(true);
		} else {
			cadUsu.setSelected(false);
		}
		if (permissoes.isCadFun()) {
			cadFun.setSelected(true);
		} else {
			cadFun.setSelected(false);
		}
		if (permissoes.isCadPerm()) {
			cadPerm.setSelected(true);
		} else {
			cadPerm.setSelected(false);
		}
		if (permissoes.isCadModelo()) {
			cadModelo.setSelected(true);
		} else {
			cadModelo.setSelected(false);
		}
		if (permissoes.isCadLocal()) {
			cadLocal.setSelected(true);
		} else {
			cadLocal.setSelected(false);
		}
		if (permissoes.isCadEmpresa()) {
			cadEmpresa.setSelected(true);
		} else {
			cadEmpresa.setSelected(false);
		}
		if (permissoes.isCadDocumento()) {
			cadDocumento.setSelected(true);
		} else {
			cadDocumento.setSelected(false);
		}
		if (permissoes.isCadEquipamento()) {
			cadEquipamento.setSelected(true);
		} else {
			cadEquipamento.setSelected(false);
		}

		cbox.addItemListener(new ItemListener() { // MONITOR DAS COMBO BOX
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				permissoes = (Permissoes) cbox.getSelectedItem(); // OBTENDO ITEM SELECIONADO NA COMBO BOX

				if (permissoes.isChat()) { // DEFINE AS CHECK BOX DE ACORDO COM O ITEM SELECIONADO NA COMBO BOX
					chat.setSelected(true);
				} else {
					chat.setSelected(false);
				}
				if (permissoes.isLogs()) {
					logs.setSelected(true);
				} else {
					logs.setSelected(true);
				}
				if (permissoes.isAlterarPastas()) {
					pasta.setSelected(true);
				} else {
					pasta.setSelected(false);
				}
				if (permissoes.isCadUsu()) {
					cadUsu.setSelected(true);
				} else {
					cadUsu.setSelected(false);
				}
				if (permissoes.isCadFun()) {
					cadFun.setSelected(true);
				} else {
					cadFun.setSelected(false);
				}
				if (permissoes.isCadPerm()) {
					cadPerm.setSelected(true);
				} else {
					cadPerm.setSelected(false);
				}
				if (permissoes.isCadModelo()) {
					cadModelo.setSelected(true);
				} else {
					cadModelo.setSelected(false);
				}
				if (permissoes.isCadLocal()) {
					cadLocal.setSelected(true);
				} else {
					cadLocal.setSelected(false);
				}
				if (permissoes.isCadEmpresa()) {
					cadEmpresa.setSelected(true);
				} else {
					cadEmpresa.setSelected(false);
				}
				if (permissoes.isCadDocumento()) {
					cadDocumento.setSelected(true);
				} else {
					cadDocumento.setSelected(false);
				}
				if (permissoes.isCadEquipamento()) {
					cadEquipamento.setSelected(true);
				} else {
					cadEquipamento.setSelected(false);
				}
			}
		});

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(confirmar, BorderLayout.WEST);
		buttonsPanel.add(cancelar, BorderLayout.EAST);

		add(cboxPanel, BorderLayout.NORTH);
		add(cboxs, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);

		setTitle("Cadastro de Permissões");
		setModal(true);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/icon.png")));

	}

}
