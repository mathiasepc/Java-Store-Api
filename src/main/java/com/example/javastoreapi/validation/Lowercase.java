package com.example.javastoreapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Target = where we want to apply this annotation
// It can be added to method, field, constructor, classes osv.
@Target(ElementType.FIELD)
// Where this annotation is applied.
// During runtime
@Retention(RetentionPolicy.RUNTIME)
// our validator
@Constraint(validatedBy = LowercaseValidator.class)
public @interface Lowercase {
    String message() default "Must be lowercase";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
