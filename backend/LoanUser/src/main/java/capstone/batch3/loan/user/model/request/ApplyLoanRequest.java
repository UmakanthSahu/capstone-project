package capstone.batch3.loan.user.model.request;

/*
 * Converts the JSON request for ApplyingLoan into Java POJO class
 */

public class ApplyLoanRequest {
	private int employeeId;
	private int itemId;
	private String itemCategory;

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
