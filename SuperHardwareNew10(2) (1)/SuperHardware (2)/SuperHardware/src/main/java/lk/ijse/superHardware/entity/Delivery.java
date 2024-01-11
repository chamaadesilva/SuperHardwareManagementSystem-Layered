package lk.ijse.superHardware.entity;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter

public class Delivery {
    private String delivery_id;

    private String emp_id;

    private String ord_id;

    private String location;

    private Date delivered_date;

}
