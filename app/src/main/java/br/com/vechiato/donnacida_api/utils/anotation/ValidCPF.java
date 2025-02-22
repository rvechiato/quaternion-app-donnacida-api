package br.com.vechiato.donnacida_api.utils.anotation;

import br.com.vechiato.donnacida_api.utils.CPFValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CPFValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCPF {
    String message() default "Invalid number.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}