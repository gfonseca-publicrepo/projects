package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Contrato;
import model.Empresa;
import util.ConexaoBD;
import util.MySQL;

public class ContratoDAO extends MySQL {

	static Contrato contrato = null;

	public static Contrato selecionar(int fk) {

		try {

			String sql = "select * from contrato where numero = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				Empresa empresa = EmpresaDAO.selecionar(rs.getInt("FKEmpresa"));

				contrato = new Contrato(rs.getString("nome"), rs.getInt("numero"), rs.getInt("vigencia"),
						rs.getDate("dtInicio"), rs.getString("status"), rs.getString("anotacoes"), empresa);

			}
			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return contrato;

	}

	public static List<Contrato> carregarContratos() {

		List<Contrato> contratos = new ArrayList<Contrato>();

		try {

			String sql = "select * from contrato";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				Empresa empresa = EmpresaDAO.selecionar(rs.getInt("FKEmpresa"));

				contrato = new Contrato(rs.getString("nome"), rs.getInt("numero"), rs.getInt("vigencia"),
						rs.getDate("dtInicio"), rs.getString("status"), rs.getString("anotacoes"), empresa);

				contratos.add(contrato);
			}
			
			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return contratos;

	}

}
