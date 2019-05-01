package util.table;

import java.util.ArrayList;
import java.util.List;
import model.Contato;

import javax.swing.table.AbstractTableModel;

public class TableContatos extends AbstractTableModel {
	
	/**
	 * @author Gabriel Fonseca
	 */

	private static final long serialVersionUID = 1L;

	private final List<Contato> contato;
	private final List<ObjectContato> objectList;
	boolean b;

	public TableContatos(List<Contato> contatos) {

		this.contato = contatos;
		objectList = new ArrayList<ObjectContato>();
		for (int i = 0; i < contato.size(); i++) {
			ObjectContato o = new ObjectContato(contato.get(i), b);
			objectList.add(o);

		}
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return contato.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		ObjectContato u = objectList.get(linha);

		switch (coluna) {

		case 0:
			return u.isB();
		case 1:
			return u.getF().getNome();
		case 2:
			return u.getF().getTelefone();
		case 3:
			return u.getF().getCelular();
		case 4:
			return u.getF().getEmail();
		case 5:
			return u.getF().getDescricao();
		case 6:
			return u.getF().getCategoria().getCategoria();

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
			return "Telefone";
		case 3:
			return "Celular";
		case 4:
			return "E-Mail";
		case 5:
			return "Descrição";
		case 6:
			return "Categoria";
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

		ObjectContato a = objectList.get(row);
		a.setB((boolean) value);
		fireTableCellUpdated(row, col);

	}

	class ObjectContato extends Object {

		private Contato c;
		private boolean b;

		public ObjectContato(Contato c, boolean b) {

			this.c = c;
			this.b = b;
		}

		public Contato getF() {
			return c;
		}

		public void setF(Contato f) {
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
