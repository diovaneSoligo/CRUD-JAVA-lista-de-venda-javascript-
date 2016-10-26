<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
 	<%@ include file="WEB-INF/jsp/head"%>
</head>

<body>
	<%@ include file="WEB-INF/jsp/footer"%>
	
	<c:if test="${not empty msg }">
			<center><div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-alert"> </span>
					OPS! PROBLEMAS NA APLICAÇÃO
					<small>(CONFIRA SUA CONEXÃO COM O BANCO E O LOG DO SISTEMA)</small>
			</div></center>
	</c:if>
	
	<c:if test="${not empty CriabancoOK }">
			<center><div class="alert alert-success" role="alert">
					<span class="glyphicon glyphicon-alert"> </span>
					BANCO CRIADO COM SUCESSO!
			</div></center>
	</c:if>
	
	<c:if test="${not empty CriaBancoERRO }">
			<center><div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-alert"> </span>
					OPS! PROBLEMAS AO CRIA O BANCO
					<small>(CONFIRA AS CONFIGURAÇÕES EM "ConectaBD.java" se estão corretas, ou se o banco já não existe!!)</small>
			</div></center>
	</c:if>
	
	
	
	<center><h2>Prova Internet B</h2></center><br>

	<center>
		<form action="mvc?Logica=AbrirAPP" method="post">
		<button class="btn btn-primary" type="submit">Cadastro de Produtos e Fornecedores</button>
		</form><br>
		<form action="mvc?Logica=cadastrarCliente" method="post">
		<button class="btn btn-primary" type="submit">Cadastrar / Ver Cliente</button>
		</form><br>
		<form action="mvc?Logica=AbrirVenda" method="post">
		<button class="btn btn-primary" type="submit">Realizar venda</button>
		</form><br><br><br>
	</center>
	<br><br><br>
	
	<div class="container"><h3>CRIAR O BANCO</h3>
			<a class="btn btn-danger btn-xs"
					href="mvc?Logica=CriarBanco">
					<span class="glyphicon glyphicon-alert"> Criar banco de dados! (parte 2 e 3 da avaliação) <small>Somente se o banco nao existir</small> </span>
			</a>
	</div>
	<br>
						
 	<%@ include file="WEB-INF/jsp/footer"%>
</head>
</body>
</html>