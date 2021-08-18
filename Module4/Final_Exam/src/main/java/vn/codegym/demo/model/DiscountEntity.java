package vn.codegym.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount")
public class DiscountEntity implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title")
    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @Column(name = "start", columnDefinition = "DATE")
    private String startDate;

    @Column(name = "end", columnDefinition = "DATE")
    private String endDate;

    @Column(name = "rate")
    @Min(value = 10000, message = "Discount rate must be higher than 10000.")
    private Integer discountRate = 0;

    @Column(name = "detail")
    @NotBlank(message = "Detail cannot be blank.")
    private String detail;

    @Override
    public boolean supports(Class<?> clazz) {
        return DiscountEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DiscountEntity customer = (DiscountEntity) target;
        if (customer.getStartDate().equals("") || customer.getEndDate().equals("")) {
            errors.rejectValue("startDate", "start.date.null");
            errors.rejectValue("endDate", "end.date.null");
        }
        else {
            String[] dateStart = customer.getStartDate().split("-");
            String[] dateEnd = customer.getEndDate().split("-");
            int yearStart = Integer.parseInt(dateStart[0]);
            int yearEnd = Integer.parseInt(dateEnd[0]);
            int monthStart = Integer.parseInt(dateStart[1]);
            int monthEnd = Integer.parseInt(dateEnd[1]);
            int dayStart = Integer.parseInt(dateStart[2]);
            int dayEnd = Integer.parseInt(dateEnd[2]);
            String startDate = yearStart + "-" + monthStart + "-" + dayStart;
            String endDate = yearEnd + "-" + monthEnd + "-" + dayEnd;
            //                birthday18th = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            if (yearStart > yearEnd) {
                errors.rejectValue("startDate", "start.greater.end");
                errors.rejectValue("endDate", "start.greater.end");
            }
            else if (monthStart > monthEnd){
                errors.rejectValue("startDate", "start.greater.end");
                errors.rejectValue("endDate", "start.greater.end");
            }
            else if (dayStart >= dayEnd){
                errors.rejectValue("startDate", "start.greater.end");
                errors.rejectValue("endDate", "start.greater.end");
            }
        }
    }
}
