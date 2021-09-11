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
@Table(name = "position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "position_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "positionEntity")
    private List<EmployeeEntity> employeeEntities = new ArrayList<>();
}
