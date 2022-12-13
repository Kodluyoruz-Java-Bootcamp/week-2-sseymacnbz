package medium.model;

public class Blog {
	private int userId;
	private String blogPost;
	private BlogType type;
	
	public Blog(int userId,String blogPost, BlogType type) {
		super();
		this.userId = userId;
		this.blogPost = blogPost;
		this.type = type;
	}

	public Blog() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBlogPost() {
		return blogPost;
	}

	public void setBlogPost(String blogPost) {
		this.blogPost = blogPost;
	}

	public BlogType getType() {
		return type;
	}

	public void setType(BlogType type) {
		this.type = type;
	}
	
	
}
