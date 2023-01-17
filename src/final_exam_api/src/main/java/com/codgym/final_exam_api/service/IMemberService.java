package com.codgym.final_exam_api.service;

import com.codgym.final_exam_api.model.travel_tour_system.Member;

import java.util.List;

public interface IMemberService {
    List<Member> findAll();
}
