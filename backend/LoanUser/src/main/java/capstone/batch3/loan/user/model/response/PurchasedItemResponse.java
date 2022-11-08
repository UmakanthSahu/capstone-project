package capstone.batch3.loan.user.model.response;

import capstone.batch3.loan.user.model.ItemMaster;

public class PurchasedItemResponse extends ItemMaster{

	private int issueId;

	public PurchasedItemResponse(int issueId, ItemMaster itemMaster) {
		setItemId(itemMaster.getItemId());
		setItemCategory(itemMaster.getItemCategory());
		setItemDescription(itemMaster.getItemDescription());
		setItemMake(itemMaster.getItemMake());
		setItemName(itemMaster.getItemName());
		setItemValuation(itemMaster.getItemValuation());
		this.issueId = issueId;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	

	
	
}
