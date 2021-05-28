package kodlamaio.HRMS.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobPostingService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobPostingDao;
import kodlamaio.HRMS.entities.concretes.Candidate;
import kodlamaio.HRMS.entities.concretes.JobPosting;
@Service
public class JobPostingManager implements JobPostingService{
	
	private JobPostingDao jobPostingDao;
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>
		(this.jobPostingDao.findAll(),"İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobPosting>> getByEmployer(int employerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPosting>> findByPostedDateOrderByPostedDate(Date postedDate) {
		return new SuccessDataResult<List<JobPosting>>
		(this.jobPostingDao.findByPostedDateOrderByPostedDate(postedDate),"İş ilanları tarihlerine göre listelendi.");
	}

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi.");
	}

}
