package capstone.batch3.loan.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.batch3.loan.user.service.UserLoanService;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/v1")
public class LoanController {

	@Autowired
	private UserLoanService userLoanService;

}
