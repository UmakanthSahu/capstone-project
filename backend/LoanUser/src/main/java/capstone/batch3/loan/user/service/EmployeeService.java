package capstone.batch3.loan.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.enums.ItemIssueStatus;
import capstone.batch3.loan.user.exception.GlobalLoanException;
import capstone.batch3.loan.user.repository.EmployeeRepository;

import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.ItemMaster;
import capstone.batch3.loan.user.model.Loancard;

@Service
public class EmployeeService {

	@Autowired
	private static EmployeeRepository employeeRepository;

	public static Employee login(String email,String password) {
		Employee cus = employeeRepository.findByEmail(email);
		System.err.println(cus);
		if(cus == null) {
			throw new GlobalLoanException("404", "No customer with this credential");
		}else if (cus.getPassword().equals(password)) {
			return cus;
		} 		

		else {
			throw new GlobalLoanException("403", "Wrong password");
		}
	}

	public static Employee addEmployee(Employee employee) {
		if(existsById(employee)) {
			return null;
		}
		
		employeeRepository.save(employee);
		
		return employee;
	}
	
	private static boolean existsById(Employee employee) {
		return employeeRepository.existsById(employee.getEmailId());
	}
	
	private static boolean addItemToLoanCard(Loancard loancard,ItemMaster it) {
		if (it.getIssue_status()==ItemIssueStatus.NOTISSUED) {
		it.setIssue_status(ItemIssueStatus.ISSUED);
		loancard.addNewItems(it);
		double temp=loancard.getLoan_val()+it.getValue();
		loancard.setLoan_val(temp);
		return true;}
		else {
			return false;
		}
	}
	
	
}
