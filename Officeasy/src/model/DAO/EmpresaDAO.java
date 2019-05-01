package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Empresa;
import util.ConexaoBD;
import util.MySQL;

public class EmpresaDAO extends MySQL {

	static Empresa empresa = null;

	public static Empresa selecionar(int fk) {

		try {

			String sql = "select * from empresa where id = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				empresa = new Empresa(rs.getInt("id"), rs.getString("ramo"), rs.getString("nome"), rs.getString("tipo"), rs.getString("descricao"), rs.getString("cnpj"),
						rs.getString("insc_municipal"), rs.getString("insc_estadual"));
			}
			
			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return empresa;

	}

}
