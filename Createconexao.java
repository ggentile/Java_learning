package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Createconexao {
	
	public static Connection getConexao() {
		
		final String url = "jdbc:mysql://localhost/curso_java_test?verifyServerCertificate=false&useSSL=true";
		final String usuario = "";
		final String senha = "";
		
		try {
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

}
}
