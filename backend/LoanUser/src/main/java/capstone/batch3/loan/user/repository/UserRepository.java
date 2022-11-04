package capstone.batch3.loan.user.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean isValidCredentials(String employeeId, String password) {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE employee_id=? and password=?",
				Integer.class, employeeId, password) == 1;
	}
}
