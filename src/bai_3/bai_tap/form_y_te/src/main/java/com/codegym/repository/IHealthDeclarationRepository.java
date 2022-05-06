package com.codegym.repository;

import com.codegym.model.HealthDeclarationForm;

public interface IHealthDeclarationRepository {
    void save(HealthDeclarationForm healthDeclarationForm);
    HealthDeclarationForm getHealthDeclarationForm();
}
