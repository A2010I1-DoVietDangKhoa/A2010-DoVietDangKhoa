package vn.codegym.casestudy.model.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.casestudy.model.Contract.ContractEntity;
import vn.codegym.casestudy.model.People.Employee.UserRoleEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "house")
public class HouseEntity extends BaseEntity{
    @Column(name = "room_standard")
    private String standard;

    @Column(name = "other_description")
    private String otherConveniencesDesc;

    @Column(name = "floors")
    private Integer floors;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "houseEntity")
    private List<ContractEntity> contractEntities = new ArrayList<>();
}
