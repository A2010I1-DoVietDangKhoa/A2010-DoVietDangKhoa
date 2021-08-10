package vn.codegym.casestudy.model.People.Employee;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.casestudy.model.People.PeopleEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends PeopleEntity {
    @Column(name = "salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity positionEntity;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private EducationEntity educationEntity;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private DivisionEntity divisionEntity;
}
