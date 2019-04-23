package com.softvision.mircea.rest.service;

import com.softvision.mircea.dto.UserDTO;
import com.softvision.mircea.exceptions.UserNotFoundException;
import com.softvision.mircea.model.Relationship;
import com.softvision.mircea.model.User;
import com.softvision.mircea.repositories.UserRepository;
import com.softvision.mircea.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



	@Override
    public UserDTO registerUser(UserDTO userDTO) {
        userRepository.save(UserMapper.convertToEntity(userDTO));
        return userDTO;
    }


    public Set<UserDTO> retrieveUsers() {
        Set<User> foundUsers = (Set<User>) userRepository.findAll();
        Set<UserDTO> userDTOs = new HashSet<>();
        for (User user : foundUsers) {
            userDTOs.add(UserMapper.convertToDTO(user));
        }
        return userDTOs;

        // JAVA 8 STREAM example
        //return ((Set<User>) userRepository.findAll()).stream().map(UserMapper::convertToDTO).collect(Collectors.toSet());
    }


    /*public boolean isUnique(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(username)) {
                return false;
            }
        }
        return true;
    }*/


    @Override
    public UserDTO searchByUsername(String userName) {
        Optional<User> foundUser = userRepository.findByLastName(userName);
        if (foundUser.isPresent()) {
            return UserMapper.convertToDTO(foundUser.get());
        }
        throw new UserNotFoundException("User with userName: " + userName + " was not found.");
    }


    @Override
    public UserDTO searchByFirstName(String firstName) {
        Optional<User> foundUser = userRepository.findByFirstName(firstName);
        if (foundUser.isPresent()) {
            return UserMapper.convertToDTO(foundUser.get());
        }
        throw new UserNotFoundException("User with firstName: " + firstName + " was not found.");
    }

    @Override
    public UserDTO searchByLastName(String lastName) {
        Optional<User> foundUser = userRepository.findByLastName(lastName);
        if (foundUser.isPresent()) {
            return UserMapper.convertToDTO(foundUser.get());
        }
        throw new UserNotFoundException("User with lastName: " + lastName + " was not found.");
    }


    @Override
    public UserDTO loginUser(String userName, String password) {


        Optional<User> logUser = userRepository.findLoginUser(userName, password);
        if (logUser.isPresent()) {
            return UserMapper.convertToDTO(logUser.get());
        }
            throw new UserNotFoundException("User is login:" +userName+password+ "");
        }







        // return null;


   /*  public User followOtherUser(String userName) {
        User foundMatch = searchByUserName(userName);
        if(foundMatch.equals(userName)) {
            folowersList.add(foundMatch);
            return foundMatch;
        }
        return null;
    }

    public List<User> getFolowersList() {
        return folowersList;
    }  */


    @Override
    public UserDTO follow(UserDTO currentUserDTO,UserDTO userDTOToFollow) {
        User userToFollow = userRepository.follow(UserMapper.convertToEntity(currentUserDTO), UserMapper.convertToEntity(userDTOToFollow));
        return UserMapper.convertToDTO(userToFollow);
    }

    @Override
    public void unfollow(UserDTO userDTO) {

    }

  
    @Override
    public void unregister(UserDTO userDTO) {

    }
    

}
