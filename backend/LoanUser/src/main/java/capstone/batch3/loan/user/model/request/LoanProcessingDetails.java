package capstone.batch3.loan.user.model.request;

public class LoanProcessingDetails {
	private int employeeId;
	private String itemCategory;
	private String itemDescription;
	private int itemValue;
	private String itemMake;

	public LoanProcessingDetails(int employeeId, String itemCategory, String itemDescription, int itemValue,
			String itemMake) {
		super();
		this.employeeId = employeeId;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemValue = itemValue;
		this.itemMake = itemMake;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemValue() {
		return itemValue;
	}

	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

}
