package kodlamaio.HRMS.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_postings")
public class JobPosting {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",nullable=false,unique=true)	
  private int id;
  
  @Column(name = "job_details")
  private String jobDetails;
  
  @Column(name = "min_wage")
  private double minWage;
  
  @Column(name = "max_wage")
  private double maxWage;
  
  @Column(name = "number_of_open_position")
  private int numberOfOpenPosition;
  
  @Column(name = "last_apply_date")
  private Date lastApplyDate;
  
  @Column(name = "is_active")
  private boolean isActive;
  
  @Column(name = "posted_date")
  private LocalDate postedDate;
  
  @Column(name = "post_name")
  private String postName;
  
  @ManyToOne()
  @JoinColumn(name = "employer_id",insertable=false, updatable=false)
  private Employer employer;
  
  @ManyToOne()
  @JoinColumn(name = "id",insertable=false, updatable=false)
  private City city;
  
  @ManyToOne()
  @JoinColumn(name = "title_id",insertable=false, updatable=false)
  private JobTitle jobTitle;
  
}
