package com.codgym.final_exam_api.repository.travel_tour_system_repo;

import com.codgym.final_exam_api.model.travel_tour_system.RegisterForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterFormRepository extends JpaRepository<RegisterForm,Integer> {
}
