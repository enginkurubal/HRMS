package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateJobExperience;
import kodlamaio.HRMS.entities.dtos.CandidateJobExperienceDto;

public interface CandidateJobExperienceService {
	DataResult<List<CandidateJobExperience>> getAll();
	DataResult<List<CandidateJobExperienceDto>> findByCandidateCvIdOrderByEndDateDesc(int id);
	Result add(CandidateJobExperienceDto candidateJobExperienceDto);
}
