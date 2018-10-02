package br.com.indracompany.indrastore.model;

import java.math.BigDecimal;

public class CarrinhoItem {

	private Produto produto;
	private Integer quantidade;

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getTotalProduto(){
		BigDecimal total = new BigDecimal(0);

		total = produto.getPreco().multiply(new BigDecimal(quantidade));

		return total;
	}
}
