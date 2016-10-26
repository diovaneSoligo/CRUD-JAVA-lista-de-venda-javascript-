package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class AtualizarProduto implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		String nome = rq.getParameter("nome");
		String PRECO = rq.getParameter("preco");
		String ID = rq.getParameter("id");
		
		
		float preco = Float.parseFloat(PRECO);
		
		int id = Integer.parseInt(ID);
		
		ProdutoDAO PD = new ProdutoDAO();
		
		String pagina = "index.jsp";
		
		try{
			
			boolean OK = PD.AtualizarProduto(nome,preco,id);
			
			if(OK){
				
				pagina="/WEB-INF/jsp/principal.jsp";
				
				rq.setAttribute("fornecedores", new ProdutoDAO().getPrincipalF());
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());
				rq.setAttribute("atualizadoProdutoOK", "atualizado com sucesso");
			}else{
			
				pagina="/WEB-INF/jsp/principal.jsp";
			
				rq.setAttribute("atualizadoProdutoERRO", "problemas ao atualizar");
			
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
