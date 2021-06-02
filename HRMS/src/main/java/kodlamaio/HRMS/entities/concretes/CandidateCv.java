package kodlamaio.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_cv")
public class CandidateCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_date")
	private String updatedDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id",referencedColumnName = "id",nullable = false)
	private Candidate candidate;
	
	@OneToMany(mappedBy = "CandidateCv")
	private List<CandidateTechnology> candidateTechnology;
	
	@OneToMany(mappedBy = "CandidateCv")
	private List<CandidateLanguage> candidateLanguage;
	
	@OneToMany(mappedBy = "CandidateCv")
	private List<CandidateJobExperience> candidateJobExperience;
	
	@OneToMany(mappedBy = "CandidateCv")
	private List<CandidateSchool> candidateSchool;
}
