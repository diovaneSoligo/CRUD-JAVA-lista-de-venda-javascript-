package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class EditarFornecedor implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		String ID = rq.getParameter("id");
		
		int id = Integer.parseInt(ID);
	
		
		String pagina="/WEB-INF/jsp/principal.jsp";
		
		try{

				rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
				rq.setAttribute("atualizarF", new ProdutoDAO().getBuscaFornecedor(id));

		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas na execusao");
			pagina = "index.jsp";
			return pagina;
		}
		

		return pagina;
	}

}
