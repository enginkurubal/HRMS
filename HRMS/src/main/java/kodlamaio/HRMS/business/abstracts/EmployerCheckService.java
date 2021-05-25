package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.Employer;

public interface EmployerCheckService {
	DataResult<List<Employer>> findByEmail(String email);
	boolean checkIfMailExist(Employer employer);
	boolean checkIfDomain(Employer employer);
}
