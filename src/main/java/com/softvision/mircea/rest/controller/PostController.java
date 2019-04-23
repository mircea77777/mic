package com.softvision.mircea.rest.controller;

import com.softvision.mircea.dto.PostDTO;
import com.softvision.mircea.dto.UserDTO;
import com.softvision.mircea.rest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<PostDTO> addPost(HttpSession session, @RequestBody PostDTO postDTO) {
        if (postDTO == null) {
            //aici returnam HTTP 400
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        UserDTO loggedinUserDTO = (UserDTO)session.getAttribute("user");
        Optional<PostDTO> realPostDTO = postService.addPost(loggedinUserDTO, postDTO);
        return new ResponseEntity<>(realPostDTO.get(), HttpStatus.OK);
    }

    //RequestMethod.GET,
    public ResponseEntity<Set<PostDTO>> getOwnPosts(HttpSession session, @RequestBody Date date){

        return null;
    }




}
