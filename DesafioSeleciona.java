package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesafioSeleciona {
	
	public static void Seleciona(String nome) throws SQLException {
		String sql = "SELECT * FROM pessoas WHERE nome = (?)";
		
		Connection conexao = Createconexao.getConexao();
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, nome);
		
		ResultSet result = stmt.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(result.next()){
			int codigo = result.getInt("codigo");
			String name = result.getString("nome");
			pessoas.add(new Pessoa(codigo, name));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + "==> " + p.getNome());
		}
		
		conexao.close();
 	}

}
