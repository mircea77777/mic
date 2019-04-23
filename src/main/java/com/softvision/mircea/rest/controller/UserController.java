package com.softvision.mircea.rest.controller;


import com.softvision.mircea.dto.UserDTO;
import com.softvision.mircea.exceptions.UserNotFoundException;
import com.softvision.mircea.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = "application/json")
    public Set<UserDTO> retriveUsers() {
        return this.userService.retrieveUsers();
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        if (userDTO == null) {
            //aici returnam HTTP 400
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        UserDTO registeredUser = userService.registerUser(userDTO);
        return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/searchByFirstName/{firstName}",
            method = RequestMethod.GET,
            produces = "application/json")
    public UserDTO searchByUserName(@PathVariable("firstName") String firstName) throws UserNotFoundException {
        if (firstName == null || firstName.trim().equals("")) {
            // returnezi HTTP 400
        }
        UserDTO foundUser = userService.searchByUsername(firstName);
        return foundUser;
    }


    @RequestMapping(
            value = "/searchByLastName/{lastName}",
            method = RequestMethod.GET,
            produces = "application/json")
    public UserDTO searchByLastName(@PathVariable("lastName") String lastName) throws UserNotFoundException {
        return userService.searchByLastName(lastName);
    }


    @RequestMapping(
            value = "searchByUserName/{userName}",
            method = RequestMethod.GET,
            produces = "application/json")
    public UserDTO searchByUsername(@PathVariable("userName") String userName) throws UserNotFoundException {
        return userService.searchByUsername(userName);
    }


    /**
     * @return if user and pass are valid return User
     */
    @RequestMapping(
            value = "/login/{userName , password}",
            method = RequestMethod.GET,
            produces = "aplication/json")
    public UserDTO loginUser(HttpSession session, String userName, String password) throws UserNotFoundException {
        UserDTO userDTO = userService.loginUser(userName, password);
        session.setAttribute("user", userDTO);
        return userDTO;
    }


    @RequestMapping(
            value = "/follow",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<UserDTO> followUser(HttpSession session, @RequestBody UserDTO userDTOToFollow) {
        if (userDTOToFollow == null) {
            //aici returnam HTTP 400
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        UserDTO loggedinUserDTO = (UserDTO)session.getAttribute("user");
        UserDTO realUserDTOToFollow = userService.follow(loggedinUserDTO, userDTOToFollow);
        return new ResponseEntity<>(realUserDTOToFollow, HttpStatus.OK);
    }














}
