package br.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;

public class CriarBanco implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
			
		
		ProdutoDAO PD = new ProdutoDAO();
		
		String pagina = "index.jsp";
		try{
			
			boolean OK = PD.CriaBanco();
			
			if(OK){
				
				rq.setAttribute("CriabancoOK", "atualizado com sucesso");
				
			}else{
			
				rq.setAttribute("CriaBancoERRO", "problemas ");
				
			}
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas na execusao");
			return pagina;
		}
		

		return pagina;
	}

}
