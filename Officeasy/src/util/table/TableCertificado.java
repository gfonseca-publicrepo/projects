package util.table;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Certificado;
import util.Mascaras;

import javax.swing.table.AbstractTableModel;

public class TableCertificado extends AbstractTableModel {
	
	/**
	 * @author Gabriel Fonseca
	 */

	private static final long serialVersionUID = 1L;

	private final List<Certificado> certificado;
	private final List<ObjectCertificado> objectList;
	boolean b;

	SimpleDateFormat dateMask = new Mascaras().dateFormat();

	public TableCertificado(List<Certificado> certificados) {

		this.certificado = certificados;
		objectList = new ArrayList<ObjectCertificado>();
		for (int i = 0; i < certificado.size(); i++) {
			ObjectCertificado o = new ObjectCertificado(certificado.get(i), b);
			objectList.add(o);

		}
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return certificado.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		ObjectCertificado u = objectList.get(linha);

		switch (coluna) {

		case 0:
			return u.isB();
		case 1:
			return u.getF().getNomeCertificado();
		case 2:
			return u.getF().getInstituicao();
		case 3:
			return dateMask.format(u.getF().getEmissao());
		case 4:
			return dateMask.format(u.getF().getValidade());
		case 5:
			return u.getF().getDescricao();

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
			return "Certificado";
		case 2:
			return "Instituição";
		case 3:
			return "Emissão";
		case 4:
			return "Validade";
		case 5:
			return "Descrição";
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

		ObjectCertificado a = objectList.get(row);
		a.setB((boolean) value);
		fireTableCellUpdated(row, col);

	}

	class ObjectCertificado extends Object {

		private Certificado c;
		private boolean b;

		public ObjectCertificado(Certificado c, boolean b) {

			this.c = c;
			this.b = b;
		}

		public Certificado getF() {
			return c;
		}

		public void setF(Certificado f) {
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
