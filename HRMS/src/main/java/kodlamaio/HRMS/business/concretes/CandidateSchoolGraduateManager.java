package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateSchoolGraduateService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateSchoolGraduateDao;
import kodlamaio.HRMS.entities.concretes.CandidateSchoolGraduate;

@Service
public class CandidateSchoolGraduateManager implements CandidateSchoolGraduateService{
	
	private CandidateSchoolGraduateDao candidateSchoolGraduateDao;
	
	public CandidateSchoolGraduateManager(CandidateSchoolGraduateDao candidateSchoolGraduateDao) {
		super();
		this.candidateSchoolGraduateDao = candidateSchoolGraduateDao;
	}

	@Override
	public DataResult<List<CandidateSchoolGraduate>> getAll() {
		
		return new SuccessDataResult<List<CandidateSchoolGraduate>>
		(this.candidateSchoolGraduateDao.findAll(),"Lisansüstü eğitimleri listelendi.");
	}

	@Override
	public Result add(CandidateSchoolGraduate candidateSchoolGraduate) {
		this.candidateSchoolGraduateDao.save(candidateSchoolGraduate);
		return new SuccessResult("Lisansüstü eğimitimi eklendi.");
	}

}
