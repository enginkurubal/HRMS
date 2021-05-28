package kodlamaio.HRMS.business.abstracts;

import java.sql.Date;
import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.JobPosting;

public interface JobPostingService {
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getByEmployer(int employerId);
	DataResult<List<JobPosting>> findByPostedDateOrderByPostedDate(Date postedDate);
	Result add(JobPosting jobPosting);
}
