package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.entities.concretes.User;

public interface UserCheckService {
	boolean checkPassword(User user);
	boolean checkPasswordExist(User user);
}
