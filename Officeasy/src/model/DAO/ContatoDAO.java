package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Contato;
import model.Contato.CategoriaCT;
import util.ConexaoBD;
import util.MySQL;

public class ContatoDAO {

	static Contato cont;
	static CategoriaCT cat;

	public static List<Contato> listarContatos() {

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			String sql = "select * from contato";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				CategoriaCT ct = CategoriaCTDAO.selecionarCategoria(rs.getInt("FKCategoriaCt"));

				cont = new Contato(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"),
						rs.getString("celular"), rs.getString("email"), rs.getString("descricao"), ct);

				contatos.add(cont);
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return contatos;

	}

	public static class CategoriaCTDAO {

		public static List<CategoriaCT> listarCategoriasCT() {

			List<CategoriaCT> categoria = new ArrayList<CategoriaCT>();

			try {

				String sql = "select * from categoriact";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				ResultSet rs = comando.executeQuery();
				while (rs.next()) {

					cat = new CategoriaCT(rs.getInt("id"), rs.getString("categoria"));

					categoria.add(cat);
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return categoria;
		}

		public static CategoriaCT selecionarCategoria(int id) {

			try {

				String sql = "select * from categoriact where id = ?";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, id);

				ResultSet rs = comando.executeQuery();
				while (rs.next()) {

					cat = new CategoriaCT(rs.getInt("id"), rs.getString("categoria"));

				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return cat;

		}

	}

}
