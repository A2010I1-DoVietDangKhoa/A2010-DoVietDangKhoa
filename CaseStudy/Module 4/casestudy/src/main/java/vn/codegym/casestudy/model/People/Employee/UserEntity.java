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
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean isEnabled;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<UserRoleEntity> userRoleEntities = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    public UserEntity(String username) {
        this.username = username;
        this.password = "123456";
        this.isEnabled = true;
    }
}
