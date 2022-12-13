package medium.service;

import medium.dao.UserDao;
import medium.model.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public void createUser(User user) { // User create etme metodu
		userDao.createUser(user);
		System.out.println("Kayit basariyla gerceklestirildi");
	}
	
	public void followUser(User user, User followedUser) { // User takip etmek için kullanılan metod
		user.getFollowedUsers().add(followedUser);
	}
	
	public void getFollowedUsers(User user) { // Bir user'ın takip ettiği user'ları veren metod
		userDao.getFollowedUser(user);
	}
	
	public void followTag(User user, String tag) { // User'ın takip ettiği tag'leri kaydeden metod
		user.getFollowedTags().add(tag);
	}
	
	public void getFollowedTags(User user) { // User'ın takip ettiği tag'leri veren metod
		userDao.getFollowedTags(user);
	}
}
	
	

