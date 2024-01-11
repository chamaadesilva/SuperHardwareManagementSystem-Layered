package lk.ijse.superHardware.entity;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter


public class Order {
    private String ord_id;

    private Double ord_payment;

    private Date ord_date;

    private String cust_id;

}
