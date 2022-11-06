package capstone.batch3.loan.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import capstone.batch3.loan.user.enums.ItemIssueStatus;

@Entity
@Table(name = "item_master")
public class ItemMaster {

	@Id
	@Column(name = "item_id", nullable = false)
	private long itemId;

	@Column(name = "issue_status")
	private ItemIssueStatus issueStatus;

	@Column(name = "category")
	private String category;

	@Column(name = "value")
	private double value;

	public ItemMaster(long itemId, ItemIssueStatus issueStatus, String category, double value) {
		super();
		this.itemId = itemId;
		this.issueStatus = issueStatus;
		this.category = category;
		this.value = value;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public ItemIssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(ItemIssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
