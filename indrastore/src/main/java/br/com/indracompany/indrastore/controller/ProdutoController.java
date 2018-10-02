package br.com.indracompany.indrastore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.indracompany.indrastore.BusinessException;
import br.com.indracompany.indrastore.ProdutoService;
import br.com.indracompany.indrastore.model.Produto;
import br.com.indracompany.indrastore.validation.ProdutoValidator;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ProdutoValidator produtoValidator;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		dataBinder.addValidators(produtoValidator);
	}

	@RequestMapping(value="/novoProduto", method = RequestMethod.GET)
	public ModelAndView cadastroProduto(Produto produto){
		ModelAndView view = new ModelAndView("produto/cadastroProduto");
		view.addObject("produto", produto);
		return view;
	}

	@RequestMapping(value="/novoProduto", method = RequestMethod.POST)
	@CacheEvict(value = "produtosHome", allEntries = true)
	public ModelAndView salvaProduto(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
		ModelAndView view = new ModelAndView();

		if (result.hasErrors()){
			return cadastroProduto(produto);
		}

		try {
			produtoService.salvaProduto(produto);
			redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado/atualizado com sucesso.");
			view.setViewName("redirect:/produto/listaProduto");
		} catch (BusinessException e) {
			view.addObject("mensagem", e.getMessage());
			view.addObject("produto", produto);
			view.setViewName("produto/cadastroProduto");
		}
		return view;
	}

	@RequestMapping(value="/listaProduto", method = RequestMethod.GET)
	public ModelAndView listaProduto(){
		ModelAndView view = new ModelAndView("produto/listaProduto");
		List<Produto> listaProduto = produtoService.buscaListaProduto();
		view.addObject("listaProduto", listaProduto);
		return view;
	}

	@RequestMapping(value="/editaProduto/{id}", method = RequestMethod.GET)
	public ModelAndView editaProduto(@PathVariable("id") Integer id){
		ModelAndView view = new ModelAndView("produto/cadastroProduto");

		Produto produto = produtoService.buscaProdutoPorId(id);
		view.addObject("produto", produto);

		return view;
	}

	@RequestMapping(value="/apagaProduto/{id}", method = RequestMethod.GET)
	public ModelAndView apagaProduto(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
		ModelAndView view = new ModelAndView("redirect:/produto/listaProduto");
	
		produtoService.apagaProduto(id);
		redirectAttributes.addFlashAttribute("mensagem", "Produto apagado com sucesso.");

		return view;
	}

//	@RequestMapping(value = "/listaProdutoJson", method=RequestMethod.GET)
//	@ResponseBody
//	public List<Produto> listaProdutosJson(){
//		List<Produto> listaProduto = produtoService.buscaListaProduto();
//
//		return listaProduto;
//	}
}
