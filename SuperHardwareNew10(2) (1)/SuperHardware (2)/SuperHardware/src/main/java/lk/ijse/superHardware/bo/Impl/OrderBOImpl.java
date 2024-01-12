package lk.ijse.superHardware.bo.Impl;

import lk.ijse.superHardware.bo.custom.OrderBO;
import lk.ijse.superHardware.dao.DAOFactory;
import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.CustomerDAO;
import lk.ijse.superHardware.dao.custom.OrderDAO;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.OrderDto;
import lk.ijse.superHardware.entity.Order;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO =
            (OrderDAO) DAOFactory.getDaoFactory().
                    getDAO(DAOFactory.DAOTypes.ORDER);

    public static String getNextOrderId() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1");

        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private static String splitOrderId(String currentId) {
        if(currentId != null) {
            String[] strings = currentId.split("OD-");
            int id = Integer.parseInt(strings[1]);
            ++id;
            String digit=String.format("%03d", id);
            return "OD-" + digit;
        }
        return "OD-001";
    }

    public  boolean save(OrderDto dto) throws SQLException {
        return orderDAO.save(new Order(dto.getOrd_id(),dto.getOrd_payment(),dto.getOrd_date(),dto.getCust_id()));
    }

    ////////////////////////place order//////////////////////////////////////////////////////////////////////////////

    public  boolean saveOrder(OrderDto dto) throws SQLException {
        return orderDAO.save(new Order(dto.getOrd_id(),dto.getOrd_payment(),dto.getOrd_date(),dto.getCust_id()));

    }


//    public String generateNextOrderId() throws SQLException {
//        Connection connection = DbConnection.getInstance().getConnection();
//
//        String sql = "SELECT ord_id FROM orders ORDER BY ord_id DESC LIMIT 1";
//        ResultSet resultSet = connection.prepareStatement(sql).executeQuery();
//
//        String currentOrderId = null;
//
//        if (resultSet.next()) {
//            currentOrderId = resultSet.getString(1);
//            return splitOrderId(currentOrderId);
//        }
//        return splitOrderId(null);
//    }
//
//    private String splitOrderId(String currentOrderId) {
//        if (currentOrderId != null) {
//            String[] split = currentOrderId.split("O");
//            int cust_id = Integer.parseInt(split[1]);
//           cust_id++;
//            return "O00" + cust_id;
//        }
//        return "O001";
//    }

    public boolean updateOrder(final OrderDto dto) throws SQLException {
        return orderDAO.update(new Order(dto.getOrd_id(),dto.getOrd_payment(),dto.getOrd_date(),dto.getCust_id()));
    }

    public boolean deleteOrder(String ord_id) throws SQLException {
        return orderDAO.delete(ord_id);
    }

    @Override
    public List<OrderDto> getAllOrders() throws SQLException {
        return null;
    }

    public List<OrderDto>getAllCustomers() throws SQLException{

        List<OrderDto> orders= orderDAO.getAll();
        List<OrderDto> orderDtos=new ArrayList<>();
        for (OrderDto order:orders) {
            orderDtos.add(new OrderDto(order.getOrd_id(),order.getOrd_payment(),order.getOrd_date(),order.getCust_id()));
        }
        return orderDtos;
    }



}
