package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class CadastrarFornecedor implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		System.out.println("Dentro de CadastrarFornecedor...");
		
		String nome = rq.getParameter("nome");
		
		ProdutoDAO PD = new ProdutoDAO();
		
		String pagina = "index.jsp";
		
		try{
			
			boolean OK = PD.AdicionaFornecedor(nome);
			
			if(OK){
				
				pagina="/WEB-INF/jsp/principal.jsp";
				
				rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
				rq.setAttribute("okF", "inserido com sucesso");
			}else{
			
				pagina="/WEB-INF/jsp/principal.jsp";
			
				rq.setAttribute("erroF", "Problemas na execusao");
			
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
