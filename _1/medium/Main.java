package medium;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import medium.model.Blog;
import medium.model.BlogType;
import medium.model.User;
import medium.service.BlogService;
import medium.service.UserService;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		UserService userService = applicationContext.getBean(UserService.class);
		BlogService blogService = applicationContext.getBean(BlogService.class);
		
		// User'lar oluşturuldu
		User user1 = new User(1,"Seyma","ce.seyma@gmail.com");
		User user2 = new User(2,"Semanur","ody.semanur@gmail.com");
		
		// User'lar userService yardımıyla kaydedildi
		userService.createUser(user1);
		userService.createUser(user2);
		
		// Blog'lar oluşturuldu. Bu nesne blogları yazan user'ın id'sini, blog'unu ve blog'unun durumunu almaktadır.
		Blog blog1 = new Blog(1,"Bu blog postu Seyma adli kullaniciya aittir",BlogType.PUBLISHED);
		Blog blog2 = new Blog(2,"Bu bir blog postudur ve Semanur adli kullaniciya aittir",BlogType.PUBLISHED);
		Blog blog3 = new Blog(2,"Semanur adli ve 2 id'li kullanicidan gelen blog",BlogType.PUBLISHED);
		
		// Blog'lar create edildi.
		blogService.createBlog(blog1);
		blogService.createBlog(blog2);
		blogService.createBlog(blog3);
		System.out.println("---------------------------------");
		blogService.getBlogs(user2); // User'a ait blog'ların durumunu(published veya draft) ve blogunu verir.
		System.out.println("---------------------------------");
		blogService.deleteBlog(blog3); // Blog silindi
		blogService.getBlogs(user2); // Tekrar konrtol edildiğinde silinen blog'un olmadığı görülebilinmektedir.
		System.out.println("---------------------------------");
		// 1 id'li user blog'unu taslak olarak kaydedebilir.
		Blog blog4 = new Blog(1,"Taslak olan ama sonradan yayinlanacak olan blog",BlogType.DRAFTED); 
		blogService.createBlog(blog4); // Blog taslak olarak kaydedildi

		blogService.getBlogs(user1);
		System.out.println("---------------------------------");
		blogService.publishBlog(blog4);// Taslak halindeki blog'un status'u published olarak değiştirildi
		blogService.getBlogs(user1);
		blogService.publishBlog(blog4);// Published olmuş blog'u tekrar yayınlamaya çalışınca uyarı verir.
		System.out.println("---------------------------------");
		userService.followUser(user1, user2); // user1, user2'yi takip eder
		userService.getFollowedUsers(user1); // user1'in takip ettiği user'lar döndürülür
		System.out.println("---------------------------------");
		userService.followTag(user2, "Java"); // User'lar tag'leri takip edebilir.
		userService.followTag(user2, "Spring Boot");
		userService.getFollowedTags(user2); // User'ların takip ettikleri tag'ler gösterilir
		
	}

}
