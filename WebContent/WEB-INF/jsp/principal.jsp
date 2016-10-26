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
	
	
		<%@ include file="error"%>
		
		<div class="col-md-6" style="border-right: 2px solid blue;">
				
		<div class="row text-center" style="background-color:#c1c1c1; margin-left:15px;margin-right: 15px">
		
			<c:if test="${not empty atualizarF }">
			<c:forEach var="fornecedor" items="${atualizarF}">
				
					<h4 style="color:blue"><span class="glyphicon glyphicon-cog"></span> Atualizar Fornecedor <span class="glyphicon glyphicon-arrow-right"></span> ${fornecedor.razaoSocial}</h4>
					<form action="mvc?Logica=AtualizarFornecedor&&id=${fornecedor.codigoFornecedor}" method="post" style="margin-left:20px">
                		<div class="input-group">
							<strong><input type="text" id="nome" name="nome" value="${fornecedor.razaoSocial}" placeholder="Nome do Fornecedor"  required></strong>
							<button class="btn btn-primary" type="submit"><small>Salvar </small><span class="glyphicon glyphicon-repeat"></span></button>
							<a class="btn btn-danger"
								href="mvc?Logica=AbrirAPP"><small>Cancelar</small> 
								<span class="glyphicon glyphicon-remove"></span>
							</a>
						</div>
            		</form>
            </c:forEach>
			</c:if>
			<c:if test="${empty atualizarF }">
					<h4>Adicionar Fornecedor</h4>
					<form action="mvc?Logica=CadastrarFornecedor" method="post" style="margin-left:20px">
                		<div class="input-group">
							<input type="text" id="nome" name="nome" placeholder="Nome do Fornecedor"  required>
							<button class="btn btn-primary" type="submit">Adicionar <span class="glyphicon glyphicon-ok-circle"></span></button>
						</div>
            		</form>
			</c:if>
			
			<br>
		</div>
		
		<div class="row text-center">
		<h3>Fornecedores</h3>
		</div>
		
		<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Nome do Fornecedor</th>
				<th>Deletar</th>
				<th>Editar</th>	
				<th>Produtos</th>	
			</tr>

		</thead>

		<tbody>
			<c:forEach var="fornecedor" items="${fornecedores}">
				<tr class="text-center">
					<td>${fornecedor.razaoSocial}</td>
					
					<td>
						<a class="btn btn-danger"
							href="mvc?Logica=ExcluirFornecedor&&id=${fornecedor.codigoFornecedor}">
							<span class="glyphicon glyphicon-trash"></span>
						</a>
					</td>
					<td>
						<a class="btn btn-info"
							href="mvc?Logica=EditarFornecedor&&id=${fornecedor.codigoFornecedor}">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
					</td>
					<td>
						<a class="btn btn-success"
							href="mvc?Logica=VerProdutos&&id=${fornecedor.codigoFornecedor}">
							<span class="glyphicon glyphicon-eye-open"></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		</div>
		
		
		<div class="col-md-6">
		<div class="row text-center" style="background-color:#c1c1c1; margin-left:15px;margin-right: 15px">
		
		<c:if test="${not empty atualizarP }">
		<c:forEach var="produto" items="${atualizarP}">
			<h4 style="color:blue"><span class="glyphicon glyphicon-cog"></span> Atualizar Produto <span class="glyphicon glyphicon-arrow-right"></span> ${produto.descricaoPro}</h4>
				<form action="mvc?Logica=AtualizarProduto&&id=${produto.codigoProduto}" method="post" style="margin-left:20px">
                	<div class="input-group">
						Nome:<strong><input type="text" id="nome" name="nome" value="${produto.descricaoPro}" placeholder="Produto" required></strong>
						Preço R$<strong><input type="text" id="preco" name="preco" value="${produto.preco}" placeholder="EX.: 2.98" pattern="[0-9.]+" required></strong>
						<br><br><button class="btn btn-primary" type="submit"><small>Salvar </small><span class="glyphicon glyphicon-repeat"></span></button>
							<a class="btn btn-danger"
								href="mvc?Logica=AbrirAPP"><small>Cancelar</small> 
								<span class="glyphicon glyphicon-remove"></span>
							</a>
					</div>
            	</form>
        </c:forEach>
        </c:if>
        <c:if test="${empty atualizarP }">
			<h4>Adicionar Produto</h4>
				<form action="mvc?Logica=CadastraProduto" method="post" style="margin-left:20px">
                	<div class="input-group">
						Nome:<input type="text" id="nome" name="nome" placeholder="Produto" required>
						Preço R$<input type="text" id="preco" name="preco" placeholder="EX.: 2.98" pattern="[0-9.]+" required>
						<button class="btn btn-primary" type="submit">Adicionar <span class="glyphicon glyphicon-ok-circle"></span></button>
					</div>
            	</form>
        </c:if>
			<br>
		</div>
		<center><h3>Produtos</h3></center>
		<table class="table table-striped table-bordered">
		<thead>
			<tr>
			<tr>
				<th>Nome do produto</th>
				<th>Preço</th>
				<th>Deletar</th>
				<th>Editar</th>
				<th>Fornecedores</th>
			</tr>

		</thead>

		<tbody>

			<c:forEach var="produto" items="${produtos}">
				<tr class="text-center">
					<td>${produto.descricaoPro}</td>
					<td>R$ ${produto.preco}</td>
					
					<td>
						<a class="btn btn-danger"
							href="mvc?Logica=ExcluirProduto&&id=${produto.codigoProduto}">
							<span class="glyphicon glyphicon-trash"></span>
						</a>
					</td>
					<td>
						<a class="btn btn-info"
							href="mvc?Logica=EditarProduto&&id=${produto.codigoProduto}">
							<span class="glyphicon glyphicon-pencil"></span>
						</a>
					</td>
					<td>
						<a class="btn btn-success"
							href="mvc?Logica=VerFornecedores&&id=${produto.codigoProduto}">
							<span class="glyphicon glyphicon-eye-open"></span>
						</a>
					</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
		</div>
		
		<br>
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