package br.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.model.util.ConectaBD;
import br.model.util.ConectaBDPostgres;
import br.model.user.Produto;

public class ProdutoDAO {
	
/********************************************************************************************************/	
	public Object getPrincipalF() {
		
		ArrayList<Produto> fornecedores = new ArrayList<Produto>();
		try{
			
			System.out.println("vai fazer consulta e trazer a lista de Fornecedores.\n vai fazer a conexão com o banco");
			
			Connection c = ConectaBDPostgres.getConexao();//Faz conexão com banco prova1
			
			PreparedStatement stmt =  c.prepareStatement("select *from fornecedor");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Produto f = new Produto();
				
				f.setCodigoFornecedor(rs.getLong("codigof"));
				f.setRazaoSocial(rs.getString("razaosocial"));
				
				fornecedores.add(f);
			}
			System.out.println("tudo OK ... retornando a lista com os fornecedores");
			
		}catch(Exception e){
			System.out.println("CATCH em getPrincipalF() em ProdutoDAO.java ...");
			e.printStackTrace();
		}
		
		return fornecedores;
	}
	
/********************************************************************************************************/
	public Object getPrincipalP() {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try{
			
			System.out.println("vai fazer consulta e trazer a lista de produtos.\n vai fazer a conexão com o banco");
			
			Connection c = ConectaBDPostgres.getConexao();//Faz conexão com banco prova1
			
			PreparedStatement stmt =  c.prepareStatement("select *from produto");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Produto p = new Produto();
				p.setCodigoProduto(rs.getShort("codigop"));
				p.setDescricaoPro(rs.getString("descricao"));
				p.setPreco(rs.getFloat("preco"));
							
				produtos.add(p);
			}
			System.out.println("tudo OK ... retornando a lista com os produtos");
			
		}catch(Exception e){
			System.out.println("CATCH em getPrincipalP() em ProdutoDAO.java ...");
			e.printStackTrace();
		}
		
		return produtos;
	}
	
/********************************************************************************************************/
	public boolean AdicionaFornecedor(String nome){
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		try {

			c = ConectaBDPostgres.getConexao();
			String sql = "";
			
				System.out.println("......... vai adicionar .............");
				
				sql = "insert into fornecedor (razaosocial) values "
						+ "(?); ";
				
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, nome);
				
			stmt.execute();			
			stmt.close();
			retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
			
		}	
		return retorno;
	}
	
/********************************************************************************************************/
	public boolean AdicionaProduto(String nome, float preco) {
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		try {
	
			c = ConectaBDPostgres.getConexao();
			String sql = "";
			
				System.out.println("......... vai adicionar .............");
				
				sql = "insert into produto (descricao,preco) values  (?,?); ";
				
				stmt = c.prepareStatement(sql);	
				stmt.setString(1, nome);
				stmt.setFloat(2, preco);
				
			stmt.execute();			
			stmt.close();
			retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
			
		}	
		return retorno;
	}
	
/********************************************************************************************************/
	public boolean ExcluiFornecedor(int id) {
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		try {
	
			c = ConectaBDPostgres.getConexao();
			String sql = "";
			
				System.out.println("......... vai excluir fornecedor .............");
				
				sql = "delete from fornecedor where codigof= ?; ";
				
				stmt = c.prepareStatement(sql);	
				stmt.setInt(1, id);

				
			stmt.execute();			
			stmt.close();
			retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
			
		}	
		return retorno;
	}
	
/********************************************************************************************************/
	public boolean ExcluiProduto(int id) {
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		try {
	
			c = ConectaBDPostgres.getConexao();
			String sql = "";
			
				System.out.println("......... vai excluir produto .............");
				
				sql = "delete from produto where codigop=?; ";
				
				stmt = c.prepareStatement(sql);	
				stmt.setInt(1, id);
	
				
			stmt.execute();			
			stmt.close();
			retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
			
		}	
		return retorno;
	}
	
/********************************************************************************************************/
	public Object getBuscaFornecedor(int id) {
		
		ArrayList<Produto> fornecedores = new ArrayList<Produto>();
		try{
			
			System.out.println("vai fazer consulta e trazer a lista de Fornecedores.\n vai fazer a conexão com o banco");
			
			Connection c = ConectaBDPostgres.getConexao();//Faz conexão com banco prova1
			
			PreparedStatement stmt =  c.prepareStatement("select *from fornecedor where codigof = "+id+";");
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Produto f = new Produto();
				
				f.setCodigoFornecedor(rs.getLong("codigof"));
				f.setRazaoSocial(rs.getString("razaosocial"));
				
				fornecedores.add(f);
			}
			System.out.println("tudo OK ... retornando a lista com os fornecedores");
			
		}catch(Exception e){
			System.out.println("CATCH em getBuscaFornecedor(int id) em ProdutoDAO.java ...");
			e.printStackTrace();
		}
		
		return fornecedores;
	}

