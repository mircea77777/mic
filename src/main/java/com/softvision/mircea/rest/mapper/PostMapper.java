package com.softvision.mircea.rest.mapper;

import com.softvision.mircea.dto.PostDTO;
import com.softvision.mircea.model.Post;
import com.softvision.mircea.model.User;


public class PostMapper {


    public static PostDTO convertToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        PostDTO.setId(post.getId());
        PostDTO.setUser(post.getUser());
        PostDTO.setText(post.getText());
        PostDTO.setDateCreated(post.getDateCreated());

        return postDTO;
    }

    public static Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setId(PostDTO.getId());
        post.setUser(PostDTO.getUser());
        post.setText(PostDTO.getText);
        post.setDateCreated(PostDTO.getDateCreated());



        return post;
    }






}
