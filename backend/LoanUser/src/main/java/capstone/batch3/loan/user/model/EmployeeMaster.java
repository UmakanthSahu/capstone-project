package capstone.batch3.loan.user.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "employee_master")
public class EmployeeMaster {
	@Id
	@Column(name = "employee_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@Column(name = "employee_name", nullable = false, length = 40)
	@NotBlank
	@Pattern(regexp = "^[A-Za-z\\s]{2,40}$", message = "Invalid Name")
	private String name;

	@Column(nullable = false, length = 25)
	private String designation;

	@Column(nullable = false, length = 25)
	private String department;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(name = "email_id", length = 30, nullable = false)
	@NotBlank
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Invalid Email Address")
	private String emailId;


	@Column
	private Date dateOfBirth;

	@Column
	private Date dateOfJoining;
	
	@OneToMany(mappedBy = "employeeCardDetailsId.employeeMaster")
	private List<EmployeeCardDetails> employeeLoanCards =  new ArrayList<EmployeeCardDetails>();
	
	@OneToMany(mappedBy = "employeeMaster")
	private List<EmployeeIssueDetails> employeeIssues = new ArrayList<EmployeeIssueDetails>();
	

	
	public List<EmployeeIssueDetails> getEmployeeIssues() {
		return employeeIssues;
	}

	public void setEmployeeIssues(List<EmployeeIssueDetails> employeeIssues) {
		this.employeeIssues = employeeIssues;
	}

	
	public List<EmployeeCardDetails> getEmployeeLoanCards() {
		return employeeLoanCards;
	}

	public void setEmployeeLoanCards(List<EmployeeCardDetails> employeeLoanCards) {
		this.employeeLoanCards = employeeLoanCards;
	}

	

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

}