/********************************************************************************************************/
	public boolean AtualizarFornecedor(String nome, int id) {
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		try {
	
			c = ConectaBDPostgres.getConexao();
			String sql = "";
			
				System.out.println("......... vai atualizar fornecedor .............");
				
				sql = "update fornecedor set razaosocial = ? where codigof = ? ;";
				
				stmt = c.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setInt(2, id);
	
			stmt.execute();			
			stmt.close();
			retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
			
		}	
		return retorno;
	}
	
/********************************************************************************************************/
	public boolean AtualizarProduto(String nome, float preco, int id) {
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		try {
	
			c = ConectaBDPostgres.getConexao();
			String sql = "";
			
				System.out.println("......... vai atualizar produto .............");
				
				sql = "update produto set descricao = ? where codigop = ? ;";
				
				stmt = c.prepareStatement(sql);
				stmt.setString(1, nome);
				stmt.setInt(2, id);
	
			stmt.execute();
				
				sql = "update produto set preco = ? where codigop = ? ;";
				
				stmt = c.prepareStatement(sql);
				stmt.setFloat(1, preco);;
				stmt.setInt(2, id);

			stmt.execute();
			
			stmt.close();
			retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
			
		}	
		return retorno;
	}
	
/********************************************************************************************************/
public Object getBuscaProduto(int id) {
	ArrayList<Produto> produto = new ArrayList<Produto>();
	try{
		
		System.out.println("vai fazer consulta e trazer os dados do produto.\n vai fazer a conexão com o banco");
		
		Connection c = ConectaBDPostgres.getConexao();//Faz conexão com banco prova1
		
		PreparedStatement stmt =  c.prepareStatement("select *from produto where codigop= "+id+" ;");
		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			Produto f = new Produto();
			
			f.setCodigoProduto(rs.getLong("codigop"));
			f.setDescricaoPro(rs.getString("descricao"));
			f.setPreco(rs.getFloat("preco"));
			produto.add(f);
		}
		System.out.println("tudo OK ... retornando os dados do produto");
		
	}catch(Exception e){
		System.out.println("CATCH em getBuscaProduto(int id) em ProdutoDAO.java ...");
		e.printStackTrace();
	}
	
	return produto;
}

/********************************************************************************************************/
public Object getFornecedores(int id) {
	ArrayList<Produto> produto = new ArrayList<Produto>();
	try{
		
		System.out.println("vai fazer consulta dos fornecedores do produto.\n vai fazer a conexão com o banco");
		
		Connection c = ConectaBDPostgres.getConexao();//Faz conexão com banco prova1
		/*
		select p.codigop,f.codigof,p.descricao,p.preco, f.razaosocial  from produto p,fornecprod fp, fornecedor f
where p.codigop = fp.codigop and fp.codigof = f.codigof and p.codigop = 12
		*/
		PreparedStatement stmt =  c.prepareStatement("select p.codigop,f.codigof,p.descricao,p.preco, f.razaosocial "
				+ "from produto p,fornecprod fp, fornecedor f "
				+ "where p.codigop = fp.codigop and fp.codigof = f.codigof and p.codigop = "+id+" ;");
		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			Produto f = new Produto();
			f.setCodigoFornecedor(rs.getLong("codigof"));
			f.setRazaoSocial(rs.getString("razaosocial"));
			
			f.setCodigoProduto(rs.getLong("codigop"));
			f.setDescricaoPro(rs.getString("descricao"));
			f.setPreco(rs.getFloat("preco"));
			produto.add(f);
		}
		System.out.println("tudo OK ... retornando os dados para a pagina de produtos_fornecedor");
		
	}catch(Exception e){
		System.out.println("CATCH em getFornecedores(int id) em ProdutoDAO.java ...");
		e.printStackTrace();
	}
	
	return produto;
}

/********************************************************************************************************/
	public boolean AssociaFornecedor(int idp, int idf) {
		Connection c = null;
		PreparedStatement stmt = null;
		boolean retorno = false;
		try {
	
			c = ConectaBDPostgres.getConexao();
			String sql = "";
			
				System.out.println("......... vai adicionar .............");
				
				sql = "insert into fornecprod (codigop,codigof) values (? , ?)";
				
				stmt = c.prepareStatement(sql);
				stmt.setInt(1, idp);
				stmt.setInt(2, idf);
				
			stmt.execute();			
			stmt.close();
			retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return retorno;
			
		}	
		return retorno;
	}
	
