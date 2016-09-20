package com.merccann;

import lombok.Getter;

@Getter
public enum CampaignStatus {
	ACTIVE("Active"), INACTIVE("inactive");

	private String stringName;

	private CampaignStatus(String name) {
		this.stringName = name;
	}
}
