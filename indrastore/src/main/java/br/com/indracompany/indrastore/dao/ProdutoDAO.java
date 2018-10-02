package br.com.indracompany.indrastore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.indracompany.indrastore.model.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvaProduto(Produto produto){
		entityManager.persist(produto);
	}

	public List<Produto> buscaListaProduto(){
		List<Produto> listaProduto = new ArrayList<Produto>();

		listaProduto = entityManager.createQuery("Select p from Produto p", Produto.class).getResultList();

		return listaProduto;
	}

	public Produto buscaProdutoPorID(Integer id){
		Produto produto = entityManager.createQuery("Select p from Produto p where p.id = :id", Produto.class)
			.setParameter("id", id).getSingleResult();
		
		return produto;
	}

	public void editaProduto(Produto produto){
		entityManager.merge(produto);
	}

	public Produto buscaProdutoPorNome(String nomeProduto){
		Produto produto = new Produto();

		List<Produto> listaProdutos = entityManager.createQuery("Select p from Produto p where p.nomeProduto = :nomeProduto", Produto.class)
				.setParameter("nomeProduto", nomeProduto).getResultList();

		if (listaProdutos != null && listaProdutos.size() > 0){
			produto = listaProdutos.get(0);
		}

		return produto;
	}

	public void apagaProduto(Integer id){
		Produto produto = entityManager.find(Produto.class, id);
		entityManager.remove(produto);
	}

	public List<Produto> buscaListaProdutoPorNome(String nome){
		List<Produto> listaProduto = new ArrayList<Produto>();
	
		listaProduto = entityManager.createQuery("Select p from Produto p where p.nomeProduto like :nome"
					, Produto.class).setParameter("nome", "%" + nome + "%").getResultList();

		return listaProduto;
	}
}
