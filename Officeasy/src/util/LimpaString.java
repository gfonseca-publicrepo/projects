package util;

public class LimpaString {
	
	/**
	 * @author Gabriel Fonseca
	 */

	public static String limpaDinheiro(String a) {

		try {

			a = a.replace(".", "");
			a = a.replace(",", ".");

			return a;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String limpaDoc(String a) {

		try {

			a = a.replace(".", "");
			a = a.replace("-", "");

			return a;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
