package lk.ijse.superHardware.bo.custom;

import lk.ijse.superHardware.bo.SuperBO;
import lk.ijse.superHardware.dto.CartDTO;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.OrderItemDetailsDto;
import lk.ijse.superHardware.entity.OrderItemDetails;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {

    public static boolean PlaceOrder(String ordrid, String customerId, Date date, double netTotal, List<CartDTO> cartDTOList) throws SQLException {
        return false;
    }


    static boolean save(OrderItemDetailsDto dto) throws SQLException {
        return false;
    }

    boolean update(OrderItemDetailsDto dto) throws SQLException;

    boolean delete(String id) throws SQLException;

    List<OrderItemDetails> getAll() throws SQLException;

    OrderItemDetails search(String id) throws SQLException;

    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderItemDetailsDto> orderDetails) throws SQLException, ClassNotFoundException;

    CustomerDto searchCustomer(String cust_id) throws SQLException, ClassNotFoundException;
}
