package com.softvision.mircea.rest.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.softvision.mircea.dto.PostDTO;
import com.softvision.mircea.dto.UserDTO;
import com.softvision.mircea.model.Post;
import com.softvision.mircea.model.Relationship;
import com.softvision.mircea.model.User;
import com.softvision.mircea.repositories.PostRepository;
import com.softvision.mircea.rest.mapper.PostMapper;
import com.softvision.mircea.rest.mapper.UserMapper;

public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    
    @Override
    public Optional<PostDTO> addPost(UserDTO userDTO, PostDTO postDTO) {

        User user = UserMapper.convertToEntity(userDTO);
        Post post = PostMapper.convertToEntity(postDTO);
        Post returnedPost = postRepository.addPost(user, post);
        if (returnedPost == null) {

            return Optional.empty();
        }
        return Optional.of(PostMapper.convertToDTO(returnedPost));
    }
        
	

    @Override
    public List<PostDTO> getOwnPosts(UserDTO userDTO, Date date) {

        return null;

    }

    @Override
    public List<PostDTO> getFeed(UserDTO userDTO) {

        return null;

    }


}







