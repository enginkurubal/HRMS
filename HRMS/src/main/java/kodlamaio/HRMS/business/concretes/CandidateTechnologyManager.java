package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateTechnologyService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateTechnologyDao;
import kodlamaio.HRMS.entities.concretes.CandidateTechnology;

@Service
public class CandidateTechnologyManager implements CandidateTechnologyService {
	
	private CandidateTechnologyDao candidateTechnologyDao;
	
	@Autowired
	public CandidateTechnologyManager(CandidateTechnologyDao candidateTechnologyDao) {
		super();
		this.candidateTechnologyDao = candidateTechnologyDao;
	}

	@Override
	public DataResult<List<CandidateTechnology>> getAll() {
		
		return new SuccessDataResult<List<CandidateTechnology>>
		(this.candidateTechnologyDao.findAll(),"Teknolojiler listelendi.");
	}

	@Override
	public Result add(CandidateTechnology candidateTechnology) {
		this.candidateTechnologyDao.save(candidateTechnology);
		return new SuccessResult("Teknoloji eklendi.");
	}

}
