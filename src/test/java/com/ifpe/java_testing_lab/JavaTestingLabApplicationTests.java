package com.ifpe.java_testing_lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.ifpe.java_testing_lab.repository.UserRepository;

@SpringBootTest
class JavaTestingLabApplicationTests {

	@MockitoBean
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

}
