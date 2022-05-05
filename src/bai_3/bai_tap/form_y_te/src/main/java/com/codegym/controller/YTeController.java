package com.codegym.controller;

import com.codegym.service.IYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class YTeController {
    @Autowired
    IYTeService iyTeService;
}