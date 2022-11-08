package capstone.batch3.loan.user.model.response;

import capstone.batch3.loan.user.model.EmployeeMaster;

public class EmployeeLoginResponse {

	private int employeeid;
	private String employeeDesignation;
	private String department;
	
	public EmployeeLoginResponse(EmployeeMaster employeeMaster) {
		this.employeeid = employeeMaster.getEmployeeId();
		this.employeeDesignation  = employeeMaster.getDesignation();
		this.department = employeeMaster.getDepartment();
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
