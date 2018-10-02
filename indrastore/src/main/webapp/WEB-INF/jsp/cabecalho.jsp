<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header" >
			<a href="${s:mvcUrl('HC#home').build()}" class="navbar-brand">Indra Store</a>
			<button type="button" data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle">Menu</button>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						Produtos
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="${s:mvcUrl('PC#cadastroProduto').build()}">Novo Produto</a>
						</li>
						<li>
							<a href="${s:mvcUrl('PC#listaProduto').build()}">Lista de Produtos</a>
						</li>
					</ul>
				</li>
			</ul>
			<ul class="navbar-nav nav navbar-right">
				<li>
					<a href="${s:mvcUrl('CC#carrinho').build()}">Carrinho (${carrinho.listaItem.size()})</a>
				</li>
			</ul>
		</div>
	</nav>
</header>