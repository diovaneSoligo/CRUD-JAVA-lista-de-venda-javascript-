<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
 	<%@ include file="head"%>
</head>

<body>
	<%@ include file="footer"%><br><br><br>
	
	
	<div class="container">
				<a class="btn btn-success"
				href="mvc?Logica=AbrirAPP">
				<span class="glyphicon glyphicon-home"></span>
				</a><br><br>
				
				<c:if test="${not empty associaFERRO }">
				
					<center><div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-alert"> </span>
							<h4>PRODUTO NÃO PODE SER ASSOCIADO! <small>PROVÁVELMENTE ELE JÁ ESTEJA ASSOCIADO A ESTE PRODUTO</small></h4>
					</div></center>
				</c:if>
				<c:if test="${not empty associaFOK }">
					<center><div class="alert alert-success" role="alert">
							<span class="glyphicon glyphicon-ok"></span>
							PRODUTO ASSOCIADO!
					</div></center>
				</c:if>
				<c:if test="${not empty desassociaFERRO }">
				
					<center><div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-alert"> </span>
							ERROR! PRODUTO NÃO PODE SER DESASSOCIADO!
					</div></center>
				</c:if>
				<c:if test="${not empty desassociaFOK }">
					<center><div class="alert alert-success" role="alert">
							<span class="glyphicon glyphicon-ok"></span>
							PRODUTO DESASSOCIADO!
					</div></center>
				</c:if>
	
	
	<div class="row">
		<div class="col-md-12">
			<c:forEach var="forn" items="${fornecedor}">
				<div class="text-center">
					<h4><strong><small>Fornecedor -</small> ${forn.razaoSocial}</strong></h4>
				</div>
			</c:forEach>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
		
			<select name="idP" form="associar">
					<c:forEach var="produto" items="${produtos}">
			 			<option value="${produto.codigoProduto}">${produto.descricaoPro}</option>
			 		</c:forEach>
			</select>	
			
			<c:forEach var="forn" items="${fornecedor}">
				<form action="mvc?Logica=AssociarProduto&&idF=${forn.codigoFornecedor}" id="associar" method="post" style="margin-left:20px">
					<h5>Adiciona produto ao fornecedor</h5>
						<button class="btn btn-primary" type="submit"><small>Adicionar </small><span class="glyphicon glyphicon-ok"></span></button>
				</form>
			</c:forEach>
		</div>
	</div>
	<hr>	
	<div class="row">
		<div class="col-md-12 text-center">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nome do Produto</th>
						<th>Remover (desassociar produto)</th>	
					</tr>
		
				</thead>
		
				<tbody>
					<c:forEach var="produto" items="${fornecprod}">
						<tr class="text-center">
							<td>${produto.descricaoPro}</td>
							
							<td>
								<a class="btn btn-danger"
									href="mvc?Logica=DesassociarProduto&&idF=${produto.codigoFornecedor}&&idP=${produto.codigoProduto}">
									<span class="glyphicon glyphicon-trash"> Remover</span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
		
	</div>
	
	<br><br><br>
 	<%@ include file="footer"%>
</head>
</body>
</html>