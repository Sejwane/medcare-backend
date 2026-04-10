package com.medcare.backend.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdentificationValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidIdentification {

    String message() default "Invalid identification details";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}