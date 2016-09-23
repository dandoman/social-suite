package com.merccann.api;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.merccann.Lead;
import com.merccann.dao.LeadsDao;
import com.merccann.entity.Entity;
import com.merccann.exception.BadArgsException;
import com.merccann.exception.NotFoundException;
import com.merccann.logic.AppLogic;
import com.merccann.request.CreateLeadRequest;
import com.merccann.response.EntityByIdResponse;
import com.merccann.view.EntityView;
import com.merccann.view.LeadView;

import io.swagger.annotations.ApiOperation;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/api/leads")
@Log4j2
public class LeadsAPI {
	@Autowired
	@Setter
	private AppLogic logic;

	@ApiOperation(value = "createLead")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public LeadView createLead(@RequestBody CreateLeadRequest r) {
		r.validate();
		log.info("Received request to create lead: " + r);
		Lead lead = logic.createLead(r.getEmail(), r.getWebsiteUrl(), r.getFacebook(), r.getInstagram(),
				r.getTwitter(), r.getYoutube());
		return LeadView.fromLead(lead);
	}

	@ApiOperation(value = "getLeads")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<LeadView> getLeads(@RequestParam(value = "page", required = false) Integer page) {
		int pageNo = (page == null) ? 0 : page;
		return logic.getPageOfLeads(pageNo).stream().map(LeadView::fromLead).collect(Collectors.toList());
	}

	@ApiOperation(value = "getLeadById")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public LeadView getLeadById(@PathVariable("id") String id) {
		if(StringUtils.isEmpty(id)) {
			throw new BadArgsException("id must be defined");
		}
		Lead lead = logic.getLeadById(id);
		if(lead == null) {
			throw new NotFoundException("Lead with id " + id + " not found");
		}
		return LeadView.fromLead(lead);
	}
}
