package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateCv;

public interface CandidateCvService {
	
	DataResult<List<CandidateCv>> getAll();
	Result add(CandidateCv candidateCv);
}
