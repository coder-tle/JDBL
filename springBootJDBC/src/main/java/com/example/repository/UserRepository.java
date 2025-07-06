package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.models.User;

@Repository
public class UserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired 
	Environment environment;
	
	class UserRowMapper implements RowMapper<User>{
		@Override 
		public User mapRow(ResultSet rs, int rowNum) throws SQLException{
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			return user;
		}
	}
	
	public List<User> findAll(){
        String sqlQuery;

        // Check if "dev" profile is active
        if (environment.acceptsProfiles(org.springframework.core.env.Profiles.of("dev"))) {
            sqlQuery = "SELECT * FROM userdb.users";
            System.out.println("Using DEV query: " + sqlQuery); // For debugging
        } else {
            // Default to 'local' or any other profile
            sqlQuery = "SELECT * FROM users";
            System.out.println("Using LOCAL query: " + sqlQuery); // For debugging
        }
		return jdbcTemplate.query(sqlQuery, new UserRowMapper());
		}
	
}
