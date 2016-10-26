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
					
		<div class="row">
		<div class="col-md-4 col-md-offset-5">
			<h3>Cadastro de Cliente</h3>
		</div>
		</div>
		
				
					
				
	<div class="row">
		<div class="col-md-6 col-md-offset-4">
			<form action="mvc?Logica=cadastrarCliente" method="post" style="/*margin-left:20px*/">
	            <div class="input-group">
							<input class="form-control" type="text" id="nome" name="nome" placeholder="Nome Completo"  required>
							<button class="btn btn-primary" type="submit">Adicionar Cliente <span class="glyphicon glyphicon-ok-circle"></span></button>
				</div>
	         </form>
         </div>
	</div>	
		<br><br><br>
		<div class="row">
		<div class="col-md-5 text-center col-md-offset-3">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nome do Cliente</th>
					</tr>
		
				</thead>
				<tbody>
					<c:forEach var="cliente" items="${clientenome}">
						<tr class="text-center">
							<td>${cliente.nomeCliente}</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
	
	<br><br><br>
 	<%@ include file="footer"%>
</head>
</body>
</html>