/********************************************************************************************************/
public boolean DesassociarFornecedor(int idP, int idF) {
	Connection c = null;
	PreparedStatement stmt = null;
	boolean retorno = false;
	try {

		c = ConectaBDPostgres.getConexao();
		String sql = "";
		
			System.out.println("......... vai desassociar fornecedor .............");
			
			sql = "delete from fornecprod where codigop = ? and codigof =? ; ";
			
			stmt = c.prepareStatement(sql);	
			stmt.setInt(1, idP);
			stmt.setInt(2, idF);

			
		stmt.execute();			
		stmt.close();
		retorno = true;
		
	} catch (Exception e) {
		e.printStackTrace();
		return retorno;
		
	}	
	return retorno;
}

/********************************************************************************************************/
public Object getProdutos(int id) {
	ArrayList<Produto> produto = new ArrayList<Produto>();
	try{
		
		System.out.println("vai fazer consulta dos produtos do fornecedor\n vai fazer a conexão com o banco");
		
		Connection c = ConectaBDPostgres.getConexao();

		PreparedStatement stmt =  c.prepareStatement("select p.codigop,f.codigof,p.descricao,p.preco, f.razaosocial "
				+ "from produto p,fornecprod fp, fornecedor f "
				+ "where p.codigop = fp.codigop and fp.codigof = f.codigof and f.codigof = "+id+" ;");
		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			Produto f = new Produto();
			f.setCodigoFornecedor(rs.getLong("codigof"));
			f.setRazaoSocial(rs.getString("razaosocial"));
			
			f.setCodigoProduto(rs.getLong("codigop"));
			f.setDescricaoPro(rs.getString("descricao"));
			f.setPreco(rs.getFloat("preco"));
			produto.add(f);
		}
		System.out.println("tudo OK ... retornando os dados para a pagina de fornecedor_produto");
		
	}catch(Exception e){
		System.out.println("CATCH em getProdutos(int id) em ProdutoDAO.java ...");
		e.printStackTrace();
	}
	
	return produto;
}

/********************************************************************************************************/


public boolean CriaBanco() {
	Connection c = null;
	PreparedStatement stmt = null;
	boolean retorno = false;
	try {

		c = ConectaBD.getConexao();
		
		String sql = "";
		
			System.out.println("......... vai criar o banco Diovane_provaInternetB .............");
			
			sql = "create database diovane_provainternetb ; ";
			
			stmt = c.prepareStatement(sql);
			
			System.out.println("......... banco Diovane_provaInternetB .............");
			
		stmt.execute();		
		
			System.out.println(".........  banco diovane_provainternetB CRIADO.............");
		
		/**************/
			
			c = ConectaBDPostgres.getConexao();
			
			System.out.println("......... vai criar as tabelas do banco Diovane_provaInternetB .............");
			
			sql = "create table produto ("
					+ "codigop serial not null,"
					+ "descricao varchar(40) not null,"
					+ "preco float not null,"
					+ "primary key (codigop)"
					+ ");"
					+ "create table fornecedor ("
					+ "codigof serial not null,"
					+ "razaosocial varchar(40) not null,"
					+ "primary key (codigof)"
					+ ");"
					+ "create table fornecprod ("
					+ "codigop integer,"
					+ "codigof integer,"
					+ "primary key (codigop, codigof), "
					+ "FOREIGN KEY(codigop) REFERENCES produto(codigop), "
					+ "FOREIGN KEY(codigof) REFERENCES fornecedor(codigof)"
					+ ");"
					+ "create table cliente("
					+ "	codigoc serial not null,"
					+ "	nome varchar (40) not null,"
					+ "	primary key (codigoc)"
					+ "	);"
					+ "	create table venda("
					+ "	codigov serial not null,"
					+ "	codigoc int not null,"
					+ "	horaVenda varchar(20),"
					+ "	datavenda varchar(40),"
					+ "	primary key (codigov),"
					+ "	foreign key (codigoc) references cliente (codigoc)"
					+ "	);"
					+ "	create table item_venda("
					+ "	codigov int not null,"
					+ "	codigop int not null,"
					+ "	quantidade int not null,"
					+ "	total float not null,"
					+ "	foreign key (codigov) references venda(codigov),"
					+ "	foreign key (codigop) references produto(codigop)"
					+ "	);";
			
			stmt = c.prepareStatement(sql);
			
			System.out.println("......... vai executa.............");
			
		stmt.execute();		
		
			System.out.println(".........  tabelas inseridas.............");
			
		stmt.close();
		retorno = true;
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("......... ERRO EM CriarBanco() .............");
		return retorno;
		
	}	
	return retorno;
}

