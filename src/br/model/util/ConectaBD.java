package br.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBD {
	public static void main(String args[]){
		ConectaBD.getConexao();
		System.out.println("conexao aberta!");
	}
	
	public static Connection getConexao(){
		Connection c = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			String url ="jdbc:postgresql://localhost:5432/"; // alterar o caminho caso seja outro (porta)
			String user = "postgres"; //alterar o usuario caso seja outro
			String password = "2304"; //alterar a senha do banco
			
			c = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
}
