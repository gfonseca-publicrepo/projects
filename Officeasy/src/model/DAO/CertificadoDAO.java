package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Certificado;
import util.Conexao;
import util.MySQL;

public class CertificadoDAO {

	@SuppressWarnings("deprecation")
	public static void inserirCertificados(List<Certificado> list, int fkMatricula) {

		Certificado c = null;

		try {

			String sql = "insert into certificado (titulo, dtEmissao, instituicao, descricao, validade, FKDocFun) values (?,?,?,?,?,?)";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			int m = DocFunDAO.selecionarFK(fkMatricula);

			for (int i = 0; i < list.size(); i++) {

				if (i <= list.size()) {

					c = list.get(i);

				}

				java.sql.Date d1 = new java.sql.Date(c.getEmissao().getDate());
				java.sql.Date d2 = new java.sql.Date(c.getValidade().getDate());

				comando.setString(1, c.getNomeCertificado());
				comando.setDate(2, d1);
				comando.setString(3, c.getInstituicao());
				comando.setString(4, c.getDescricao());
				comando.setDate(5, d2);
				comando.setInt(6, m);

				comando.executeUpdate();

				comando.close();
				con.close();

			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

	}

	public static List<Certificado> trazerCertificados(int fkDocFun) {
		List<Certificado> listC = new ArrayList<>();

		try {

			String sql = "select * from certificado where FKDocFun = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fkDocFun);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				Certificado c = new Certificado(rs.getInt("id"), rs.getString("titulo"), rs.getDate("dtEmissao"),
						rs.getString("instituicao"), rs.getString("descricao"), rs.getDate("validade"));

				listC.add(c);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return listC;

	}

}
