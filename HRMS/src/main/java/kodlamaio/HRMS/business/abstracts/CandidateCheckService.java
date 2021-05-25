package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.DataResult;
import kodlamaio.HRMS.entities.concretes.Candidate;

public interface CandidateCheckService {
	DataResult<List<Candidate>> findByEmailIs(String email);
	DataResult<List<Candidate>> findByIdentityNumberIs(String identityNumber);
	boolean checkIfMailExist(Candidate candidate);
	boolean checkIfIdentityExist(Candidate candidate);
}
