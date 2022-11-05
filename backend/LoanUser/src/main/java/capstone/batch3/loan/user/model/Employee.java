package capstone.batch3.loan.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "employee_master")
public class Employee {
	@Id
	@Column(name = "employee_id", nullable = false)
	private long employeeId;
	@Column(name = "email_id", length = 30, nullable = false)
	@NotBlank
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Invalid Email Address")
	private String emailId;

	@Column(nullable = false, length = 50)
	private String password;

	public Employee() {
	}

	@Column(nullable = false, length = 40)
	@NotBlank
	@Pattern(regexp = "^[A-Za-z\\s]{2,40}$", message = "Invalid Name")
	private String name;

	@Column(name = "phone_number", nullable = false, length = 15)
	@Pattern(regexp = "^[0-9+-]{8,15}", message = "Phone number must not be less than 8 or greater than 16 digits")
	private String phoneNumber;

	public Employee(String name, String emailId, String password,
			String phoneNumber) {
		this.emailId = emailId.trim();
		this.password = password;
		this.name = name.trim();
		this.phoneNumber = phoneNumber.trim();
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
	

