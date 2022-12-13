package medium.service;

import medium.dao.BlogDao;
import medium.model.Blog;
import medium.model.User;

public class BlogService {
	BlogDao blogDao = new BlogDao();
	
	public void createBlog(Blog blog) {
		blogDao.createBlog(blog);
		System.out.println("Isleminiz basariyla gerceklestirildi..");
	}
	
	public void getBlogs(User user) {
		blogDao.getBlogs(user);
	}
	
	public void deleteBlog(Blog blog) {
		blogDao.deleteBlog(blog);
	}
	
	public void publishBlog(Blog blog) {
		blogDao.publishBlog(blog);
	}
}
