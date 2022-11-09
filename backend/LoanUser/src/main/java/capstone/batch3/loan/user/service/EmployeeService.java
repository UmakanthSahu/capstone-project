package capstone.batch3.loan.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.model.EmployeeMaster;
import capstone.batch3.loan.user.model.response.EmployeeLoginResponse;
import capstone.batch3.loan.user.repository.EmployeeRepository;

/*
 * Service class to handle employeeLogin
 */

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

}
