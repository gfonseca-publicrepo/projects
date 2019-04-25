package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import model.DadosFun;
import util.Conexao;
import util.MySQL;

public class DadosFunDAO {

	@SuppressWarnings("deprecation")
	public static void novo(Date dtAdmissao, double salario, int cargaH, Date dtNascimento, String estadoCivil,
			String sexo, String telefone, String celular, String email, int fkMatricula) {

		try {

			String sql = "insert into dadosfun (dtAdmissao, salario, estadoCivil, dtNascimento, cargaH, sexo, telefone, celular, email, FKMatricula) values (?,?,?,?,?,?,?,?,?,?)";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			java.sql.Date d1 = new java.sql.Date(dtAdmissao.getDate());
			java.sql.Date d2 = new java.sql.Date(dtNascimento.getDate());

			comando.setDate(1, d1);
			comando.setDouble(2, salario);
			comando.setString(3, estadoCivil);
			comando.setDate(4, d2);
			comando.setInt(5, cargaH);
			comando.setString(6, sexo);
			comando.setString(7, telefone);
			comando.setString(8, celular);
			comando.setString(9, email);
			comando.setInt(10, fkMatricula);

			comando.executeUpdate();

			comando.close();
			con.close();

			JOptionPane.showMessageDialog(null, "DadosFun Salvo", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

	}

	public static DadosFun selecionar(int fkMatricula) {

		DadosFun df = null;

		try {

			String sql = "select * from dadosfun where FKMatricula = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fkMatricula);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				df = new DadosFun(rs.getInt("id"), rs.getDate("dtAdmissao"), rs.getDate("dtDesligamento"),
						rs.getDouble("salario"), rs.getInt("cargaH"), rs.getDate("dtNascimento"),
						rs.getString("estadoCivil"), rs.getString("sexo"), rs.getString("telefone"),
						rs.getString("celular"), rs.getString("email"), rs.getInt("FKMatricula"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return df;

	}
}
