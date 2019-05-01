package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Local;
import util.ConexaoBD;
import util.MySQL;

public class LocalDAO extends MySQL {

	static Local local = null;

	public static Local selecionar(int fk) {

		try {

			String sql = "select * from local where id = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				local = new Local(rs.getInt("id"), rs.getString("nomeLocal"), rs.getString("descricao"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return local;

	}

	public static List<Local> carregarNiveis() {

		List<Local> locais = new ArrayList<Local>();

		try {

			String sql = "select * from local";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				local = new Local(rs.getInt("id"), rs.getString("nomeLocal"), rs.getString("descricao"));

				locais.add(local);
			}
			
			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return locais;

	}

}
