package kodlamaio.HRMS.entities.dtos;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidateJobExperienceDto {
	private int id;
	private int candidateCvId;
	private int jobTitleId;
	private String companyName;
	private Date startedDate;
	private Date endDate;
	@JsonIgnore()
	private LocalDateTime addedDate = LocalDateTime.now();
}
