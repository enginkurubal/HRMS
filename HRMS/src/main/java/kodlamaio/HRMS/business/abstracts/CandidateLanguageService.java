package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	
	DataResult<List<CandidateLanguage>> getAll();
	Result add(CandidateLanguage candidateLanguage);
}
