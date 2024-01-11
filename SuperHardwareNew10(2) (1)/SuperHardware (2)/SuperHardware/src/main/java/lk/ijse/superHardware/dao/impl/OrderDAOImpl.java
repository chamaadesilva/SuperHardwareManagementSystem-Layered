package lk.ijse.superHardware.dao.impl;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.OrderDAO;
import lk.ijse.superHardware.dto.OrderDto;
import lk.ijse.superHardware.entity.Employee;
import lk.ijse.superHardware.entity.Order;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public  boolean save(Order entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO orders VALUES(?,?,?,?)",
                entity.getOrd_id(),entity.getCust_id(),entity.getOrd_payment(),entity.getOrd_date());

    }

    @Override
    public boolean update(final Order entity) throws SQLException {
        return SQLUtil.execute("UPDATE orders SET cust_id = ?,payment =?,ord_date = ? WHERE order_id = ?",
                entity.getCust_id(),entity.getOrd_payment(),entity.getOrd_date(),entity.getOrd_id());
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
    public boolean delete(String ord_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM orders WHERE order_id = ?",ord_id);
    }

    @Override
    public List<OrderDto> getAll() throws SQLException {
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

    @Override
    public OrderDto search(String id) throws SQLException {
        return null;
    }


    @Override
    public String getNextOrderId() throws SQLException {
        return null;
    }

    @Override
    public String splitOrderId(String currentId) {
        return null;
    }
}

