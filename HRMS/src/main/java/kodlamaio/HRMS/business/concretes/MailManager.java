package kodlamaio.HRMS.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.helpers.MailService;
import kodlamaio.HRMS.core.utilities.SuccessResult;
@Service
public class MailManager implements MailService{

	

	@Override
	public boolean sendMail(String email) {
		
		return sendMail(email);
	}

	@Override
	public boolean checkMailActivation() {
		
		return true;
	}

	
}
