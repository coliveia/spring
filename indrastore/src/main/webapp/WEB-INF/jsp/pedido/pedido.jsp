<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Seu Pedido" >

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-6 col-md-offset-3">
				<h4 class="text-center">Pedido 1000123 concluído com sucesso</h4>
			</div>
			<div class="col-xs-12 col-md-6 col-md-offset-3 text-center">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th class="text-center">Produto</th>
							<th class="text-center">Quantidade</th>
							<th class="text-center">Preço Unitário</th>
							<th class="text-center">Preço Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carrinho.listaItem.values()}" var="item">
							<tr>
								<td>${item.produto.nomeProduto}</td>
								<td>${item.quantidade}</td>
								<td>${item.produto.preco}</td>
								<td>${item.totalProduto}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>R$ ${carrinho.totalCompra}</div>
			</div>
		</div>
	</div>
</body>

</tags:pageTemplate>