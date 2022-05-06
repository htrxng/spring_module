package com.codegym.service;

import com.codegym.model.HealthDeclarationForm;

public interface IHealthDeclarationService {
    void saveUpdate(HealthDeclarationForm healthDeclarationForm);

    HealthDeclarationForm getHealDeclarationForm();
}
