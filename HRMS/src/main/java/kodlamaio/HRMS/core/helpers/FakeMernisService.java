package kodlamaio.HRMS.core.helpers;

import kodlamaio.HRMS.entities.concretes.Candidate;

public interface FakeMernisService {
  boolean ifRealPerson(Candidate candidate);
}
