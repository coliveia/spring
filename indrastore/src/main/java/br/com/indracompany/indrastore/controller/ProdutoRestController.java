package br.com.indracompany.indrastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.indracompany.indrastore.BusinessException;
import br.com.indracompany.indrastore.ProdutoService;
import br.com.indracompany.indrastore.model.Produto;

@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoRestController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(method = RequestMethod.POST)
	public void novoProduto(@RequestBody Produto produto) throws BusinessException{
		produtoService.salvaProduto(produto);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void atualizaProduto(@RequestBody Produto produto) throws BusinessException{
		produtoService.salvaProduto(produto);
	}

	@RequestMapping(value = "/{idProduto}", method = RequestMethod.DELETE)
	public void apagaProduto(@PathVariable Integer idProduto){
		produtoService.apagaProduto(idProduto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produto buscaProdutoPorId(@PathVariable Integer id){
		Produto produto = produtoService.buscaProdutoPorId(id);
		return produto;
	}
}
