package com.example.notes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
public class NotesApplication {

	private static  Environment environment;
	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(NotesApplication.class, args);
		environment = applicationContext.getEnvironment();
		initLog();

	}

	private static void initLog() {
		log.info("----------------------------------Start application----------------------------------");
	}

}
