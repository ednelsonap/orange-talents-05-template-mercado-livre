package br.com.zup.academy.ednelson.mercadolivre.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Long> {

	@PersistenceContext
	private EntityManager em;

	private Class<?> classe;
	private String id;

	@Override
	public void initialize(ExistsId annotation) {
		this.classe = annotation.domainClass();
		this.id = annotation.fieldName();
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		Query query = em.createQuery("select c from " + classe.getName() + " c where c." + id + " = :pId");
		query.setParameter("pId", value);
		
		List<?> resultado = query.getResultList();
		
		return !resultado.isEmpty();
	}

}
