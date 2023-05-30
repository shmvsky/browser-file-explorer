package ru.shmvsky.browserfileexplorer.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.io.IOException;
import java.nio.file.Paths;

public class RealPathValidator implements ConstraintValidator<RealPath, String> {

    @Override
    public void initialize(RealPath constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Paths.get(s).toRealPath();
        } catch (IOException | SecurityException e) {
            return false;
        }
        return true;
    }
}
