package capstone.batch3.loan.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import capstone.batch3.loan.user.model.ItemMaster;

/*
 * Repository for EmployeeCardDetails Table
 */

@Repository
public interface ItemRepository extends JpaRepository<ItemMaster, Integer> {

}
