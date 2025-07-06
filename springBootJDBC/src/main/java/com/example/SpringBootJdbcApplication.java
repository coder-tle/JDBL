package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.models.User;
import com.example.repository.UserRepository;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner{
	@Autowired
	UserRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {
        System.out.println("--- Application Started ---");

        // Now 'repo' is safely injected and can be used
//        List<User> users = repo.findAll();
//
//        if (users.isEmpty()) {
//            System.out.println("No users found in the database.");
//            // Optional: Add some data if you want to test insertion
//            // repo.save(new User(1, "john.doe@example.com", "John Doe")); // Assuming you have a save method
//            // users = repo.findAll(); // Re-fetch
//            // System.out.println("Users after adding: " + users);
//        } else {
//            System.out.println("Found Users:");
//            users.forEach(System.out::println);
//        }

        System.out.println("--- Application Finished Initial Run ---");
        // If you want the application to stop after this, you might need to
        // configure Spring Boot to exit. For command-line apps, it often exits naturally.
        // For web apps, it would continue running to serve requests.
    }
}
