package lk.ijse.superHardware.bo.custom;

import lk.ijse.superHardware.bo.SuperBO;
import lk.ijse.superHardware.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
     boolean saveCustomer(CustomerDto dto) throws SQLException;

    boolean updateCustomer(CustomerDto dto) throws SQLException;

    boolean deleteCustomer(String cust_id) throws SQLException;

    List<CustomerDto> getAllCustomers() throws SQLException;

    CustomerDto searchCustomer(String cust_id) throws SQLException;

   // CustomerDto searchCustomer(String cust_id) throws SQLException;

}