/*******************************************************************************************/
public boolean AdicionaCliente(String nome) {
	Connection c = null;
	PreparedStatement stmt = null;
	boolean retorno = false;
	try {

		c = ConectaBDPostgres.getConexao();
		String sql = "";
		
			System.out.println("......... vai adicionar .............");

			sql = "insert into cliente (nome) values  (?); ";
			
			stmt = c.prepareStatement(sql);	
			stmt.setString(1, nome);
			
			
		stmt.execute();			
		stmt.close();
		System.out.println("......... Tudo OK, retornando ... .............");
		retorno = true;
		
	} catch (Exception e) {
		e.printStackTrace();
		return retorno;
		
	}	
	return retorno;
	
}

/**********************************************************************************/
public Object getClientes() {
	ArrayList<Produto> produto = new ArrayList<Produto>();
	try{
		
		System.out.println("vai fazer consulta dos clientes \n vai fazer a conexão com o banco");
		
		Connection c = ConectaBDPostgres.getConexao();//Faz conexão com banco prova1
		
		PreparedStatement stmt =  c.prepareStatement("select *from cliente");
		
		ResultSet rs = stmt.executeQuery();

		while(rs.next()){
			Produto f = new Produto();
			f.setCodigoCliente(rs.getLong("codigoc"));
			f.setNomeCliente(rs.getString("nome"));
			
			produto.add(f);
		}
		System.out.println("tudo OK ... retornando os dados ");
		
	}catch(Exception e){
		System.out.println("CATCH em ggetClientes() em ProdutoDAO.java ...");
		e.printStackTrace();
	}
	
	return produto;
}

public boolean FinalizaVenda(String codigoCliente, String dataVenda, String horaVenda, ArrayList<Produto> finaliza) {
	Connection c = null;
	PreparedStatement stmt = null;
	boolean retorno = false;
	ArrayList<Produto> venda = new ArrayList<Produto>();
	int codigoc = Integer.parseInt(codigoCliente);
	
	try {

		c = ConectaBDPostgres.getConexao();
		String sql = "";
		
			System.out.println("......... vai adicionar na tabela venda .............");
			sql = "insert into venda (codigoc,datavenda,horaVenda) values  (?,?,?); ";
			
			stmt = c.prepareStatement(sql);	
			stmt.setInt(1, codigoc);
			stmt.setString(2, dataVenda);
			stmt.setString(3, horaVenda);
			
			
		stmt.execute();
		stmt.close();
		
			System.out.println("......... vaibuscar ID da venda .............");
			PreparedStatement stmtt =  c.prepareStatement("select codigov from venda where horavenda = '"+horaVenda+"';");
		
			ResultSet rs = stmtt.executeQuery();

		while(rs.next()){
			Produto f = new Produto();
			f.setCodigoVenda(rs.getLong("codigov"));
			
			venda.add(f);
		}
		
		long CodigoVenda = venda.get(0).getCodigoVenda();
		
			System.out.println(" ID da venda: "+CodigoVenda);
			
		stmtt.close();

			//coloca os valores na tabela Item_Venda de acordo com o codigo da venda
		
		// insert into item_venda (codigov,codigop,quantidade,total) values (1,2,2,21.75);
		
		c = ConectaBDPostgres.getConexao();
		sql = "";
		
			System.out.println("......... vai adicionar na tabela item_venda .............");
			
			sql = "insert into item_venda (codigov,codigop,quantidade,total) values (?,?,?,?);";

		int i=0;
		while(i < finaliza.size()){
			
			stmt = c.prepareStatement(sql);	
			stmt.setLong(1, CodigoVenda );
			stmt.setLong(2, finaliza.get(i).getCodigoProduto());
			stmt.setInt(3, finaliza.get(i).getQuantidade());
			stmt.setFloat(4, finaliza.get(i).getPreco());
			
			stmt.execute();
			System.out.println("WHILE: "+i);
			i++;
		}
		
		stmt.close();
		
		
		System.out.println("......... Tudo OK, retornando ... .............");
		retorno = true;
		
	} catch (Exception e) {
		e.printStackTrace();
		return retorno;
		
	}	
	return retorno;
}



}

