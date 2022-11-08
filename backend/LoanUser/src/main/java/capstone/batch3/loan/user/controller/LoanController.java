package capstone.batch3.loan.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.batch3.loan.user.model.EmployeeCardDetails;
import capstone.batch3.loan.user.model.request.ApplyLoanRequest;
import capstone.batch3.loan.user.model.request.EmployeeIdRequest;
import capstone.batch3.loan.user.model.response.ViewLoansResponse;
import capstone.batch3.loan.user.service.UserLoanService;

@RestController

@CrossOrigin(origins = {"http://localhost:3000",  "http://localhost:3001", "http://localhost:3002"})

@RequestMapping("/api/v1")
public class LoanController {

	@Autowired
	private UserLoanService userLoanService;
	
	
	@PostMapping("/viewLoans")
	public ResponseEntity<List<ViewLoansResponse>> viewLoans(@RequestBody EmployeeIdRequest employeeIdRequest) {
		
		return ResponseEntity.ok(userLoanService.getLoans(employeeIdRequest.getEmployeeId()));
	}
	
	@PostMapping("/applyLoan")
	public ResponseEntity<?> applyLoan(@RequestBody ApplyLoanRequest applyLoanRequest){
		userLoanService.applyLoan(applyLoanRequest);
		return ResponseEntity.ok(true);
	}

}
