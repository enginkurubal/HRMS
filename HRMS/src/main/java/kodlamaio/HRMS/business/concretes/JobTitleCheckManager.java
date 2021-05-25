package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobTitleCheckService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlamaio.HRMS.entities.concretes.JobTitle;
@Service
public class JobTitleCheckManager implements JobTitleCheckService{
	
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleCheckManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public boolean checkIfTitleExist(JobTitle jobTitle) {
		if(this.findByTitleIs(jobTitle.getTitle()).getData().size()!=0) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<JobTitle>> findByTitleIs(String title) {
		
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findByTitleIs(title));
		
	}

}
