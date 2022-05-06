package com.codegym.service.impl;

import com.codegym.model.EmailBox;
import com.codegym.service.IEmailBoxService;
import org.springframework.stereotype.Service;

@Service
public class EmailBoxServiceImpl implements IEmailBoxService {
    private static EmailBox mainEmailBox = new EmailBox();

    @Override
    public void update(EmailBox emailBox) {
        mainEmailBox.setLanguages(emailBox.getLanguages());
        mainEmailBox.setPageSize(emailBox.getPageSize());
        mainEmailBox.setSpamsFilter(emailBox.getSpamsFilter());
        mainEmailBox.setSignature(emailBox.getSignature());
    }
}
