<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Lista de Produtos" >

<jsp:body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-10 col-md-offset-1">
				<h2 class="text-center">Sua Compra</h2>
			</div>
			<div class="col-xs-12 col-md-6 col-md-offset-3 text-center">
				<form:form action="${s:mvcUrl('CC#finalizaCompra').build()}" modelAttribute="carrinho">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th class="text-center">Produto</th>
								<th class="text-center">Quantidade</th>
								<th class="text-center">Preço</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${carrinho.listaItem.values()}" var="item" varStatus="status">
								<tr>
									<td>${item.produto.nomeProduto}</td>
									<td> <form:input path="listaItem[${status.index}].quantidade" class="form-control" /></td>
									<td>${item.produto.preco}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<button type="submit" class="btn btn-default">Finalizar Compra</button>
				</form:form>
			</div>
		</div>
	</div>
</jsp:body>
</tags:pageTemplate>