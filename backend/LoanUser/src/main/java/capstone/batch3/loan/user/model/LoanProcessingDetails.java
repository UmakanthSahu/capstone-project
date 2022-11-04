package capstone.batch3.loan.user.model;

public class LoanProcessingDetails {
	private String employeeId;
	private String itemCategory;
	private String itemDescription;
	private int itemValue;
	private String itemMake;

	public LoanProcessingDetails(String employeeId, String itemCategory, String itemDescription, int itemValue,
			String itemMake) {
		super();
		this.employeeId = employeeId;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemValue = itemValue;
		this.itemMake = itemMake;
	}

	public LoanProcessingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public int getItemValue() {
		return itemValue;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	@Override
	public String toString() {
		return "LoanProcessingDetails [employeeId=" + employeeId + ", itemCategory=" + itemCategory
				+ ", itemDescription=" + itemDescription + ", itemValue=" + itemValue + ", itemMake=" + itemMake + "]";
	}
	

}
