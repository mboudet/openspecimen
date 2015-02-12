package com.krishagni.catissueplus.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.krishagni.catissueplus.core.biospecimen.events.CollectionProtocolEventDetail;
import com.krishagni.catissueplus.core.biospecimen.services.CollectionProtocolService;
import com.krishagni.catissueplus.core.common.events.RequestEvent;
import com.krishagni.catissueplus.core.common.events.ResponseEvent;

import edu.wustl.catissuecore.util.global.Constants;
import edu.wustl.common.beans.SessionDataBean;

@Controller
@RequestMapping("/collection-protocol-events")
public class CollectionProtocolEventsController {

	@Autowired
	private CollectionProtocolService cpSvc;
	
	@Autowired
	private HttpServletRequest httpServletRequest;	

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CollectionProtocolEventDetail> getEvents(
			@RequestParam(value = "cpId", required = true) 
			Long cpId) {
		ResponseEvent<List<CollectionProtocolEventDetail>> resp = cpSvc.getProtocolEvents(getRequest(cpId));
		resp.throwErrorIfUnsuccessful();
		return resp.getPayload();
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public CollectionProtocolEventDetail getEvent(@PathVariable("id") Long cpeId) {
		ResponseEvent<CollectionProtocolEventDetail> resp = cpSvc.getProtocolEvent(getRequest(cpeId));
		resp.throwErrorIfUnsuccessful();
		return resp.getPayload();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CollectionProtocolEventDetail createEvent(@RequestBody CollectionProtocolEventDetail event) {
		ResponseEvent<CollectionProtocolEventDetail> resp = cpSvc.addEvent(getRequest(event));
		resp.throwErrorIfUnsuccessful();
		return resp.getPayload();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{eventId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CollectionProtocolEventDetail updateEvent(
			@PathVariable("eventId") Long eventId,
			@RequestBody CollectionProtocolEventDetail event) {
		
		event.setId(eventId);
		
		ResponseEvent<CollectionProtocolEventDetail> resp = cpSvc.updateEvent(getRequest(event));
		resp.throwErrorIfUnsuccessful();
		return resp.getPayload();
	}	
	
	private <T> RequestEvent<T> getRequest(T payload) {
		return new RequestEvent<T>(getSession(), payload);
	}
	
	private SessionDataBean getSession() {
		return (SessionDataBean) httpServletRequest.getSession().getAttribute(Constants.SESSION_DATA);
	}	
}
