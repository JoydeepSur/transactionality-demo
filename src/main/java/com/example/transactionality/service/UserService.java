package com.example.transactionality.service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactionality.model.User;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * public void insert(List<User> users) {
	 * 
	 * for (User user : users) { System.out.println("Inserting data for username" +
	 * user.getName());
	 * jdbcTemplate.update("insert into USER(Name, Dept, Salart) values(?,?,?)", new
	 * PreparedStatementSetter() {
	 * 
	 * @Override public void setValues(PreparedStatement ps) throws SQLException {
	 * ps.setString(1, user.getName()); ps.setString(2, user.getDept());
	 * ps.setLong(3, user.getSalary()); } }); } }
	 */

	// Java 8 Lambda
	@Transactional
	public void insert(List<User> users) {

		for (User user : users) {
			System.out.println("Inserting data for username" + user.getName());
			jdbcTemplate.update("insert into USER(Name, Dept, Salary) values(?,?,?)", ps -> {
				ps.setString(1, user.getName());
				ps.setString(2, user.getDept());
				ps.setLong(3, user.getSalary());
			});
		}
	}

	/*
	 * public List<User> getUsers() { return
	 * jdbcTemplate.query("select Name, Dept, Salary from USER", new
	 * RowMapper<User>() {
	 * 
	 * @Override public User mapRow(ResultSet rs, int i) throws SQLException { User
	 * user = new User(); user.setName(rs.getString("Name"));
	 * user.setDept(rs.getString("Dept")); user.setSalary(rs.getLong("Salary"));
	 * return user;
	 * 
	 * } }); }
	 */

	// Java 8 Lambda
	public List<User> getUsers() {
		return jdbcTemplate.query("select Name, Dept, Salary from USER", (ResultSet rs, int i) -> {
			User user = new User();
			user.setName(rs.getString("Name"));
			user.setDept(rs.getString("Dept"));
			user.setSalary(rs.getLong("Salary"));
			return user;

		});
	}
}
