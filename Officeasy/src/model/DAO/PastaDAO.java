package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pasta;
import util.ConexaoBD;
import util.MySQL;

public class PastaDAO extends MySQL {

	public static List<Pasta> listarAtivos() {
		List<Pasta> lista = new ArrayList<Pasta>();

		Pasta p;

		try {

			String sql = "select * from pasta";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				p = new Pasta(rs.getInt("id"), rs.getString("nome"), rs.getString("caminho"), rs.getString("assunto"),
						rs.getInt("fkdpto"));

				lista.add(p);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return lista;
	}

	public static List<Pasta> listarPastasComId(int id) {
		List<Pasta> pastas = new ArrayList<Pasta>();
		Pasta pasta;

		try {

			String sql = "select * from pasta where FKDpto = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				pasta = new Pasta(rs.getInt("id"), rs.getString("nome"), rs.getString("caminho"),
						rs.getString("assunto"), rs.getInt("fkdpto"));

				pastas.add(pasta);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return pastas;
	}

	public static boolean isRegistro(int fkdpto, String nome) {
		boolean result = false;
		Pasta d = null;

		try {
			String sql = "select * from pasta where nome = ? and fkdpto = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, nome);
			comando.setInt(2, fkdpto);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				d = new Pasta(rs.getInt("id"), rs.getString("nome"), rs.getString("caminho"),
						rs.getString("assunto"), rs.getInt("fkdpto"));
				System.out.println(d);

			}
			if (d.getNomePast().equals(nome) && d.getFkdpto() == fkdpto) {

				result = true;
				
			}
			System.out.println(result);
			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static void inserirPasta(String nomePasta, String caminho, String assunto, int fkId) {
		try {

			String sql = "insert into pasta values (?,?,?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, null);
			comando.setString(2, nomePasta);
			comando.setString(3, assunto);
			comando.setString(4, caminho);
			comando.setInt(5, fkId);
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
	}

//	public static void deleteModelo(int id) {
//		try {
//
//			String sql = "delete from modelo where id = ?";
//
//			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());
//
//			Connection con = conex.obterConexao();
//
//			PreparedStatement comando = con.prepareStatement(sql);
//
//			comando.setInt(1, id);
//			comando.executeUpdate();
//
//			comando.close();
//			con.close();
//
//		} catch (Exception e) {
//
//			JOptionPane.showMessageDialog(null, e.getMessage());
//			System.out.println(e.getMessage());
//		}
//	}

}
