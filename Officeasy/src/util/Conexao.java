package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	private String url;
	private String driver;
	private String login;
	private String senha;

	public Conexao(String url, String driver, String login, String senha) {

		try {

			this.url = url;
			this.driver = driver;
			this.login = login;
			this.senha = senha;
			Class.forName(driver);

		} catch (ClassNotFoundException e) {

			String error = e.getMessage();

			JOptionPane.showMessageDialog(null, error);

		}
	}

	public Connection obterConexao() {

		Connection con = null;

		try {
			con = DriverManager.getConnection(url, login, senha);
		} catch (SQLException e) {

			String error = e.getMessage();

			JOptionPane.showMessageDialog(null, error);
		}
		return con;
	}

	public String getUrl() {
		return url;
	}

	public String getDriver() {
		return driver;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

}
