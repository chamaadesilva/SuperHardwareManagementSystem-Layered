package lk.ijse.superHardware.dao.impl;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.OrderItemDetailsDAO;
import lk.ijse.superHardware.dto.CartDTO;
import lk.ijse.superHardware.dto.OrderItemDetailsDto;
import lk.ijse.superHardware.entity.Employee;
import lk.ijse.superHardware.entity.OrderItemDetails;

import java.sql.SQLException;
import java.util.List;

public class OrderItemDetailsDAOImpl implements OrderItemDetailsDAO {

    public static boolean save(OrderItemDetailsDto detailsDto) throws SQLException {
        for(CartDTO dto : detailsDto.getCartDTOList()){
            if(!save(detailsDto.getOrder_id(), dto)){
                return false;
            }
        }
        return true;
    }
    public static boolean save(String orderId, CartDTO dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO order_item_details(item_stock_code, order_id, ord_quantity)" +
                "VALUES(?, ?, ?)");
    }


    @Override
    public boolean update(OrderItemDetailsDto dto) throws SQLException {
        return false;
    }

    @Override
    public boolean save(Employee dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Employee dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<OrderItemDetails> getAll() throws SQLException {
        return null;
    }

    @Override
    public OrderItemDetails search(String id) throws SQLException {
        return null;
    }
}
