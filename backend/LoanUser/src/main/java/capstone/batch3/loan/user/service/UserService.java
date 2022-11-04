package capstone.batch3.loan.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public boolean isValidCredentials(String username, String password) {
		return userRepository.isValidCredentials(username, password);
	}

}
