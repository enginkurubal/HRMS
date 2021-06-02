package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmployerActivationByEmployeeService;
import kodlamaio.HRMS.business.abstracts.EmployerCheckService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.helpers.MailService;
import kodlamaio.HRMS.core.utilities.DataResult;

import kodlamaio.HRMS.core.utilities.ErrorResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmployerCheckService employerCheckService;
	private MailService mailService;
	private EmployerActivationByEmployeeService employeeEmployerActivationByEmployeeService;
	
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerCheckService employerCheckService, MailService mailService,
			EmployerActivationByEmployeeService employeeEmployerActivationByEmployeeService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService = employerCheckService;
		this.mailService = mailService;
		this.employeeEmployerActivationByEmployeeService = employeeEmployerActivationByEmployeeService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"İşverenler Listelendi.");
	}

	@Override
	public Result add(Employer employer) {
		if(!this.employerCheckService.checkIfMailExist(employer)) {
			return new ErrorResult("Bu e-posta ile kayıt bulunmaktadır.");
		}else if(!this.employerCheckService.checkIfDomain(employer)) {
			return new ErrorResult("E-posta ile web sitenin domaini aynı olmalıdır.");
		}else if(!this.mailService.checkMailActivation()) {
			return new ErrorResult("E-posta adresinize gelen aktivasyon işlemini tamamlayın.");
		}else if(!this.employeeEmployerActivationByEmployeeService.activationByEmployee(employer)){
			return new ErrorResult("Kayıt işlemi başarısız, sistem onayını bekleyin.");
		}else {
			this.employerDao.save(employer);
			return new SuccessResult("Kayıt işlemi başarılı. "+employer.getCompanyName()+ "Hoşgediniz..");
		}
		
	}


}
