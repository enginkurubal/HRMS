package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.CandidateTechnology;

public interface CandidateTechnologyService {

		DataResult<List<CandidateTechnology>> getAll();
		Result add(CandidateTechnology candidateTechnology);
}
