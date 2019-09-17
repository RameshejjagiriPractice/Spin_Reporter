package com.spin.main.dao;
//sandeepK

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spin.main.model.usermaster;

@Repository
public class LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public usermaster validateUser(usermaster signup) {
		String sql = "select * from usermaster where emailid='" + signup.getEmailid() + "' and pword='" + signup.getPword()
				+ "'";
		List<usermaster> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}
}

class UserMapper implements RowMapper<usermaster> {
	public usermaster mapRow(ResultSet rs, int arg1) throws SQLException {
		usermaster user = new usermaster();
		user.setEmailid(rs.getString("emailid"));
		user.setPword(rs.getString("pword"));
		user.setUserid(rs.getInt("userid"));
		user.setUsername(rs.getString("username"));

		return user;
	}

	
}
