package capstone.batch3.loan.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loan_card_master")
public class LoanCardMaster {
	@Id
	@Column(name = "loan_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "duration_in_years")
	private int durationInYears;

	@OneToMany(mappedBy = "employeeCardDetailsId.loanCardMaster")
	private List<EmployeeCardDetails> employeeLoanCards = new ArrayList<>();

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	public List<EmployeeCardDetails> getEmployeeLoanCards() {
		return employeeLoanCards;
	}

	public void setEmployeeLoanCards(List<EmployeeCardDetails> employeeLoanCards) {
		this.employeeLoanCards = employeeLoanCards;
	}

	public LoanCardMaster(int loanId, String loanType, int durationInYears) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.durationInYears = durationInYears;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDuration_in_years() {
		return durationInYears;
	}

	public void setDuration_in_years(int duration_in_years) {
		this.durationInYears = duration_in_years;
	}

}
