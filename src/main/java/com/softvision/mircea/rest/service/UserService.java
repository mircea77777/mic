package com.softvision.mircea.rest.service;

import com.softvision.mircea.dto.UserDTO;
import com.softvision.mircea.model.Relationship;

import java.util.Set;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO);

    UserDTO searchByUsername(String username);

    UserDTO searchByFirstName(String firstName);

    UserDTO searchByLastName(String lastName);

    UserDTO  follow(UserDTO userDTO, UserDTO userDTOFollowing);

    void unfollow(UserDTO userDTO);

    void unregister(UserDTO userDTO);

    Set<UserDTO> retrieveUsers();

    UserDTO loginUser(String userName, String password);

	
}
