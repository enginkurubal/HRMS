package kodlamaio.HRMS.business.concretes;



import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.UserCheckService;
import kodlamaio.HRMS.entities.concretes.User;

@Service
public class UserCheckManager implements UserCheckService{

	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().length() < 6) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPasswordExist(User user) {
		if(user.getPassword().equals(user.getPasswordRepeat())) {
			return true;
		}
		return false;
	}

	
}
