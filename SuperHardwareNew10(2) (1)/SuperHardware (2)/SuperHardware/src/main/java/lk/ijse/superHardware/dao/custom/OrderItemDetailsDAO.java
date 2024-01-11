package lk.ijse.superHardware.dao.custom;

import lk.ijse.superHardware.dao.CrudDAO;
import lk.ijse.superHardware.dto.OrderItemDetailsDto;
import lk.ijse.superHardware.entity.OrderItemDetails;

import java.sql.SQLException;

public interface OrderItemDetailsDAO extends CrudDAO<OrderItemDetails> {
    static boolean save(OrderItemDetailsDto dto) throws SQLException {
        return false;
    }

    boolean update(OrderItemDetailsDto dto) throws SQLException;
}
