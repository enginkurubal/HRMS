package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateSchoolGraduate;

public interface CandidateSchoolGraduateService {

		DataResult<List<CandidateSchoolGraduate>> getAll();
		Result add(CandidateSchoolGraduate candidateSchoolGraduate);
}
