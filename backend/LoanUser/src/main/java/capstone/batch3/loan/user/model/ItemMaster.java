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
	private long item_id;

	@Column(name = "issue_status")
	private ItemIssueStatus issue_status;

	@Column(name = "catagory")
	private String category;

	@Column(name = "value")
	private double value;

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public ItemIssueStatus getIssue_status() {
		return issue_status;
	}

	public void setIssue_status(ItemIssueStatus issue_status) {
		this.issue_status = issue_status;
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

	public void setValue(int value) {
		this.value = value;
	}

}
