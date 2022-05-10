package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DesafioDeleta {
	
	public static void DeletarUser(int codigo) throws SQLException {
		Connection conexao = Createconexao.getConexao();
		
		final String sql = "DELETE FROM pessoas WHERE codigo = (?)";
		
		PreparedStatement stms = conexao.prepareStatement(sql);
		stms.setInt(1, codigo);
		
		stms.execute();
		
		System.out.println("Usuário deletado como solicitado");
		
		stms.close();
	}

}
