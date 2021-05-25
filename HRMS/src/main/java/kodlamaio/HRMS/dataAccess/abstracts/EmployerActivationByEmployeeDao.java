package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployerActivationByEmployeeDao {
	boolean activationByEmployee();
}
