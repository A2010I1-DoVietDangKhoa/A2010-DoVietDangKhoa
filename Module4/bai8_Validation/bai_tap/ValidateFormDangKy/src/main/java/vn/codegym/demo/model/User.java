package vn.codegym.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    @NotEmpty
    @Size(min = 5, max = 45, message = "Must be 5-45 characters long.")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty
    @Size(min = 5, max = 45, message = "Must be 5-45 characters long.")
    private String lastName;

    @Column(name = "phone")
    @NotEmpty
    @Pattern(regexp = "[0-9]{9}", message = "Phone number must has 9 digits.")
    private String phone;

    @Column(name = "age")
    @Min(value = 18, message = "Age must be above 18.")
    private Integer age;

    @Column(name = "email")
    @Email
    private String email;
}
