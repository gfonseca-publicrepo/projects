package controller;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import model.Funcionario;
import model.DAO.UsuarioDAO;
import view.Principal;
import view.SplashScreen;

public class Officeasy {

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
				JOptionPane.showMessageDialog(null, "O usuário já encontra-se logado no sistema!.");
				return false;
			}

			if (usuario.getSenha().equals(senha.toString())) {
				UsuarioDAO.alterarStatus(usuario.getLogin(), true);
				usuario.setLogado(true);
				new Principal(usuario);

				return true;

			} else {

				JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos");

				return false;
			}

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Login", 0);

			return false;
		}

	}

	public static void saidaSistema(int login) {

		UsuarioDAO.alterarStatus(login, false);
		System.exit(0);
	}

}
