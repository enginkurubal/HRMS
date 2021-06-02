package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceService {
	DataResult<List<CandidateJobExperience>> getAll();
	Result add(CandidateJobExperience candidateJobExperience);
}
