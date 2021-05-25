package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerCheckService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;
@Service
public class EmployerCheckManager implements EmployerCheckService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> findByEmail(String email) {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findByEmailIs(email));
	}

	@Override
	public boolean checkIfMailExist(Employer employer) {
		if(this.findByEmail(employer.getEmail()).getData().size()!=0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkIfDomain(Employer employer) {
		String regex = "^[A-Za-z0-9._%+-]+@" + employer.getWebAddress() +"$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if(matcher.matches()) {
       	 return true;
        }else {
            return false;
        }
	}

}
