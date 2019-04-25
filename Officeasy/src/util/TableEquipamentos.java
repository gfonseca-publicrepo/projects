package util;

import java.util.ArrayList;
import java.util.List;
import model.Equipamento;

import javax.swing.table.AbstractTableModel;

public class TableEquipamentos extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private final List<Equipamento> equipamento;
	private final List<ObjectEquipamento> objectList;
	boolean b;

	public TableEquipamentos(List<Equipamento> equipamentos) {

		this.equipamento = equipamentos;
		objectList = new ArrayList<ObjectEquipamento>();
		for (int i = 0; i < equipamento.size(); i++) {
			ObjectEquipamento o = new ObjectEquipamento(equipamento.get(i), b);
			objectList.add(o);

		}
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return equipamento.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		ObjectEquipamento u = objectList.get(linha);

		switch (coluna) {

		case 0:
			return u.isB();
		case 1:
			return u.getF().getNome();
		case 2:
			return u.getF().getMarca();
		case 3:
			return u.getF().getModelo();
		case 4:
			return u.getF().getVlCompra();
		case 5:
			return u.getF().getDescricao();
		case 6:
			return u.getF().getResponsavel();

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
			return "Marca";
		case 3:
			return "Modelo";
		case 4:
			return "Responsável";
		case 5:
			return "Local";
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

		ObjectEquipamento a = objectList.get(row);
		a.setB((boolean) value);
		fireTableCellUpdated(row, col);

	}

	class ObjectEquipamento extends Object {

		private Equipamento c;
		private boolean b;

		public ObjectEquipamento(Equipamento c, boolean b) {

			this.c = c;
			this.b = b;
		}

		public Equipamento getF() {
			return c;
		}

		public void setF(Equipamento f) {
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
