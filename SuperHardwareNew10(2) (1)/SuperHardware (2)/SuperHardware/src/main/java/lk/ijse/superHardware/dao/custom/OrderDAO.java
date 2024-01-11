package lk.ijse.superHardware.dao.custom;

import lk.ijse.superHardware.dao.CrudDAO;
import lk.ijse.superHardware.dto.OrderDto;
import lk.ijse.superHardware.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO extends CrudDAO<OrderDto> {
    /*boolean saveOrder(OrderDto dto) throws SQLException;

    boolean updateOrder(OrderDto dto) throws SQLException;

    boolean deleteOrder(String ord_id) throws SQLException;

    List<OrderDto> getAllOrders() throws SQLException;

     */

    boolean save(Order entity) throws SQLException;

    boolean update(Order entity) throws SQLException;

    String getNextOrderId() throws SQLException;

     String splitOrderId(String currentId);
}

