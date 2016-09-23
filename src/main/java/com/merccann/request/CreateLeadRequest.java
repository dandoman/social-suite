package com.merccann.request;

import org.apache.commons.lang3.StringUtils;

import com.merccann.exception.BadArgsException;

import lombok.Data;

@Data
public class CreateLeadRequest implements Request {
	private String email;
	private String websiteUrl;
	private String instagram;
	private String facebook;
	private String twitter;
	private String youtube;

	@Override
	public void validate() {
		// One of these needs to be defined
		if (StringUtils.isEmpty(email) && StringUtils.isEmpty(websiteUrl) && StringUtils.isEmpty(instagram)
				&& StringUtils.isEmpty(facebook) && StringUtils.isEmpty(twitter) && StringUtils.isEmpty(youtube)) {
			throw new BadArgsException("At least one of email, websiteUrl, instagram, facebook, twitter or youtube must be defined");
		}
	}
}
