package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Permissoes;
import util.Conexao;
import util.MySQL;

public class PermissoesDAO extends MySQL {

	static Permissoes perm;

	public static List<Permissoes> carregarNiveis() {

		List<Permissoes> niveis = new ArrayList<Permissoes>();

		try {

			String sql = "select * from permissoes";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();
			while (rs.next()) {
				perm = new Permissoes(rs.getInt("id"), rs.getString("nome"), rs.getBoolean("chat"),
						rs.getBoolean("logs"), rs.getBoolean("alterarPasta"), rs.getBoolean("cadUsu"),
						rs.getBoolean("cadFun"), rs.getBoolean("cadPerm"), rs.getBoolean("cadModelo"),
						rs.getBoolean("cadLocal"), rs.getBoolean("cadEmpresa"), rs.getBoolean("cadDocumento"),
						rs.getBoolean("cadEquipamento"));

				niveis.add(perm);
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return niveis;

	}

	public static void modificar(Permissoes nivel) {

		try {

			String sql = "UPDATE permissoes SET nome = ?, chat = ?, logs = ?, alterarPasta = ?, cadUsu = ?, cadFun = ?, cadPerm = ?, cadModelo = ?, cadLocal = ?, cadEmpresa = ?, cadDocumento = ?, cadEquipamento = ? where id = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, nivel.getNome());
			comando.setBoolean(2, nivel.isChat());
			comando.setBoolean(3, nivel.isLogs());
			comando.setBoolean(4, nivel.isAlterarPastas());
			comando.setBoolean(5, nivel.isCadUsu());
			comando.setBoolean(6, nivel.isCadFun());
			comando.setBoolean(7, nivel.isCadPerm());
			comando.setBoolean(8, nivel.isCadModelo());
			comando.setBoolean(9, nivel.isCadLocal());
			comando.setBoolean(10, nivel.isCadEmpresa());
			comando.setBoolean(11, nivel.isCadDocumento());
			comando.setBoolean(12, nivel.isCadEquipamento());

			comando.setInt(13, nivel.getId());

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		JOptionPane.showMessageDialog(null, MySQL.getMSG());

	}

	public static Permissoes selecionar(int id) {

		try {

			String sql = "select * from permissoes where id = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, id);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				perm = new Permissoes(rs.getInt("id"), rs.getString("nome"), rs.getBoolean("chat"),
						rs.getBoolean("logs"), rs.getBoolean("alterarPasta"), rs.getBoolean("cadUsu"),
						rs.getBoolean("cadFun"), rs.getBoolean("cadPerm"), rs.getBoolean("cadModelo"),
						rs.getBoolean("cadLocal"), rs.getBoolean("cadEmpresa"), rs.getBoolean("cadDocumento"),
						rs.getBoolean("cadEquipamento"));
			}

			rs.close();
			comando.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}

		return perm;
	}

	public static void excluir(int id) {

		try {

			String sql = "delete from permissoes where id = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, id);

			comando.executeQuery();

			comando.close();

			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		JOptionPane.showMessageDialog(null, MySQL.getMSG());

	}

	public static void inserir(String nome, boolean chat, boolean logs, boolean alterarPastas, boolean cadUsu,
			boolean cadFun, boolean cadPerm, boolean cadModelo, boolean cadLocal, boolean cadEmpresa,
			boolean cadDocumento, boolean cadEquipamento) {

		try {

			String sql = "insert into permissoes values (null,'?','?','?','?','?','?','?','?','?','?','?','?'";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, nome);
			comando.setBoolean(2, chat);
			comando.setBoolean(3, logs);
			comando.setBoolean(4, alterarPastas);
			comando.setBoolean(5, cadUsu);
			comando.setBoolean(6, cadFun);
			comando.setBoolean(7, cadPerm);
			comando.setBoolean(8, cadModelo);
			comando.setBoolean(9, cadLocal);
			comando.setBoolean(10, cadEmpresa);
			comando.setBoolean(11, cadDocumento);
			comando.setBoolean(12, cadEquipamento);

			comando.executeQuery();

			comando.close();

			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		JOptionPane.showMessageDialog(null, MySQL.getMSG());

	}

}
