package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.model.dao.ProdutoDAO;

public class ExcluirFornecedor implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
System.out.println("Dentro de CadastrarFornecedor...");
		
		String ID = rq.getParameter("id");
		
		int id = Integer.parseInt(ID);
	
		ProdutoDAO PD = new ProdutoDAO();
		
		String pagina = "index.jsp";
		
		try{
			
			boolean OK = PD.ExcluiFornecedor(id);
			
			if(OK){
				
				pagina="/WEB-INF/jsp/principal.jsp";
				
				rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
				rq.setAttribute("deleteF_OK", "inserido com sucesso");
			}else{
			
				pagina="/WEB-INF/jsp/principal.jsp";
			
				rq.setAttribute("deleteF_ERRO", "Problemas na execusao");
			
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
