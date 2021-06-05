package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingAddDto {
	@JsonIgnore
	private int id;
	private int employerId;
	private int jobTitleId;
	private int cityId;
	private String postName;
	private int numberOfOpenPosition;
	private int minSalary;
	private int maxSalary;
	private LocalDateTime postedDate = LocalDateTime.now();
	private String applicationDeadline;
	private String jobDetails;
}
