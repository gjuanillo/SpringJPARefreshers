package com.jeiyuen.relrefreshers;

import com.jeiyuen.relrefreshers.models.Post;
import com.jeiyuen.relrefreshers.models.SocialGroup;
import com.jeiyuen.relrefreshers.models.SocialProfile;
import com.jeiyuen.relrefreshers.models.SocialUser;
import com.jeiyuen.relrefreshers.repositories.PostRepository;
import com.jeiyuen.relrefreshers.repositories.SocialGroupRepository;
import com.jeiyuen.relrefreshers.repositories.SocialProfileRepository;
import com.jeiyuen.relrefreshers.repositories.SocialUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final SocialUserRepository userRepository;
    private final SocialGroupRepository groupRepository;
    private final SocialProfileRepository profileRepository;
    private final PostRepository postRepository;

    @Autowired
    public DataInitializer(SocialUserRepository userRepository, SocialGroupRepository groupRepository,
            SocialProfileRepository profileRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.profileRepository = profileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);
            groupRepository.save(group1);
            groupRepository.save(group2);

            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            profile1.setSocialUser(user1);
            profile2.setSocialUser(user2);
            profile3.setSocialUser(user3);

            profileRepository.save(profile1);
            profileRepository.save(profile2);
            profileRepository.save(profile3);
        };
    }

}
