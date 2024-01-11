package lk.ijse.superHardware.model;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.CustomerDAO;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.dto.ItemStockDto;
import lk.ijse.superHardware.dto.tm.CustomerTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    public static CustomerDto searchByCustId(String cust_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer WHERE cust_id = ?",cust_id);
        resultSet.next();

        return new CustomerDto(cust_id +"",resultSet.getString("cust_name"),resultSet.getString("address"),resultSet.getInt("contact"));

    }

    //////////////////////////new ////////////////////////////////////////////////////////////////////////////

    public boolean saveCustomer(final CustomerDto dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO customer VALUES(?, ?, ?, ?)",dto.getCust_id(),dto.getCust_name(),dto.getAddress(),dto.getContact());
        }

    public boolean updateCustomer(final CustomerDto dto) throws SQLException {
        return SQLUtil.execute("UPDATE customer SET cust_name = ?, address = ?, contact= ? WHERE cust_id = ?",dto.getCust_name(),dto.getAddress(),dto.getContact(),dto.getCust_id());
    }
    public CustomerDto searchCustomer(String cust_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer WHERE cust_id = ?", cust_id);
        resultSet.next();

        return new CustomerDto(cust_id + "",resultSet.getString("cust_name"),resultSet.getString("address"),resultSet.getInt("contact"));

    }


    public List<CustomerDto> getAllCustomers() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer");
        List<CustomerDto> dtoList = new ArrayList<>();

        while (resultSet.next()) {
            String cust_id = resultSet.getString(1);
            String cust_name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int contact = resultSet.getInt(4);

            var dto = new CustomerDto(cust_id, cust_name, address, contact);
            dtoList.add(dto);
        }
        return dtoList;

    }

    public boolean deleteCustomer(String cust_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM customer WHERE cust_id = ?",cust_id);
    }


    public List<CustomerDto> loadAllCustomers() throws SQLException {
        ResultSet resultSet =SQLUtil.execute( "SELECT * FROM customer");
        List<CustomerDto> custList = new ArrayList<>();

        while (resultSet.next()) {
            custList.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
            ));
        }
        return custList;
    }

}







