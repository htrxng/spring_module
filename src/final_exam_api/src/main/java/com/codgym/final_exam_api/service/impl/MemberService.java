package com.codgym.final_exam_api.service.impl;

import com.codgym.final_exam_api.model.travel_tour_system.Member;
import com.codgym.final_exam_api.repository.travel_tour_system_repo.IMemberRepository;
import com.codgym.final_exam_api.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements IMemberService {
    @Autowired
    private IMemberRepository memberRepository;

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
