package br.com.indracompany.indrastore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.indracompany.indrastore.ProdutoService;
import br.com.indracompany.indrastore.model.Produto;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class HomeController {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@Cacheable(value = "produtosHome")
	public ModelAndView home(){
		ModelAndView view = new ModelAndView("home");
		List<Produto> listaProduto = produtoService.buscaListaProduto();
		view.addObject("listaProduto", listaProduto);
		return view;
	}

}
