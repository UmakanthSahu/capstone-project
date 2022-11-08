package capstone.batch3.loan.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.model.EmployeeMaster;
import capstone.batch3.loan.user.model.response.EmployeeLoginResponse;
import capstone.batch3.loan.user.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeLoginResponse login(String email, String password) {
		Optional<EmployeeMaster> employee = employeeRepository.findByEmailIdAndPassword(email, password);
		return employee.isPresent() ? new EmployeeLoginResponse(employee.get()) : null;
	}

	public EmployeeMaster addEmployee(EmployeeMaster employee) {
		if (existsById(employee)) {
			return null;
		}

		employeeRepository.save(employee);

		return employee;
	}

	private boolean existsById(EmployeeMaster employee) {
		return employeeRepository.existsById(employee.getEmailId());
	}

//	private boolean addItemToLoanCard(LoanCard loanCard, ItemMaster it) {
//		if (it.getIssueStatus() == ItemIssueStatus.NOTISSUED) {
//			it.setIssueStatus(ItemIssueStatus.ISSUED);
//			loanCard.addNewItems(it);
//			double temp = loanCard.getLoan_val() + it.getValue();
//			loanCard.setLoan_val(temp);
//			return true;
//		} else {
//			return false;
//		}
//	}

}
