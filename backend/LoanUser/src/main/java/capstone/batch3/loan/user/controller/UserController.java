package capstone.batch3.loan.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.batch3.loan.user.model.LoanProcessingDetails;
import capstone.batch3.loan.user.service.UserLoanService;
import capstone.batch3.loan.user.service.UserLoginService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserLoginService userService;
	
	@Autowired
	UserLoanService userLoanService;

	@GetMapping("/loginUser/{username}/{password}")
	public boolean loginUser(@PathVariable String username, @PathVariable String password) {
		return userService.isValidCredentials(username, password);
	}

	@PostMapping("/loanProcessing")
	public boolean processLoan(@RequestBody LoanProcessingDetails loanProcessingDetails ) {
		System.out.println(loanProcessingDetails);
		return false;
	}
}
