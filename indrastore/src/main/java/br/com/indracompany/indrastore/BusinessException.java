package br.com.indracompany.indrastore;

public class BusinessException extends Exception{

	private static final long serialVersionUID = -5103253887469690906L;

	public BusinessException(String message){
		super(message);
	}
}
