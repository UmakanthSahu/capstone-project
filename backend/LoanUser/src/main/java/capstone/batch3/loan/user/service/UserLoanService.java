package capstone.batch3.loan.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.batch3.loan.user.exception.GlobalLoanException;
import capstone.batch3.loan.user.model.EmpCardDetails;
import capstone.batch3.loan.user.model.Employee;
import capstone.batch3.loan.user.model.ItemMaster;
import capstone.batch3.loan.user.model.Loancard;
import capstone.batch3.loan.user.repository.EmpCardDetailsRepository;
import capstone.batch3.loan.user.repository.EmployeeRepository;
import capstone.batch3.loan.user.repository.LoancardRepository;


@Service
public class UserLoanService {
	@Autowired
	private static EmpCardDetailsRepository empcardrepo;
	@Autowired
	private static LoancardRepository loanrepo;

	public List<ItemMaster> getLoanCardItems(Employee e) {
		Loancard loan1 = empcardrepo.findByEmployee(e).getLoancard();
		System.err.println(loan1);
		return loan1.getItems();}
		
	public static Loancard addLoanCard(Employee e) {
		
		
		Loancard l=new Loancard(e);
		loanrepo.save(l);
		EmpCardDetails ec=new EmpCardDetails(l,e);
		empcardrepo.save(ec);
		
		return l;}
	public static double getloanval(Employee e) {
		Loancard loan1 = empcardrepo.findByEmployee(e).getLoancard();
		return loan1.getLoan_val();
	}
	public static Loancard addnewitems(Employee e,ItemMaster i) {
		Loancard loan1 = empcardrepo.findByEmployee(e).getLoancard();
		double loanVal=loan1.getLoan_val();
		double get_item_val=i.getValue();
		
		loan1.setLoan_val(get_item_val+loanVal);
		return loan1;
	}
		
		
		
		
	

}
