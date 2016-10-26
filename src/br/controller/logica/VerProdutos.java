package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class VerProdutos implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		System.out.println("Dentro de VerProdutos");
		
		
		String ID = rq.getParameter("id");
		
		int id = Integer.parseInt(ID);

		String pagina = "index.jsp";
		
		try{
			
			pagina="/WEB-INF/jsp/fornecedor_produto.jsp";
			
			rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());//todos Produtos
			rq.setAttribute("fornecedor", new ProdutoDAO().getBuscaFornecedor(id));//info do fornecedor
			rq.setAttribute("fornecprod", new ProdutoDAO().getProdutos(id));//produtos associados
			
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas em VerProdutos");
			pagina = "index.jsp";
			return pagina;
		}
		
		return pagina;
	}

}
