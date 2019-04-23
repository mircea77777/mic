package com.softvision.mircea.repositories;

import com.softvision.mircea.model.Post;
import com.softvision.mircea.model.User;

import java.util.Date;
import java.util.List;

public interface PostRepository {

    public Post addPost(User user, Post post);

    public List<Post> getOwnPosts(User user, Date date);

    public List<Post> getFeed(User user);

}
