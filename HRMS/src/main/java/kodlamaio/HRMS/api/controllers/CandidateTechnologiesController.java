package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CandidateTechnologyService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateTechnology;

@RestController
@RequestMapping("/api/candidateTechnologies")
public class CandidateTechnologiesController {
	
	private CandidateTechnologyService candidateTechnologyService;

	@Autowired
	public CandidateTechnologiesController(CandidateTechnologyService candidateTechnologyService) {
		super();
		this.candidateTechnologyService = candidateTechnologyService;
	}
	@GetMapping("/getAll")
	public DataResult<List<CandidateTechnology>> getAll(){
		return this.candidateTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(CandidateTechnology candidateTechnology) {
		return this.candidateTechnologyService.add(candidateTechnology);
	}
}
