package kodlamaio.HRMS.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvDto {
	
	private int id;
	private int candidateId;
	private String photo;
	private String githubLink;
	private String linkedinLink;
	private String coverLetter;
	private String createdDate;
	private String updatedDate;
}
