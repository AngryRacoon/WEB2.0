package org.example.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.repositories.BrandRepository;

public class UniqueBrandNameValidator implements ConstraintValidator<UniqueBrandName, String> {
    private final BrandRepository brandRepository;

    public UniqueBrandNameValidator(BrandRepository companyRepository) {
        this.brandRepository = companyRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return brandRepository.findByName(value).isEmpty();
    }
}
