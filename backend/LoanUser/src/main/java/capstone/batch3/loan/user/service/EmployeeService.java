package capstone.batch3.loan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.exception.GlobalLoanException;
import capstone.batch3.loan.user.model.EmployeeMaster;
import capstone.batch3.loan.user.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeMaster login(String email, String password) {
		EmployeeMaster cus = employeeRepository.findByEmailId(email);
		System.err.println(cus);
		if (cus == null) {
			throw new GlobalLoanException("404", "No customer with this credential");
		} else if (cus.getPassword().equals(password)) {
			return cus;
		}

		else {
			throw new GlobalLoanException("403", "Wrong password");
		}
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
