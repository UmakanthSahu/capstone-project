package capstone.batch3.loan.user.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.model.LoanCardMaster;
import capstone.batch3.loan.user.model.request.ApplyLoanRequest;
import capstone.batch3.loan.user.model.response.ViewLoansResponse;
import capstone.batch3.loan.user.repository.EmployeeCardDetailsRepository;
import capstone.batch3.loan.user.repository.EmployeeIssueDetailsRepository;
import capstone.batch3.loan.user.repository.LoanCardMasterRepository;

@Service
public class UserLoanService {

	@Autowired
	private EmployeeCardDetailsRepository employeeCardDetailsRepository;

	@Autowired
	private LoanCardMasterRepository loanCardMasterRepository;
	
	@Autowired
	private EmployeeIssueDetailsRepository employeeIssueDetailsRepository;

	public List<ViewLoansResponse> getLoans(Integer employeeId) {

		return employeeCardDetailsRepository.getActiveLoans(employeeId).stream()
				.map(details -> new ViewLoansResponse(details.getEmployeeCardDetailsId().getLoanCardMaster(),
						details.getCardIssueDate()))
				.toList();
	}

	@Transactional
	public void applyLoan(ApplyLoanRequest applyLoanRequest) {
		List<LoanCardMaster> loans = loanCardMasterRepository.findByCategory(applyLoanRequest.getItemCategory());

		loans.forEach(loan -> {
			System.out.println(loan.getLoanId() + " " + loan.getEmployeeLoanCards().size());
			System.out.println(loan.getEmployeeLoanCards());
		});

		Optional<LoanCardMaster> unusedLoanCard = loans.stream().filter(loan -> loan.getEmployeeLoanCards().size() == 0)
				.findFirst();
		
		Date today = Date.valueOf(LocalDate.now());

		if (unusedLoanCard.isPresent()) {
			LoanCardMaster unusedLoanCardMaster = unusedLoanCard.get();
			employeeCardDetailsRepository.insertRecord(applyLoanRequest.getEmployeeId(),
					unusedLoanCardMaster.getLoanId(), today);
		}
		
		employeeIssueDetailsRepository.insertRecord(today, unusedLoanCard.isEmpty() ? "Rejected" : "Active", applyLoanRequest.getEmployeeId(), applyLoanRequest.getItemId());
	}
}
