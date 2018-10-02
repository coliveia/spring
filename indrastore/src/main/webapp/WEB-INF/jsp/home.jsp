<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Nossos Produtos" >

	<jsp:body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-9">
					<h3 class="text-center">Nossos Produtos</h3>
				</div>
				<c:forEach items="${listaProduto}" var="produto">
					<div class="col-xs-12 col-md-4 thumbnail text-center">
							<figure>
								<img alt="${produto.nomeProduto}" height="200" width="200" src="resources/img/produto.jpg">
								<div>
									<h4>${produto.nomeProduto}</h4>
									<p>${produto.descricaoProduto}</p>
								</div>
							</figure>
							<div class="btn-group">
								<a href="#" class="btn btn-default">${produto.preco}</a>
								<a href="${s:mvcUrl('CC#adicionaProduto').arg(0, produto.id).build()}" class="btn btn-primary">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Comprar
								</a>
							</div>
					</div>				
				</c:forEach>
			</div>
		</div>
	</jsp:body>

</tags:pageTemplate>

