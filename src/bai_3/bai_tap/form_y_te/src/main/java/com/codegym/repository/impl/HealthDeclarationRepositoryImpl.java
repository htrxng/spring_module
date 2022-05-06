package com.codegym.repository.impl;

import com.codegym.model.HealthDeclarationForm;
import com.codegym.repository.IHealthDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HealthDeclarationRepositoryImpl implements IHealthDeclarationRepository {

    HealthDeclarationForm healthDeclarationForm = null;


    public void setHealthDeclarationForm(HealthDeclarationForm healthDeclarationForm) {
        this.healthDeclarationForm = healthDeclarationForm;
    }

    @Override
    public void save(HealthDeclarationForm healthDeclarationForm) {
        this.setHealthDeclarationForm(healthDeclarationForm);
    }

    @Override
    public HealthDeclarationForm getHealthDeclarationForm() {
        return healthDeclarationForm;
    }
}
