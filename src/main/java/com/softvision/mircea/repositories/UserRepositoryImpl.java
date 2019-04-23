package com.softvision.mircea.repositories;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.softvision.mircea.model.Post;
import com.softvision.mircea.model.Relationship;
import com.softvision.mircea.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Set<User> users = new HashSet<>();

    private Set<Relationship> relations = new HashSet<>();

    @Override
    public Optional<User> findById(long id){

            for(User user : users){
                if (user.getId() == id) {
                    return Optional.of(user);
                }
                
            }
            return Optional.empty();
    }

    // custom methods
    @Override
    public Optional<User> findByUserName(String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByFirstName(String firstName) {
        for (User user : users) {
            if (user.getFirstName().equals(firstName)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLastName(String lastName) {
        for (User user : users) {
            if (user.getLastName().equals(lastName)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findLoginUser(String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getUserName().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public Set<User> getUsers() {
        return null;
    }




    // CRUD methods - to be deleted when integrated a database
    @Override
    public <S extends User> S save(S s) {
        users.add(s);
        return s;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return users;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> iterable) {
        return users;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Set<Post>> getOwnPosts(User currentUser, Date date){
    	return Optional.of(currentUser.getPosts(date));
    }

	@Override
	public User follow(User currentUser, User userToFollow) {
		currentUser.addUserToFollow(userToFollow);
		relations.add(new Relationship(currentUser, userToFollow, new Date()));
		return userToFollow;
	}

	@Override
	public Optional<Set<Post>> getFeed(User currentUser) {
		Set<Post> allPosts = new HashSet<>();
		for (User user : currentUser.getUsersToFollow()) {
			Date dateWhenFollowingBegins = getStartDateToFollow(currentUser, user);
			
			allPosts.addAll(user.getPosts(dateWhenFollowingBegins));
		}
		return Optional.of(allPosts);		
	}

	private Date getStartDateToFollow(User currentUser, User userToFollow) {
		for (Relationship relationship : relations) {
			if (relationship.getCurrentUser().equals(currentUser) && relationship.getUserToFollow().equals(userToFollow)) {
				return relationship.getDateWhenFollowingBegins();
			}
		}
		return null;
	}
	
	
	@Override
	public Set<Relationship> getRelations() {
		return relations;
	}
	@Override
	public void setRelations(Set<Relationship> relations) {
		this.relations = relations;
	}

	
}
