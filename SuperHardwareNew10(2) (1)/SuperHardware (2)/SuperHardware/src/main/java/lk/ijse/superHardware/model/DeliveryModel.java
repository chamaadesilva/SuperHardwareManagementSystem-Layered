package lk.ijse.superHardware.model;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.DeliveryDto;
import lk.ijse.superHardware.dto.EmployeeDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryModel {

    public boolean saveDelivery(final DeliveryDto dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO delivery VALUES(?, ?, ?, ? ,?)",dto.getDelivery_id(),dto.getEmp_id(),dto.getOrd_id(),dto.getLocation(),dto.getDelivered_date());
    }

    public boolean updateDelivery(final DeliveryDto dto) throws SQLException {
        return SQLUtil.execute("UPDATE delivery SET emp_id = ?, ord_id = ?, location = ?,delivered_date =? WHERE delivery_id = ?",dto.getEmp_id(),dto.getOrd_id(),dto.getOrd_id(),dto.getLocation(),dto.getDelivered_date(),dto.getDelivery_id());
    }

    public DeliveryDto searchDelivery(String delivery_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM delivery WHERE delivery_id = ?",delivery_id);
        resultSet.next();
        return new DeliveryDto(delivery_id +"",resultSet.getString("emp_id"),resultSet.getString("ord_id"),resultSet.getString("location"),resultSet.getDate("delivered_date"));
    }

    public List<DeliveryDto> getAllDeliveries() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM delivery");
        List<DeliveryDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String delivery_id = resultSet.getString(1);
            String emp_id = resultSet.getString(2);
            String ord_id = resultSet.getString(3);
            String location = resultSet.getString(4);
            Date delivered_date = resultSet.getDate(5);

            var dto = new DeliveryDto(delivery_id,emp_id,ord_id,location,delivered_date);
            dtoList.add(dto);
        }
        return dtoList;

    }
    public boolean deleteDelivery(String delivery_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM delivery WHERE delivery_id = ?" ,delivery_id);
    }

    public List<DeliveryDto> loadAllDeliveries() throws SQLException {
        ResultSet resultSet =SQLUtil.execute("SELECT * FROM delivery");
        List<DeliveryDto> deliveryList = new ArrayList<>();


        while (resultSet.next()) {
            deliveryList.add(new DeliveryDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5)
            ));
        }
        return deliveryList;
    }
}























