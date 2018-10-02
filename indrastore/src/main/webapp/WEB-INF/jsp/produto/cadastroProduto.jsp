<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate titulo="Cadastro de Produtos" >

<jsp:body>
	<div class="alert-warning">${mensagem}</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-9 col-md-10 col-md-offset-1">
				<h3 class="text-center">Cadastro de Produtos</h3>
			</div>
			<div class="col-xs-12 col-md-6 col-md-offset-3">
				<form:form  action="${s:mvcUrl('PC#salvaProduto').build()}" method="POST" modelAttribute="produto">
					<form:hidden path="id"/>
					<div class="form-group">
						<label>Nome do Produto</label>
						<form:input path="nomeProduto" class="form-control" />
						<form:errors path="nomeProduto" cssClass="form-control alert-danger"></form:errors>
					</div>
					<div class="form-group">
						<label>Descrição do Produto</label>
						<form:textarea path="descricaoProduto" class="form-control" ></form:textarea>
					</div>
					<div class="form-group">
						<label>Preço</label>
						<form:input path="preco" class="form-control" />
						<form:errors path="preco" cssClass="form-control alert-danger"></form:errors>
					</div>
					<button type="submit" class="btn btn-default">Salvar</button>
					<a href="${s:mvcUrl('PC#listaProduto').build()}" class="btn btn-default">Cancelar</a>
				</form:form>
			</div>
		</div>
	</div>
</jsp:body>

</tags:pageTemplate>