package com.codegym.service.impl;

import com.codegym.model.HealthDeclarationForm;
import com.codegym.repository.IHealthDeclarationRepository;
import com.codegym.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthDeclarationServivceImpl implements IHealthDeclarationService {
    @Autowired
    IHealthDeclarationRepository iHealthDeclarationRepository;

    @Override
    public void saveUpdate(HealthDeclarationForm healthDeclarationForm) {
        iHealthDeclarationRepository.save(healthDeclarationForm);
    }

    @Override
    public HealthDeclarationForm getHealDeclarationForm() {
        return iHealthDeclarationRepository.getHealthDeclarationForm();
    }
}
