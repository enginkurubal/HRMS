package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateLanguage;
import kodlamaio.HRMS.entities.dtos.CandidateLanguageDto;

public interface CandidateLanguageService {
	
	DataResult<List<CandidateLanguage>> getAll();
	Result add(CandidateLanguageDto candidateLanguageDto);
}
