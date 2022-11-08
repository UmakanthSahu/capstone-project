package capstone.batch3.loan.user.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_card_details")

public class EmployeeCardDetails implements Serializable {


	@EmbeddedId
	private EmployeeCardDetailsId employeeCardDetailsId;

	@Column(name = "card_issue_date")
	private Date cardIssueDate;

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	public EmployeeCardDetailsId getEmployeeCardDetailsId() {
		return employeeCardDetailsId;
	}

	public void setEmployeeCardDetailsId(EmployeeCardDetailsId employeeCardDetailsId) {
		this.employeeCardDetailsId = employeeCardDetailsId;
	}

	@Override
	public String toString() {
		return "EmployeeCardDetails [employeeCardDetailsId=" + employeeCardDetailsId.getEmployeeMaster().getEmployeeId() +"--"+ employeeCardDetailsId.getLoanCardMaster().getLoanId() + ", cardIssueDate="
				+ cardIssueDate + "]";
	}
	
	

}
