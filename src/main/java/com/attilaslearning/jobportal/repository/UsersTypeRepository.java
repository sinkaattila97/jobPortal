package com.attilaslearning.jobportal.repository;

import com.attilaslearning.jobportal.entity.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTypeRepository extends JpaRepository<UsersType, Integer> { //this is basically the roles of the users

}
