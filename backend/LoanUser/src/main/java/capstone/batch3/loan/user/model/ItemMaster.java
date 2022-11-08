package capstone.batch3.loan.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item_master")
public class ItemMaster {

	@Id
	@Column(name = "item_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;

	@Column(name = "item_description")
	private String itemDescription;

	@Column(name = "item_make")
	private String itemMake;
	
	@Column(name = "item_name")
	private String itemName;
	
	

	@Column(name = "item_category")
	private String itemCategory;

	@Column(name = "item_valuation")
	private int itemValuation;

	@OneToMany(mappedBy = "itemMaster")
	private List<EmployeeIssueDetails> employeeIssueDetails = new ArrayList<EmployeeIssueDetails>();

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemValuation() {
		return itemValuation;
	}

	public void setItemValuation(int itemValuation) {
		this.itemValuation = itemValuation;
	}

}
