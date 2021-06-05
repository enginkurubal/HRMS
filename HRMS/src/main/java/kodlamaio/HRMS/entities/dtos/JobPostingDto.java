package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	
	private String employerCompanyName;
	private String jobTitleTitle;
	private int numberOfOpenPosition;
	private LocalDateTime postedDate = LocalDateTime.now();
	private String applicationDeadline;
	private String jobDetails;
	
	
}
