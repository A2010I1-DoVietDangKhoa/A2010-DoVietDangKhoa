package vn.codegym.casestudy.model.Contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.codegym.casestudy.model.People.Customer.CustomerEntity;
import vn.codegym.casestudy.model.People.Customer.CustomerTypeEntity;
import vn.codegym.casestudy.model.People.Employee.EmployeeEntity;
import vn.codegym.casestudy.model.Service.HouseEntity;
import vn.codegym.casestudy.model.Service.RoomEntity;
import vn.codegym.casestudy.model.Service.VillaEntity;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contract")
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "deposit")
    private Integer deposit;

    @Column(name = "total")
    private Integer total;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    @ManyToOne
    @JoinColumn(name = "villa_id")
    private VillaEntity villaEntity;
    @ManyToOne
    @JoinColumn(name = "house_id")
    private HouseEntity houseEntity;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
}
