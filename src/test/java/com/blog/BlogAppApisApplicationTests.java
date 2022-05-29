package com.blog;

import com.blog.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogAppApisApplicationTests {
	@Autowired
	private UserRepo userRepo;
	@Test
	void contextLoads() {
	}

	@Test
	void userDetaisl(){
		String className=this.userRepo.getClass().getName();
		String packname=this.userRepo.getClass().getPackageName();
		System.out.println();
		System.out.println(className+" "+packname);
		System.out.println();
	}

}
