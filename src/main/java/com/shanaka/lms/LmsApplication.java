package com.shanaka.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shanaka.lms.entity.Student;
import com.shanaka.lms.repo.StudentRepo;

@SpringBootApplication
public class LmsApplication implements CommandLineRunner {
	@Autowired
	private StudentRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
