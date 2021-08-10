package vn.codegym.casestudy.model.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "additional_service")
public class AdditionalServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "service_name")
    private String name;

    @Column(name = "unit")
    private Integer unit;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;
}
