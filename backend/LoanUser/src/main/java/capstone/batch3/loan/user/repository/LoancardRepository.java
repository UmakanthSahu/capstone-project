package capstone.batch3.loan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.Loancard;

public interface LoancardRepository extends JpaRepository<Loancard, String>{

}
