package capstone.batch3.loan.user.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import capstone.batch3.loan.user.model.EmpCardDetails;
import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.ItemMaster;
import capstone.batch3.loan.user.model.Loancard;

@Repository
public interface EmpCardDetailsRepository extends JpaRepository<EmpCardDetails,Employee>{
	
	

	EmpCardDetails findByEmployee(Employee e);
	
}
