package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobTitleCheckService;
import kodlamaio.HRMS.business.abstracts.JobTitleService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.ErrorResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobTitleDao;
import kodlamaio.HRMS.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleCheckService jobTitleCheckService;
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao,JobTitleCheckService jobTitleCheckService) {
		super();
		this.jobTitleDao = jobTitleDao;
		this.jobTitleCheckService=jobTitleCheckService;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(),"İş pozisyonları listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(!this.jobTitleCheckService.checkIfTitleExist(jobTitle)) {
			return new ErrorResult("Girilen iş pozisyonu zaten mevcut.");
		}else {
			this.jobTitleDao.save(jobTitle);
			return new SuccessResult(jobTitle.getTitle()+" : eklendi.");
		}
		
		
	}

}
