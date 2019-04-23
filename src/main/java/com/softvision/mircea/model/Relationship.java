package com.softvision.mircea.model;

import java.util.Date;

public class Relationship {

	
	private User currentUser;
	private User userToFollow;
	private Date dateWhenFollowingBegins;
	
	public Relationship() {
	}
	
	public Relationship(User currentUser, User userToFollow, Date dateWhenFollowingBegins) {
		super();
		this.currentUser = currentUser;
		this.userToFollow = userToFollow;
		this.dateWhenFollowingBegins = dateWhenFollowingBegins;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getUserToFollow() {
		return userToFollow;
	}

	public void setUserToFollow(User userToFollow) {
		this.userToFollow = userToFollow;
	}

	public Date getDateWhenFollowingBegins() {
		return dateWhenFollowingBegins;
	}

	public void setDateWhenFollowingBegins(Date dateWhenFollowingBegins) {
		this.dateWhenFollowingBegins = dateWhenFollowingBegins;
	}

	@Override
	public String toString() {
		return "Relationship [currentUser=" + currentUser + ", userToFollow=" + userToFollow
				+ ", dateWhenFollowingBegins=" + dateWhenFollowingBegins + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentUser == null) ? 0 : currentUser.hashCode());
		result = prime * result + ((dateWhenFollowingBegins == null) ? 0 : dateWhenFollowingBegins.hashCode());
		result = prime * result + ((userToFollow == null) ? 0 : userToFollow.hashCode());
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
		Relationship other = (Relationship) obj;
		if (currentUser == null) {
			if (other.currentUser != null)
				return false;
		} else if (!currentUser.equals(other.currentUser))
			return false;
		if (dateWhenFollowingBegins == null) {
			if (other.dateWhenFollowingBegins != null)
				return false;
		} else if (!dateWhenFollowingBegins.equals(other.dateWhenFollowingBegins))
			return false;
		if (userToFollow == null) {
			if (other.userToFollow != null)
				return false;
		} else if (!userToFollow.equals(other.userToFollow))
			return false;
		return true;
	}
	
	
	
	
	
}
