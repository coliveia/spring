package br.com.indracompany.indrastore.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.indracompany.indrastore.ProdutoService;
import br.com.indracompany.indrastore.model.Produto;
import br.com.indracompany.indrastore.ws.generated.ListaProdutosRequest;
import br.com.indracompany.indrastore.ws.generated.ListaProdutosResponse;
import br.com.indracompany.indrastore.ws.generated.ProdutoTO;

@Endpoint
public class ConsultaProdutosEndPoint {

	@Autowired
	private ProdutoService produtoService;
	
	@PayloadRoot(localPart = "ListaProdutosRequest", namespace="http://ws.indrastore.indracompany.com.br/generated")
	@ResponsePayload
	public ListaProdutosResponse consultaListaProdutos(@RequestPayload ListaProdutosRequest request){
		ListaProdutosResponse response = new ListaProdutosResponse();

		String nome = request.getNome();
	
		List<Produto> listaProduto = produtoService.buscaListaProdutoPorNome(nome);

		for (Produto produto : listaProduto){
			response.getProdutoTO().add(criaProdutoTO(produto));
		}

		return response;
	}

	private ProdutoTO criaProdutoTO(Produto produto) {
		ProdutoTO produtoTO = new ProdutoTO();

		produtoTO.setNomeProduto(produto.getNomeProduto());
		produtoTO.setDescricaoProduto(produto.getDescricaoProduto());
		produtoTO.setPreco(produto.getPreco());

		return produtoTO;
	}

}
 