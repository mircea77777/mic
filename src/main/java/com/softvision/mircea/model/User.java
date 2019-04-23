package com.softvision.mircea.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="user") 
public class User {

    @Id
    @Column(name="id")
    private long id;
    
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    @ManyToMany
    private Set<User> usersToFollow = new HashSet<>();
    
    @OneToMany
    @JoinColumn(name="user_id")
    private Set<Post> posts = new HashSet<>();


    public User() {
    }

    public User(long id, String userName, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<User> userToFollow() {
        return usersToFollow;
    }

    public void setuserToFollow(Set<User> usersToFollow) {
        this.usersToFollow = usersToFollow;
    }


  

    public Set<Post> getPosts() {
        return posts;
    }

    public Set<Post> getPosts(Date beginDate) {        
    	Set<Post> result = posts.stream()                
                .filter(post -> post.getDateCreated().after(beginDate)) 
                .collect(Collectors.toSet());              
    	return result;    	
    }
    
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public void addUserToFollow(User user) {
        usersToFollow.add(user);
    }

	public Set<User> getUsersToFollow() {
		return usersToFollow;
	}

	public void setUsersToFollow(Set<User> usersToFollow) {
		this.usersToFollow = usersToFollow;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((usersToFollow == null) ? 0 : usersToFollow.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (usersToFollow == null) {
			if (other.usersToFollow != null)
				return false;
		} else if (!usersToFollow.equals(other.usersToFollow))
			return false;
		return true;
	}






}
