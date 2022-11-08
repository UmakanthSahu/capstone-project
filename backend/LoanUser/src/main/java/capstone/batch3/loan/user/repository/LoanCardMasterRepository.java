package capstone.batch3.loan.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import capstone.batch3.loan.user.model.LoanCardMaster;

@Repository
public interface LoanCardMasterRepository extends JpaRepository<LoanCardMaster, Integer> {

	@Query("FROM LoanCardMaster where loanType=?1")
	public List<LoanCardMaster> findByCategory(String category);
}
