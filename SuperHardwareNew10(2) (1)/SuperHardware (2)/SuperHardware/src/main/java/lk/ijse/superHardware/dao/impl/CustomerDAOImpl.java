package lk.ijse.superHardware.dao.impl;

import lk.ijse.superHardware.dao.SQLUtil;
import lk.ijse.superHardware.dao.custom.CustomerDAO;
import lk.ijse.superHardware.db.DbConnection;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.entity.Customer;
import lk.ijse.superHardware.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

   public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean save(final Customer entity) throws SQLException {

        return SQLUtil.execute("INSERT INTO customer VALUES(?, ?, ?, ?)",
                entity.getCust_id(),entity.getCust_name(),entity.getAddress(),entity.getContact());
    }

    @Override
 public boolean update(final Customer entity) throws SQLException{
     return SQLUtil.execute("UPDATE customer SET cust_name = ?, address = ?, contact= ? WHERE cust_id = ?",
             entity.getCust_id(),entity.getCust_name(),entity.getAddress(),entity.getContact());
 }

       @Override
       public boolean save(Employee dto) throws SQLException {
           return false;
       }

       @Override
       public boolean update(Employee dto) throws SQLException {
           return false;
       }

       //@Override
       //public boolean update(Employee dto) throws SQLException {
          // return false;
       //}

       @Override
    public boolean delete(String cust_id) throws SQLException {
        return SQLUtil.execute("DELETE FROM customer WHERE cust_id = ?",cust_id);
    }


    @Override
    public List<CustomerDto> getAll() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
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

    @Override
    public CustomerDto search(String cust_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer WHERE cust_id = ?", cust_id);
        resultSet.next();

        return new CustomerDto(cust_id + "",resultSet.getString("cust_name"),resultSet.getString("address"),resultSet.getInt("contact"));

    }

   /* @Override
    public static CustomerDto searchByCustId(String cust_id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer WHERE cust_id = ?",cust_id);
       resultSet.next();

        return new CustomerDto(cust_id +"",resultSet.getString("cust_name"),resultSet.getString("address"),resultSet.getInt("contact"));

    }*/

       @Override
       public CustomerDto searchCustomer(String cust_id) throws SQLException {
           return null;
       }



     //  @Override
      // public boolean save(Customer customer) {
         //  return false;
       }

