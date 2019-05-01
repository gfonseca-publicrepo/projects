package util.table;

import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import javax.swing.table.AbstractTableModel;

public class TableFuncionario extends AbstractTableModel {
	
	/**
	 * @author Gabriel Fonseca
	 */

	private static final long serialVersionUID = 1L;
	private final List<Funcionario> funcionario;
	private final List<ObjectFuncionario> objectList;
	boolean b;

	public TableFuncionario(List<Funcionario> funcionarios) {

		this.funcionario = funcionarios;
		objectList = new ArrayList<ObjectFuncionario>();
		for (int i = 0; i < funcionario.size(); i++) {
			ObjectFuncionario g = new ObjectFuncionario(funcionario.get(i), b);
			objectList.add(g);

		}

	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return funcionario.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		ObjectFuncionario f = objectList.get(linha);

		switch (coluna) {

		case 0:
			return f.isB();
		case 1:
			return f.getF().getMatricula();
		case 2:
			return f.getF().getNome();
		case 3:
			return f.getF().getCargo();
		case 4:
			if (f.getF().isSituacao() == true) {
				return "Ativo";
			} else {
				return "Desligado";
			}
		case 5:
			try {
				return f.getF().getContrato().getNome();
			} catch (NullPointerException e) {
				return null;
			}
		case 6:
			try {
				return f.getF().getLocal().getNome();
			} catch (NullPointerException e) {
				return null;
			}

		default:
			break;
		}

		return null;
	}

	public String getColumnName(int column) {

		switch (column) {

		case 0:
			return "Sel";
		case 1:
			return "Matricula";
		case 2:
			return "Nome";
		case 3:
			return "Cargo";
		case 4:
			return "Situacao";
		case 5:
			return "Contrato";
		case 6:
			return "Local de Trabalho";
		default:
			return "";
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 0) {
			return Boolean.class;
		} else {
			return String.class;
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		if (col == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {

		ObjectFuncionario a = objectList.get(row);
		a.setB((boolean) value);
		fireTableCellUpdated(row, col);

	}

	class ObjectFuncionario extends Object {

		private Funcionario f;
		private boolean b;

		public ObjectFuncionario(Funcionario f, boolean b) {

			this.f = f;
			this.b = b;
		}

		public Funcionario getF() {
			return f;
		}

		public void setF(Funcionario f) {
			this.f = f;
		}

		public boolean isB() {
			return b;
		}

		public void setB(boolean b) {
			this.b = b;
		}

	}

	public int pegarMatricula(int row) {

		int matricula = objectList.get(row).getF().getMatricula();

		return matricula;
	}

}
