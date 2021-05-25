package kodlamaio.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerActivationByEmployeeService;
import kodlamaio.HRMS.entities.concretes.Employer;
@Service
public class EmployerActivationByEmployeeManager implements EmployerActivationByEmployeeService {

	@Override
	public boolean activationByEmployee(Employer employer) {
		return true;
	}

	

	

	

}
