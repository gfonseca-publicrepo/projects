package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JWindow;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class SplashScreen extends JWindow {

	private static final long serialVersionUID = 1L;
	private int tempoExibicao = 1500;
	private int largura = 600;
	private int altura = 148;

	public SplashScreen() {

		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setBackground(new Color(0, 255, 0, 0));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SplashScreen.class.getResource("/imagens/splash.png")));
		getContentPane().add(label);

	}

	public void showSplashAndExit() {
		showSplash();
		System.exit(0);
	}

	public void showSplashAndLogin() {
		showSplash();
		dispose();
		new Login();
	}

	private void showSplash() {

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - largura) / 2;
		int y = (screen.height - altura) / 2;
		setBounds(x, y, largura, altura);

		setVisible(true);

		try {
			Thread.sleep(tempoExibicao);
		} catch (Exception e) {
		}
		setVisible(false);
	}

}
