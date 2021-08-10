package vn.codegym.casestudy.model.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.casestudy.model.Contract.ContractEntity;
import vn.codegym.casestudy.model.People.Employee.EmployeeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class RoomEntity extends BaseEntity{
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "roomEntity")
    private List<AdditionalServiceEntity> additionalServiceEntities = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "roomEntity")
    private List<ContractEntity> contractEntities = new ArrayList<>();
}
