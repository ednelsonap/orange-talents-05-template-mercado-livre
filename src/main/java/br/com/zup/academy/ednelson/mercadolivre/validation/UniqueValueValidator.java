package br.com.zup.academy.ednelson.mercadolivre.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

	
	@PersistenceContext 
	private EntityManager em;
	 
	private Class<?> classe;

	private String atributo;
	
	@Override
	public void initialize(UniqueValue annotation) {
		this.classe = annotation.entidade();
		this.atributo = annotation.atributo();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Query query = em.createQuery("select c from " + classe.getName() + " c where c." + atributo + " = :pAtributo");
		query.setParameter("pAtributo", value);
		
		List<?> resultado = query.getResultList();
		
		return resultado.isEmpty();
	}

}
