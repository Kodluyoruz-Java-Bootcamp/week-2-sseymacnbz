package emlakcepte.service;

import java.util.List;

import emlakcepte.dao.UserDaoSingleton;
import emlakcepte.model.User;


public class UserService {
		
	UserDaoSingleton userDaoSingleton = UserDaoSingleton.getInstance();
	
	public void createUser(User user) {		
		
		System.out.println("ben bir userDao objesiyim:" + userDaoSingleton.toString());
		
		if (user.getPassword().length() < 5) {
			System.out.println("Sifre en az 5 karakterli olmali");
		}			
		userDaoSingleton.createUser(user);		
	}
	
	public List<User> getAllUser() {
				
		return userDaoSingleton.findAllUsers();
	}
	
	public void printAllUser() {
		
		getAllUser().forEach(user -> System.out.println(user.getName()));
		
	}
	
	public void updatePassword(User user, String newPassword) {
		for (User usr : userDaoSingleton.findAllUsers()) {
			if(user.equals(usr)) {
				user.setPassword(newPassword);
			}
		}
	}

}
