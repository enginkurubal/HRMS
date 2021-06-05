package kodlamaio.HRMS.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateLanguageDto {
	private int id;
	private int candidateCvId;
	private String languageName;
	private char languageLevel;
	private LocalDateTime addedDate = LocalDateTime.now();
}
