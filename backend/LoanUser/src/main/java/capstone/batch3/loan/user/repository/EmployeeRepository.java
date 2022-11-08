package capstone.batch3.loan.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import capstone.batch3.loan.user.model.EmployeeMaster;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMaster, String> {

//	@Query("SELECT emailId FROM Employee WHERE email_id=?1 AND password=?2")
	public Optional<EmployeeMaster> findByEmailIdAndPassword(String emailId, String password);

	public EmployeeMaster findByEmailId(String emailId);

}
