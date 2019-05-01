package util.table;

import java.text.SimpleDateFormat;
import java.util.List;
import model.Documento;
import model.TipoDoc;
import util.Mascaras;

import javax.swing.table.AbstractTableModel;

public class TableDocumento extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat m = new Mascaras().dateFormat();

	private final List<Documento> doc;
	private final List<TipoDoc> tipo;

	public TableDocumento(List<Documento> doc, List<TipoDoc> tipo) {

		this.doc = doc;
		this.tipo = tipo;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return doc.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Documento u = doc.get(linha);
		TipoDoc t = tipo.get(linha);

		switch (coluna) {

		case 0:
			return u.getTitulo();
		case 1:
			return u.getAutor();
		case 2:
			return u.getAssunto();
		case 3:
			return t.getTipo();
		case 4:
			return u.getCaminho();

		default:
			break;
		}

		return null;
	}

	public String getColumnName(int column) {

		switch (column) {

		case 0:
			return "T�tulo";
		case 1:
			return "Autor";
		case 2:
			return "Assunto";
		case 3:
			return "Tipo";
		case 4:
			return "Caminho";
		default:
			return "";
		}
	}

}
