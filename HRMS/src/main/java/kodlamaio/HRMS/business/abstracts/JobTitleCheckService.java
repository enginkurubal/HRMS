package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.JobTitle;

public interface JobTitleCheckService {
	boolean checkIfTitleExist(JobTitle jobTitle);
	DataResult<List<JobTitle>> findByTitleIs(String title);
}
