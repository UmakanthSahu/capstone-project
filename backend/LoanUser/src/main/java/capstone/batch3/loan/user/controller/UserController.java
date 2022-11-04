package capstone.batch3.loan.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capstone.batch3.loan.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/loginUser/{username}/{password}")
	public boolean loginUser(@PathVariable String username, @PathVariable String password) {
		return userService.isValidCredentials(username, password);
	}

}
