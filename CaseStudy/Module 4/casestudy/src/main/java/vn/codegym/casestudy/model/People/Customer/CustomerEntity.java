package vn.codegym.casestudy.model.People.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.casestudy.model.People.PeopleEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity extends PeopleEntity{
    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "customer_code")
    @Pattern(regexp = "^KH-\\d{4}$",
            message = "Customer ID must be in KH-XXXX format.")
    private String customerCode;

    @Column(name = "address")
    @NotBlank(message = "Address can't be empty.")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerTypeEntity customerTypeEntity;

}
