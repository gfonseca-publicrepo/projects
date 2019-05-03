package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Dependente;
import util.ConexaoBD;
import util.LimpaString;
import util.MySQL;

public class DependenteDAO {

	public static void novo(String nome, String rg, String cpf, Date nascimento, String grau, int fkMatricula) {

		try {

			String sql = "insert into dependente values null,?,?,?,?,?,?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, rg);
			comando.setString(2, cpf);
			comando.setString(3, nome);
			comando.setDate(4, (java.sql.Date) nascimento);
			comando.setString(5, grau);
			comando.setInt(6, fkMatricula);

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

	}

	@SuppressWarnings("deprecation")
	public static void novaLista(List<Dependente> list, int fkMatricula) {

		try {

			String sql = "insert into dependente (rg, cpf, nome, dtNascimento, parentesco, FKFuncionario) values (?,?,?,?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			for (int i = 0; i < list.size(); i++) {

				Dependente d = list.get(i);

				java.sql.Date d1 = new java.sql.Date(d.getNascimento().getDate());

				comando.setString(1, LimpaString.limpaDoc(d.getRg()));
				comando.setString(2, LimpaString.limpaDoc(d.getCpf()));
				comando.setString(3, d.getNome());
				comando.setDate(4, d1);
				comando.setString(5, d.getGrau());
				comando.setInt(6, fkMatricula);

				comando.executeUpdate();

				comando.close();
				con.close();
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();

		}

	}

	public static List<Dependente> selecionarDependentes(int fkMatricula) {
		List<Dependente> listD = new ArrayList<>();

		try {

			String sql = "select * from dependente where FKFuncionario = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fkMatricula);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				Dependente d = new Dependente(rs.getInt("id"), rs.getString("nome"), rs.getString("rg"),
						rs.getString("cpf"), rs.getDate("dtNascimento"), rs.getString("parentesco"));
				listD.add(d);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return listD;

	}
}
