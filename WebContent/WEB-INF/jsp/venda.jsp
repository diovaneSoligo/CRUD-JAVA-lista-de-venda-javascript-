<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<%@ include file="script.jsp"%>
 	<%@ include file="head"%>
</head>

<body>
	<%@ include file="footer"%><br><br><br>
	
	
	<div class="container">

				<c:if test="${not empty finalizarOK }">
					<div class="alert alert-success">
  						<strong>Success!</strong> Venda finalizada com sucesso, tudo cadastrado no banco.
					</div>
				</c:if>
				<c:if test="${not empty finalizarERRO }">
					<div class="alert alert-danger">
  						<strong>OPS!</strong> Algo deu errado, desculpe pelo encomodo, tente novamente.
					</div>
				</c:if>
		
		<div class="row" style="border-bottom: 2px solid blue;">
			<div class="col-md-offset-4 col-md-1">
			 	<img src="car.png" alt="carrinho de venda" height="70" width="70"> 
			</div>
			<div class="col-md-4">
				<h4>Sistemas de Vendas WEB</h4>
			</div>
		</div>
		<br>
			<div class="row">
			
				<div class="col-md-6">
							 	<div class="form-group">
								  <label for="sel1">Cliente:</label>
								  <select name="cliente" id="cliente" class="form-control" form="venda">
								    <c:forEach var="nome" items="${clientenome}">
			 							<option value="${nome.codigoCliente}">${nome.nomeCliente}</option>
			 						</c:forEach>>
								  </select>
								</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
					  <label for="usr">DATA:</label>
					  <input type="text" class="form-control" id="data" name="data" form="venda" placeholder="dd/mm/aaaa" pattern="[0-9/]+" required>
					</div>
				</div>
				
			</div>
			
			<br>
			<h3>Produto</h3>
			<div class="row">
			
				<div class="col-md-6">
							 	<div class="form-group">
								  <label for="sel1">Descrição:</label>
								  <select name="descrição" id="valor" onblur="calcular();" class="form-control" form="venda">
								    <c:forEach var="produto" items="${produtos}">
			 							<option value="${produto.preco}@${produto.descricaoPro}@${produto.codigoProduto}">${produto.descricaoPro}</option>
			 						</c:forEach>
								  </select>
								</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
					  <label for="usr">Quantidade:</label>
					  <input type="text" id="qtda" onblur="calcular();" class="form-control" name="data" placeholder="Qtda" pattern="[0-9]+" required>
					</div>
				</div>
				
			</div>
			
		<div class="row">
				<div class="col-md-6">
					<div class="form-group">
					  <h2> <strong>Preço Unitário: R$</label><span id="valoruni"></span><small id="quant"></small></strong></h2>
					</div>
				</div>
				<div class="col-md-offset-2 col-md-3" style="border-bottom: 2px solid red;">
					<div class="form-group"><br><br>
					 <h2> <strong>Total: R$ <div id="resultado">0</div></strong></h2>
					</div>
				</div>
				
		
		</div>
		
		<center  style="border-bottom: 2px solid blue;">		
		<form action="mvc?Logica=Adicionarcompra" id="associar" method="post" style="margin-left:20px">
			<input type="button" name="submit" value="Adicionar a lista" class="btn btn-success" onclick="adicionar()">
		</form><br>
		</center>
		<br>	
		
		
			<div class="row">
			
		<div class="col-md-12">
		<h2>Itens:</h2>
			<table class="table table-striped table-bordered" form="venda" id="">
				<thead>
					<tr>
						<th>Produto</th>
						<th>Descrição</th>
						<th>Quantidade</th>
						<th>Total</th>
					</tr>
		
				</thead>
		
			</table>
			<div class="row">
				<div class="col-md-2 col-md-offset-9">
				SOMA TOTAL: R$
				</div>
				<div class="col-md-1" id="totalFim"  style="border-bottom: 2px solid red; margin-left:-60px">
				 0,00
				</div>
			</div>
		</div>
	</div>
		<br><br>
		
		<div class="row">
			<div class="col-md-2 col-md-offset-10">
			<form action="mvc?Logica=FinalizarVenda" id="venda" method="post" style="margin-left:20px">
			<button type="submit" class="btn btn-danger">Finalizar Venda</button>
			</form>
			</div>
		</div>
		
		
		
		<br><br><br>
		<div class="row">
			<a class="btn btn-success"
					href="index.jsp">
					<span class="glyphicon glyphicon-log-out"> SAIR</span>
			</a>
		</div><br>
	</div>

	
 	<%@ include file="footer"%>
</head>
</body>

</html>