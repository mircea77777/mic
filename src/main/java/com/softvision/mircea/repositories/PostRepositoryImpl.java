package com.softvision.mircea.repositories;

import com.softvision.mircea.model.Post;
import com.softvision.mircea.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class PostRepositoryImpl implements PostRepository{

    @Autowired
    UserRepository userRepository;

    @Override
    public Post addPost(User user, Post post) {

        Set<User> users = userRepository.getUsers();
        for(User u : users) {
            if (user.getUserName().equals(u.getUserName())) {
              //  u.addPost(post);
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> getOwnPosts(User user, Date date) {
        // TODO Auto-generated method stub
        // return u.getPosts(); + filtrul
        return null;
    }

    @Override
    public List<Post> getFeed(User user) {
        // TODO Auto-generated method stub
        return null;
    }


}
