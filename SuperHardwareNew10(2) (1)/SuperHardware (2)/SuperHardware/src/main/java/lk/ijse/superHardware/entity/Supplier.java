package lk.ijse.superHardware.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter

public class Supplier {
    private String sup_id;

    private String sup_name;

    private String address;

    private String email;
}
