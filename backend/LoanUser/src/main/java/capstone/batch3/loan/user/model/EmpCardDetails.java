package capstone.batch3.loan.user.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee_card_details")
public class EmpCardDetails {

	@Id
	private long empcardId;
	
	@OneToOne // can have one loan details at a time
	@JoinColumn(name = "loan_id")
	private LoanCard loanCard;

	@OneToOne // can have one loan details at a time
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date card_issue_date;

	public LoanCard getLoanCard() {
		return loanCard;
	}

	public EmpCardDetails(LoanCard loanCard, Employee employee) {
		this.loanCard = loanCard;
		this.employee = employee;
		this.card_issue_date = new Date(0);
	}

	public void setLoancard(LoanCard loanCard) {
		this.loanCard = loanCard;
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
