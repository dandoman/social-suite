package com.merccann.logic;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.merccann.Lead;
import com.merccann.dao.LeadsDao;
import com.merccann.entity.Entity;
import com.merccann.entity.LeadEntity;
import com.merccann.view.EntityView;

import lombok.Setter;

public class AppLogic {
	@Autowired
	@Setter
	private LeadsDao appDao;
	
	
	public Lead createLead(String email, String websiteUrl, String facebook, String instagram, String twitter,
			String youtube) {
		String id = UUID.randomUUID().toString();
		LeadEntity entity = new LeadEntity();
		
		return appDao.createLead(entity);
	}


	public List<Lead> getPageOfLeads(int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}


	public Lead getLeadById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
