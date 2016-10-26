package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class cadastrarCliente implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		
		String nome=rq.getParameter("nome");
		
		System.out.println("Entrou no cadastrar cliente");
		
		String pagina = "/WEB-INF/jsp/cadastroCliente.jsp";

			ProdutoDAO PD = new ProdutoDAO();
			
			boolean OK = PD.AdicionaCliente(nome);
			
			if(OK){
				System.out.println("CADASTROU CLIENTE ...");
			}
		rq.setAttribute("clientenome", new ProdutoDAO().getClientes());
		return pagina;
	}

}
