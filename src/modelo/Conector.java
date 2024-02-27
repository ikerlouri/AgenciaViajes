package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
	protected static Connection conexion;

	final static String host = "localhost";
	final static String BBDD = "agenciahoteles";
	final static String usuario = "root";
	final static String contrasenia = "";

	public static void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "/" + BBDD, usuario,
					contrasenia);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
