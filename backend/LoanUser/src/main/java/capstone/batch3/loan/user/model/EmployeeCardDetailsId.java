package capstone.batch3.loan.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EmployeeCardDetailsId implements Serializable {

	@ManyToOne
	@JoinColumn(name="employee_id", referencedColumnName = "employee_id")
	private EmployeeMaster employeeMaster;
	
	@ManyToOne
	@JoinColumn(name="loan_id", referencedColumnName = "loan_id")
	private LoanCardMaster loanCardMaster;

	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}

	public LoanCardMaster getLoanCardMaster() {
		return loanCardMaster;
	}

	public void setLoanCardMaster(LoanCardMaster loanCardMaster) {
		this.loanCardMaster = loanCardMaster;
	}
	
	
	
}
