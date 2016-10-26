package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class VerFornecedores implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		System.out.println("Dentro de VerFornecedores");
		
		
		String ID = rq.getParameter("id");
		
		int id = Integer.parseInt(ID);

		String pagina = "index.jsp";
		
		try{
			
			pagina="/WEB-INF/jsp/produto_fornecedor.jsp";
			
			rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());//todos fornecedores
			rq.setAttribute("produto", new ProdutoDAO().getBuscaProduto(id));//info do produto
			rq.setAttribute("fornecprod", new ProdutoDAO().getFornecedores(id));//fornecedores associados
			
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas ao abrir APP");
			pagina = "index.jsp";
			return pagina;
		}
		
		return pagina;

	}

}
