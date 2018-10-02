<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Lista de Produtos" >

<jsp:body>
	<div class="container-fluid">
		<div class="row">
			<div class="alert-danger">${mensagem}</div>
			<div class="col-xs-12 col-sm-9 col-md-10 col-md-offset-1">
				<h3 class="text-center">Lista de Produtos</h3>
			</div>
			<div class="col-xs-12 col-md-6 col-md-offset-3 text-center">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="text-center">Nome do Produto</th>
							<th class="text-center">Descrição</th>
							<th class="text-center">Preço</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaProduto}" var="produto">
							<tr>
								<td>${produto.nomeProduto}</td>
								<td>${produto.descricaoProduto}</td>
								<td>${produto.preco}</td>
								<td><a href="${s:mvcUrl('PC#editaProduto').arg(0, produto.id).build()}"> <span class="glyphicon glyphicon-edit"></span> </a>
									<a href="${s:mvcUrl('PC#apagaProduto').arg(0, produto.id).build()}"> <span class="glyphicon glyphicon-trash"></span> </a> </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</jsp:body>

</tags:pageTemplate>