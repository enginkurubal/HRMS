package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CandidateJobExperienceService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateJobExperience;

@RestController
@RequestMapping("/api/candidateJobExperinces")
public class CandidateJobExperincesController {
	
	private CandidateJobExperienceService candidateJobExperienceService;
	
	@Autowired
	public CandidateJobExperincesController(CandidateJobExperienceService candidateJobExperienceService) {
		super();
		this.candidateJobExperienceService = candidateJobExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateJobExperience>> getAll(){
		return this.candidateJobExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateJobExperience candidateJobExperience) {
		return this.candidateJobExperienceService.add(candidateJobExperience);
	}
}
