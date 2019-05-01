package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Modelo;
import util.ConexaoBD;
import util.MySQL;

public class ModeloDAO extends MySQL {

	public static List<Modelo> listarAtivos() {
		List<Modelo> lista = new ArrayList<Modelo>();

		Modelo modelo;

		try {

			String sql = "select * from modelo";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				modelo = new Modelo(rs.getInt("id"), rs.getString("titulo"), rs.getString("caminho"));

				lista.add(modelo);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return lista;
	}

	public static void inserirModelo(String titulo, String caminho, int fkTipoDoc) {
		try {

			String sql = "insert into modelo values (?,?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, null);
			comando.setString(2, caminho);
			comando.setString(3, titulo);
			comando.setInt(4, fkTipoDoc);
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	public static void deleteModelo(int id) {
		try {

			String sql = "delete from modelo where id = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, id);
			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
	}

}
