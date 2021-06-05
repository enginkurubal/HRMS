package kodlamaio.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ActivationCodeService;
import kodlamaio.HRMS.core.utilities.Result;
@RestController
@RequestMapping("/api/activationCode")
public class ActivationCodeController {
	
	private ActivationCodeService activationCodeService;
	
	@Autowired
	public ActivationCodeController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	public Result update(@PathVariable("activationCode") String activationCode) {
		return activationCodeService.activeUser(activationCode);
		
	}
}
