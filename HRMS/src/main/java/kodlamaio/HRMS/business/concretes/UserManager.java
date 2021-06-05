package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.UserCheckService;
import kodlamaio.HRMS.business.abstracts.UserService;
import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.core.utilities.ErrorResult;
import kodlamaio.HRMS.core.utilities.Result;
import kodlamaio.HRMS.core.utilities.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.UserDao;
import kodlamaio.HRMS.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	UserDao userDao;
	UserCheckService userCheckService;
	@Autowired
	public UserManager(UserDao userDao,UserCheckService userCheckService) {
		super();
		this.userDao = userDao;
		this.userCheckService = userCheckService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Kullanıcılar listelendi.");
	}

	@Override
	public Result add(User user) {
		if(!this.userCheckService.checkPassword(user)) {
			return new ErrorResult("Parola 6 karakterden uzun olmalıdır.");
		}else if(!this.userCheckService.checkPasswordExist(user)) {
			return new ErrorResult("Parolalar eşleşmiyor.");
		}
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi.");
	}

	

}
