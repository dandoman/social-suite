package com.merccann;

import lombok.Getter;

@Getter
public enum LeadStatus {
	
	CREATED("created"), NO_CONTACT("no_contact"), ATTEMPTED_CONTACT("attempted_contact"), 
		SUCCESSFUL_CONTACT("successful_contact"), CAMPAIGN_CANDIDATE("campaign_candidate"), 
		IN_CAMPAIGN("in_campaign"), CAMPAIGN_COMPLETE("campaign_complete"), CLOSED("closed");
	
	private String stringName;
	private LeadStatus(String name) {
		this.stringName = name;
	}
}
