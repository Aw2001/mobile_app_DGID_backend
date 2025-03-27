package com.springAPI.SpringProject;

import com.springAPI.SpringProject.config.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(SecurityConfiguration.class)
class SpringProjectApplicationTests {

	@Test
	void contextLoads() {
	}

}
