package capstone.batch3.loan.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import capstone.batch3.loan.user.model.EmployeeMaster;

/*
 * Repository for EmployeeCardDetails Table
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMaster, String> {
	public Optional<EmployeeMaster> findByEmailIdAndPassword(String emailId, String password);

	public EmployeeMaster findByEmailId(String emailId);

}
