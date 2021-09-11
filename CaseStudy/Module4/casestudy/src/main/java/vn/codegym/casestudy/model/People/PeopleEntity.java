package vn.codegym.casestudy.model.People;

import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;
import vn.codegym.casestudy.model.Service.RentTypeEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class PeopleEntity implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @Column(name = "birthday", columnDefinition = "DATE")
    private String birthday;

    @Column(name = "email")
    @Email(message = "Email must be in correct format.")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "identity_card")
    @Pattern(regexp = "^(\\d{9}|\\d{12})$",
            message = "ID card number must contain 9 or 12 digits.")
    private String personalId;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerEntity customer = (CustomerEntity) target;
        if (customer.getBirthday().equals("")) {
            errors.rejectValue("birthday", "customer.age.at.least.18");
        } else {
            String[] date = customer.getBirthday().split("-");
            int year = Integer.parseInt(date[0]);
            String birthday = (year + 18) + "-" + date[1] + "-" + date[2];
            Date birthday18th;
            try {
                birthday18th = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                if (birthday18th.compareTo(new Date()) > 0) {
                    errors.rejectValue("birthday", "customer.age.at.least.18");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
