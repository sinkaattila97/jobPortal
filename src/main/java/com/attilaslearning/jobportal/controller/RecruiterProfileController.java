package com.attilaslearning.jobportal.controller;

import com.attilaslearning.jobportal.entity.RecruiterProfile;
import com.attilaslearning.jobportal.entity.Users;
import com.attilaslearning.jobportal.repository.UsersRepository;
import com.attilaslearning.jobportal.services.RecruiterProfileService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {

    private final UsersRepository usersRepository;
    public final RecruiterProfileService recruiterProfileService;

    public RecruiterProfileController(UsersRepository usersRepository, RecruiterProfileService recruiterProfileService) {
        this.usersRepository = usersRepository;
        this.recruiterProfileService = recruiterProfileService;
    }


    @GetMapping("/")
    public String recruiterProfile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String currentUserName = auth.getName();
            Users users = usersRepository.findByEmail(currentUserName).
                    orElseThrow(() -> new UsernameNotFoundException("User not found"));
            Optional<RecruiterProfile> recruiterProfiler = recruiterProfileService.getOne(users.getUserId());

            if (recruiterProfiler.isEmpty()) {
                model.addAttribute("profile", recruiterProfiler.get());
            }

        }
        return "recruiter-profile";
    }
}
