package util.table;

import java.util.List;
import model.Funcionario;

import javax.swing.table.AbstractTableModel;

public class TableUsuario extends AbstractTableModel {
	
	/**
	 * @author Gabriel Fonseca
	 */

	private static final long serialVersionUID = 1L;
	private final List<Funcionario> usuario;
	boolean b;

	public TableUsuario(List<Funcionario> usuarios) {

		this.usuario = usuarios;

	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return usuario.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Funcionario u = usuario.get(linha);

		switch (coluna) {

		case 0:
			return u.getLogin();
		case 1:
			return u.getNivel();
		case 2:
			return u.getStatus();
		case 3:
			return u.isLogado();

		default:
			break;
		}

		return null;
	}

	public String getColumnName(int column) {

		switch (column) {

		case 0:
			return "Login";
		case 1:
			return "Nível";
		case 2:
			return "Status";
		case 3:
			return "Logado";
		default:
			return "";
		}
	}

}
