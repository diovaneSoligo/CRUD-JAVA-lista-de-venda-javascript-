package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class AssociarProduto implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		String IDP = rq.getParameter("idP");
		String IDF = rq.getParameter("idF");
		
		System.out.println("ID do produto.. "+IDP);
		System.out.println("ID do fornecedor.."+IDF);
		
		ProdutoDAO PD = new ProdutoDAO();
		
		String pagina = "index.jsp";
		
		try{
			
			boolean OK = PD.AssociaFornecedor(Integer.parseInt(IDP),Integer.parseInt(IDF));
			
			if(OK){
				
				pagina="/WEB-INF/jsp/fornecedor_produto.jsp";
				
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());//todos Produtos
				rq.setAttribute("fornecedor", new ProdutoDAO().getBuscaFornecedor(Integer.parseInt(IDF)));//info do fornecedor
				rq.setAttribute("fornecprod", new ProdutoDAO().getProdutos(Integer.parseInt(IDF)));//produtos associados
				
				rq.setAttribute("associaFOK", "associado");
			}else{
			
				pagina="/WEB-INF/jsp/fornecedor_produto.jsp";
				
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());//todos Produtos
				rq.setAttribute("fornecedor", new ProdutoDAO().getBuscaFornecedor(Integer.parseInt(IDF)));//info do fornecedor
				rq.setAttribute("fornecprod", new ProdutoDAO().getProdutos(Integer.parseInt(IDF)));//produtos associados
			
				rq.setAttribute("associaFERRO", "não associado");
			}
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas na execusao");
			return pagina;
		}
		

		return pagina;
	}

}
