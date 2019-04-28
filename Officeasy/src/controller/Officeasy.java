package controller;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import model.Funcionario;
import model.DAO.UsuarioDAO;
import view.Principal;
import view.SplashScreen;

public class Officeasy {

	/**
	 * @author Gabriel Fonseca
	 * 
	 */

	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel(new McWinLookAndFeel()); // Definindo aparência da GUI

			new SplashScreen().showSplashAndLogin(); // Chama tela de abertura e vai para o login

		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	public static boolean efetuarLogin(int login, String senha) {

		Funcionario usuario = null;

		try {

			usuario = UsuarioDAO.selecionarUsuario(login);

			if (usuario.isLogado()) {
				JOptionPane.showMessageDialog(null, "O usuário já está logado");
				return false;
			} else if (usuario.getSenha().equals(senha.toString()) && login == usuario.getLogin()) {
				usuario.setLogado(true);
				UsuarioDAO.alterarStatus(usuario.getLogin(), usuario.isLogado());
				new Principal(usuario);
				return true;

			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos");
				return false;
			}
		} catch (NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Usuário Inválido");
			return false;
		}

	}

	public static void saida(int login) {

		UsuarioDAO.alterarStatus(login, false);
		System.exit(0);
	}

}
