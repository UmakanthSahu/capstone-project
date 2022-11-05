package capstone.batch3.loan.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.response.EmployeeLoginResponse;
import capstone.batch3.loan.user.model.response.EmployeeRegistrationResponse;
import capstone.batch3.loan.user.pojo.LoginPOJO;
import capstone.batch3.loan.user.pojo.ResponseHeader;
import capstone.batch3.loan.user.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private EmployeeService employeeService;
	private ResponseHeader rh;
	@PostMapping(path = "/registerEmployee", consumes = "application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee) {
		rh = new ResponseHeader();
		rh.putOnMap("success", "true");
		ResponseEntity<Employee> res = new ResponseEntity<Employee>(EmployeeService.addEmployee(employee),
				rh.getHeaders(), HttpStatus.OK);
		return res;
	}

	@PostMapping(path = "/loginEmployee", consumes = "application/json")
	public ResponseEntity<Employee> login(@RequestBody LoginPOJO login) {
		rh = new ResponseHeader();
		rh.putOnMap("success", "true");
		ResponseEntity<Employee> res = new ResponseEntity<Employee>(
		EmployeeService.login(login.getEmail(), login.getPassword()),
		rh.getHeaders(), HttpStatus.OK);
		return res;
	}
}
