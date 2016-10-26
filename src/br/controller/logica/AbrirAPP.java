package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class AbrirAPP implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		System.out.println("Dentro de AbrirAPP");

		String pagina = "index.jsp";
		
		try{
			
			pagina="/WEB-INF/jsp/principal.jsp";
			
			rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
			rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
			
			System.out.println("Dentro de AbrirAPP, tudo OK");
			
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas ao abrir APP");
			return pagina;
		}
		
		return pagina;

	}

}
