package capstone.batch3.loan.user.model;

import java.sql.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.Loancard;

public class EmpCardDetails {
	
	@Column(name="loan_id")
	private Loancard loancard;
	
	
	@Column(name="employee_id")
	private Employee employee;
	
	
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date card_issue_date;


	public Loancard getLoancard() {
		return loancard;
	}
	public EmpCardDetails(Loancard loancard,Employee employee){
		this.loancard=loancard;
		this.employee=employee;
		this.card_issue_date=new Date(0);
	}


	public void setLoancard(Loancard loancard) {
		this.loancard = loancard;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Date getCard_issue_date() {
		return card_issue_date;
	}


	public void setCard_issue_date(Date card_issue_date) {
		this.card_issue_date = card_issue_date;
	}

}
