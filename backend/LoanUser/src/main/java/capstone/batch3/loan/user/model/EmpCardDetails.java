package capstone.batch3.loan.user.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.Loancard;

@Entity
public class EmpCardDetails {
	
	@Id
	private long empcardId;
	@OneToOne // can have one loan details at a time
	@JoinColumn(name = "loan_id")
	private Loancard loancard;
	
	@OneToOne // can have one loan details at a time
	@JoinColumn(name = "employee_id")
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
