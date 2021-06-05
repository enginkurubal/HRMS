package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateSchool;
import kodlamaio.HRMS.entities.dtos.CandidateSchoolDto;

public interface CandidateSchoolService {
	DataResult<List<CandidateSchool>> getAll();
	DataResult<List<CandidateSchoolDto>> findByCandidateCvIdOrderByStartedDateDesc(int id);
	Result add(CandidateSchoolDto candidateSchoolDto);
}
