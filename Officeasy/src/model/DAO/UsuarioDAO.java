package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Permissoes;
import util.ConexaoBD;
import util.MySQL;

public class UsuarioDAO extends MySQL {

	/**
	 * @author Gabriel Fonseca
	 */

	public static Funcionario buscaPorLogin(String login) {

		try {

			Funcionario usu = null;

			String sql = "select * from usuario where login = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, login);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				usu = new Funcionario(rs.getInt("login"), rs.getString("senha"));

				rs.close();
				comando.close();
				con.close();

				return usu;

			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return null;

	}

	public static void alterarSenha(int login, String senha) {

		try {

			String sql = "update usuario set senha = ? where login = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, senha);
			comando.setInt(2, login);

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		JOptionPane.showMessageDialog(null, "Senha alterada!");

	}

	public static void alterarStatus(int login, boolean status) {

		try {

			String sql = "update usuario set logado = ? WHERE login = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setBoolean(1, status);
			comando.setInt(2, login);

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static void manterLogado(String nomeUsu, boolean manterLogado) {

		try {

			String sql = "UPDATE usuario SET manterLogado = ? where nomeUsu = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setBoolean(1, manterLogado);
			comando.setString(2, nomeUsu);

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static void inserirUsuario(int login, String senha, Permissoes nivel, int matricula) {

		try {

			String sql = "INSERT INTO usuario values (?,?,?,?,?,?)";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, login);
			comando.setString(2, senha);
			comando.setBoolean(3, true);
			comando.setBoolean(4, false);
			comando.setBoolean(5, false);
			comando.setInt(6, nivel.getId());

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Já existe um usuário para esta matricula",
					"Não foi possível concluir esta ação", 0);
		}

		JOptionPane.showMessageDialog(null, MySQL.getMSG());

	}

	public static Funcionario selecionarUsuario(int login) {

		Permissoes perm;
		Funcionario usu = null;

		try {

			String sql = "select * from usuario where login = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, login);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				perm = PermissoesDAO.selecionar(rs.getInt("FKNivel"));

				usu = new Funcionario(rs.getInt("login"), rs.getString("senha"), perm, rs.getBoolean("status"),
						rs.getBoolean("manterLogado"), rs.getBoolean("logado"));

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
		}

		return usu;
	}

	public static Funcionario buscarUsuarioPorMatricula(int matricula) {

		Permissoes perm;
		Funcionario usu = null;

		try {

			String sql = "select * from usuario where usuario.nomeUsu = funcionario.FKUsuario and funcionario.matricula = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, matricula);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {

				perm = PermissoesDAO.selecionar(rs.getInt("FKNivel"));

				usu = new Funcionario(rs.getInt("login"), rs.getString("senha"), perm, rs.getBoolean("status"),
						rs.getBoolean("manterLogado"), rs.getBoolean("logado"));

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
		}

		return usu;

	}

	public static List<Funcionario> listarUsuariosAtivos() {

		List<Funcionario> listaUsu = new ArrayList<Funcionario>();

		Permissoes perm;
		Funcionario usu = null;

		try {

			String sql = "select * from usuario where status = true";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				if (rs.next()) {
					perm = PermissoesDAO.selecionar(rs.getInt("FKNivel"));
					usu = new Funcionario(rs.getInt("login"), rs.getString("senha"), perm, rs.getBoolean("status"),
							rs.getBoolean("manterLogado"), rs.getBoolean("logado"));

					listaUsu.add(usu);
				}

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return listaUsu;
	}

	public static List<Funcionario> listarUsuariosInativos() {

		List<Funcionario> listaUsu = new ArrayList<Funcionario>();

		Permissoes perm;
		Funcionario usu = null;

		try {

			String sql = "select * from usuario where status = false";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				if (rs.next()) {
					perm = PermissoesDAO.selecionar(rs.getInt("FKNivel"));
					usu = new Funcionario(rs.getInt("login"), rs.getString("senha"), perm, rs.getBoolean("status"),
							rs.getBoolean("manterLogado"), rs.getBoolean("logado"));

					listaUsu.add(usu);
				}

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return listaUsu;
	}

	public static List<Funcionario> buscarUsuariosPorMatricula(int matricula) {

		List<Funcionario> listaUsu = new ArrayList<Funcionario>();

		Permissoes perm;
		Funcionario usu = null;

		try {

			String sql = "select usuario.nomeUsu, usuario.status, usuario.logado, usuario.FKNivel from usuario, funcionario where funcionario.matricula = ? and funcionario.FKUsuario = usuario.nomeUsu";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, matricula);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				if (rs.next()) {
					perm = PermissoesDAO.selecionar(rs.getInt("FKNivel"));
					usu = new Funcionario(rs.getInt("login"), rs.getString(""), perm, rs.getBoolean("status"),
							rs.getBoolean("manterLogado"), rs.getBoolean("logado"));

					listaUsu.add(usu);
				}

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return listaUsu;
	}

	public static List<Funcionario> buscarUsuariosPorLogin(String login) {

		List<Funcionario> listaUsu = new ArrayList<Funcionario>();

		Permissoes perm;
		Funcionario usu = null;

		try {

			String sql = "select usuario.nomeUsu, usuario.status, usuario.logado, usuario.FKNivel from usuario where usuario.nomeUsu = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, login);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {

				if (rs.next()) {
					perm = PermissoesDAO.selecionar(rs.getInt("FKNivel"));
					usu = new Funcionario(rs.getInt("login"), rs.getString(""), perm, rs.getBoolean("status"),
							rs.getBoolean("manterLogado"), rs.getBoolean("logado"));

					listaUsu.add(usu);
				}

			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return listaUsu;
	}

	public static void modificarUsuario(Funcionario usuario) {

		Permissoes perm = usuario.getNivel();

		try {

			String sql = "UPDATE usuario SET senha = ?, status = ?, FKNivel = ? where nomeUsu = ?";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, usuario.getSenha());
			comando.setBoolean(2, usuario.getStatus());
			comando.setInt(3, perm.getId());
			comando.setInt(4, usuario.getLogin());

			comando.executeUpdate();

			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		JOptionPane.showMessageDialog(null, MySQL.getMSG());

	}

	public static int quantidadeUsuarios() {

		int quantidade = 0;

		try {

			String sql = "SELECT COUNT(*) from usuario";

			ConexaoBD conex = new ConexaoBD(MySQL.getURL(), MySQL.getDRIVER(), MySQL.getLOGIN(), MySQL.getSENHA());

			Connection con = conex.obterConexao();

			PreparedStatement comando = con.prepareStatement(sql);

			ResultSet rs = comando.executeQuery();

			quantidade = rs.getInt(0);

			comando.close();
			con.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return quantidade;

	}

}
