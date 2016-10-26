package br.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

import br.model.util.ConectaBDPostgres;

public class ConectaBDPostgres {
	public static void main(String args[]){
		ConectaBDPostgres.getConexao();
		System.out.println("conexao aberta!");
	}
	
	public static Connection getConexao(){
		Connection c = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			String url ="jdbc:postgresql://localhost:5432/diovane_provainternetb"; //manter o "/diovane_provainternetb", alterar só o necessario
			String user = "postgres"; //alterar caso necessario
			String password = "2304"; //alterar a senha do banco
			c = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
}
