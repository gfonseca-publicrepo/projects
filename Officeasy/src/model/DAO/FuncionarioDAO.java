package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Contrato;
import model.Funcionario;
import model.Local;
import util.Conexao;
import util.MySQL;

public class FuncionarioDAO extends MySQL {

	private static int result;
	private static Funcionario f;

	static Funcionario usu = null;

	public static boolean verificarMatricula(int matricula) {

		try {

			String sql = "select matricula from funcionario where matricula = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, matricula);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				rs.close();
				comando.close();
				con.close();

				return true;

			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return false;

	}

	public static String buscarFKUsuario(int matricula) {

		String fk = null;

		try {

			String sql = "select FKUsuario from funcionario where matricula = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, matricula);

			ResultSet rs = comando.executeQuery();

			fk = rs.getString("FKUsuario");

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return fk;

	}

	public static String buscarNome(int matricula) {

		String nome = null;

		try {

			String sql = "select nome from funcionario where matricula = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, matricula);

			ResultSet rs = comando.executeQuery();

			nome = rs.getString("nome");

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return nome;

	}

	public static List<Funcionario> listarAtivos() {
		List<Funcionario> listFun = new ArrayList<Funcionario>();

		Contrato contrato;
		Local local;
		Funcionario usu = null;

		try {

			String sql = "select * from funcionario where situacao = true";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			rs.absolute(0);

			while (rs.next()) {
				contrato = ContratoDAO.selecionar(rs.getInt("FKContratoNum"));
				local = LocalDAO.selecionar(rs.getInt("FKLocal"));
				usu = new Funcionario(rs.getInt("matricula"), rs.getString("nome"), rs.getString("cargo"),
						rs.getBoolean("situacao"), contrato, local);

				listFun.add(usu);
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		return listFun;
	}

	public static List<String> listarCargos() {
		List<String> listCargo = new ArrayList<String>();

		String cargo;

		try {

			String sql = "select distinct cargo from funcionario";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				cargo = rs.getString("cargo");

				listCargo.add(cargo);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return listCargo;
	}

	public static void novoFuncionario(int Matricula, Boolean situacao, String nome, String cargo, int fkContrato,
			int fkLocal) {

		try {

			String sql = "insert into funcionario (matricula, situacao, nome, cargo, FKContratoNum, FKLocal) values (?,?,?,?,?,?)";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, Matricula);
			comando.setBoolean(2, situacao);
			comando.setString(3, nome);
			comando.setString(4, cargo);
			comando.setInt(5, fkContrato);
			comando.setInt(6, fkLocal);

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

	}

	public static int contarMatriculaNova() {

		try {

			String sql = "select max(matricula) as matricula from funcionario";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				result = rs.getInt("matricula") + 1;

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(result);
		}

		return result;
	}

	public static Funcionario selecionarPorMatricula(int fkMatricula) {

		try {

			String sql = "select * from funcionario where matricula = ?";

			Conexao conex = new Conexao(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fkMatricula);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				f = new Funcionario(fkMatricula, rs.getString("nome"), rs.getString("cargo"), rs.getBoolean("situacao"),
						ContratoDAO.selecionar(rs.getInt("FKContratoNum")), LocalDAO.selecionar(rs.getInt("FKLocal")),
						DadosFunDAO.selecionar(fkMatricula), EnderecoDAO.selecionarEndFun(fkMatricula),
						DependenteDAO.selecionarDependentes(fkMatricula), BeneficioDAO.selecionar(fkMatricula),
						DocFunDAO.selecionarDoc(fkMatricula), DadosBancariosDAO.selecionarDadosBancoFun(fkMatricula),
						null);

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}

		return f;
	}

}
