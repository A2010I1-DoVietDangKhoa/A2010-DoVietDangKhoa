package vn.codegym.casestudy.model.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.casestudy.model.Contract.ContractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "villa")
public class VillaEntity extends BaseEntity{
    @Column(name = "room_standard")
    private String standard;

    @Column(name = "other_description")
    private String otherConveniencesDesc;

    @Column(name = "pool_area")
    private Double poolArea;

    @Column(name = "floors")
    private Integer floors;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "villaEntity")
    private List<ContractEntity> contractEntities = new ArrayList<>();
}
