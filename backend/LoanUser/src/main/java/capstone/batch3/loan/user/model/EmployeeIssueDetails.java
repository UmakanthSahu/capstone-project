package capstone.batch3.loan.user.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_issue_details")
public class EmployeeIssueDetails {

	@Id
	@Column(name = "issue_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issueId;

	@ManyToOne
	@JoinColumn(name = "employee_id") // name of the column when generated
	private EmployeeMaster employeeMaster;

	@Column(name = "issue_status")
	private String issueStatus;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private ItemMaster itemMaster;

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "return_date")
	private Date returnDate;

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}

	public ItemMaster getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	public ItemMaster getItemId() {
		return itemMaster;
	}

	public void setItemId(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
