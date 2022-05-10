package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class DesafioMain {
	
	static String nome;
	static int codigo;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Insira a ação desejada para o banco:\n"
				+ "1: Verificar Dados\n"
				+ "2: Inserir pessoa\n"
				+ "3: Modificar pessoa\n"
				+ "4: Deleta pessoa");
		
		int resultado = entrada.nextInt();
		
		if(resultado == 1) {
			
			System.out.println("Selecione o nome da pessoa: ");
			Scanner selection = new Scanner(System.in);
			nome = selection.nextLine();
			
			DesafioSeleciona.Seleciona(nome);
			
		}else if(resultado == 2) {			
			System.out.println("Insira o nome: ");
			Scanner teste = new Scanner(System.in);
			String name = teste.nextLine();
			
			DesafioInsere.Inserir(name);
		
		} else if(resultado == 3){
			
			DesafioModifica.Modifica();
			
		}else if(resultado == 4) {
			
			System.out.println("Insira o codigo do usuário que deseja deletar do banco: ");
			codigo = entrada.nextInt();
			entrada.nextLine();
			
			DesafioDeleta.DeletarUser(codigo);
			
		}
		
	}

}
