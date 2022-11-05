package capstone.batch3.loan.user.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
public enum ItemIssueStatus {

		@JsonProperty("Issued")
		ISSUED, 
		@JsonProperty("Not Issued")
		NOTISSUED,
	
}
