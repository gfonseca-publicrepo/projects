package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Dependente;
import javax.swing.table.AbstractTableModel;

public class TableDependente extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private final List<Dependente> dependente;
	private final List<ObjectDependente> objectList;
	boolean b = false;

	SimpleDateFormat dateFormat = new Mascaras().dateFormat();

	public TableDependente(List<Dependente> dependentes) {

		this.dependente = dependentes;
		objectList = new ArrayList<ObjectDependente>();
		for (int i = 0; i < dependente.size(); i++) {
			ObjectDependente o = new ObjectDependente(dependente.get(i), b);
			objectList.add(o);

		}
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return dependente.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		ObjectDependente u = objectList.get(linha);

		switch (coluna) {

		case 0:
			return u.isB();
		case 1:
			return u.getF().getNome();
		case 2:
			return dateFormat.format(u.getF().getNascimento());
		case 3:
			return u.getF().getGrau();
		case 4:
			return u.getF().getCpf();
		case 5:
			return u.getF().getRg();

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
			return "Nome";
		case 2:
			return "Nascimento";
		case 3:
			return "Grau";
		case 4:
			return "CPF";
		case 5:
			return "RG";
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

		ObjectDependente a = objectList.get(row);
		a.setB((boolean) value);
		fireTableCellUpdated(row, col);

	}

	class ObjectDependente extends Object {

		private Dependente d;
		private boolean b;

		public ObjectDependente(Dependente d, boolean b) {

			this.d = d;
			this.b = b;
		}

		public Dependente getF() {
			return d;
		}

		public void setF(Dependente f) {
			this.d = f;
		}

		public boolean isB() {
			return b;
		}

		public void setB(boolean b) {
			this.b = b;
		}

	}

}
