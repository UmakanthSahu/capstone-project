package capstone.batch3.loan.user.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import capstone.batch3.loan.user.model.EmployeeCardDetails;
import capstone.batch3.loan.user.model.EmployeeCardDetailsId;

public interface EmployeeCardDetailsRepository extends JpaRepository<EmployeeCardDetails, EmployeeCardDetailsId> {

	
	@Query("FROM EmployeeCardDetails WHERE employee_id=?1")
	public List<EmployeeCardDetails> getActiveLoans(Integer employeeId);
	
	@Modifying
	@Query(value = "INSERT INTO employee_card_details VALUES(?3, ?1, ?2)", nativeQuery = true)
	public void insertRecord(Integer employeeId, Integer loanId, Date date);
}
