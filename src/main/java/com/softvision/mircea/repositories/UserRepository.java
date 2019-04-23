package com.softvision.mircea.repositories;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softvision.mircea.model.Post;
import com.softvision.mircea.model.Relationship;
import com.softvision.mircea.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public Set<User> getUsers();

	Optional<User> findById(long id);
	
	Optional<User> findByUserName(String userName);

	Optional<User> findByFirstName(String firstName);

	Optional<User> findByLastName(String lastName);

	Optional<User> findLoginUser(String userName, String password);

	User follow(User follower, User following);

	Optional<Set<Post>> getOwnPosts(User currentUser, Date date);

	Optional<Set<Post>> getFeed(User currentUser);

	Set<Relationship> getRelations();

	void setRelations(Set<Relationship> relations);

}
