package kodlamaio.HRMS.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "identity_number")
	private String identityNumber;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "birth_date")
	private Date birthDate;
	
}
