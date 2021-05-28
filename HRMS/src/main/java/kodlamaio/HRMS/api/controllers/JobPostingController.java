package kodlamaio.HRMS.api.controllers;

import java.sql.Date;
import java.util.List;

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

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingController {

	
	private JobPostingService jobPostingService;

	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobPosting>> getByEmployer(@RequestParam int employerId){
		return this.jobPostingService.getByEmployer(employerId);
	}
	@GetMapping("/getByPostedDate")
	public DataResult<List<JobPosting>> findByPostedDateOrderByPostedDate(Date postedDate){
		return this.jobPostingService.findByPostedDateOrderByPostedDate(postedDate);
	}
}
