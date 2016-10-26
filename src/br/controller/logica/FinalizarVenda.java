package br.controller.logica;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.model.dao.ProdutoDAO;
import br.model.user.Produto;

public class FinalizarVenda implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
			System.out.println("Dentro de finalizar venda...");
			
			Date date=new Date();
            SimpleDateFormat x= new SimpleDateFormat("HH:mm:ss");
			
			String codigoCliente = rq.getParameter("cliente");
			String dataVenda = rq.getParameter("data");
			String horaVenda =x.format(date);//referência para colocar os produtos desta venda
			
            /****************************LOG*******************************/
			System.out.println("Código do Cliente: "
					+ ""+codigoCliente+"\n Data da Venda: "
							+ ""+dataVenda+"\n Hora Venda: "
									+ ""+horaVenda);
			/***********************************************************/
		
			String[] item = rq.getParameterValues("item");//pega os valores da tabela
			
			if(item==null){
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());//todos Produtos
				rq.setAttribute("clientenome", new ProdutoDAO().getClientes());//todos clientes
				System.out.println("Dentro de Finalizar venda OK=FALSE... retornando para JSP");
				String pagina = "/WEB-INF/jsp/venda.jsp";
				rq.setAttribute("finalizarERRO", "naofinalizado");
				return pagina;
			}
			
			ArrayList<Produto> finaliza = new ArrayList<Produto>();

			int i = 0;
			while(i<item.length){
				String X = item[i]; //joga a string da posição 
				String array[] = new String[3];  //cria um array com 3 posiçoes
				array = X.split("@"); //separa a string onde tem @ (sao 3 valores)
				Produto f = new Produto();
				f.setCodigoProduto(Integer.parseInt(array[0]));
				f.setQuantidade(Integer.parseInt(array[1]));
				f.setPreco(Float.parseFloat(array[2]));
				finaliza.add(f);
				i++;
			}

			ProdutoDAO PD = new ProdutoDAO();
			
			String pagina = "index.jsp";
		
		try{
			
			boolean OK = PD.FinalizaVenda(codigoCliente,dataVenda,horaVenda,finaliza);
			
			if(OK){
			pagina = "/WEB-INF/jsp/venda.jsp";
			
			rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());//todos Produtos
			rq.setAttribute("clientenome", new ProdutoDAO().getClientes());//todos clientes
			System.out.println("Dentro de Finalizar venda tudo OK... retornando para JSP");
			rq.setAttribute("finalizarOK", "finalizado");
			}else{
				rq.setAttribute("produtos", new ProdutoDAO().getPrincipalP());//todos Produtos
				rq.setAttribute("clientenome", new ProdutoDAO().getClientes());//todos clientes
				System.out.println("Dentro de Finalizar venda OK=FALSE... retornando para JSP");
				pagina = "/WEB-INF/jsp/venda.jsp";
				rq.setAttribute("finalizarERRO", "naofinalizado");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			rq.setAttribute("msg", "Probleas ao abrir vendas");
			return pagina;
		}

		return pagina;
	}

}
