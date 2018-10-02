package br.com.indracompany.indrastore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.indracompany.indrastore.dao.ProdutoDAO;
import br.com.indracompany.indrastore.model.Produto;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDAO produtoDAO;

	@Transactional
	public void salvaProduto(Produto produto) throws BusinessException{
		Produto produtoExistente = produtoDAO.buscaProdutoPorNome(produto.getNomeProduto());

		if ( produto.getId() != null ){

			if ( produtoExistente != null &&
					(produtoExistente.getId() != null &&
						produtoExistente.getId().equals(produto.getId())) ||
					(produtoExistente.getId() == null)){
				produtoExistente.setId(produto.getId());
				produtoExistente.setNomeProduto(produto.getNomeProduto());
				produtoExistente.setDescricaoProduto(produto.getDescricaoProduto());
				produtoExistente.setPreco(produto.getPreco());
				produtoDAO.editaProduto(produtoExistente);
			} else {
				throw new BusinessException("Já existe um produto com este nome!");
			}
		} else {
			if ( produtoExistente != null &&
				produtoExistente.getId() != null &&
					produtoExistente.getId() > 0 ) {
				throw new BusinessException("Já existe um produto com este nome!");
			} else {
				produtoDAO.salvaProduto(produto);
			}
		}
	}

	public List<Produto> buscaListaProduto(){
		return produtoDAO.buscaListaProduto();
	}

	public Produto buscaProdutoPorId(Integer id){
		return produtoDAO.buscaProdutoPorID(id);
	}

	@Transactional
	public void apagaProduto(Integer id){
		produtoDAO.apagaProduto(id);
	}

	public List<Produto> buscaListaProdutoPorNome(String nome){
		return produtoDAO.buscaListaProdutoPorNome(nome);
	}
}
