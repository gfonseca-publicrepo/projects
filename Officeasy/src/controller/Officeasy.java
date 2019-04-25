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

			// Definindo aparência da GUI
			UIManager.setLookAndFeel(new McWinLookAndFeel());

			new SplashScreen().showSplashAndLogin();

		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	public static boolean efetuarLogin(String login, String senha) {

		Funcionario usuario = null;

		usuario = UsuarioDAO.selecionarUsuario(login);

		if (usuario.isLogado()) {
			JOptionPane.showMessageDialog(null, "O usuário já encontra-se logado no sistema!.");
			return false;
		}

		boolean valido = UsuarioDAO.buscarPorLoginSenha(login, senha);
		if (valido) {
			UsuarioDAO.alterarStatus(login, true);
			usuario.setLogado(true);
			new Principal(usuario);

			return true;

		} else {
			JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos");

			return false;
		}

	}

	public static void saidaSistema(String usu) {

		UsuarioDAO.alterarStatus(usu, false);
		System.exit(0);
	}
	
	

}
