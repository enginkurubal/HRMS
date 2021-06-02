package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateSchool;

public interface CandidateSchoolService {
	DataResult<List<CandidateSchool>> getAll();
	Result add(CandidateSchool candidateSchool);
}
