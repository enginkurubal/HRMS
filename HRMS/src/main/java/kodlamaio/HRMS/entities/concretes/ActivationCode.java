package kodlamaio.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activation_codes")
public class ActivationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private int id;
	
	@Column(name = "activation_code")
	@JsonIgnore
	private String activationCode;
	
	@Column(name = "is_confirmed")
	@JsonIgnore
	private boolean isConfirmed;
	
	@Column(name = "created_date")
	@JsonIgnore
	private Date createdDate;
	
	@Column(name = "confirmed_date")
	@JsonIgnore
	private Date confirmedDate;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="user_id",referencedColumnName = "id",nullable = false)
	@JsonIgnore
	private User user;
	
}
