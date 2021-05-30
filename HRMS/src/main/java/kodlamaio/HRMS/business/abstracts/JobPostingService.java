package kodlamaio.HRMS.business.abstracts;


import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getByEmployer(String companyName);
	DataResult<List<JobPosting>> findByIsActiveOrderByApplicationDeadline(String applicationDeadline);
	Result add(JobPosting jobPosting);
	Result delete(JobPosting jobPosting);
}
