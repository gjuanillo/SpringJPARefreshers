package com.jeiyuen.relrefreshers.services;

import java.util.List;

import com.jeiyuen.relrefreshers.models.SocialUser;
import com.jeiyuen.relrefreshers.repositories.SocialUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialService{

    SocialUserRepository socialUserRepository;

    @Autowired
    public SocialService(SocialUserRepository theSocialUserRepository){
        socialUserRepository = theSocialUserRepository;
    }


    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();

    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

}
