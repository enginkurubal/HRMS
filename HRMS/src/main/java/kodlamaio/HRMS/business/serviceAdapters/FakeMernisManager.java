package kodlamaio.HRMS.business.serviceAdapters;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.helpers.FakeMernisService;
import kodlamaio.HRMS.entities.concretes.Candidate;
@Service
public class FakeMernisManager implements FakeMernisService{

	@Override
	public boolean ifRealPerson(Candidate candidate) {
		if(candidate.getIdentityNumber().length() != 11 ) {
			return false;
		}
		return true;
	}

}
