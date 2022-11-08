package capstone.batch3.loan.user.model.response;

import java.sql.Date;
import java.time.LocalDate;

import capstone.batch3.loan.user.model.LoanCardMaster;

public class ViewLoansResponse {

	private int loadId;
	private String loanType;
	private int durationInYears;
	private LocalDate cardIssueDate;

	public ViewLoansResponse(LoanCardMaster loanCardMaster, Date date) {
		// TODO Auto-generated constructor stub
		this.loadId = loanCardMaster.getLoanId();
		this.loanType = loanCardMaster.getLoanType();
		this.durationInYears = loanCardMaster.getDurationInYears();
		this.cardIssueDate = date.toLocalDate();
	}

	public int getLoadId() {
		return loadId;
	}

	public void setLoadId(int loadId) {
		this.loadId = loadId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	public LocalDate getDate() {
		return cardIssueDate;
	}

	public void setDate(LocalDate date) {
		this.cardIssueDate = date;
	}

}
