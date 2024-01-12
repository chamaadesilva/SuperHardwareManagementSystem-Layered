package lk.ijse.superHardware.bo.custom;

import lk.ijse.superHardware.bo.SuperBO;
import lk.ijse.superHardware.dto.OrderDto;

import java.sql.SQLException;
import java.util.List;

public interface OrderBO extends SuperBO {
    static boolean saveOrder(OrderDto dto) throws SQLException {
        return false;
    }

    boolean updateOrder(OrderDto dto) throws SQLException;

    boolean deleteOrder(String ord_id) throws SQLException;

    List<OrderDto> getAllOrders() throws SQLException;

}
