package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.entities.concretes.Employer;

public interface EmployerActivationByEmployeeService {
	
	boolean activationByEmployee(Employer employer);
}
