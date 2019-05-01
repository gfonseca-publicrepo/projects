package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Beneficio;
import model.Beneficio.Alimentacao;
import model.Beneficio.SeguroOdontologico;
import model.Beneficio.SeguroSaude;
import model.Beneficio.Transporte;
import util.ConexaoBD;
import util.MySQL;

public class BeneficioDAO {

	public static class TransporteDAO {

		public static List<Transporte> carregarBox() {

			List<Transporte> transportes = new ArrayList<Transporte>();

			try {

				String sql = "select * from tipotransporte";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {
					Transporte trans = new Transporte(rs.getInt("id"), rs.getString("tipo"));

					transportes.add(trans);
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return transportes;

		}

		public static Transporte selecionar(int id) {
			Transporte t = null;

			try {

				String sql = "select * from tipotransporte where id = ?";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, id);

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {

					t = new Transporte(rs.getInt("id"), rs.getString("tipo"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}

			return t;
		}

	}

	public static class AlimentacaoDAO {

		public static List<Alimentacao> carregarBox() {

			List<Alimentacao> listA = new ArrayList<Alimentacao>();

			try {

				String sql = "select * from tiporefeicao";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {
					Alimentacao a = new Alimentacao(rs.getInt("id"), rs.getString("tipo"), rs.getDouble("valor"));

					listA.add(a);
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return listA;

		}

		public static Alimentacao selecionar(int id) {
			Alimentacao a = null;

			try {

				String sql = "select * from tiporefeicao where id = ?";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, id);

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {

					a = new Alimentacao(rs.getInt("id"), rs.getString("tipo"), rs.getDouble("valor"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}

			return a;
		}

	}

	public static class SeguroSaudeDAO {

		public static List<SeguroSaude> carregarBox() {

			List<SeguroSaude> list = new ArrayList<SeguroSaude>();

			try {

				String sql = "select * from planosaude";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {
					SeguroSaude a = new SeguroSaude(rs.getInt("id"), rs.getString("plano"), rs.getDouble("valor"));

					list.add(a);
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return list;

		}

		public static SeguroSaude selecionar(int id) {
			SeguroSaude ss = null;

			try {

				String sql = "select * from planosaude where id = ?";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, id);

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {
					ss = new SeguroSaude(rs.getInt("id"), rs.getString("plano"), rs.getDouble("valor"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}

			return ss;
		}

	}

	public static class SeguroOdontologicoDAO {

		public static List<SeguroOdontologico> carregarBox() {

			List<SeguroOdontologico> list = new ArrayList<SeguroOdontologico>();

			try {

				String sql = "select * from planoodonto";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				ResultSet rs = comando.executeQuery();

				while (rs.next()) {
					SeguroOdontologico a = new SeguroOdontologico(rs.getInt("id"), rs.getString("plano"),
							rs.getDouble("valor"));

					list.add(a);
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage());
			}

			return list;

		}

		public static SeguroOdontologico selecionar(int id) {
			SeguroOdontologico so = null;

			try {

				String sql = "select * from planoodonto where id = ?";

				ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

				Connection con = conex.obterConexao();

				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, id);

				ResultSet rs = comando.executeQuery();

				if (rs.next()) {
					so = new SeguroOdontologico(rs.getInt("id"), rs.getString("plano"), rs.getDouble("valor"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}

			return so;
		}

	}

	public static void inserirBeneficio(double vtValor, int fkVR, int fkVT, int pO, int pS, int fkFuncionario) {
		try {

			String sql = "insert into beneficios (vtValor, FKTipoRefeicao, FKTipoTransporte, FKPlanoOdonto, FKPlanoSaude, FKFuncionario) values (?,?,?,?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setDouble(1, vtValor);
			comando.setInt(2, fkVR);
			comando.setInt(3, fkVT);
			comando.setInt(4, pO);
			comando.setInt(5, pS);
			comando.setInt(6, fkFuncionario);

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

	}

	public static Beneficio selecionar(int fkMatricula) {

		Beneficio b = null;

		try {

			String sql = "select * from beneficios where FKFuncionario = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fkMatricula);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				b = new Beneficio(rs.getInt("id"), rs.getDouble("vtValor"),
						TransporteDAO.selecionar(rs.getInt("FKTipoTransporte")),
						AlimentacaoDAO.selecionar(rs.getInt("FKTipoRefeicao")),
						SeguroSaudeDAO.selecionar(rs.getInt("FKPlanoSaude")),
						SeguroOdontologicoDAO.selecionar(rs.getInt("FKPlanoOdonto")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

		return b;
	}

}
