package com.jeiyuen.relrefreshers.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SocialGroup{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "groups")
    private Set<SocialUser> socialUsers = new HashSet<>();

    public SocialGroup() {
    }
    public SocialGroup(Long id, Set<SocialUser> socialUsers) {
        this.id = id;
        this.socialUsers = socialUsers;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Set<SocialUser> getSocialUsers() {
        return socialUsers;
    }
    public void setSocialUsers(Set<SocialUser> socialUsers) {
        this.socialUsers = socialUsers;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

}

