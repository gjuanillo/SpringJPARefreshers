package com.jeiyuen.relrefreshers.controllers;

import java.util.List;

import com.jeiyuen.relrefreshers.models.SocialUser;
import com.jeiyuen.relrefreshers.services.SocialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialController{

    private SocialService socialService;

    @Autowired
    public SocialController(SocialService theSocialService){
        socialService = theSocialService;
    }

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){

        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){

        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.OK);
    }
    
    @DeleteMapping("social/users/{id}")
    public ResponseEntity<SocialUser> deleteUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(socialService.deleteUser(id), HttpStatus.OK);
    }

}
