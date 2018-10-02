package br.com.indracompany.indrastore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.indracompany.indrastore.ProdutoService;
import br.com.indracompany.indrastore.model.Carrinho;
import br.com.indracompany.indrastore.model.Produto;

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/carrinho")
public class CarrinhoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private Carrinho carrinho;

	@RequestMapping(value="/adicionaProduto/{id}", method=RequestMethod.GET)
	public ModelAndView adicionaProduto(@PathVariable("id") Integer id){
		ModelAndView view = new ModelAndView("carrinho/carrinho");

		Produto produto = produtoService.buscaProdutoPorId(id);
		carrinho.adicionaProduto(produto);

//		view.addObject("carrinho", carrinho);
		return view;
	}

	@RequestMapping(value = "/carrinho", method = RequestMethod.GET)
	public ModelAndView carrinho(){
		ModelAndView view = new ModelAndView("carrinho/carrinho");
//		view.addObject("carrinho", carrinho);
		return view;
	}

	@RequestMapping(value="/finalizaCompra", method = RequestMethod.POST)
	public ModelAndView finalizaCompra(Carrinho carrinhoForm){
		ModelAndView view = new ModelAndView("pedido/pedido");

		Carrinho carrinhoFinalizado = new Carrinho(); 
	    carrinhoFinalizado.copiaItens(carrinho);
	    carrinhoFinalizado.atualizaQuantidade(carrinhoForm);
		carrinho.apagaItens();

		view.addObject("carrinho", carrinhoFinalizado);

		return view;
	}
}
