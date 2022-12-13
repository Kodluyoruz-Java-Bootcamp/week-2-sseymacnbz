package emlakcepte.dao;

import java.util.ArrayList;
import java.util.List;

import emlakcepte.model.User;

public class UserDaoSingleton {
	private static List<User> userList = new ArrayList<>();
	
	// Bu instance return edilecek ve service class'larında kullanılacak
	private static UserDaoSingleton instance = new UserDaoSingleton();
	
	private UserDaoSingleton() {//Cosntructor private. Böylece dışarıdan bir nesne oluşturulması engellenecek
		
	}
	
	public static UserDaoSingleton getInstance() {
		return instance;
	}
	
	public void createUser(User user) {	
		userList.add(user);
	}
	
	public List<User> findAllUsers() {	
		return userList;
	}
}
