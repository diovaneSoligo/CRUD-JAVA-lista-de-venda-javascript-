package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class AtualizarFornecedor implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		String nome = rq.getParameter("nome");
		String ID = rq.getParameter("id");
		
		int id = Integer.parseInt(ID);
		
		ProdutoDAO PD = new ProdutoDAO();
		
		String pagina = "index.jsp";
		
		try{
			
			boolean OK = PD.AtualizarFornecedor(nome,id);
			
			if(OK){
				
				pagina="/WEB-INF/jsp/principal.jsp";
				
				rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
				rq.setAttribute("atualizadoFornecedorOK", "atualizado com sucesso");
			}else{
			
				pagina="/WEB-INF/jsp/principal.jsp";
			
				rq.setAttribute("atualizadoFornecedorERRO", "problemas ao atualizar");
			
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
