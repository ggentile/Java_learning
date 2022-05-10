package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DesafioInsere {
	
	
	public static void Inserir(String nome) throws SQLException {
		Connection conexao = Createconexao.getConexao();
		
		final String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, nome);
		
		stmt.execute();
		
		System.out.println("Pessoa inserida com sucesso!");
		
		stmt.close();
		
	}

}
