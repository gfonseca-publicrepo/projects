package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Configurador {

	private String idioma;
	private String regiao;
	private String arquivoAjuda;

	public Configurador() {

		try {

			FileInputStream arq = new FileInputStream("config.ini");

			Properties prop = new Properties();

			prop.load(arq);

			arq.close();

			idioma = prop.getProperty("idioma");
			regiao = prop.getProperty("regiao");
			arquivoAjuda = prop.getProperty("ajuda");

		} catch (IOException ioe) {

			String error = ioe.getMessage();

			JOptionPane.showMessageDialog(null, error);

		}
	}

	public String getIdioma() {
		return idioma;
	}

	public String getRegiao() {
		return regiao;
	}

	public String getArquivoAjuda() {
		return arquivoAjuda;
	}

}
