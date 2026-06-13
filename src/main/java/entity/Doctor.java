package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 3, max = 20)
	@NotBlank
	private String name;

	@Min(20)
	@Max(70)
	private Integer age;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Email
	@Column(nullable = false, unique = true)
	private String email;

	@Pattern(regexp = "^[0-9]{10}")
	private String phone;

	public Doctor(@Size(min = 3, max = 20) @NotBlank String name, @Min(20) @Max(70) Integer age, Gender gender,
			@Email String email, @Pattern(regexp = "^[0-9]{10}") String phone) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}

}
