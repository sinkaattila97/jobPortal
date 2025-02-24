package com.attilaslearning.jobportal.services;

import com.attilaslearning.jobportal.entity.UsersType;
import com.attilaslearning.jobportal.repository.UsersTypeRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsersTypeService {

    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll() {
        return usersTypeRepository.findAll();
    }
}