package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.TipoDoc;
import util.Conexao;
import util.MySQL;

public class TipoDocDAO extends MySQL {

	public static void inserirTipoDoc(String tipo) {
		try {

			String sql = "insert into tipodoc values (?,?)";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, null);
			comando.setString(2, tipo);
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public static List<TipoDoc> listarTipoDoc() {
		List<TipoDoc> lista = new ArrayList<TipoDoc>();

		TipoDoc tipoDoc;
		try {

			String sql = "select * from tipodoc";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				tipoDoc = new TipoDoc(rs.getInt("id"), rs.getString("tipo"));

				lista.add(tipoDoc);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}

		return lista;

	}

	public static TipoDoc encontrarTipoDoc(String tipo) {

		TipoDoc tipoDoc = null;
		try {

			String sql = "select * from tipodoc where tipo = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, tipo);
			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				tipoDoc = new TipoDoc(rs.getInt("id"), tipo);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return tipoDoc;

	}

}
