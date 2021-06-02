package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CandidateSchoolGraduateService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateSchoolGraduate;

@RestController
@RequestMapping("/api/candidateSchoolGraduates")
public class CandidateSchoolGraduatesController {
	
	private CandidateSchoolGraduateService candidateSchoolGraduateService;
	@Autowired
	public CandidateSchoolGraduatesController(CandidateSchoolGraduateService candidateSchoolGraduateService) {
		super();
		this.candidateSchoolGraduateService = candidateSchoolGraduateService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSchoolGraduate>> getAll(){
		return this.candidateSchoolGraduateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchoolGraduate candidateSchoolGraduate) {
		return this.candidateSchoolGraduateService.add(candidateSchoolGraduate);
	}
	
}
