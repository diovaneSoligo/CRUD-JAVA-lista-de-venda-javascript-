package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class CadastraProduto implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {

		String nome = rq.getParameter("nome");
		String pre = rq.getParameter("preco");
		
		float preco = Float.parseFloat(pre);
		
		ProdutoDAO PD = new ProdutoDAO();
		
		String pagina = "index.jsp";
		
		try{
			
			boolean OK = PD.AdicionaProduto(nome,preco);
			
			if(OK){
				
				pagina="/WEB-INF/jsp/principal.jsp";
				
				rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
				rq.setAttribute("okP", "inserido com sucesso");
			}else{
			
				pagina="/WEB-INF/jsp/principal.jsp";
			
				rq.setAttribute("erroP", "Problemas na execusao");
			
				rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
			}
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas na execusao");
			return pagina;
		}
		

		return pagina;

	}

}
