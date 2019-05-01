package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Endereco;
import util.ConexaoBD;
import util.MySQL;

public class EnderecoDAO {

	public static void novoEndFun(String logradouro, String numero, String complemento, String bairro, String cidade,
			String estado, String cep, int fkMatricula) {

		try {

			String sql = "insert into endfun (logradouro, numero, complemento, bairro, cidade, estado, cep, FKFuncionario) values (?,?,?,?,?,?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, logradouro);
			comando.setString(2, numero);
			comando.setString(3, complemento);
			comando.setString(4, bairro);
			comando.setString(5, cidade);
			comando.setString(6, estado);
			comando.setString(7, cep);
			comando.setInt(8, fkMatricula);

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

	}

	public static Endereco selecionarEndFun(int fkMatricula) {

		Endereco e = null;

		try {

			String sql = "select * from endFun where FKFuncionario = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fkMatricula);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				e = new Endereco(rs.getInt("id"), rs.getString("logradouro"), rs.getString("numero"),
						rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"),
						rs.getString("estado"), rs.getString("cep"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}

		return e;
	}

}
