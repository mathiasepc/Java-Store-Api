package com.example.javastoreapi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ConstraintValidator<What content, What data we want to apply on the content>
public class LowercaseValidator implements ConstraintValidator<Lowercase, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true;

        return value.toLowerCase().equals(value);
    }
}
