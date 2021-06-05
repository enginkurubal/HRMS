package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CandidateSchoolService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateSchool;
import kodlamaio.HRMS.entities.dtos.CandidateSchoolDto;

@RestController
@RequestMapping("/api/candidateSchool")
public class CandidateSchoolsController {
	
	private CandidateSchoolService candidateSchoolService;
	
	@Autowired
	public CandidateSchoolsController(CandidateSchoolService candidateSchoolService) {
		super();
		this.candidateSchoolService = candidateSchoolService;
	} 
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSchool>> getAll(){
		return this.candidateSchoolService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSchoolDto candidateSchoolDto) {
		return this.candidateSchoolService.add(candidateSchoolDto);
	}
	
	@GetMapping("/rderByStartedDateDesc")
	public DataResult<List<CandidateSchoolDto>> OrderByStartedDateDesc(int id){
		return this.candidateSchoolService.findByCandidateCvIdOrderByStartedDateDesc(id);
		
	}
	
}
