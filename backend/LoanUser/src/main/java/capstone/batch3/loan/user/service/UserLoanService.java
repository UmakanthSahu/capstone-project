package capstone.batch3.loan.user.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.model.LoanCardMaster;
import capstone.batch3.loan.user.model.request.ApplyLoanRequest;
import capstone.batch3.loan.user.model.response.ViewLoansResponse;
import capstone.batch3.loan.user.repository.EmployeeCardDetailsRepository;
import capstone.batch3.loan.user.repository.EmployeeIssueDetailsRepository;
import capstone.batch3.loan.user.repository.LoanCardMasterRepository;

/*
 * handles applying Loan and getAllAvailedLoans
 */
@Service
public class UserLoanService {

	@Autowired
	private EmployeeCardDetailsRepository employeeCardDetailsRepository;

	@Autowired
	private LoanCardMasterRepository loanCardMasterRepository;

	@Autowired
	private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;

	// returns all the availed Loans based on employeeId
	public List<ViewLoansResponse> getLoans(Integer employeeId) {

		return employeeCardDetailsRepository.getActiveLoans(employeeId).stream()
				.map(details -> new ViewLoansResponse(details.getEmployeeCardDetailsId().getLoanCardMaster(),
						details.getCardIssueDate()))
				.collect(Collectors.toList());
	}

	/*
	 * returns boolean value representing success or failure
	 */
	@Transactional
	public boolean applyLoan(ApplyLoanRequest applyLoanRequest) {

		// get all the loan cards based on category from LoanCardMaster table
		List<LoanCardMaster> loans = loanCardMasterRepository.findByCategory(applyLoanRequest.getItemCategory());

		// get any loan card which is not availed yet
		LoanCardMaster unavailedLoanCard = loans.stream().filter(loan -> loan.getEmployeeLoanCards().size() == 0)
				.findFirst().orElse(null);

		// todays date to insert for loan application date
		Date today = Date.valueOf(LocalDate.now());

		// if there is any unavailed loan card then insert in EmployeeIssueDetails
		// tables with Activated else Rejected
		employeeIssueDetailsRepository.insertRecord(today, unavailedLoanCard == null ? "Rejected" : "Active",
				applyLoanRequest.getEmployeeId(), applyLoanRequest.getItemId());

		// if there is any availed loanCard then insert a record in EmployeeCardDetails
		// stating that its availed
		if (unavailedLoanCard != null) {
			employeeCardDetailsRepository.insertRecord(applyLoanRequest.getEmployeeId(), unavailedLoanCard.getLoanId(),
					today);
			return true;
		}

		return false;
	}
}
