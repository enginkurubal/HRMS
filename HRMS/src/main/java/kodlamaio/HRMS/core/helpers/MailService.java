package kodlamaio.HRMS.core.helpers;

public interface MailService {
	public boolean sendMail(String email);
	boolean checkMailActivation();
}
