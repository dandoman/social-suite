package com.merccann;

import lombok.Getter;

@Getter
public enum ScrapeableHandleType {

	EMAIL("email"), INSTAGRAM("instagram"), FACEBOOK("facebook"), TWITTER("twitter"), YOUTUBE("youtube");

	private String stringName;

	private ScrapeableHandleType(String name) {
		this.stringName = name;
	}
}
