package capstone.batch3.loan.user.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import capstone.batch3.loan.user.model.EmployeeIssueDetails;

public interface EmployeeIssueDetailsRepository extends JpaRepository<EmployeeIssueDetails, Integer> {

//	@Query("")
//	public List<ItemMaster> getItemsPurchased(Integer employeeId);
	
	@Query("FROM EmployeeIssueDetails where employee_id=?1")
	public List<EmployeeIssueDetails> findByEmployeeId(Integer employeeId);
	
	@Modifying
	@Query(value = "INSERT INTO employee_issue_details VALUES( NULL, ?1, ?2, NULL, ?3, ?4)", nativeQuery = true)
	public void insertRecord(Date issueDate, String issueStatus, int employeeId, int itemId);
}
