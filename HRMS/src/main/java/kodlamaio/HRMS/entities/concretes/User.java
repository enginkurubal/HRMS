package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Email(message = "Geçerli bir mail giriniz..")
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Size(min=6, message = "Şifre alanı en az 6 karakterden oluşturulmalıdır")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Transient 										//veri tabanında sütunu oluşmayacak
	@JsonProperty(access = Access.WRITE_ONLY)
	private String passwordRepeat;
	
	@Column(name = "active")
	private boolean active = false;
}
