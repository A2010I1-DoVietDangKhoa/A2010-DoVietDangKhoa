package vn.codegym.casestudy.model.People.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "division")
public class DivisionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "division_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "divisionEntity")
    private List<EmployeeEntity> employeeEntities = new ArrayList<>();

}
