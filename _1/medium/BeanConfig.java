package medium;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import medium.service.BlogService;
import medium.service.UserService;

@Configuration
public class BeanConfig {
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public BlogService blogService() {
		return new BlogService();
	}
	
}
