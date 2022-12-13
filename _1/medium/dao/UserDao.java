package medium.dao;

import java.util.ArrayList;
import java.util.List;

import medium.model.User;

public class UserDao {
	private static List<User> userList = new ArrayList<>();
	
	public void createUser(User user) { // User'lar eklenir.
		userList.add(user);
	}
	
	public void getFollowedUser(User user) { // Gelen user'ın takip ettiği user'lar döndürülür
		for(User usr : userList) {
			if(user.equals(usr)) {
				for(User fu : user.getFollowedUsers()) {
					System.out.println(fu.getName());
				}
			}
		}
	}

	public void getFollowedTags(User user) {
		for(User usr : userList) {
			if(user.equals(usr)) {
				for(String tag : user.getFollowedTags()) {
					System.out.println(tag);
				}
			}
		}
		
	}
}
