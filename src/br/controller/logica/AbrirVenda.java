package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class AbrirVenda implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		System.out.println("Dentro de abrir venda...");
		
		String pagina ="index.jsp";
		
		try{
			pagina = "/WEB-INF/jsp/venda.jsp";
			
			rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());//todos Produtos
			rq.setAttribute("clientenome", new ProdutoDAO().getClientes());//todos clientes
			System.out.println("Dentro de abrir venda tudo OK... retornando para JSP");
			
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Probleas ao abrir vendas");
			return pagina;
		}

		return pagina;
	}

}
