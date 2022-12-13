package medium.model;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String name;
	private String mail;
	private ArrayList<User> followedUsers = new ArrayList<User>();
	private ArrayList<Integer> blogList = new ArrayList<Integer>();
	private ArrayList<String> followedTags = new ArrayList<String>();
	
	public User() {
		super();
	}
	
	public User(int id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ArrayList<User> getFollowedUsers() {
		return followedUsers;
	}

	public void setFollowedUsers(ArrayList<User> followedUsers) {
		this.followedUsers = followedUsers;
	}

	public ArrayList<Integer> getBlogList() {
		return blogList;
	}

	public void setBlogList(ArrayList<Integer> blogList) {
		this.blogList = blogList;
	}

	public ArrayList<String> getFollowedTags() {
		return followedTags;
	}

	public void setFollowedTags(ArrayList<String> followedTags) {
		this.followedTags = followedTags;
	}
	
	
	
	
	
	
	
}
