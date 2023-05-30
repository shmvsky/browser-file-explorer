package ru.shmvsky.browserfileexplorer.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RealPathValidator.class)
@Documented
public @interface RealPath {
    String message() default "Invalid directory path";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
