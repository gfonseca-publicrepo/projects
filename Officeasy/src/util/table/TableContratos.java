package util.table;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Contrato;
import util.Mascaras;

import javax.swing.table.AbstractTableModel;

public class TableContratos extends AbstractTableModel {
	
	/**
	 * @author Gabriel Fonseca
	 */

	private static final long serialVersionUID = 1L;

	private final List<Contrato> contrato;
	private final List<ObjectContrato> objectList;
	boolean b;
	SimpleDateFormat dateMask = new Mascaras().dateFormat();

	public TableContratos(List<Contrato> contratos) {

		this.contrato = contratos;
		objectList = new ArrayList<ObjectContrato>();
		for (int i = 0; i < contrato.size(); i++) {
			ObjectContrato o = new ObjectContrato(contrato.get(i), b);
			objectList.add(o);

		}
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return contrato.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		ObjectContrato u = objectList.get(linha);

		switch (coluna) {

		case 0:
			return u.isB();
		case 1:
			return u.getF().getNome();
		case 2:
			return u.getF().getNumero();
		case 3:
			return u.getF().getVigencia();
		case 4:
			return dateMask.format(u.getF().getData());
		case 5:
			return u.getF().getStatus();
		case 6:
			return u.getF().getAnotacoes();

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
			return "Número";
		case 3:
			return "Vigencia";
		case 4:
			return "Inicio";
		case 5:
			return "Status";
		case 6:
			return "Anotações";
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

		ObjectContrato a = objectList.get(row);
		a.setB((boolean) value);
		fireTableCellUpdated(row, col);

	}

	class ObjectContrato extends Object {

		private Contrato c;
		private boolean b;

		public ObjectContrato(Contrato c, boolean b) {

			this.c = c;
			this.b = b;
		}

		public Contrato getF() {
			return c;
		}

		public void setF(Contrato f) {
			this.c = f;
		}

		public boolean isB() {
			return b;
		}

		public void setB(boolean b) {
			this.b = b;
		}

	}

}
