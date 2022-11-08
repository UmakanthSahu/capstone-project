package capstone.batch3.loan.user.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import capstone.batch3.loan.user.model.Employee;

@Entity
@Table(name = "loan_table")
public class Loancard {
	@Id
	@Column(name="loan_id",nullable=false)
	private long loan_id;
	
	@Column(name="loan_val")
	private double loan_val;
	
	@OneToMany
	private List<ItemMaster> items;
	
	@Column
	private int long_duration;
	
	@Column
	private String type;
	
	@OneToOne // can have one loan details at a time
	@JoinColumn(name = "employee_id")
	private Employee connect_emp;
	public Loancard(Employee e){
		this.connect_emp=e;
		this.loan_val=0;
		this.items=new ArrayList<>();
		this.long_duration=0;
	}

	public Employee getConnect_emp() {
		return connect_emp;
	}

	public void setConnect_emp(Employee connect_emp) {
		this.connect_emp = connect_emp;
	}

	public double getLoan_val() {
		return loan_val;
	}

	public void setLoan_val(double loan_val) {
		this.loan_val = loan_val;
	}

	public int getLong_duration() {
		return long_duration;
	}

	public void setLong_duration(int long_duration) {
		this.long_duration = long_duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ItemMaster> getItems() {
		return this.items;
	}

	public void addNewItems(ItemMaster items) {
		this.items.add(items);
	}

	
	
}
