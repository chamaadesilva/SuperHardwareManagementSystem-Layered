package lk.ijse.superHardware.dao.custom;

import lk.ijse.superHardware.dao.CrudDAO;
import lk.ijse.superHardware.dto.CustomerDto;
import lk.ijse.superHardware.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<CustomerDto>{
   /* boolean saveCustomer(CustomerDto dto) throws SQLException;

    boolean updateCustomer(CustomerDto dto) throws SQLException;

    boolean deleteCustomer(String cust_id) throws SQLException;

    List<CustomerDto> getAllCustomers() throws SQLException;

    CustomerDto searchCustomer(String cust_id) throws SQLException;*/

     CustomerDto searchCustomer(String cust_id) throws SQLException;

    boolean update(Customer customer) throws SQLException;

    boolean save(Customer customer) throws SQLException;
}
