package util;

import java.text.SimpleDateFormat;
import java.util.List;
import model.Modelo;
import model.TipoDoc;

import javax.swing.table.AbstractTableModel;

public class TableModelo extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat m = new Mascaras().dateFormat();

	private final List<Modelo> modelo;
	private final List<TipoDoc> tipo;

	public TableModelo(List<Modelo> modelo, List<TipoDoc> tipo) {

		this.modelo = modelo;
		this.tipo = tipo;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return modelo.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Modelo u = modelo.get(linha);
		TipoDoc t = tipo.get(linha);

		switch (coluna) {

		case 0:
			return u.getTitulo();
		case 1:
			return t.getTipo();
		case 2:
			return u.getCaminho();

		default:
			break;
		}

		return null;
	}

	public String getColumnName(int column) {

		switch (column) {

		case 0:
			return "Título";
		case 1:
			return "Tipo";
		case 2:
			return "Caminho";

		default:
			return "";
		}
	}

}
