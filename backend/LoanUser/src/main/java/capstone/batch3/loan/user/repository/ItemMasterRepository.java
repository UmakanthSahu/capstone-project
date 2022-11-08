package capstone.batch3.loan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, String>{

}
