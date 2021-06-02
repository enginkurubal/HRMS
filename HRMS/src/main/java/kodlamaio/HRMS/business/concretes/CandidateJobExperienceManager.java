package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateJobExperienceService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlamaio.HRMS.entities.concretes.CandidateJobExperience;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService{
	
	private CandidateJobExperienceDao candidateJobExperienceDao;
	
	@Autowired
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao) {
		super();
		this.candidateJobExperienceDao = candidateJobExperienceDao;
	}

	
	
	
	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		return new SuccessDataResult<List<CandidateJobExperience>>
		(this.candidateJobExperienceDao.findAll(),"İş tecrübeleri listelendi.");
	}

	@Override
	public Result add(CandidateJobExperience candidateJobExperience) {
		this.candidateJobExperienceDao.save(candidateJobExperience);
		return new SuccessResult("İş tecrübesi eklendi.");
	}

}
