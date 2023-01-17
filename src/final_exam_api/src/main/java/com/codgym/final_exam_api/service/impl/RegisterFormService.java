package com.codgym.final_exam_api.service.impl;

import com.codgym.final_exam_api.repository.travel_tour_system_repo.IRegisterFormRepository;
import com.codgym.final_exam_api.service.IRegisterFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterFormService implements IRegisterFormService {
    @Autowired
    private IRegisterFormRepository registerFormRepository;
}
