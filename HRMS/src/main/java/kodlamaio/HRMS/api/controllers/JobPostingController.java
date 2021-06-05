package kodlamaio.HRMS.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobPostingService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.JobPosting;
import kodlamaio.HRMS.entities.dtos.JobPostingAddDto;
import kodlamaio.HRMS.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingController {

	
	private JobPostingService jobPostingService;
	
	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/isActive")
	public DataResult<List<JobPostingDto>> findByIsActive(){
		return this.jobPostingService.findByIsActive();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.add(jobPostingAddDto);
	}
	
	@GetMapping("/getByEmployer")
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName){
		return this.jobPostingService.findByIsActiveAndEmployer_CompanyName(companyName);
	}
	
	@DeleteMapping("/deletePost")
	public Result delete(@RequestParam JobPosting jobPosting) {
		return this.jobPostingService.delete(jobPosting);
		
	}
}
