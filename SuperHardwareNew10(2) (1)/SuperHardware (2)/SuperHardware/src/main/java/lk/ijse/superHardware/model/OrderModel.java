package lk.ijse.superHardware.model;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.OrderDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderModel {
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

    public static boolean save(OrderDto dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO orders VALUES(?,?,?,?)",dto.getOrd_id(),dto.getCust_id(),dto.getOrd_payment(),dto.getOrd_date());
    }

    ////////////////////////place order//////////////////////////////////////////////////////////////////////////////

    public static boolean saveOrder(OrderDto dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO orders VALUES(?,?,?,?)",dto.getOrd_id(),dto.getCust_id(),dto.getOrd_payment(),dto.getOrd_date());

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
        return SQLUtil.execute("UPDATE orders SET cust_id = ?,payment =?,ord_date = ? WHERE order_id = ?",dto.getCust_id(),dto.getOrd_payment(),dto.getOrd_date(),dto.getOrd_id());
    }

    public boolean deleteOrder(String ord_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM orders WHERE order_id = ?",ord_id);
    }

    public List<OrderDto> getAllOrders() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM orders");
        List<OrderDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String ord_id = resultSet.getString(1);
            String cust_id = resultSet.getString(2);
            double ord_payment = resultSet.getDouble(3);
            Date ord_date = resultSet.getDate(4);

            OrderDto dto = new OrderDto(ord_id,ord_payment,ord_date,cust_id);
            dtoList.add(dto);
        }
        return dtoList;

    }


}