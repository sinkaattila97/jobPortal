package com.attilaslearning.jobportal.repository;

import com.attilaslearning.jobportal.entity.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
}
