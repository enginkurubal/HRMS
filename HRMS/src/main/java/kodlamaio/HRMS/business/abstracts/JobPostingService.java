package kodlamaio.HRMS.business.abstracts;


import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.JobPosting;
import kodlamaio.HRMS.entities.dtos.JobPostingAddDto;
import kodlamaio.HRMS.entities.dtos.JobPostingDto;

public interface JobPostingService {
	DataResult<List<JobPostingDto>>  findByIsActive();
	DataResult<List<JobPostingDto>> findByIsActiveOrderByApplicationDeadline(String applicationDeadline);
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
	Result add(JobPostingAddDto JobPostingAddDto);
	Result delete(JobPosting jobPosting);
}
