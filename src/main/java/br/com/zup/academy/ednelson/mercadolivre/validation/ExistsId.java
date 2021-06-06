package br.com.zup.academy.ednelson.mercadolivre.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({FIELD,PARAMETER})
@Retention(RUNTIME)
public @interface ExistsId {

	String message() default "O id não existe";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String value() default "";
    
    Class<?> domainClass();
	
    String fieldName();
}
