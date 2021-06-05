package kodlamaio.HRMS.entities.dtos;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSchoolDto {
	
	@JsonIgnore
	private int id;
	private int candidateCvId;
	private int candidateSchoolGraduateId;
	private String schoolName;
	private String schoolDepartment;
	private Date startedDate;
	private Date endDate;
	private LocalDate addedDate = LocalDate.now();
}
