package util;

public abstract class MySQL {
	
	private final static String URL = "jdbc:mysql://localhost:3306/officeasy?useTimezone=true&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String LOGIN = "root";
	private final static String SENHA = "root";
	private final static String MSG = "Sucesso !";

	public static String getURL() {
		return URL;
	}

	public static String getDRIVER() {
		return DRIVER;
	}

	public static String getLOGIN() {
		return LOGIN;
	}

	public static String getSENHA() {
		return SENHA;
	}
	
	public static  String getMSG() {
		return MSG;
	}

}
