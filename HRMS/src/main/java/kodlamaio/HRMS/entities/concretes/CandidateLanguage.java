package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CandidateLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "language_name")
	private String languageName;
	
	@Column(name = "language_level")
	private char languageLevel;
	
	@Column(name = "added_date")
	private LocalDateTime addedDate = LocalDateTime.now();
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "cv_id")
	@ManyToOne(targetEntity = CandidateCv.class)
	private CandidateCv candidateCv;
}
