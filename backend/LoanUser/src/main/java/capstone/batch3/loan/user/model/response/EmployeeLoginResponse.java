package capstone.batch3.loan.user.model.response;

import capstone.batch3.loan.user.model.EmployeeMaster;

/*
 * On Successful login employeeId, Designation and Department are returned as response
 */
public class EmployeeLoginResponse {

	private int employeeId;
	private String employeeDesignation;
	private String employeeDepartment;

	public EmployeeLoginResponse(EmployeeMaster employeeMaster) {
		this.employeeId = employeeMaster.getEmployeeId();
		this.employeeDesignation = employeeMaster.getDesignation();
		this.employeeDepartment = employeeMaster.getDepartment();
	}

	public int getEmployeeid() {
		return employeeId;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeId = employeeid;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getDepartment() {
		return employeeDepartment;
	}

	public void setDepartment(String department) {
		this.employeeDepartment = department;
	}

}
