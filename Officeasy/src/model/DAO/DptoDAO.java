package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Dpto;
import util.ConexaoBD;
import util.MySQL;

public class DptoDAO extends MySQL {

	public static List<Dpto> listarAtivos() {
		List<Dpto> lista = new ArrayList<Dpto>();

		Dpto d;

		try {

			String sql = "select * from dpto";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				d = new Dpto(rs.getInt("id"), rs.getString("nome"), rs.getString("assunto"));

				lista.add(d);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return lista;
	}

	public static void inserirDpto(String nome, String assunto) {
		try {

			String sql = "insert into dpto values (?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, null);
			comando.setString(2, nome);
			comando.setString(3, assunto);
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public static boolean isRegistro(String nome) {
		boolean result = false;
		Dpto d = null;

		try {
			String sql = "select * from dpto where nome = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, nome);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				d = new Dpto(rs.getInt("id"), rs.getString("nome"), rs.getString("assunto"));

			}
			if (d.getNome().equals(nome)) {

				result = true;
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static Dpto encontrarId(String nome) {

		Dpto d = null;

		try {
			String sql = "select * from dpto where nome = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, nome);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				d = new Dpto(rs.getInt("id"), rs.getString("nome"), rs.getString("assunto"));

			}
			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return d;
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
