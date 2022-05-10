package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DesafioModifica {
	
	static String sql;
	
	public static void Modifica() throws SQLException {
		Scanner req = new Scanner(System.in);
		
		System.out.println("Deseja Modificar: "
				+ "1: Apenas nome da pessoa "
				+ "2: Nome e codigo da pessoa ");
		int res = req.nextInt();
		
		if(res == 1) {
			System.out.println("Insira o codigo da pessoa no banco: ");
			int cod = req.nextInt();
			
			System.out.println("Insira o nome que deve ser colocado no lugar: ");
			String name = req.nextLine();
			ModificarJustName(cod, name);
		}else {
			System.out.println("Insira o codigo da pessoa no banco: ");
			int cod2 = req.nextInt();
			
			System.out.println("Insira o nome que deve ser colocado no lugar: ");
			String name2 = req.nextLine();
			
			System.out.println("Insira novo codigo da pessoa no banco: ");
			int newCod = req.nextInt();
			
			ModificarAll(cod2, name2, newCod);
			
		}
		
		System.out.println("Modificação feita com sucesso!");
		
		req.close();
	}
	
	private static void ModificarJustName(int codigo, String nome) throws SQLException {
		Connection conexao = Createconexao.getConexao();
		
		sql = "UPDATE pessoas SET nome = (?) WHERE codigo = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
			stmt.setString(1, nome);
			stmt.setInt(2, codigo);
			
			stmt.execute();
			
			stmt.close();
	}
	
	private static void ModificarAll(int codigo, String nome, int newCodigo) throws SQLException {
		Connection conexao = Createconexao.getConexao();
		
		sql = "UPDATE pessoas SET codigo = (?), nome = (?) WHERE codigo = (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setInt(1, newCodigo);
		stmt.setString(2, nome);
		stmt.setInt(3, codigo);
		
		stmt.execute();
		
		stmt.close();
	}

}
