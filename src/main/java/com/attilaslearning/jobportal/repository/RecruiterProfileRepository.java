package com.attilaslearning.jobportal.repository;

import com.attilaslearning.jobportal.entity.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterProfileRepository  extends JpaRepository<RecruiterProfile, Integer> {
}