package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.entities.concretes.User;

public interface ActivationCodeService {
	
	String createActivationCode(User user);
	void sendMail(String email);
	Result activeUser(String activationCode);
}
