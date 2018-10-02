package br.com.indracompany.indrastore.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.indracompany.indrastore.model.Produto;

@Component
public class ProdutoValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nomeProduto", "field.required");
		
		Produto produto = (Produto) target;
		if ( produto.getPreco() == null || produto.getPreco().doubleValue() <= 0 ){
			errors.rejectValue("preco", "field.required");
		}
	}

}
