package br.com.indracompany.indrastore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Carrinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9109468008480083306L;

	private Map<Integer, CarrinhoItem> listaItem = new LinkedHashMap<Integer, CarrinhoItem>(0);

	public void adicionaProduto(Produto produto) {
		CarrinhoItem carrinhoItem = new CarrinhoItem();
		boolean temItem = false;

		for (CarrinhoItem item : listaItem.values()) {
			if ( item.getProduto().equals(produto) ){
				item.setQuantidade(item.getQuantidade() + 1);
				temItem = true;
				break;
			}
		}

		if (!temItem) {
			carrinhoItem.setProduto(produto);
			carrinhoItem.setQuantidade(1);
			listaItem.put(listaItem.size(), carrinhoItem);
		}
	}

	public Map<Integer, CarrinhoItem> getListaItem() {
		return listaItem;
	}

	public void setListaItem(Map<Integer, CarrinhoItem> listaItem) {
		this.listaItem = listaItem;
	}

	public void copiaItens(Carrinho carrinho) {
		listaItem.putAll(carrinho.getListaItem());
	}

	public void apagaItens() {
		listaItem.clear();
	}

	public BigDecimal getTotalCompra(){
		BigDecimal totalCompra = new BigDecimal(0);

		for (CarrinhoItem item : listaItem.values()) {
			totalCompra = totalCompra.add(item.getTotalProduto());
		}

		return totalCompra;
	}

	public void atualizaQuantidade(Carrinho carrinho){
		for (int i = 0; i < listaItem.size(); i++){
			listaItem.get(i).setQuantidade(carrinho.getListaItem().get(i).getQuantidade());
		}
	}
	
}
