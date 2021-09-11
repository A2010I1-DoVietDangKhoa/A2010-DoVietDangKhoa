package vn.codegym.casestudy.model.People.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.casestudy.model.People.Employee.EmployeeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_type")
public class CustomerTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_type_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customerTypeEntity")
    private List<CustomerEntity> customerEntities = new ArrayList<>();
}
