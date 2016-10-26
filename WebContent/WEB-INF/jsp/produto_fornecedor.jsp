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
							<h4>FORNECEDOR N�O PODE SER ASSOCIADO! <small>PROV�VELMENTE ELE J� ESTEJA ASSOCIADO A ESTE PRODUTO</small></h4>
					</div></center>
				</c:if>
				<c:if test="${not empty associaFOK }">
					<center><div class="alert alert-success" role="alert">
							<span class="glyphicon glyphicon-ok"></span>
							FORNECEDOR ASSOCIADO!
					</div></center>
				</c:if>
				<c:if test="${not empty desassociaFERRO }">
				
					<center><div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-alert"> </span>
							ERROR! FORNECEDOR N�O PODE SER DESASSOCIADO!
					</div></center>
				</c:if>
				<c:if test="${not empty desassociaFOK }">
					<center><div class="alert alert-success" role="alert">
							<span class="glyphicon glyphicon-ok"></span>
							FORNECEDOR DESASSOCIADO!
					</div></center>
				</c:if>
	
	
	<div class="row">
		<div class="col-md-12">
			<c:forEach var="prod" items="${produto}">
				<div class="text-center">
					<h4><strong><small>Produto -</small> ${prod.descricaoPro}</strong></h4>
				</div>
			</c:forEach>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-md-offset-2 col-md-8">
			<select name="idF" form="associar">
					<c:forEach var="fornecedor" items="${fornecedores}">
			 			<option value="${fornecedor.codigoFornecedor}">${fornecedor.razaoSocial}</option>
			 		</c:forEach>
			</select>	
			<c:forEach var="prod" items="${produto}">
				<form action="mvc?Logica=AssociarFornecedor&&idP=${prod.codigoProduto}" id="associar" method="post" style="margin-left:20px">
					<h5>Adiciona fornecedor ao produto</h5>
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
						<th>Nome do Fornecedor</th>
						<th>Remover (desassociar fornecedor)</th>	
					</tr>
		
				</thead>
		
				<tbody>
					<c:forEach var="fornecedor" items="${fornecprod}">
						<tr class="text-center">
							<td>${fornecedor.razaoSocial}</td>
							
							<td>
								<a class="btn btn-danger"
									href="mvc?Logica=DesassociarFornecedor&&idF=${fornecedor.codigoFornecedor}&&idP=${fornecedor.codigoProduto}">
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